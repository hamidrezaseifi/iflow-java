package com.pth.iflow.core.model;

import java.util.HashSet;
import java.util.Set;

public class WorkflowSearchFilter {

  private Set<Long>    assignedUserIdSet = new HashSet<>();

  private Set<Integer> statusSet         = new HashSet<>();

  private Set<Long>    workflowTypeIdSet = new HashSet<>();

  private Set<Long>    workflowStepIdSet = new HashSet<>();

  public Set<Long> getAssignedUserIdSet() {
    return this.assignedUserIdSet;
  }

  public void setAssignedUserIdSet(final Set<Long> assignedUserIdSet) {
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

  public Set<Long> getWorkflowTypeIdSet() {
    return this.workflowTypeIdSet;
  }

  public void setWorkflowTypeIdSet(final Set<Long> workflowTypeIdSet) {
    this.workflowTypeIdSet = new HashSet<>();
    if (workflowTypeIdSet != null) {
      this.workflowTypeIdSet.addAll(workflowTypeIdSet);
    }
  }

  public Set<Long> getWorkflowStepIdSet() {
    return this.workflowStepIdSet;
  }

  public void setWorkflowStepIdSet(final Set<Long> workflowStepIdSet) {
    this.workflowStepIdSet = new HashSet<>();
    if (workflowStepIdSet != null) {
      this.workflowStepIdSet.addAll(workflowStepIdSet);
    }
  }

}
