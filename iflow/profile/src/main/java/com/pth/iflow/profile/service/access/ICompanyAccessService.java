package com.pth.iflow.profile.service.access;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;

public interface ICompanyAccessService {

  Company getByIdentity(final String comapnyIdentity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  Company saveCompany(Company company) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
