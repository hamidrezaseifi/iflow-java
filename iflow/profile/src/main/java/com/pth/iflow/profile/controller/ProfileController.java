package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.TokenProfileRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationRequestEdo;
import com.pth.iflow.common.moduls.security.RestAccessRoles;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.IAuthenticationService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;

@RestController
@RequestMapping
public class ProfileController {

  private final ITokenUserDataManager tokenUserDataManager;
  private final IAuthenticationService authenticationService;

  public ProfileController(@Autowired final ITokenUserDataManager tokenUserDataManager,
      @Autowired final IAuthenticationService authenticationService) {

    this.tokenUserDataManager = tokenUserDataManager;
    this.authenticationService = authenticationService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readAuthenticatedInfo(@RequestBody final AuthenticatedProfileRequestEdo requestEdo,
      final HttpServletRequest request, final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.tokenUserDataManager
        .getProfileByTokenUserIdentity(requestEdo.getAppId(), requestEdo.getUserIdentity(),
            authentication);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(profile), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readTokenInfo(@RequestBody final TokenProfileRequestEdo requestEdo,
      final HttpServletRequest request, final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(requestEdo.getAppId(), authentication);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(profile), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_VALIDATE_TOKEN)
  @ResponseBody
  public void validateToken(final HttpServletRequest request, final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    /*
     * if (StringUtils.isEmpty(requestToken) || StringUtils.isEmpty(headerTokenId) || (requestToken.equals(headerTokenId) == false)) { throw
     * new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN); }
     */

    this.tokenUserDataManager.validateToken(authentication);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostAuthorize(RestAccessRoles.Users.HAS_ROLE_USERS_SAVE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_SAVE_AUTHENTOCATION)
  @ResponseBody
  public ResponseEntity<UserAuthenticationRequestEdo> saveAuthentication(@RequestBody final UserAuthenticationRequestEdo userEdo,
      final HttpServletRequest request, final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final UserAuthenticationRequest auth = this.authenticationService.setAuthentication(ProfileModelEdoMapper.fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(auth), HttpStatus.OK);
  }

}
