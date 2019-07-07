package com.pth.ifow.workflow.controllers;

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
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
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
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_ID)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final Workflow model = this.workflowService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_SAVE)
  public ResponseEntity<WorkflowEdo> saveWorkflow(@RequestBody final WorkflowEdo workflowEdo, final HttpServletRequest request)
      throws Exception {

    final Workflow model = this.workflowService.save(new Workflow().fromEdo(workflowEdo));

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_TYPE)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowListByType(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByTypeId(id);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_USER)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowListForUser(@PathVariable final Long id, @PathVariable final int status,
      final HttpServletRequest request) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListForUser(id, status);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

}
