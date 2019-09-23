package com.pth.iflow.core.controllers;

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
import com.pth.iflow.common.edo.models.WorkflowOfferListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.core.model.WorkflowOffer;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowOfferService;

@RestController
@RequestMapping
public class WorkflowOfferController {

  final IWorkflowOfferService workflowOfferService;

  public WorkflowOfferController(@Autowired final IWorkflowOfferService workflowOfferService) {
    this.workflowOfferService = workflowOfferService;

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWOFFER_READ_BY_USER)
  public ResponseEntity<WorkflowOfferListEdo> readWorkflow(@PathVariable(required = true) final Long userid, @PathVariable(required = false) Integer status, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    status = status == null ? 0 : status;

    final List<WorkflowOffer> offerList = this.workflowOfferService.getListByUserId(userid, status);

    return ControllerHelper.createResponseEntity(request,
                                                 new WorkflowOfferListEdo(CoreModelEdoMapper.toWorkflowOfferEdoList(offerList)),
                                                 HttpStatus.OK);
  }

}
