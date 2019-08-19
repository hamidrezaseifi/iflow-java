package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;

public interface IWorkflowAccess {

  GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest)
                                                                                 throws GuiCustomizedException,
                                                                                 MalformedURLException;

  GuiWorkflow saveWorkflow(final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflowType> readWorkflowTypeList(final Long companyId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException,
                                                                                       MalformedURLException;

}
