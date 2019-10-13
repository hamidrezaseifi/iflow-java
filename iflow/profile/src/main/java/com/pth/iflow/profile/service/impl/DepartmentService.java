package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IDepartmentService;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;

@Service
public class DepartmentService implements IDepartmentService {

  private static final Logger                 logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public DepartmentService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public Department getById(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department data for companyid {}", identity);

    final DepartmentEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_BY_ID(identity)).toString(), EModule.CORE,
        DepartmentEdo.class, true, identity);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<Department> getListByCompanyId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department list data for companyid {}", identity);

    final DepartmentListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_LIST_BY_COMPANY(identity)).toString(),
        EModule.CORE, DepartmentListEdo.class, true, identity);

    return ProfileModelEdoMapper.fromDepartmentEdoList(edo.getDepartments());
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department list data for companyid {}", identity);

    final DepartmentGroupListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENTGRPUP_LIST_BY_DEPARTMENT(identity)).toString(),
        EModule.CORE, DepartmentGroupListEdo.class, true, identity);

    return ProfileModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups());
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department list data for companyid {}", identity);

    final UserListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_ALLUSERLIST_BY_DEPARTMENT(identity)).toString(),
        EModule.CORE, UserListEdo.class, true, identity);

    return ProfileModelEdoMapper.fromUserEdoList(edo.getUsers());
  }

}
