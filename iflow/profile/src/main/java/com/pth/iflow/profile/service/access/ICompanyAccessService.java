package com.pth.iflow.profile.service.access;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;

public interface ICompanyAccessService {

  Company getByIdentity(final String comapnyIdentity)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException;

}
