package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;

public interface ICompanyAccess {

  public Company readCompany(final String companyIdentity, String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company, String token) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(String companyIdentity, String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public CompanyWorkflowtypeItemOcrSettingPreset saveCompanyWorkflowtypeItemOcrSettings(CompanyWorkflowtypeItemOcrSettingPreset model,
      String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public void deleteCompanyWorkflowtypeItemOcrSettings(CompanyWorkflowtypeItemOcrSettingPreset preset, String token)
      throws GuiCustomizedException, MalformedURLException;

}
