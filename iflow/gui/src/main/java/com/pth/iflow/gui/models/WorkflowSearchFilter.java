package com.pth.iflow.gui.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EWorkflowStatus;

public class WorkflowSearchFilter {

  private boolean            meAssigned;

  private final Set<String>  assignedUserIdSet = new HashSet<>();

  private final Set<Integer> statusList        = new HashSet<>();

  private final Set<String>  workflowTypes     = new HashSet<>();

  private final Set<String>  workflowSteps     = new HashSet<>();

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

  public void setAssignedUserIdentitySet(final Set<String> assignedUserIdList) {
    this.assignedUserIdSet.clear();
    if (assignedUserIdList != null) {
      this.assignedUserIdSet.addAll(assignedUserIdList);
    }
  }

  public void addAssignedUserIdentity(final String assignedUserIdentity) {

    this.assignedUserIdSet.add(assignedUserIdentity);

  }

  public Set<Integer> getStatusList() {
    return this.statusList;
  }

  public void setStatusList(final Set<Integer> statusList) {
    this.statusList.clear();
    if (statusList != null) {
      this.statusList.addAll(statusList);
    }
  }

  public Set<String> getWorkflowTypes() {
    return this.workflowTypes;
  }

  public void setWorkflowTypes(final Set<String> workflowTypes) {
    this.workflowTypes.clear();
    if (workflowTypes != null) {
      this.workflowTypes.addAll(workflowTypes);
    }
  }

  public Set<String> getWorkflowSteps() {
    return this.workflowSteps;
  }

  public void setWorkflowSteps(final Set<String> workflowSteps) {
    this.workflowSteps.clear();
    if (workflowSteps != null) {
      this.workflowSteps.addAll(workflowSteps);
    }
  }

  public static WorkflowSearchFilter generateNew(final Collection<WorkflowType> workflowTypes) {
    final WorkflowSearchFilter workflowSearchFilter = new WorkflowSearchFilter();

    workflowSearchFilter.setMeAssigned(true);
    workflowSearchFilter.setStatusList(Arrays.asList(EWorkflowStatus.values()).stream().filter(e -> e != EWorkflowStatus.ARCHIVED)
        .map(e -> e.getValue().intValue()).collect(Collectors.toSet()));

    workflowSearchFilter.setWorkflowTypes(workflowTypes.stream().map(t -> t.getIdentity()).collect(Collectors.toSet()));

    return workflowSearchFilter;
  }
}
