package com.pth.iflow.profile.service.access.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@Service
public class CompanyAccessService implements ICompanyAccessService {

  private static final Logger logger = LoggerFactory.getLogger(CompanyAccessService.class);

  final IProfileRestTemplateCall restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public CompanyAccessService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {

    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public Company getByIdentity(final String comapnyIdentity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request company data for id {}", comapnyIdentity);

    final CompanyEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_COMPANY_BY_ID(comapnyIdentity)), EModule.CORE,
            CompanyEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public Company saveCompany(final Company company)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Saving company {}", company);

    final CompanyEdo edo = this.restTemplate
        .callRestPost(this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.SAVE_COMPANY()), EModule.CORE,
            ProfileModelEdoMapper.toEdo(company), CompanyEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(final String companyidentity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request company Workflowtype Item Ocr Settings for identity {}", companyidentity);

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo listEdo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig
                .prepareCoreUrl(IflowRestPaths.CoreModule.READ_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY(companyidentity)),
            EModule.CORE,
            CompanyWorkflowtypeItemOcrSettingPresetListEdo.class, true);

    return ProfileModelEdoMapper.fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(listEdo.getCompanyWorkflowtypeItemOcrSettings());

  }

  @Override
  public CompanyWorkflowtypeItemOcrSettingPreset
      saveCompanyWorkflowtypeItemOcrSettings(final CompanyWorkflowtypeItemOcrSettingPreset modelInput)
          throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Saving company Workflowtype Item Ocr Settings");

    final CompanyWorkflowtypeItemOcrSettingPresetEdo requestEdo = ProfileModelEdoMapper
        .toCompanyWorkflowtypeItemOcrSettingPresetEdo(modelInput);

    final CompanyWorkflowtypeItemOcrSettingPresetEdo resultEdo = this.restTemplate
        .callRestPost(this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.SAVE_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS()),
            EModule.CORE,
            requestEdo,
            CompanyWorkflowtypeItemOcrSettingPresetEdo.class, true);

    return ProfileModelEdoMapper.fromCompanyWorkflowtypeItemOcrSettingPresetEdo(resultEdo);

  }

  @Override
  public void deleteCompanyWorkflowtypeItemOcrSettings(final CompanyWorkflowtypeItemOcrSettingPreset modelInput)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Delete company Workflowtype Item Ocr Settings");

    final CompanyWorkflowtypeItemOcrSettingPresetEdo requestEdo = ProfileModelEdoMapper
        .toCompanyWorkflowtypeItemOcrSettingPresetEdo(modelInput);

    this.restTemplate
        .callRestPost(this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DELETE_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS()),
            EModule.CORE,
            requestEdo,
            Void.class, true);

  }

}
