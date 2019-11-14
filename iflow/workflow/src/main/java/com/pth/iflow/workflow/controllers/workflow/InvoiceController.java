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
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;

@RestController
@RequestMapping
public class InvoiceController {

  final IWorkflowProcessService<InvoiceWorkflow> workflowService;

  public InvoiceController(@Autowired final IWorkflowProcessService<InvoiceWorkflow> invoiceWorkflowService) {
    this.workflowService = invoiceWorkflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_READ_BY_IDENTITY)
  public ResponseEntity<InvoiceWorkflowEdo> readInvoice(@PathVariable final String identity, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final InvoiceWorkflow model = this.workflowService.getByIdentity(identity, headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_CREATE)
  public ResponseEntity<InvoiceWorkflowListEdo> createInvoice(@RequestBody final InvoiceWorkflowSaveRequestEdo workflowCreateRequestEdo, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService
                                                                .create(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo),
                                                                        headerTokenId);

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(modelList)),
                                                 HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_SAVE)
  public ResponseEntity<InvoiceWorkflowEdo> saveInvoice(@RequestBody final InvoiceWorkflowSaveRequestEdo requestEdo, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final InvoiceWorkflow model = this.workflowService.save(WorkflowModelEdoMapper.fromEdo(requestEdo), headerTokenId);

    return ControllerHelper.createResponseEntity(request, WorkflowModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_READ_LIST)
  public ResponseEntity<InvoiceWorkflowListEdo> readInvoiceList(@RequestBody final Set<String> idList, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.getListByIdentityList(idList, headerTokenId);

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_READ_LIST_BY_USEREMAIL)
  public ResponseEntity<InvoiceWorkflowListEdo> readInvoiceListForUser(@PathVariable final String email, @PathVariable(required = false) final int status, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.getListForUser(email, status, headerTokenId);

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_SEARCH)
  public ResponseEntity<InvoiceWorkflowListEdo> searchInvoice(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.search(WorkflowModelEdoMapper.fromEdo(workflowSearchFilterEdo),
                                                                        headerTokenId);

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.WorkflowModule.INVOICE_VALIDATE)
  public void validateInvoiceRequest(@RequestBody final InvoiceWorkflowSaveRequestEdo workflowCreateRequestEdo, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws Exception {

    this.workflowService.validate(WorkflowModelEdoMapper.fromEdo(workflowCreateRequestEdo), headerTokenId);

  }

}
