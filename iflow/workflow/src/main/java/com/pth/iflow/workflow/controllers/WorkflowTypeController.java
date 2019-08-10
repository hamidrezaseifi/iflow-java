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
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.models.WorkflowType;

@RestController
@RequestMapping
public class WorkflowTypeController {
  
  final IWorkflowTypeProcessService workflowTypeProcessService;
  
  public WorkflowTypeController(@Autowired final IWorkflowTypeProcessService workflowTypeProcessService) {
    this.workflowTypeProcessService = workflowTypeProcessService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_BY_ID)
  
  public ResponseEntity<WorkflowTypeEdo> readWorkflowType(@PathVariable final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final WorkflowType model = this.workflowTypeProcessService.getById(id, tokenId);
    
    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST)
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final List<WorkflowType> modelList = this.workflowTypeProcessService.getListByIdList(idList, tokenId);
    
    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST_BY_COMPANY)
  
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowListByCompany(@PathVariable final Long id, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String tokenId) throws Exception {
    
    final List<WorkflowType> modelList = this.workflowTypeProcessService.getListByIdCompanyId(id, tokenId);
    
    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }
  
}