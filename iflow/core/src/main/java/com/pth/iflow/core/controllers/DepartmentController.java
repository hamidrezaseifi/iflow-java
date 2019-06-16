package com.pth.iflow.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.ModelMapperBase;
import com.pth.iflow.core.service.IDepartmentService;

@RestController
@RequestMapping
public class DepartmentController {

  final IDepartmentService departmentService;

  public DepartmentController(@Autowired final IDepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.DEPARTMENT_READ_BY_ID, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<DepartmentEdo> readDepartments(@PathVariable final Long id) throws Exception {

    final Department model = departmentService.getById(id);

    return new ResponseEntity<>(model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.Core.DEPARTMENT_READ_LIST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentEdo>> readDepartmentList(@RequestBody final List<Long> idList) throws Exception {

    final List<Department> modelList = departmentService.getListByIdList(idList);

    return new ResponseEntity<>(ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.DEPARTMENT_READ_LIST_BY_COMPANY, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentEdo>> readDepartmentListByCompany(@PathVariable final Long id) throws Exception {

    final List<Department> modelList = departmentService.getListByIdCompanyId(id);

    return new ResponseEntity<>(ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

}
