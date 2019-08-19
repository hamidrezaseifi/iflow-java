package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuiWorkflow;
import com.pth.iflow.backend.models.GuiWorkflowCreateRequest;
import com.pth.iflow.backend.models.GuiWorkflowSearchFilter;
import com.pth.iflow.backend.models.GuiWorkflowType;

public interface IWorkflowAccess {

  GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest)
                                                                                 throws GuiCustomizedException,
                                                                                 MalformedURLException;

  GuiWorkflow saveWorkflow(final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> readWorkflowList(final Long companyId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflowType> readWorkflowTypeList(final Long companyId) throws GuiCustomizedException, MalformedURLException;

  List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException,
                                                                                       MalformedURLException;

}
