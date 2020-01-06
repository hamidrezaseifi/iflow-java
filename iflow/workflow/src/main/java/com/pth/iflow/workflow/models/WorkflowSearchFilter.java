package com.pth.iflow.workflow.models;

import java.util.HashSet;
import java.util.Set;

public class WorkflowSearchFilter {

  private Set<String> assignedUserIdentitySet = new HashSet<>();

  private Set<Integer> statusSet = new HashSet<>();

  private Set<String> workflowTypeIdentitySet = new HashSet<>();

  private Set<String> workflowStepeIdentitySet = new HashSet<>();

  private String companyIdentity;

  public Set<String> getAssignedUserIdSet() {

    return this.assignedUserIdentitySet;
  }

  public void setAssignedUserIdSet(final Set<String> assignedUserIdSet) {

    this.assignedUserIdentitySet = new HashSet<>();
    if (assignedUserIdSet != null) {
      this.assignedUserIdentitySet.addAll(assignedUserIdSet);
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

    return this.workflowTypeIdentitySet;
  }

  public void setWorkflowTypeIdSet(final Set<String> workflowTypeIdSet) {

    this.workflowTypeIdentitySet = new HashSet<>();
    if (workflowTypeIdSet != null) {
      this.workflowTypeIdentitySet.addAll(workflowTypeIdSet);
    }
  }

  public Set<String> getWorkflowStepeIdSet() {

    return this.workflowStepeIdentitySet;
  }

  public void setWorkflowStepeIdSet(final Set<String> workflowStepeIdSet) {

    this.workflowStepeIdentitySet = new HashSet<>();
    if (workflowStepeIdSet != null) {
      this.workflowStepeIdentitySet.addAll(workflowStepeIdSet);
    }
  }

  public String getCompanyIdentity() {

    return companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {

    this.companyIdentity = companyIdentity;
  }

}
