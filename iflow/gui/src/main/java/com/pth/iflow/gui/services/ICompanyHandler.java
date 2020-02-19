package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSetting;

public interface ICompanyHandler {

  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSetting> readCompanyWorkflowtypeItemOcrSettings(String identity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<CompanyWorkflowtypeItemOcrSetting> saveCompanyWorkflowtypeItemOcrSettings(List<CompanyWorkflowtypeItemOcrSetting> settingList,
      String companyidentity, String workflowtypeidentity) throws MalformedURLException, IFlowMessageConversionFailureException;

}
