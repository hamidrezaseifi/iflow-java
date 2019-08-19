package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowHandler.class);

  private final IWorkflowAccess workflowAccess;

  private final GuiSessionUserInfo sessionUserInfo;

  public WorkflowHandler(@Autowired final IWorkflowAccess workflowAccess,
                         @Autowired final GuiSessionUserInfo sessionUserInfo,
                         @Autowired final IUserAccess userAccess) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException {
    return this.workflowAccess.readWorkflow(workflowId, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest) throws GuiCustomizedException,
                                                                                        MalformedURLException {
    return this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException {
    return this.workflowAccess.saveWorkflow(workflow, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final Long companyId) throws GuiCustomizedException, MalformedURLException {
    return this.workflowAccess.readWorkflowTypeList(companyId, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException,
                                                                                              MalformedURLException {
    final List<GuiWorkflow> list = this.workflowAccess.searchWorkflow(workflowSearchFilter, this.sessionUserInfo.getToken());

    return prepareWorkflowList(list);
  }

  private List<GuiWorkflow> prepareWorkflowList(final List<GuiWorkflow> pureWorkflowList) {

    final List<GuiWorkflow> workflowList = new ArrayList<>();

    for (final GuiWorkflow workflow : pureWorkflowList) {
      workflowList.add(prepareWorkflow(workflow));
    }

    return workflowList;
  }

  private GuiWorkflow prepareWorkflow(final GuiWorkflow workflow) {

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeMap().get(workflow.getWorkflowTypeId()));
    workflow.setAssignToUser(this.sessionUserInfo.getUserMap().get(workflow.getAssignTo()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserMap().get(workflow.getCreatedBy()));
    workflow.setControllerUser(this.sessionUserInfo.getUserMap().get(workflow.getController()));

    return workflow;
  }

}
