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
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IDepartmentService;

@RestController
@RequestMapping
public class DepartmentController {

  final IDepartmentService departmentService;

  public DepartmentController(@Autowired final IDepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_BY_ID)
  public ResponseEntity<DepartmentEdo> readDepartment(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final Department model = this.departmentService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST)
  public ResponseEntity<DepartmentListEdo> readDepartmentList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {

    final List<Department> modelList = this.departmentService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST_BY_COMPANY)
  public ResponseEntity<DepartmentListEdo> readDepartmentListByCompany(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<Department> modelList = this.departmentService.getListByIdCompanyId(id);

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENT)
  public ResponseEntity<UserListEdo> readAllUserListByDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<User> modelList = this.departmentService.getAllUserListByDepartmentId(id);

    return ControllerHelper.createResponseEntity(request, new UserListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }
}
