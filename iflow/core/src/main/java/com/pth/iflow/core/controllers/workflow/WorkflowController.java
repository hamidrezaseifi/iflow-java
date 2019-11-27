package com.pth.iflow.core.controllers.workflow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.WorkflowResultEntity;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowSearchService;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowSearchService workflowSearchService;

  public WorkflowController(@Autowired final IWorkflowSearchService workflowSearchService) {
    this.workflowSearchService = workflowSearchService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_SEARCH)
  public ResponseEntity<WorkflowResultListEdo> searchWorkflow(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowResultEntity> modelList = this.workflowSearchService
        .search(CoreModelEdoMapper.fromEdo(workflowSearchFilterEdo));

    return ControllerHelper.createResponseEntity(request,
        new WorkflowResultListEdo(CoreModelEdoMapper.toWorkflowResultEntityEdoList(modelList)), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READLIST)
  public ResponseEntity<WorkflowResultListEdo> searchWorkflow(@RequestBody final IdentityListEdo identityList,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowResultEntity> modelList = this.workflowSearchService.readByIdentityList(identityList.getIdentityList());

    return ControllerHelper.createResponseEntity(request,
        new WorkflowResultListEdo(CoreModelEdoMapper.toWorkflowResultEntityEdoList(modelList)), HttpStatus.ACCEPTED);
  }

}
