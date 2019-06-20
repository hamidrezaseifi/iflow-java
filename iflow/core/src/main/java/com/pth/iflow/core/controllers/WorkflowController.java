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

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.service.IWorkflowService;

@RestController
@RequestMapping
public class WorkflowController {
  
  final IWorkflowService workflowService;
  
  public WorkflowController(@Autowired final IWorkflowService workflowService) {
    this.workflowService = workflowService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.WORKFLOW_READ_BY_ID, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final Long id) throws Exception {
    
    final Workflow model = this.workflowService.getById(id);
    
    return new ResponseEntity<>(model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.Core.WORKFLOW_READ_LIST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowList(@RequestBody final List<Long> idList) throws Exception {
    
    final List<Workflow> modelList = this.workflowService.getListByIdList(idList);
    
    return new ResponseEntity<>(Workflow.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.WORKFLOW_READ_LIST_BY_COMPANY, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowListByCompany(@PathVariable final Long id) throws Exception {
    
    final List<Workflow> modelList = this.workflowService.getListByIdCompanyId(id);
    
    return new ResponseEntity<>(Workflow.toEdoList(modelList), HttpStatus.OK);
  }
  
}