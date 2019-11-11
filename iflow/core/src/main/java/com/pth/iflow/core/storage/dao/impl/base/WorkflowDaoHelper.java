package com.pth.iflow.core.storage.dao.impl.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@Component
public class WorkflowDaoHelper {

  @Autowired
  private IWorkflowActionDao   workflowActionDao;

  @Autowired
  private IWorkflowFileDao     workflowFileDao;

  @Autowired
  private IWorkflowTypeDao     workflowTypeDao;

  @Autowired
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @Autowired
  private IUserDao             userDao;

  public void createWorkflowActions(final Workflow workflow, final Long workflowId, final boolean withTransaction) {

    this.workflowActionDao.deleteByWorkflowId(workflowId, withTransaction);

    final List<WorkflowAction> resultList = new ArrayList<>();

    for (final WorkflowAction model : workflow.getActions()) {
      model.setWorkflowId(workflowId);
      resultList.add(this.workflowActionDao.create(model, withTransaction));

    }

    workflow.setActions(resultList);
  }

  public void createWorkflowFiles(final Workflow workflow, final Long workflowId, final boolean withTransaction) {

    this.workflowFileDao.deleteByWorkflowId(workflowId, withTransaction);

    final List<WorkflowFile> resultList = new ArrayList<>();

    for (final WorkflowFile model : workflow.getFiles()) {
      model.setWorkflowId(workflowId);
      resultList.add(this.workflowFileDao.create(model, withTransaction));

    }

    workflow.setFiles(resultList);
  }

  public void verifyWorkflowTypeByIdentity(final Workflow workflow) {
    if (workflow.getWorkflowType() == null) {
      final WorkflowType type = workflowTypeDao.getByIdentity(workflow.getWorkflowTypeIdentity());
      workflow.setWorkflowType(type);
    }
  }

  public void verifyCurrentStepByIdentity(final Workflow workflow) {
    if (workflow.getCurrentStep() == null) {
      final WorkflowTypeStep type = workflowTypeStepDao.getByIdentity(workflow.getCurrentStepIdentity());
      workflow.setCurrentStep(type);
    }
  }

  public void verifyControllerByIdentity(final Workflow workflow) {
    if (workflow.getController() == null) {
      final User type = userDao.getByEmail(workflow.getControllerIdentity());
      workflow.setController(type);
    }
  }

  public void verifyCreatedByByIdentity(final Workflow workflow) {
    if (workflow.getCreatedBy() == null) {
      final User type = userDao.getByEmail(workflow.getCreatedByIdentity());
      workflow.setCreatedBy(type);
    }
  }

  public void verifyWorkflowTypeById(final Workflow workflow, final Long id) {
    if (workflow.getWorkflowType() == null) {
      final WorkflowType type = workflowTypeDao.getById(id);
      workflow.setWorkflowType(type);
    }
  }

  public void verifyCurrentStepById(final Workflow workflow, final Long id) {
    if (workflow.getCurrentStep() == null) {
      final WorkflowTypeStep type = workflowTypeStepDao.getById(id);
      workflow.setCurrentStep(type);
    }
  }

  public void verifyControllerById(final Workflow workflow, final Long id) {
    if (workflow.getController() == null) {
      final User type = userDao.getById(id);
      workflow.setController(type);
    }
  }

  public void verifyCreatedByById(final Workflow workflow, final Long id) {
    if (workflow.getCreatedBy() == null) {
      final User type = userDao.getById(id);
      workflow.setCreatedBy(type);
    }
  }

  public void setWorkflowDetails(final Workflow workflow) {
    workflow.setActions(this.workflowActionDao.getListByWorkflowId(workflow.getId()));
    workflow.setFiles(this.workflowFileDao.getListByWorkflowId(workflow.getId()));
  }

  public void deleteWorkflowDetails(final Long workflowId, final boolean withTransaction) {
    this.workflowActionDao.deleteByWorkflowId(workflowId, withTransaction);

    this.workflowFileDao.deleteByWorkflowId(workflowId, withTransaction);
  }

  public void prepareWorkflowSearchFilter(final WorkflowSearchFilter workflowSearchFilter) {
    if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {
      final List<User> list = userDao.getListByIdentityList(workflowSearchFilter.getAssignedUserIdentitySet());

      workflowSearchFilter.setAssignedUserIdSet(list.stream().map(u -> u.getId()).collect(Collectors.toSet()));
    }

    if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
      final List<WorkflowTypeStep> list = workflowTypeStepDao.getListByIdentityList(workflowSearchFilter.getWorkflowStepIdentitySet());
      workflowSearchFilter.setWorkflowStepeIdSet(list.stream().map(u -> u.getId()).collect(Collectors.toSet()));

    }

    if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
      final List<WorkflowType> list = workflowTypeDao.getListByIdentityList(workflowSearchFilter.getWorkflowTypeIdentitySet());
      workflowSearchFilter.setWorkflowTypeIdSet(list.stream().map(u -> u.getId()).collect(Collectors.toSet()));
    }

  }

}
