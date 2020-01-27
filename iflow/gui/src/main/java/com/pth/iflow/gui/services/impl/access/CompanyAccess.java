package com.pth.iflow.gui.services.impl.access;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.ICompanyAccess;
import com.pth.iflow.gui.services.IRestTemplateCall;

@Service
public class CompanyAccess implements ICompanyAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig;

  private final SessionUserInfo sessionUserInfo;

  public CompanyAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig,
      @Autowired final SessionUserInfo sessionUserInfo) {

    this.restTemplate = restTemplate;
    this.profileModuleAccessConfig = profileModuleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read ucompany info from core {}", identity);

    final CompanyEdo companyEdo = this.restTemplate
        .callRestGet(this.profileModuleAccessConfig.getReadCompanyUri(identity),
            EModule.CORE, CompanyEdo.class,
            this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : this.sessionUserInfo.getToken(), true);

    return GuiModelEdoMapper.fromEdo(companyEdo);
  }

  @Override
  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save company");

    final CompanyEdo companyEdo = this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getSaveCompanyUri(), EModule.CORE, GuiModelEdoMapper.toEdo(company), CompanyEdo.class,
            this.sessionUserInfo.getToken(), true);

    return GuiModelEdoMapper.fromEdo(companyEdo);
  }

}
