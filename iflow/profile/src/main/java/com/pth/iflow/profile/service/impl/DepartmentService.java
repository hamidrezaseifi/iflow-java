package com.pth.iflow.profile.service.impl;

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
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IDepartmentService;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;

@Service
public class DepartmentService implements IDepartmentService {

  private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public DepartmentService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {

    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public Department getByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request Department data for companyid {}", identity);

    final DepartmentEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_BY_ID(identity)),
            EModule.CORE,
            DepartmentEdo.class,
            true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<Department> getListByCompanyIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request Department list data for companyid {}", identity);

    final DepartmentListEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_LIST_BY_COMPANY(identity)),
            EModule.CORE,
            DepartmentListEdo.class,
            true);

    return ProfileModelEdoMapper.fromDepartmentEdoList(edo.getDepartments());
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request Department list data for companyid {}", identity);

    final UserListEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_ALLUSERLIST_BY_DEPARTMENT(identity)),
            EModule.CORE,
            UserListEdo.class,
            true);

    return ProfileModelEdoMapper.fromUserEdoList(edo.getUsers());
  }

}
