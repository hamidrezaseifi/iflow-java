package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPresetItem;

public interface ICompanyHandler {

  public Company readCompany(final String companyIdentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(String companyIdentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> saveCompanyWorkflowtypeItemOcrSettings(
      CompanyWorkflowtypeItemOcrSettingPreset preset, String companyidentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<String> readWorkflowtypeItems(final String workflowtypeidentity);

  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItems(final String presetName, String CompanyIdentity,
      final String token)
      throws IFlowMessageConversionFailureException, MalformedURLException;

  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItemsFromSession(final String presetName)
      throws IFlowMessageConversionFailureException;

  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> extractMappedCompanyWorkflowtypeItemsFromOcrPreset(
      final CompanyWorkflowtypeItemOcrSettingPreset preset) throws IFlowMessageConversionFailureException;

}
