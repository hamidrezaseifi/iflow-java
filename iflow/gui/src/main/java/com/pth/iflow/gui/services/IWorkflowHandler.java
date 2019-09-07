package com.pth.iflow.gui.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;

public interface IWorkflowHandler {

  GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException;

  GuiWorkflowFile readWorkflowFile(final Long workflowId, final Long fileId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException;

  GuiWorkflow saveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException;

  GuiWorkflow doneWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException;

  GuiWorkflow archiveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException;

  List<GuiWorkflowType> readWorkflowTypeList(final Long companyId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException;

}
