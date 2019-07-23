package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class ProfileController {

  private final ITokenUserDataManager tokenUserDataManager;

  public ProfileController(@Autowired final ITokenUserDataManager tokenUserDataManager) {

    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readAuthenticatedInfo(@RequestBody final AuthenticatedProfileRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    if (StringUtils.isEmpty(requestEdo.getToken()) || StringUtils.isEmpty(headerTokenId)
        || (requestEdo.getToken().equals(headerTokenId) == false)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByTokenEmail(requestEdo.getEmail(), requestEdo.getToken());

    return ControllerHelper.createResponseEntity(request, profile.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readTokenInfo(@RequestBody final TokenProfileRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    if (StringUtils.isEmpty(requestEdo.getToken()) || StringUtils.isEmpty(headerTokenId)
        || (requestEdo.getToken().equals(headerTokenId) == false)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(requestEdo.getToken());

    return ControllerHelper.createResponseEntity(request, profile.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.PROFILE_VALIDATE_TOKEN)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> validateToken(@PathVariable final String requestToken,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    if (StringUtils.isEmpty(requestToken) || StringUtils.isEmpty(headerTokenId)
        || (requestToken.equals(headerTokenId) == false)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(requestToken);

    return ControllerHelper.createResponseEntity(request, profile.toEdo(), HttpStatus.OK);
  }

}
