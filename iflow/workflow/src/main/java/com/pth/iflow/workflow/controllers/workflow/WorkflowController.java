package com.pth.iflow.workflow.controllers.workflow;

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
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.models.IdentityListEdo;
import com.pth.iflow.common.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.workflow.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowSearchService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.Workflow;
import com.pth.iflow.workflow.models.workflow.WorkflowResult;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowSearchService            workflowSearchService;
  final IWorkflowProcessService<Workflow> workflowService;

  public WorkflowController(@Autowired final IWorkflowSearchService workflowSearchService,
      @Autowired final IWorkflowProcessService<Workflow> workflowService) {
    this.workflowSearchService = workflowSearchService;
    this.workflowService = workflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_SEARCH)
  public ResponseEntity<WorkflowResultListEdo> searchWorkflow(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo,
      final HttpServletRequest request, @RequestHeader(
        TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
      ) final String headerTokenId) throws Exception {

    final List<
        WorkflowResult> modelList = this.workflowSearchService.search(WorkflowModelEdoMapper.fromEdo(workflowSearchFilterEdo), headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowResultListEdo(WorkflowModelEdoMapper.toWorkflowResultEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READLISTBY_IDENTITYLIST)
  public ResponseEntity<WorkflowResultListEdo> readWorkflowList(@RequestBody final IdentityListEdo identityList,
      final HttpServletRequest request, @RequestHeader(
        TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
      ) final String headerTokenId) throws Exception {

    final List<
        WorkflowResult> modelList = this.workflowSearchService.readWorkflowListByIdentityList(identityList.getIdentityList(), headerTokenId);

    return ControllerHelper.createResponseEntity(request, new WorkflowResultListEdo(WorkflowModelEdoMapper.toWorkflowResultEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable final String identity, final HttpServletRequest request, @RequestHeader(
    TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY
  ) final String headerTokenId) throws Exception {

    final Workflow model = this.workflowService.getByIdentity(identity, headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

}
