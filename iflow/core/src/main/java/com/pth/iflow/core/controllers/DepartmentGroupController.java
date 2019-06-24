package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.pth.iflow.common.controllers.helper.ControllerHelper;
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
  @GetMapping(path = IflowRestPaths.CoreModul.DEPARTMENTGRPUP_READ_BY_ID, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<DepartmentGroupEdo> readDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {
    
    final DepartmentGroup model = this.departmentGroupService.getById(id);
    
    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.CoreModul.DEPARTMENTGRPUP_READ_LIST, consumes = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
          MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<DepartmentGroupEdo>> readDepartmentList(@RequestBody final List<Long> idList,
      final HttpServletRequest request) throws Exception {
    
    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByIdList(idList);
    
    return ControllerHelper.createResponseEntity(request, DepartmentGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<DepartmentGroupEdo>> readDepartmentListByCompany(@PathVariable final Long id,
      final HttpServletRequest request) throws Exception {
    
    final List<DepartmentGroup> modelList = this.departmentGroupService.getListByDepartmentId(id);
    
    return ControllerHelper.createResponseEntity(request, DepartmentGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
}
