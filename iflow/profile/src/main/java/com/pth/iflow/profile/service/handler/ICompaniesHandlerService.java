package com.pth.iflow.profile.service.handler;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSetting;

public interface ICompaniesHandlerService {

  Company getCompanyByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  Company saveCompany(final Company company)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<CompanyWorkflowtypeItemOcrSetting> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String companyidentity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<CompanyWorkflowtypeItemOcrSetting> saveCompanyWorkflowtypeItemOcrSettings(List<CompanyWorkflowtypeItemOcrSetting> modelInputList)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
