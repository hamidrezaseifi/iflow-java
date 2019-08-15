package com.pth.iflow.workflow.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowProcessService workflowService;

  public WorkflowController(@Autowired final IWorkflowProcessService workflowService) {
    this.workflowService = workflowService;

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_ID)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final Long id,
                                                  final HttpServletRequest request,
                                                  @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final Workflow model = this.workflowService.getById(id, headerTokenId);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_CREATE)
  public ResponseEntity<WorkflowListEdo> createWorkflow(@RequestBody final WorkflowCreateRequestEdo workflowCreateRequestEdo,
                                                        final HttpServletRequest request,
                                                        @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<Workflow> modelList = this.workflowService.create(new WorkflowCreateRequest().fromEdo(workflowCreateRequestEdo),
                                                                 headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(Workflow.toEdoList(modelList)), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_SAVE)
  public ResponseEntity<WorkflowEdo> saveWorkflow(@RequestBody final WorkflowEdo workflowEdo,
                                                  final HttpServletRequest request,
                                                  @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final Workflow model = this.workflowService.save(new Workflow().fromEdo(workflowEdo), headerTokenId);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST)
  public ResponseEntity<WorkflowListEdo> readWorkflowList(@RequestBody final List<Long> idList,
                                                          final HttpServletRequest request,
                                                          @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdList(idList, headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_TYPE)
  public ResponseEntity<WorkflowListEdo> readWorkflowListByType(@PathVariable final Long id,
                                                                final HttpServletRequest request,
                                                                @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByTypeId(id, headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_USER)
  public ResponseEntity<WorkflowListEdo> readWorkflowListForUser(@PathVariable final Long id,
                                                                 @PathVariable final int status,
                                                                 final HttpServletRequest request,
                                                                 @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListForUser(id, status, headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(ModelMapperBase.toEdoList(modelList)), HttpStatus.OK);
  }

}
