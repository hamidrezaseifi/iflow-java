package com.pth.ifow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class DepartmentGroupController {

  private final ITokenUserDataManager tokenUserDataManager;

  public DepartmentGroupController(@Autowired final ITokenUserDataManager tokenUserDataManager) {

    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENTGROUP_READ_BY_ID)
  @ResponseBody
  public ResponseEntity<DepartmentGroupEdo> readById(@PathVariable(name = "id") final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final DepartmentGroup model = this.tokenUserDataManager.getDepartmentGroupById(headerTokenId, id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENTGROUP_READ_USER_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "id") final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<User> list = this.tokenUserDataManager.getAllUserListByDepartmentGroupId(headerTokenId, id);

    final UserListEdo edo = new UserListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

}
