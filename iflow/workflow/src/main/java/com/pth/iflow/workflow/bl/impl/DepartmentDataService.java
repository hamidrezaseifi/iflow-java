package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class DepartmentDataService implements IDepartmentDataService {

  private static final Logger                            logger = LoggerFactory.getLogger(DepartmentDataService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public DepartmentDataService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public List<User> getUserListByDepartmentId(final Long departmentId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request department user list");

    final UserListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENT_ALLUSERLIST_BY_DEPARTMENT(departmentId)),
        token, EModule.CORE, UserListEdo.class, true);

    return WorkflowModelEdoMapper.fromUserEdoList(edoList.getUsers());
  }

  @Override
  public List<User> getUserListByDepartmentGroupId(final Long departmentGroupId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request departmentgroup user list");

    final UserListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig
            .generateCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENTGRPUP_ALLUSERLIST_BY_DEPARTMENTGROUP(departmentGroupId)),
        token, EModule.CORE, UserListEdo.class, true);

    return WorkflowModelEdoMapper.fromUserEdoList(edoList.getUsers());
  }

}
