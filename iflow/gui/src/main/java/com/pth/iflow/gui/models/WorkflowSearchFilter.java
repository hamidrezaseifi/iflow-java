package com.pth.iflow.gui.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EWorkflowStatus;

public class WorkflowSearchFilter {

  private boolean            meAssigned;

  private final Set<String>  assignedUserIdSet  = new HashSet<>();

  private final Set<Integer> statusSet          = new HashSet<>();

  private final Set<String>  workflowTypeIdSet  = new HashSet<>();

  private final Set<String>  workflowStepeIdSet = new HashSet<>();

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

  public Set<String> getAssignedUserIdSet() {
    return this.assignedUserIdSet;
  }

  public void setAssignedUserIdSet(final Set<String> assignedUserIdList) {
    this.assignedUserIdSet.clear();
    if (assignedUserIdList != null) {
      this.assignedUserIdSet.addAll(assignedUserIdList);
    }
  }

  public Set<Integer> getStatusSet() {
    return this.statusSet;
  }

  public void setStatusSet(final Set<Integer> statusList) {
    this.statusSet.clear();
    if (statusList != null) {
      this.statusSet.addAll(statusList);
    }
  }

  public Set<String> getWorkflowTypeIdSet() {
    return this.workflowTypeIdSet;
  }

  public void setWorkflowTypeIdSet(final Set<String> workflowTypeIdList) {
    this.workflowTypeIdSet.clear();
    if (workflowTypeIdList != null) {
      this.workflowTypeIdSet.addAll(workflowTypeIdList);
    }
  }

  public Set<String> getWorkflowStepeIdSet() {
    return this.workflowStepeIdSet;
  }

  public void setWorkflowStepeIdSet(final Set<String> workflowStepeIdList) {
    this.workflowStepeIdSet.clear();
    if (workflowStepeIdList != null) {
      this.workflowStepeIdSet.addAll(workflowStepeIdList);
    }
  }

  public static WorkflowSearchFilter generateNew() {
    final WorkflowSearchFilter workflowSearchFilter = new WorkflowSearchFilter();

    workflowSearchFilter.setMeAssigned(true);
    workflowSearchFilter.setStatusSet(Arrays.asList(EWorkflowStatus.values()).stream().filter(e -> e != EWorkflowStatus.ARCHIVED)
        .map(e -> e.getValue().intValue()).collect(Collectors.toSet()));

    return workflowSearchFilter;
  }
}
