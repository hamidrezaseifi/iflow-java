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
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowTypeStepService;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@RestController
@RequestMapping
public class WorkflowTypeStepController {

  final IWorkflowTypeStepService workflowStepService;

  public WorkflowTypeStepController(@Autowired final IWorkflowTypeStepService workflowStepService) {
    this.workflowStepService = workflowStepService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_BY_ID, produces = { MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<WorkflowTypeStepEdo> readDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final WorkflowTypeStep model = this.workflowStepService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST, produces = { MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<WorkflowTypeStepEdo>> readDepartmentList(@RequestBody final List<Long> idList,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowTypeStep> modelList = this.workflowStepService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<WorkflowTypeStepEdo>> readDepartmentListByCompany(@PathVariable final Long id,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowTypeStep> modelList = this.workflowStepService.getListByWorkflowId(id);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(modelList), HttpStatus.OK);
  }

}
