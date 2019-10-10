package com.pth.iflow.workflow.models;

import java.util.Set;
import java.util.HashSet;

public class WorkflowSearchFilter {

  private Set<String>  assignedUserIdSet  = new HashSet<>();

  private Set<Integer> statusSet          = new HashSet<>();

  private Set<String>  workflowTypeIdSet  = new HashSet<>();

  private Set<String>  workflowStepeIdSet = new HashSet<>();

  public Set<String> getAssignedUserIdSet() {
    return this.assignedUserIdSet;
  }

  public void setAssignedUserIdSet(final Set<String> assignedUserIdSet) {
    this.assignedUserIdSet = new HashSet<>();
    if (assignedUserIdSet != null) {
      this.assignedUserIdSet.addAll(assignedUserIdSet);
    }
  }

  public Set<Integer> getStatusSet() {
    return this.statusSet;
  }

  public void setStatusSet(final Set<Integer> statusSet) {
    this.statusSet = new HashSet<>();
    if (statusSet != null) {
      this.statusSet.addAll(statusSet);
    }
  }

  public Set<String> getWorkflowTypeIdSet() {
    return this.workflowTypeIdSet;
  }

  public void setWorkflowTypeIdSet(final Set<String> workflowTypeIdSet) {
    this.workflowTypeIdSet = new HashSet<>();
    if (workflowTypeIdSet != null) {
      this.workflowTypeIdSet.addAll(workflowTypeIdSet);
    }
  }

  public Set<String> getWorkflowStepeIdSet() {
    return this.workflowStepeIdSet;
  }

  public void setWorkflowStepeIdSet(final Set<String> workflowStepeIdSet) {
    this.workflowStepeIdSet = new HashSet<>();
    if (workflowStepeIdSet != null) {
      this.workflowStepeIdSet.addAll(workflowStepeIdSet);
    }
  }

}
