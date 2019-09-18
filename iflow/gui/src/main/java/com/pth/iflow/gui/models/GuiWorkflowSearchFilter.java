package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.xml.WorkflowSearchFilterEdo;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class GuiWorkflowSearchFilter {

  private boolean       meAssigned;

  private List<Long>    assignedUserIdList  = new ArrayList<>();

  private List<Integer> statusList          = new ArrayList<>();

  private List<Long>    workflowTypeIdList  = new ArrayList<>();

  private List<Long>    workflowStepeIdList = new ArrayList<>();

  private String        title;

  /**
   * @return the meAssigned
   */
  public boolean isMeAssigned() {
    return this.meAssigned;
  }

  /**
   * @param meAssigned the meAssigned to set
   */
  public void setMeAssigned(final boolean meAssigned) {
    this.meAssigned = meAssigned;
  }

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

  public WorkflowSearchFilterEdo toEdo1() {
    final WorkflowSearchFilterEdo edo = new WorkflowSearchFilterEdo();
    edo.setAssignedUserIdList(this.assignedUserIdList);
    edo.setStatusList(this.statusList);
    edo.setTitle(this.title);
    edo.setWorkflowStepeIdList(this.workflowStepeIdList);
    edo.setWorkflowTypeIdList(this.workflowTypeIdList);
    return edo;
  }

  public static GuiWorkflowSearchFilter generateNew() {
    final GuiWorkflowSearchFilter workflowSearchFilter = new GuiWorkflowSearchFilter();

    workflowSearchFilter.setMeAssigned(true);
    workflowSearchFilter.setStatusList(Arrays.asList(EWorkflowStatus.values()).stream().filter(e -> e != EWorkflowStatus.ARCHIVED)
        .map(e -> e.getValue().intValue()).collect(Collectors.toList()));

    return workflowSearchFilter;
  }
}
