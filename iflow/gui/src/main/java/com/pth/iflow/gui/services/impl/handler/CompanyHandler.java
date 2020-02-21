package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EInvoiceWorkflowTypeItems;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSetting;
import com.pth.iflow.gui.models.WorkflowType;
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
  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.readCompany(identity);
  }

  @Override
  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.saveCompany(company);
  }

  @Override
  public Map<String, List<CompanyWorkflowtypeItemOcrSetting>> readCompanyWorkflowtypeItemOcrSettings(final String identity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<CompanyWorkflowtypeItemOcrSetting> list = this.companyAccess.readCompanyWorkflowtypeItemOcrSettings(identity);

    final Map<String, List<CompanyWorkflowtypeItemOcrSetting>> map = this.extractMappedCompanyWorkflowtypeItemOcrSettings(list);

    return map;
  }

  @Override
  public Map<String, List<CompanyWorkflowtypeItemOcrSetting>> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSetting> settingList,
      final String companyidentity, final String workflowtypeidentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<CompanyWorkflowtypeItemOcrSetting> readList = this.companyAccess.readCompanyWorkflowtypeItemOcrSettings(companyidentity);

    final List<CompanyWorkflowtypeItemOcrSetting> newList = readList
        .stream()
        .filter(item -> item.getWorkflowIdentity().equals(workflowtypeidentity) == false)
        .collect(Collectors.toList());

    newList.addAll(settingList);

    final List<CompanyWorkflowtypeItemOcrSetting> finallList = newList
        .stream()
        .filter(i -> i.hasValue())
        .collect(Collectors.toList());

    final List<CompanyWorkflowtypeItemOcrSetting> resultlList = this.companyAccess.saveCompanyWorkflowtypeItemOcrSettings(finallList);

    this.sessionUserInfo.getCompanyProfile().setWorkflowtypeItemOcrSettings(resultlList);
    this.sessionUserInfo.resetWorkflowtypeItemOcrSettings();

    return this.extractMappedCompanyWorkflowtypeItemOcrSettings(resultlList);
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
  public Map<String, List<CompanyWorkflowtypeItemOcrSetting>>
      extractMappedCompanyWorkflowtypeItemOcrSettings(final List<CompanyWorkflowtypeItemOcrSetting> list)
          throws IFlowMessageConversionFailureException {

    final Map<String, List<CompanyWorkflowtypeItemOcrSetting>> map = new HashMap<>();

    for (final CompanyWorkflowtypeItemOcrSetting item : list) {
      if (map.containsKey(item.getWorkflowIdentity()) == false) {
        map.put(item.getWorkflowIdentity(), new ArrayList<>());
      }
      map.get(item.getWorkflowIdentity()).add(item);
    }

    final Collection<WorkflowType> allWorkflowTypes = this.sessionUserInfo.getAllWorkflowTypes();
    for (final WorkflowType type : allWorkflowTypes) {
      if (map.containsKey(type.getIdentity()) == false) {
        map.put(type.getIdentity(), new ArrayList<>());
      }

      final List<CompanyWorkflowtypeItemOcrSetting> propertyList = map.get(type.getIdentity());

      final Map<String,
          CompanyWorkflowtypeItemOcrSetting> propertyMap = propertyList
              .stream()
              .collect(Collectors.toMap(p -> p.getPropertyName(), p -> p));

      final List<String> items = this.readWorkflowtypeItems(type.getIdentity());
      for (final String item : items) {
        if (propertyMap.containsKey(item) == false) {
          final CompanyWorkflowtypeItemOcrSetting prop = new CompanyWorkflowtypeItemOcrSetting();
          prop.setWorkflowIdentity(type.getIdentity());
          prop.setPropertyName(item);
          prop.setValue("");
          prop.setStatus(1);
          prop.setVersion(1);
          prop.setCompanyIdentity(this.sessionUserInfo.getCompany().getIdentity());

          map.get(type.getIdentity()).add(prop);
        }
      }

    }
    return map;
  }
}
