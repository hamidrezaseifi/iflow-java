package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.UserDashboardMenuEdo;
import com.pth.iflow.common.models.edo.UserDashboardMenuListEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserPasswordChangeRequestEdo;
import com.pth.iflow.common.moduls.security.RestAccessRoles;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserDashboardMenu;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.IUsersHandlerService;

@RestController
@RequestMapping
public class UserController {

  private final IUsersHandlerService usersHandlerService;

  public UserController(@Autowired final IUsersHandlerService usersHandlerService) {

    this.usersHandlerService = usersHandlerService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_READ)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.USER_READ_BY_IDENTITY)
  @ResponseBody
  public ResponseEntity<UserEdo> readUserByIdentity(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final User user = this.usersHandlerService.getUserByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(user), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_SAVE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_SAVE)
  @ResponseBody
  public ResponseEntity<UserEdo> saveUser(@RequestBody final UserEdo userEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final User user = this.usersHandlerService.saveUser(ProfileModelEdoMapper.fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(user), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PreAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_DELETE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_DELETE)
  @ResponseBody
  public void deleteUser(@RequestBody final UserEdo userEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.usersHandlerService.deleteUser(ProfileModelEdoMapper.fromEdo(userEdo));

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_UPDATE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_RESETPASSWORD)
  @ResponseBody
  public void resetUserPassword(@RequestBody final UserPasswordChangeRequestEdo userPasswordChangeRequestEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.usersHandlerService.resetUserPassword(ProfileModelEdoMapper.fromEdo(userPasswordChangeRequestEdo));

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_UPDATE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_DELETE_AUTHENTICATION)
  @ResponseBody
  public void deleteUserAuthentication(@RequestBody final UserPasswordChangeRequestEdo userPasswordChangeRequestEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.usersHandlerService.deleteUserAuthentication(ProfileModelEdoMapper.fromEdo(userPasswordChangeRequestEdo));

  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(path = IflowRestPaths.ProfileModule.USERDASHBOARDMENU_READ_BY_USERIDENTITY)
  public ResponseEntity<UserDashboardMenuListEdo>
      readUserDashboardMenuByIdentity(@PathVariable(name = "appIdentity") final String appIdentity, @PathVariable(name = "userIdentity") final String userIdentity,
          final HttpServletRequest request, final Authentication authentication) throws Exception {

    final List<UserDashboardMenu> list = this.usersHandlerService.getUserDashboardMenuListByUserIdentity(appIdentity, userIdentity);

    final List<UserDashboardMenuEdo> edoList = ProfileModelEdoMapper.toUserDashboardMenuEdoList(list);

    return ControllerHelper.createResponseEntity(request, new UserDashboardMenuListEdo(edoList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowPostRequestMapping(path = IflowRestPaths.ProfileModule.USERDASHBOARDMENU_SAVE_BY_USERIDENTITY)
  public ResponseEntity<UserDashboardMenuListEdo>
      saveUserDashboardMenuByIdentity(@RequestBody final UserDashboardMenuListEdo requestedEdoList, @PathVariable(name = "appIdentity") final String appIdentity,
          @PathVariable(name = "userIdentity") final String userIdentity, final HttpServletRequest request, final Authentication authentication)
          throws Exception {

    final List<UserDashboardMenu> requestedModelList = ProfileModelEdoMapper
        .fromUserDashboardMenuEdoList(requestedEdoList.getUserDashboardMenus());

    final List<UserDashboardMenu> list = this.usersHandlerService
        .saveUserDashboardMenuListByUserIdentity(appIdentity, userIdentity, requestedModelList);

    final List<UserDashboardMenuEdo> edoList = ProfileModelEdoMapper.toUserDashboardMenuEdoList(list);

    return ControllerHelper.createResponseEntity(request, new UserDashboardMenuListEdo(edoList), HttpStatus.CREATED);
  }

}
