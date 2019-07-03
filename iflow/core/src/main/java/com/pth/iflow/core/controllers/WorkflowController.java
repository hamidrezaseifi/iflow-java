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
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.service.IWorkflowService;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowService workflowService;
  final IWorkflowActionService workflowActionService;
  final IWorkflowFileService workflowFileService;

  public WorkflowController(@Autowired final IWorkflowService workflowService,
      @Autowired final IWorkflowActionService workflowActionService, @Autowired final IWorkflowFileService workflowFileService) {
    this.workflowService = workflowService;
    this.workflowActionService = workflowActionService;
    this.workflowFileService = workflowFileService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_READ_BY_ID)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final Workflow model = this.workflowService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_SAVE)
  public ResponseEntity<WorkflowEdo> saveWorkflow(@RequestBody final WorkflowEdo workflowEdo, final HttpServletRequest request)
      throws Exception {

    final Workflow model = this.workflowService.save(new Workflow().fromEdo(workflowEdo));

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_READ_LIST)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_READ_LIST_BY_TYPE)
  public ResponseEntity<List<WorkflowEdo>> readWorkflowListByCompany(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdTypeId(id);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_ACTION_READ_BY_ID)
  public ResponseEntity<WorkflowActionEdo> readWorkflowAction(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final WorkflowAction model = this.workflowActionService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_ACTION_SAVE)
  public ResponseEntity<WorkflowActionEdo> saveWorkflowAction(@RequestBody final WorkflowActionEdo workflowActionEdo,
      final HttpServletRequest request) throws Exception {

    final WorkflowAction model = this.workflowActionService.save(new WorkflowAction().fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_ACTION_READ_LIST_BY_WORKFLOW)
  public ResponseEntity<List<WorkflowActionEdo>> readWorkflowActionListByWorkflow(@PathVariable final Long id,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowAction> modelList = this.workflowActionService.getListByIdWorkflowId(id);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_FILE_READ_BY_ID)
  public ResponseEntity<WorkflowFileEdo> readWorkflowFile(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final WorkflowFile model = this.workflowFileService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_FILE_SAVE)
  public ResponseEntity<WorkflowFileEdo> saveWorkflowFile(@RequestBody final WorkflowFileEdo workflowActionEdo,
      final HttpServletRequest request) throws Exception {

    final WorkflowFile model = this.workflowFileService.save(new WorkflowFile().fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.WORKFLOW_FILE_READ_LIST_BY_WORKFLOW)
  public ResponseEntity<List<WorkflowFileEdo>> readWorkflowFileListByWorkflow(@PathVariable final Long id,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowFile> modelList = this.workflowFileService.getListByIdWorkflowId(id);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

}
