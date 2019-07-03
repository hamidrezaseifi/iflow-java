package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class WorkflowTypeService implements IWorkflowTypeService {

  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowTypeService(@Autowired final IWorkflowTypeDao workflowDao, @Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.workflowTypeDao = workflowDao;
    this.workflowTypeStepDao = workflowStepDao;
  }

  @Override
  public WorkflowType getById(final Long id) {
    return this.workflowTypeDao.getById(id);
  }

  @Override
  public List<WorkflowTypeStep> getStepsById(final Long id) {
    final WorkflowType workflow = getById(id);
    return this.workflowTypeStepDao.getListByIdList(workflow.getSteps().stream().collect(Collectors.toList()));
  }

  @Override
  public List<WorkflowType> getListByIdCompanyId(final Long id) {
    return this.workflowTypeDao.getListByCompanyId(id);
  }

  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList) {
    return this.workflowTypeDao.getListByIdList(idList);
  }

  @Override
  public WorkflowType save(final WorkflowType model) {
    if (model.isNew()) {
      return workflowTypeDao.create(model);
    }

    final WorkflowType exists = workflowTypeDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("WorkflowType with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return workflowTypeDao.update(model);
  }

}
