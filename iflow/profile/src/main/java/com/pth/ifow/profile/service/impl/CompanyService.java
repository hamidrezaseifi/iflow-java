package com.pth.ifow.profile.service.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.profile.config.ProfileConfiguration;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.service.ICompanyService;
import com.pth.ifow.profile.service.IProfileRestTemplateCall;

@Service
public class CompanyService implements ICompanyService {

  private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  CompanyService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public Company getById(final Long comapnyId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    logger.debug("Request company data for id {}", comapnyId);

    final CompanyEdo edo = restTemplate.callRestGet(coreAccessConfig.getReadCompanyByIdUrl().toString(), EModule.CORE,
        CompanyEdo.class, true, comapnyId);

    return new Company().fromEdo(edo);
  }

}
