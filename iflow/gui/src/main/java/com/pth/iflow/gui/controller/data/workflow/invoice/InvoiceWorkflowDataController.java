package com.pth.iflow.gui.controller.data.workflow.invoice;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.data.workflow.WorkflowDataControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.INVOICEWORKFLOW_DATA_BASE)
public class InvoiceWorkflowDataController extends WorkflowDataControllerBase<InvoiceWorkflow, InvoiceWorkflowSaveRequest> {

  @Override
  protected InvoiceWorkflow generateInitialWorkflow(final String userIdentity) {

    final InvoiceWorkflow workflow = InvoiceWorkflow.generateInitial(userIdentity);
    workflow.setWorkflowType(this.getWorkflowTypeByEnumType(EWorkflowType.INVOICE_WORKFLOW_TYPE));
    workflow.setIsDirectDebitPermission(false);
    return workflow;
  }

  @Override
  protected InvoiceWorkflowSaveRequest generateInitialWorkflowSaveRequest(final InvoiceWorkflow workflow, final int expireDays) {

    return InvoiceWorkflowSaveRequest.generateNewWihExpireDays(workflow, expireDays);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/uploadinvoicefile" })
  @ResponseBody
  public GuiSocketMessage createWorkflowFile(@RequestParam(value = "file") final MultipartFile file)
      throws GuiCustomizedException, JsonParseException, JsonMappingException, IOException {

    final GuiSocketMessage results = GuiSocketMessage.generate("processing");

    if (file != null && file.getOriginalFilename().isEmpty() == false) {
      final String tempPath = this.uploadFileManager.saveSingleMultipartInTemp(file);

      final File tempFile = new File(tempPath);
      String hocrpPath = tempFile.getParent() + "/" + tempFile.getName() + ".hocr";
      hocrpPath = hocrpPath.replace("\\", "/");

      results.setStatus("done");
      results.setFileNotHash(tempPath);
      results.setHocrFileNotHash(hocrpPath);

    }

    return results;

  }

}
