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

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.service.IDepartmentGroupService;

@RestController
@RequestMapping
public class DepartmentGroupController {
  
  final IDepartmentGroupService departmentGroupService;
  
  public DepartmentGroupController(@Autowired final IDepartmentGroupService departmentGroupService) {
    this.departmentGroupService = departmentGroupService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.DEPARTMENTGRPUP_READ_BY_ID, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<DepartmentGroupEdo> readDepartmentGroup(@PathVariable final Long id) throws Exception {
    
    final DepartmentGroup model = this.departmentGroupService.getById(id);
    
    return new ResponseEntity<>(model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.Core.DEPARTMENTGRPUP_READ_LIST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentGroupEdo>> readDepartmentList(@RequestBody final List<Long> idList) throws Exception {
    
    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByIdList(idList);
    
    return new ResponseEntity<>(DepartmentGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentGroupEdo>> readDepartmentListByCompany(@PathVariable final Long id) throws Exception {

    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByDepartmentId(id);

    return new ResponseEntity<>(DepartmentGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
}