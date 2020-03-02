package com.pth.iflow.gui.services.impl.access;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.ICompanyAccess;
import com.pth.iflow.gui.services.IRestTemplateCall;

@Service
public class CompanyAccess implements ICompanyAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig;

  public CompanyAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig) {

    this.restTemplate = restTemplate;
    this.profileModuleAccessConfig = profileModuleAccessConfig;
  }

  @Override
  public Company readCompany(final String companyIdentity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read company info from core {}", companyIdentity);

    final CompanyEdo companyEdo = this.restTemplate
        .callRestGet(this.profileModuleAccessConfig.getReadCompanyUri(companyIdentity), EModule.PROFILE, CompanyEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(companyEdo);
  }

  @Override
  public Company saveCompany(final Company company, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save company");

    final CompanyEdo companyEdo = this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getSaveCompanyUri(), EModule.PROFILE, GuiModelEdoMapper.toEdo(company), CompanyEdo.class, token,
            true);

    return GuiModelEdoMapper.fromEdo(companyEdo);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings(final String identity, final String token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read company workflowtype item ocr settings from core {}", identity);

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo listEdo = this.restTemplate
        .callRestGet(this.profileModuleAccessConfig.getReadCompanyWorkflowTypeItemOcrSettingsUri(identity),
            EModule.PROFILE, CompanyWorkflowtypeItemOcrSettingPresetListEdo.class, token, true);

    return GuiModelEdoMapper.fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(listEdo.getCompanyWorkflowtypeItemOcrSettings());
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      saveCompanyWorkflowtypeItemOcrSettings(final List<CompanyWorkflowtypeItemOcrSettingPreset> newList, final String token)
          throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save company workflowtype item ocr settings");

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo workflowtypeItemOcrSettingListEdo = new CompanyWorkflowtypeItemOcrSettingPresetListEdo(
        GuiModelEdoMapper.toCompanyWorkflowtypeItemOcrSettingPresetEdoList(newList));
    final CompanyWorkflowtypeItemOcrSettingPresetListEdo listEdo = this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getSaveCompanyWorkflowTypeItemOcrSettingsUri(), EModule.PROFILE,
            workflowtypeItemOcrSettingListEdo, CompanyWorkflowtypeItemOcrSettingPresetListEdo.class, token, true);

    return GuiModelEdoMapper.fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(listEdo.getCompanyWorkflowtypeItemOcrSettings());
  }

}
