package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;

public interface ICompanyAccess {

  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(String identity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(String identity, String token)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      saveCompanyWorkflowtypeItemOcrSettings(List<CompanyWorkflowtypeItemOcrSettingPreset> newList)
          throws MalformedURLException, IFlowMessageConversionFailureException;

}
