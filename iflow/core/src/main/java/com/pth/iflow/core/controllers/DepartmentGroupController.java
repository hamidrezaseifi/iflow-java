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
import com.pth.iflow.common.models.edo.DepartmentGroupEdo;
import com.pth.iflow.common.models.edo.DepartmentGroupListEdo;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RestController
@RequestMapping
public class DepartmentGroupController {

  final IDepartmentGroupService departmentGroupService;
  final IUsersService userService;

  public DepartmentGroupController(@Autowired final IDepartmentGroupService departmentGroupService,
      @Autowired final IUsersService userService) {

    this.departmentGroupService = departmentGroupService;
    this.userService = userService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_BY_IDENTITY)
  public ResponseEntity<DepartmentGroupEdo> readDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final DepartmentGroupEntity model = this.departmentGroupService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, this.departmentGroupService.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_SAVE)
  public ResponseEntity<DepartmentGroupEdo> saveDepartmentGroup(@RequestBody final DepartmentGroupEdo edo,
      final HttpServletRequest request) throws Exception {

    final DepartmentGroupEntity model = this.departmentGroupService.save(this.departmentGroupService.fromEdo(edo));

    return ControllerHelper.createResponseEntity(request, this.departmentGroupService.toEdo(model), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_DELETE)
  public void deleteDepartmentGroup(@RequestBody final DepartmentGroupEdo edo,
      final HttpServletRequest request) throws Exception {

    this.departmentGroupService.delete(this.departmentGroupService.fromEdo(edo));

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST)
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentList(@RequestBody final IdentityListEdo idList,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroupEntity> modelList = idList.getIdentityList().isEmpty() ? new ArrayList<>()
        : this.departmentGroupService.getListByIdentityList(idList.getIdentityList());

    return ControllerHelper
        .createResponseEntity(request, new DepartmentGroupListEdo(this.departmentGroupService.toEdoList(modelList)),
            HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> modelList = this.userService.getAllUserIdentityListByDepartmentGroupIdentity(identity);

    return ControllerHelper.createResponseEntity(request, new UserListEdo(this.userService.toEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_GET_MANAGER)
  public ResponseEntity<UserEdo> getDepartmentGroupManager(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final UserEntity model = this.departmentGroupService.getDepartmentGroupManager(identity);

    return ControllerHelper.createResponseEntity(request, this.userService.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_GET_DEPUTY)
  public ResponseEntity<UserEdo> getDepartmentGroupDeputy(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final UserEntity model = this.departmentGroupService.getDepartmentGroupDeputy(identity);

    return ControllerHelper.createResponseEntity(request, this.userService.toEdo(model), HttpStatus.OK);
  }

}
