package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

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
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;
import com.pth.iflow.profile.service.handler.IUsersHandlerService;

@RestController
@RequestMapping
public class UserController {

  private final ITokenUserDataManager tokenUserDataManager;
  private final IUsersHandlerService usersHandlerService;

  public UserController(@Autowired final ITokenUserDataManager tokenUserDataManager,
      @Autowired final IUsersHandlerService usersHandlerService) {

    this.tokenUserDataManager = tokenUserDataManager;
    this.usersHandlerService = usersHandlerService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.USER_READ_BY_IDENTITY)
  @ResponseBody
  public ResponseEntity<UserEdo> readUserByIdentity(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request,
      @RequestHeader(
        TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
      ) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    final User user = this.usersHandlerService.getUserByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(user), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_SAVE)
  @ResponseBody
  public ResponseEntity<UserEdo> saveUser(@RequestBody final UserEdo userEdo,
      final HttpServletRequest request,
      @RequestHeader(
        TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
      ) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    final User user = this.usersHandlerService.saveUser(ProfileModelEdoMapper.fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(user), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.USER_DELETE)
  @ResponseBody
  public void deleteUser(@RequestBody final UserEdo userEdo,
      final HttpServletRequest request,
      @RequestHeader(
        TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
      ) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    this.usersHandlerService.deleteUser(ProfileModelEdoMapper.fromEdo(userEdo));

  }

}
