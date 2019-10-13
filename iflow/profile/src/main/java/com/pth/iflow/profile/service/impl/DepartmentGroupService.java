package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IDepartmentGroupService;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;

@Service
public class DepartmentGroupService implements IDepartmentGroupService {

  private static final Logger                 logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public DepartmentGroupService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public DepartmentGroup getById(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department data for companyid {}", identity);

    final DepartmentGroupEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENTGRPUP_BY_ID(identity)).toString(), EModule.CORE,
        DepartmentGroupEdo.class, true, identity);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<User> getAllUserListByDepartmentGroupId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request Department list data for companyid {}", identity);

    final UserListEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig
                .prepareCoreUrl(IflowRestPaths.CoreModule.READ_DEPARTMENTGRPUP_ALLUSERLIST_BY_DEPARTMENTGROUP(identity)).toString(),
            EModule.CORE, UserListEdo.class, true, identity);

    return ProfileModelEdoMapper.fromUserEdoList(edo.getUsers());
  }

}
