package com.pth.iflow.core.controllers;

import java.util.List;
import java.util.Set;

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
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IDepartmentGroupService;

@RestController
@RequestMapping
public class DepartmentGroupController {

  final IDepartmentGroupService departmentGroupService;

  public DepartmentGroupController(@Autowired final IDepartmentGroupService departmentGroupService) {
    this.departmentGroupService = departmentGroupService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_BY_IDENTITY)
  public ResponseEntity<DepartmentGroupEdo> readDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final DepartmentGroup model = this.departmentGroupService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST)
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentList(@RequestBody final Set<String> idList,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByIdentityList(idList);

    return ControllerHelper.createResponseEntity(request,
        new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENTIDENTITY)
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentListByDepartment(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByDepartmentIdentity(identity);

    return ControllerHelper.createResponseEntity(request,
        new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<User> modelList = this.departmentGroupService.getAllUserListByDepartmentGroupId(identity);

    return ControllerHelper.createResponseEntity(request, new UserListEdo(CoreModelEdoMapper.toUserEdoList(modelList)), HttpStatus.OK);
  }

}
