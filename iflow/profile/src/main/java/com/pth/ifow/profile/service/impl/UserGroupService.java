package com.pth.ifow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.UserGroupEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.profile.config.ProfileConfiguration;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.UserGroup;
import com.pth.ifow.profile.service.IProfileRestTemplateCall;
import com.pth.ifow.profile.service.IUserGroupService;

@Service
public class UserGroupService implements IUserGroupService {

  private static final Logger                 logger = LoggerFactory.getLogger(CompanyService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public UserGroupService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public UserGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request UserGroup data for companyid {}", id);

    final UserGroupEdo edo = restTemplate.callRestGet(
        coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModul.USERGROUP_READ_BY_ID).toString(), EModule.CORE, UserGroupEdo.class,
        true, id);

    return new UserGroup().fromEdo(edo);
  }

  @Override
  public List<UserGroup> getListByComaonyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request UserGroup list data for companyid {}", companyId);

    final UserGroupListEdo edo = restTemplate.callRestGet(
        coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModul.USERGROUP_READ_LIST_BY_COMPANY).toString(), EModule.CORE,
        UserGroupListEdo.class, true, companyId);

    return new UserGroup().fromEdoList(edo.getUserGroups());
  }

}
