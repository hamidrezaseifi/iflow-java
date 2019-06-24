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
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.service.IWorkflowService;

@RestController
@RequestMapping
public class WorkflowTypeController {
  
  final IWorkflowService workflowService;
  
  public WorkflowTypeController(@Autowired final IWorkflowService workflowService) {
    this.workflowService = workflowService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_BY_ID, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<WorkflowTypeEdo> readWorkflow(@PathVariable final Long id, final HttpServletRequest request) throws Exception {
    
    final WorkflowType model = this.workflowService.getById(id);
    
    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST, consumes = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
          MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<WorkflowTypeEdo>> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {
    
    final List<WorkflowType> modelList = this.workflowService.getListByIdList(idList);
    
    return ControllerHelper.createResponseEntity(request, WorkflowType.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST_BY_COMPANY, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<WorkflowTypeEdo>> readWorkflowListByCompany(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {
    
    final List<WorkflowType> modelList = this.workflowService.getListByIdCompanyId(id);
    
    return ControllerHelper.createResponseEntity(request, WorkflowType.toEdoList(modelList), HttpStatus.OK);
  }
  
}
