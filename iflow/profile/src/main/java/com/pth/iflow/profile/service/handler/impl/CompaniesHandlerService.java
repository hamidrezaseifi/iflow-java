package com.pth.iflow.profile.service.handler.impl;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.handler.ICompaniesHandlerService;

@Service
public class CompaniesHandlerService implements ICompaniesHandlerService {

  private final ICompanyAccessService CompanyAccessService;

  public CompaniesHandlerService(@Autowired final ICompanyAccessService CompanyAccessService) {

    this.CompanyAccessService = CompanyAccessService;
  }

  @Override
  public Company getCompanyByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.CompanyAccessService.getByIdentity(identity);
  }

  @Override
  public Company saveCompany(final Company company)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.CompanyAccessService.saveCompany(company);
  }

}