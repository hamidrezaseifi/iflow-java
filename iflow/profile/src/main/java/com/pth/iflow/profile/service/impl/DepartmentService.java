package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
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
  public Department getById(final Long id) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request Department data for companyid {}", id);

    final DepartmentEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DEPARTMENT_READ_BY_ID).toString(), EModule.CORE,
        DepartmentEdo.class, true, id);

    return new Department().fromEdo(edo);
  }

  @Override
  public List<Department> getListByCompanyId(final Long id) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request Department list data for companyid {}", id);

    final DepartmentListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST_BY_COMPANY).toString(), EModule.CORE,
        DepartmentListEdo.class, true, id);

    return new Department().fromEdoList(edo.getDepartments());
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final Long id)
      throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request Department list data for companyid {}", id);

    final DepartmentGroupListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT).toString(),
        EModule.CORE, DepartmentGroupListEdo.class, true, id);

    return new DepartmentGroup().fromEdoList(edo.getDepartmentGroups());
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final Long id) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request Department list data for companyid {}", id);

    final UserListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENT).toString(),
        EModule.CORE, UserListEdo.class, true, id);

    return new User().fromEdoList(edo.getUsers());
  }

}
