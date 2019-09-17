package com.pth.iflow.core.controllers;

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
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.mapper.ModelEdoMapper;
import com.pth.iflow.core.service.IDepartmentGroupService;

@RestController
@RequestMapping
public class DepartmentGroupController {

  final IDepartmentGroupService departmentGroupService;

  public DepartmentGroupController(@Autowired final IDepartmentGroupService departmentGroupService) {
    this.departmentGroupService = departmentGroupService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_BY_ID)
  public ResponseEntity<DepartmentGroupEdo> readDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final DepartmentGroup model = this.departmentGroupService.getById(id);

    return ControllerHelper.createResponseEntity(request, ModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST)
  public ResponseEntity<List<DepartmentGroupEdo>> readDepartmentList(@RequestBody final List<Long> idList, final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, ModelEdoMapper.toDepartmentGroupEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT)
  public ResponseEntity<DepartmentGroupListEdo> readDepartmentListByDepartment(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByDepartmentId(id);

    return ControllerHelper.createResponseEntity(request,
                                                 new DepartmentGroupListEdo(ModelEdoMapper.toDepartmentGroupEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUP)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final List<User> modelList = this.departmentGroupService.getAllUserListByDepartmentGroupId(id);

    return ControllerHelper.createResponseEntity(request,
                                                 new UserListEdo(ModelEdoMapper.toUserEdoList(modelList)),
                                                 HttpStatus.OK);
  }

}
