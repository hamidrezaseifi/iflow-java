package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;

public interface ICompanyAccess {

  public Company readCompany(final String companyIdentity, String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company, String token) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(String companyIdentity, String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      saveCompanyWorkflowtypeItemOcrSettings(List<CompanyWorkflowtypeItemOcrSettingPreset> newList, String token)
          throws MalformedURLException, IFlowMessageConversionFailureException;

}
