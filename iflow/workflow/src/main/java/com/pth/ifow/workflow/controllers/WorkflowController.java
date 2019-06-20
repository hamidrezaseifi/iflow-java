package com.pth.ifow.workflow.controllers;

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
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowService;
import com.pth.ifow.workflow.models.Workflow;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowService workflowService;

  public WorkflowController(@Autowired final IWorkflowService workflowService) {
    this.workflowService = workflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_ID, produces = { MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final Workflow model = this.workflowService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST, produces = { MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, Workflow.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_COMPANY, produces = { MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<WorkflowEdo>> readWorkflowListByCompany(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdCompanyId(id);

    return ControllerHelper.createResponseEntity(request, Workflow.toEdoList(modelList), HttpStatus.OK);
  }

}
