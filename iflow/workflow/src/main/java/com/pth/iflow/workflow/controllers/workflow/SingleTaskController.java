package com.pth.iflow.workflow.controllers.workflow;

import java.util.List;
import java.util.Set;

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
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;

@RestController
@RequestMapping
public class SingleTaskController {

  final IWorkflowProcessService<SingleTaskWorkflow> workflowService;

  public SingleTaskController(@Autowired final IWorkflowProcessService<SingleTaskWorkflow> workflowService) {
    this.workflowService = workflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<SingleTaskWorkflowEdo> readWorkflow(@PathVariable final String identity, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final SingleTaskWorkflow model = this.workflowService.getByIdentity(identity, headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_CREATE)
  public ResponseEntity<SingleTaskWorkflowListEdo> createWorkflow(
      @RequestBody final SingleTaskWorkflowSaveRequestEdo workflowCreateRequestEdo, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<SingleTaskWorkflow> modelList = this.workflowService.create(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo),
        headerTokenId);

    return ControllerHelper.createResponseEntity(request,
        new SingleTaskWorkflowListEdo(WorkflowModelEdoMapper.toSingleTaskWorkflowEdoList(modelList)), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_SAVE)
  public ResponseEntity<SingleTaskWorkflowEdo> saveWorkflow(@RequestBody final SingleTaskWorkflowSaveRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final SingleTaskWorkflow model = this.workflowService.save(WorkflowModelEdoMapper.fromEdo(requestEdo), headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_READ_LIST)
  public ResponseEntity<SingleTaskWorkflowListEdo> readWorkflowList(@RequestBody final Set<String> idList,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<SingleTaskWorkflow> modelList = this.workflowService.getListByIdentityList(idList, headerTokenId);

    return ControllerHelper.createResponseEntity(request,
        new SingleTaskWorkflowListEdo(WorkflowModelEdoMapper.toSingleTaskWorkflowEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_READ_LIST_BY_USEREMAIL)
  public ResponseEntity<SingleTaskWorkflowListEdo> readWorkflowListForUser(@PathVariable final String email,
      @PathVariable(required = false) final int status, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<SingleTaskWorkflow> modelList = this.workflowService.getListForUser(email, status, headerTokenId);

    return ControllerHelper.createResponseEntity(request,
        new SingleTaskWorkflowListEdo(WorkflowModelEdoMapper.toSingleTaskWorkflowEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.SINGLETASKWORKFLOW_VALIDATE)
  public void validateWorkflowRequest(@RequestBody final SingleTaskWorkflowSaveRequestEdo workflowCreateRequestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    this.workflowService.validate(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo), headerTokenId);

  }

}
