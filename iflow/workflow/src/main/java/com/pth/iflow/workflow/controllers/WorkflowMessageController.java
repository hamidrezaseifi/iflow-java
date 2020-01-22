package com.pth.iflow.workflow.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.models.edo.WorkflowMessageListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

@RestController
@RequestMapping
public class WorkflowMessageController {

  final IWorkflowMessageDataService workflowMessageDataService;

  public WorkflowMessageController(@Autowired final IWorkflowMessageDataService workflowMessageDataService) {

    this.workflowMessageDataService = workflowMessageDataService;

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWMESSAGE_READ_BY_USERIDENTITY)
  public ResponseEntity<WorkflowMessageListEdo> readUserWorkflowMessageList(@PathVariable(required = true) final String identity,
      @PathVariable(required = false) Integer status, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    status = status == null ? 0 : status;

    final List<WorkflowMessage> messageList = this.workflowMessageDataService.getListForUser(identity, status, headerTokenId);

    return ControllerHelper
        .createResponseEntity(request,
            new WorkflowMessageListEdo(WorkflowModelEdoMapper.toWorkflowMessageEdoList(messageList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWMESSAGE_READ_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowMessageListEdo> readWorkfloWorkflowMessageList(@PathVariable(required = true) final String identity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<WorkflowMessage> messageList = this.workflowMessageDataService.getListForWorkflow(identity, headerTokenId);

    return ControllerHelper
        .createResponseEntity(request,
            new WorkflowMessageListEdo(WorkflowModelEdoMapper.toWorkflowMessageEdoList(messageList)), HttpStatus.OK);
  }

}
