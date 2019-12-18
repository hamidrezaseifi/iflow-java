package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.CompanyEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ICompanyService;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;

@Service
public class CompanyService implements ICompanyService {

  private static final Logger                 logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public CompanyService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public Company getByIdentity(final String comapnyIdentity)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request company data for id {}", comapnyIdentity);

    final CompanyEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_COMPANY_BY_ID(comapnyIdentity)).toString(), EModule.CORE,
        CompanyEdo.class, true, comapnyIdentity);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

}
