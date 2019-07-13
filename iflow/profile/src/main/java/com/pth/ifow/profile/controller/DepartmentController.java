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
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class DepartmentController {

  private final ITokenUserDataManager tokenUserDataManager;

  public DepartmentController(@Autowired final ITokenUserDataManager tokenUserDataManager) {

    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_READ_BY_ID)
  @ResponseBody
  public ResponseEntity<DepartmentEdo> readById(@PathVariable(name = "id") final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final Department model = this.tokenUserDataManager.getDepartmentById(headerTokenId, id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_READ_DEPARTMENTGROUP_LIST)
  @ResponseBody
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentGroupList(@PathVariable(name = "id") final Long id,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<DepartmentGroup> list = this.tokenUserDataManager.getDepartmentGroupListByDepartmentId(headerTokenId, id);

    final DepartmentGroupListEdo edo = new DepartmentGroupListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_READ_ALLUSERS_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "id") final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<User> list = this.tokenUserDataManager.getAllUserListByDepartmentId(headerTokenId, id);

    final UserListEdo edo = new UserListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

}
