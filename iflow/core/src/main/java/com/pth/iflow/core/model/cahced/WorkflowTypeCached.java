package com.pth.iflow.core.model.cahced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

public class WorkflowTypeCached extends WorkflowType implements ICachedModel {

  protected Set<WorkflowTypeStepCached> steps = new HashSet<>();

  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowTypeCached(@Autowired final IWorkflowTypeDao workflowDao, @Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.workflowTypeDao = workflowDao;
    this.workflowTypeStepDao = workflowStepDao;

  }

  public Set<WorkflowTypeStepCached> getSteps() {
    return steps;
  }

  public void setSteps(final List<WorkflowTypeStepCached> steps) {
    setSteps(steps.stream().collect(Collectors.toSet()));
  }

  public void addStep(final WorkflowTypeStepCached model) {
    steps.add(model);
  }

  public void setSteps(final Set<WorkflowTypeStepCached> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(workflowTypeDao.getById(getId()));
      this.steps.clear();
      for (final Long stepId : stepIds) {
        addStep(loadWorkflowTypeStepCached(stepId));
      }
    }

  }

  protected WorkflowTypeStepCached loadWorkflowTypeStepCached(final Long stepId) {
    final WorkflowTypeStepCached item = new WorkflowTypeStepCached(workflowTypeStepDao);
    item.setId(stepId);
    item.reload();
    return item;
  }
}
