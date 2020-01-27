package com.pth.iflow.profile.service.handler;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;

public interface ICompaniesHandlerService {

  Company getCompanyByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
