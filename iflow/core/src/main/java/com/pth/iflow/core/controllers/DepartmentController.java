package com.pth.iflow.core.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RestController
@RequestMapping
public class DepartmentController {

  final IDepartmentService departmentService;
  final IUsersService      userService;

  public DepartmentController(@Autowired final IDepartmentService departmentService, @Autowired final IUsersService userService) {
    this.departmentService = departmentService;
    this.userService = userService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_BY_IDENTITY)
  public ResponseEntity<DepartmentEdo> readDepartment(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final DepartmentEntity model = this.departmentService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, this.departmentService.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST)
  public ResponseEntity<DepartmentListEdo> readDepartmentList(@RequestBody final IdentityListEdo idList,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentEntity> modelList = idList.getIdentityList().isEmpty() ? new ArrayList<>()
        : this.departmentService.getListByIdentityList(idList.getIdentityList());

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(this.departmentService.toEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST_BY_COMPANYIDENTITY)
  public ResponseEntity<DepartmentListEdo> readDepartmentListByCompany(
      @PathVariable(name = "companyidentity") final String companyidentity, final HttpServletRequest request) throws Exception {

    final List<DepartmentEntity> modelList = this.departmentService.getListByIdCompanyIdentity(companyidentity);

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(this.departmentService.toEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENTIDENTITY)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> modelList = this.userService.getAllUserIdentityListByDepartmentIdentity(identity);

    return ControllerHelper.createResponseEntity(request, new UserListEdo(this.userService.toEdoList(modelList)), HttpStatus.OK);
  }
}
