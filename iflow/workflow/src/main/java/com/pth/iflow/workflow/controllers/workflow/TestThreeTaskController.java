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
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;

@RestController
@RequestMapping
public class TestThreeTaskController {

  final IWorkflowProcessService<TestThreeTaskWorkflow> workflowService;

  public TestThreeTaskController(@Autowired final IWorkflowProcessService<TestThreeTaskWorkflow> workflowService) {

    this.workflowService = workflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<TestThreeTaskWorkflowEdo> readWorkflow(@PathVariable final String identity, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final TestThreeTaskWorkflow model = this.workflowService.getByIdentity(identity, headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_CREATE)
  public ResponseEntity<TestThreeTaskWorkflowListEdo> createWorkflow(
      @RequestBody final TestThreeTaskWorkflowSaveRequestEdo workflowCreateRequestEdo, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<TestThreeTaskWorkflow> modelList = this.workflowService
        .create(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo),
            headerTokenId);

    return ControllerHelper
        .createResponseEntity(request,
            new TestThreeTaskWorkflowListEdo(WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(modelList)), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_SAVE)
  public ResponseEntity<TestThreeTaskWorkflowEdo> saveWorkflow(@RequestBody final TestThreeTaskWorkflowSaveRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final TestThreeTaskWorkflow model = this.workflowService.save(WorkflowModelEdoMapper.fromEdo(requestEdo), headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_READ_LIST)
  public ResponseEntity<TestThreeTaskWorkflowListEdo> readWorkflowList(@RequestBody final Set<String> idList,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<TestThreeTaskWorkflow> modelList = this.workflowService.getListByIdentityList(idList, headerTokenId);

    return ControllerHelper
        .createResponseEntity(request,
            new TestThreeTaskWorkflowListEdo(WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_READ_LIST_BY_USERIDENTITY)
  public ResponseEntity<TestThreeTaskWorkflowListEdo> readWorkflowListForUser(@PathVariable final String Identity,
      @PathVariable(required = false) final int status, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<TestThreeTaskWorkflow> modelList = this.workflowService.getListForUser(Identity, status, headerTokenId);

    return ControllerHelper
        .createResponseEntity(request,
            new TestThreeTaskWorkflowListEdo(WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_VALIDATE)
  public void validateWorkflowRequest(@RequestBody final TestThreeTaskWorkflowSaveRequestEdo workflowCreateRequestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    this.workflowService.validate(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo), headerTokenId);

  }

}
