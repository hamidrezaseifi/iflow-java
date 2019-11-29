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
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RestController
@RequestMapping
public class DepartmentGroupController {

  final IDepartmentGroupService departmentGroupService;
  final IUsersService           userService;

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

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST)
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentList(@RequestBody final IdentityListEdo idList,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroupEntity> modelList = idList.getIdentityList().isEmpty() ? new ArrayList<>()
        : this.departmentGroupService.getListByIdentityList(idList.getIdentityList());

    return ControllerHelper.createResponseEntity(request,
        new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> modelList = this.userService.getAllUserIdentityListByDepartmentGroupId(identity);

    return ControllerHelper.createResponseEntity(request, new UserListEdo(CoreModelEdoMapper.toUserEdoList(modelList)), HttpStatus.OK);
  }

}
