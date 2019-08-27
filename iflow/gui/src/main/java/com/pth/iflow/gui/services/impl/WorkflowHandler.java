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
import com.pth.iflow.gui.models.GuiWorkflowAction;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowHandler.class);

  private final IWorkflowAccess workflowAccess;

  private final GuiSessionUserInfo sessionUserInfo;

  public WorkflowHandler(@Autowired final IWorkflowAccess workflowAccess,
                         @Autowired final GuiSessionUserInfo sessionUserInfo) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException {
    final GuiWorkflow wirkflow = this.workflowAccess.readWorkflow(workflowId, this.sessionUserInfo.getToken());
    return prepareWorkflow(wirkflow);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest) throws GuiCustomizedException,
                                                                                        MalformedURLException {
    final List<GuiWorkflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());

    return prepareWorkflowList(list);
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

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeById(workflow.getWorkflowTypeId()));
    workflow.setAssignToUser(this.sessionUserInfo.getUserById(workflow.getAssignTo()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserById(workflow.getCreatedBy()));
    workflow.setControllerUser(this.sessionUserInfo.getUserById(workflow.getController()));

    prepareWorkflowActions(workflow);

    return workflow;
  }

  private GuiWorkflow prepareWorkflowActions(final GuiWorkflow workflow) {
    for (final GuiWorkflowAction action : workflow.getActions()) {
      if ((action.isRunning()) && (action.getCreatedBy() == this.sessionUserInfo.getUser().getId())) {
        action.setActive(true);
        break;
      }
    }

    if (!workflow.hasActiveAction()) {
      final GuiWorkflowAction action = GuiWorkflowAction.createNewAction(workflow, this.sessionUserInfo.getUser().getId(), true);

      workflow.addAction(action);
    }

    return workflow;
  }

}
