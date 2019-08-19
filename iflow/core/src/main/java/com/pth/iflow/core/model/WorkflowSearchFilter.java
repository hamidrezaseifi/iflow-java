package com.pth.iflow.core.model;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.xml.WorkflowSearchFilterEdo;

public class WorkflowSearchFilter {

  private List<Long>    assignedUserIdList  = new ArrayList<>();

  private List<Integer> statusList          = new ArrayList<>();

  private List<Long>    workflowTypeIdList  = new ArrayList<>();

  private List<Long>    workflowStepeIdList = new ArrayList<>();

  private String        title;

  public List<Long> getAssignedUserIdList() {
    return this.assignedUserIdList;
  }

  public void setAssignedUserIdList(final List<Long> assignedUserIdList) {
    this.assignedUserIdList = new ArrayList<>();
    if (assignedUserIdList != null) {
      this.assignedUserIdList.addAll(assignedUserIdList);
    }
  }

  public List<Integer> getStatusList() {
    return this.statusList;
  }

  public void setStatusList(final List<Integer> statusList) {
    this.statusList = new ArrayList<>();
    if (statusList != null) {
      this.statusList.addAll(statusList);
    }
  }

  public List<Long> getWorkflowTypeIdList() {
    return this.workflowTypeIdList;
  }

  public void setWorkflowTypeIdList(final List<Long> workflowTypeIdList) {
    this.workflowTypeIdList = new ArrayList<>();
    if (workflowTypeIdList != null) {
      this.workflowTypeIdList.addAll(workflowTypeIdList);
    }
  }

  public List<Long> getWorkflowStepeIdList() {
    return this.workflowStepeIdList;
  }

  public void setWorkflowStepeIdList(final List<Long> workflowStepeIdList) {
    this.workflowStepeIdList = new ArrayList<>();
    if (workflowStepeIdList != null) {
      this.workflowStepeIdList.addAll(workflowStepeIdList);
    }
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public WorkflowSearchFilterEdo toEdo() {
    final WorkflowSearchFilterEdo edo = new WorkflowSearchFilterEdo();
    edo.setAssignedUserIdList(this.assignedUserIdList);
    edo.setStatusList(this.statusList);
    edo.setTitle(this.title);
    edo.setWorkflowStepeIdList(this.workflowStepeIdList);
    edo.setWorkflowTypeIdList(this.workflowTypeIdList);

    return edo;
  }

  public static WorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) {
    final WorkflowSearchFilter model = new WorkflowSearchFilter();
    model.setAssignedUserIdList(edo.getAssignedUserIdList());
    model.setStatusList(edo.getStatusList());
    model.setTitle(edo.getTitle());
    model.setWorkflowStepeIdList(edo.getWorkflowStepeIdList());
    model.setWorkflowTypeIdList(edo.getWorkflowTypeIdList());

    return model;

  }

}
