package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;
import com.pth.iflow.profile.service.IUserGroupService;

@Service
public class UserGroupService implements IUserGroupService {

  private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public UserGroupService(@Autowired final IProfileRestTemplateCall restTemplate,
                          @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public UserGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request UserGroup data for companyid {}", id);

    final UserGroupEdo edo = restTemplate.callRestGet(
                                                      coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.USERGROUP_READ_BY_ID)
                                                                      .toString(),
                                                      EModule.CORE,
                                                      UserGroupEdo.class,
                                                      true,
                                                      id);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<UserGroup> getListByCompanyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request UserGroup list data for companyid {}", companyId);

    final UserGroupListEdo edo = restTemplate.callRestGet(
                                                          coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.USERGROUP_READ_LIST_BY_COMPANY)
                                                                          .toString(),
                                                          EModule.CORE,
                                                          UserGroupListEdo.class,
                                                          true,
                                                          companyId);

    return ProfileModelEdoMapper.fromUserGroupEdoList(edo.getUserGroups());
  }

}
