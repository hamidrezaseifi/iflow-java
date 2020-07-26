package com.pth.iflow.gui.services.impl.access;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.rest.IRestTemplateCall;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.IDepartmentAccess;

@Service
public class DepartmentAccess implements IDepartmentAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig;

  private final SessionUserInfo sessionUserInfo;

  public DepartmentAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig,
      @Autowired final SessionUserInfo sessionUserInfo) {

    this.restTemplate = restTemplate;
    this.profileModuleAccessConfig = profileModuleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public List<Department> getCompanyDepartmentList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read department list for company id from core {}", companyIdentity);

    final DepartmentListEdo responseEdo = this.restTemplate
        .callRestGet(this.profileModuleAccessConfig.getReadCompanyDepartmentListUri(companyIdentity),
            EModule.CORE, DepartmentListEdo.class,
            this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : this.sessionUserInfo.getToken(), true);

    return GuiModelEdoMapper.fromDepartmentEdoList(responseEdo.getDepartments());
  }

  @Override
  public Department saveDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save department");

    final DepartmentEdo userEdo = this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getSaveDepartmentUri(), EModule.CORE, GuiModelEdoMapper.toEdo(department), DepartmentEdo.class,
            this.sessionUserInfo.getToken(), true);

    return GuiModelEdoMapper.fromEdo(userEdo);
  }

  @Override
  public void deleteDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Delete department");

    this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getDeleteDepartmentUri(), EModule.CORE, GuiModelEdoMapper.toEdo(department), Void.class,
            this.sessionUserInfo.getToken(), true);

  }

}
