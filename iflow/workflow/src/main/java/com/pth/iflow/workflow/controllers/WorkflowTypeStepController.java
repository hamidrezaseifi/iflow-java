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
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepProcessService;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@RestController
@RequestMapping
public class WorkflowTypeStepController {
  
  final IWorkflowTypeStepProcessService workflowStepProcessService;
  
  public WorkflowTypeStepController(@Autowired final IWorkflowTypeStepProcessService workflowStepProcessService) {
    this.workflowStepProcessService = workflowStepProcessService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_BY_ID)
  public ResponseEntity<WorkflowTypeStepEdo> readDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final WorkflowTypeStep model = this.workflowStepProcessService.getById(id, tokenId);
    
    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST)
  public ResponseEntity<WorkflowTypeStepListEdo> readByList(@RequestBody final List<Long> idList, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final List<WorkflowTypeStep> modelList = this.workflowStepProcessService.getListByIdList(idList, tokenId);
    
    return ControllerHelper.createResponseEntity(request, new WorkflowTypeStepListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW)
  public ResponseEntity<WorkflowTypeStepListEdo> readListByWorkflowId(@PathVariable final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final List<WorkflowTypeStep> modelList = this.workflowStepProcessService.getListByWorkflowId(id, tokenId);
    
    return ControllerHelper.createResponseEntity(request, new WorkflowTypeStepListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }
  
}
