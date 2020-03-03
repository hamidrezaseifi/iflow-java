package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EInvoiceWorkflowTypeItems;
import com.pth.iflow.common.enums.EOcrType;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPresetItem;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.ICompanyAccess;
import com.pth.iflow.gui.services.ICompanyHandler;

@Service
public class CompanyHandler implements ICompanyHandler {

  private final ICompanyAccess companyAccess;

  private final SessionUserInfo sessionUserInfo;

  public CompanyHandler(@Autowired final ICompanyAccess companyAccess, @Autowired final SessionUserInfo sessionUserInfo) {

    this.companyAccess = companyAccess;
    this.sessionUserInfo = sessionUserInfo;

  }

  @Override
  public Company readCompany(final String companyIdentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.readCompany(companyIdentity, token);
  }

  @Override
  public Company saveCompany(final Company company, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.saveCompany(company, token);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(final String companyIdentity,
      final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<
        CompanyWorkflowtypeItemOcrSettingPreset> list = this.companyAccess.readCompanyWorkflowtypeItemOcrSettings(companyIdentity, token);

    return list;
  }

  @Override
  public CompanyWorkflowtypeItemOcrSettingPreset saveCompanyWorkflowtypeItemOcrSetting(
      final CompanyWorkflowtypeItemOcrSettingPreset preset,
      final String companyidentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    preset.prepareItems();

    final CompanyWorkflowtypeItemOcrSettingPreset result = this.companyAccess.saveCompanyWorkflowtypeItemOcrSettings(preset, token);

    this.sessionUserInfo.getCompanyProfile().setOcrPreset(result);
    this.sessionUserInfo.resetWorkflowtypeItemOcrSettings();

    return result;
  }

  @Override
  public List<String> readWorkflowtypeItems(final String workflowtypeidentity) {

    final List<String> items = new ArrayList<>();

    if (EWorkflowType.INVOICE_WORKFLOW_TYPE.getIdentity().equals(workflowtypeidentity)) {
      items.addAll(EInvoiceWorkflowTypeItems.toIdentityList());

    }

    return items;
  }

  @Override
  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItems(final String presetName, final String CompanyIdentity,
      final String token)
      throws IFlowMessageConversionFailureException, MalformedURLException {

    final List<CompanyWorkflowtypeItemOcrSettingPreset> presetList = this.readCompanyWorkflowtypeItemOcrSettings(CompanyIdentity, token);
    final Optional<CompanyWorkflowtypeItemOcrSettingPreset> optionalPreset = presetList
        .stream()
        .filter(p -> p.getPresetName().equals(presetName))
        .findAny();

    if (optionalPreset.isPresent() == false) {
      return null;
    }

    return this.extractMappedCompanyWorkflowtypeItemsFromOcrPreset(optionalPreset.get());
  }

  @Override
  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItemsFromSession(final String presetName)
      throws IFlowMessageConversionFailureException {

    final List<CompanyWorkflowtypeItemOcrSettingPreset> presetList = this.sessionUserInfo.getWorkflowtypeItemOcrSettings();
    final Optional<CompanyWorkflowtypeItemOcrSettingPreset> optionalPreset = presetList
        .stream()
        .filter(p -> p.getPresetName().equals(presetName))
        .findAny();

    if (optionalPreset.isPresent() == false) {
      return null;
    }

    return this.extractMappedCompanyWorkflowtypeItemsFromOcrPreset(optionalPreset.get());
  }

  @Override
  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> extractMappedCompanyWorkflowtypeItemsFromOcrPreset(
      final CompanyWorkflowtypeItemOcrSettingPreset preset) throws IFlowMessageConversionFailureException {

    final Map<String,
        CompanyWorkflowtypeItemOcrSettingPresetItem> map = preset
            .getItems()
            .stream()
            .collect(Collectors.toMap(i -> i.getPropertyName(), i -> i));

    final List<String> items = this.readWorkflowtypeItems(preset.getWorkflowTypeIdentity());

    for (final String itemName : items) {
      if (map.containsKey(itemName) == false) {
        final CompanyWorkflowtypeItemOcrSettingPresetItem prop = new CompanyWorkflowtypeItemOcrSettingPresetItem();
        prop.setOcrType(EOcrType.SEARCH_WORD.getValue());
        prop.setPropertyName(itemName);
        prop.setValue("");
        prop.setStatus(1);
        prop.setVersion(1);

        map.put(itemName, prop);
      }
    }

    return map;
  }

}
