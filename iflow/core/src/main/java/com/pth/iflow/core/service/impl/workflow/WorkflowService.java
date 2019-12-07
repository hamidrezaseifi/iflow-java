package com.pth.iflow.core.service.impl.workflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.workflow.WorkflowEdo;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class WorkflowService extends CoreModelEdoMapperService<WorkflowEntity, WorkflowEdo> implements IWorkflowService {

  private final IWorkflowDao         workflowDao;
  private final IWorkflowTypeDao     workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;
  private final IUserDao             usersDao;

  public WorkflowService(@Autowired final IWorkflowDao workflowDao, @Autowired final IWorkflowTypeDao workflowTypeDao,
      @Autowired final IWorkflowTypeStepDao workflowTypeStepDao, @Autowired final IUserDao usersDao) {
    this.workflowDao = workflowDao;
    this.workflowTypeDao = workflowTypeDao;
    this.workflowTypeStepDao = workflowTypeStepDao;
    this.usersDao = usersDao;
  }

  @Override
  public WorkflowEntity save(final WorkflowEntity model) {

    if (model.isNew()) {
      return workflowDao.create(model);
    }

    final WorkflowEntity exists = workflowDao.getById(model.getId());
    model.verifyVersion(exists);

    return workflowDao.update(model);

  }

  @Override
  public WorkflowEntity getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowEntity> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

  @Override
  public WorkflowEntity fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowEntity model = new WorkflowEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());

    model.setControllerId(usersDao.getByIdentity(edo.getControllerIdentity()).getId());
    model.setCurrentStepId(workflowTypeStepDao.getByIdentity(edo.getCurrentStepIdentity()).getId());
    model.setCreatedById(usersDao.getByIdentity(edo.getCreatedByIdentity()).getId());
    model.setId(EIdentity.isNotSet(edo.getIdentity()) ? null : workflowDao.getByIdentity(edo.getIdentity()).getId());
    model.setWorkflowTypeId(workflowTypeDao.getByIdentity(edo.getWorkflowTypeIdentity()).getId());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  private List<WorkflowFileEntity> fromWorkflowFileEdoList(final List<WorkflowFileEdo> files) throws IFlowMessageConversionFailureException {
    final List<WorkflowFileEntity> modelList = new ArrayList<>();

    for (final WorkflowFileEdo edo : files) {
      modelList.add(fromFileEdo(edo));
    }

    return modelList;
  }

  private WorkflowFileEntity fromFileEdo(final WorkflowFileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFileEntity model = new WorkflowFileEntity();

    model.setTitle(edo.getTitle());
    model.setExtention(edo.getExtention());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCreatedByUserId(usersDao.getByIdentity(edo.getCreatedByIdentity()).getId());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setIdentity(edo.getIdentity());
    model.setFileVersions(fromWorkflowFileVersionEdoList(edo.getFileVersions()));

    return model;
  }

  private List<WorkflowFileVersionEntity> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> fileVersions)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowFileVersionEntity> modelList = new ArrayList<>();

    for (final WorkflowFileVersionEdo edo : fileVersions) {
      modelList.add(fromFileVersionEdo(edo));
    }

    return modelList;
  }

  private WorkflowFileVersionEntity fromFileVersionEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCreatedByUserId(usersDao.getByIdentity(edo.getCreatedByIdentity()).getId());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());

    return model;
  }

  private List<WorkflowActionEntity> fromWorkflowActionEdoList(final List<WorkflowActionEdo> actions)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowActionEntity> modelList = new ArrayList<>();

    for (final WorkflowActionEdo edo : actions) {
      modelList.add(fromActionEdo(edo));
    }

    return modelList;
  }

  private WorkflowActionEntity fromActionEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowActionEntity model = new WorkflowActionEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCurrentStepId(workflowTypeStepDao.getByIdentity(edo.getCurrentStepIdentity()).getId());
    model.setAssignToId(EIdentity.isNotSet(edo.getAssignToIdentity()) ? 0L : usersDao.getByIdentity(edo.getAssignToIdentity()).getId());

    return model;
  }

  public WorkflowActionEdo toActionEdo(final WorkflowActionEntity model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setAssignToIdentity(
        model.getAssignToId() > 0L ? usersDao.getById(model.getAssignToId()).getIdentity() : EIdentity.NOT_SET.getIdentity());
    edo.setCurrentStepIdentity(workflowTypeStepDao.getById(model.getCurrentStepId()).getIdentity());

    return edo;
  }

  @Override
  public WorkflowEdo toEdo(final WorkflowEntity model) {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    edo.setControllerIdentity(usersDao.getById(model.getControllerId()).getIdentity());
    edo.setCurrentStepIdentity(workflowTypeStepDao.getById(model.getCurrentStepId()).getIdentity());
    edo.setCreatedByIdentity(usersDao.getById(model.getCreatedById()).getIdentity());
    edo.setWorkflowTypeIdentity(workflowTypeDao.getById(model.getWorkflowTypeId()).getIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  private List<WorkflowFileEdo> toWorkflowFileEdoList(final List<WorkflowFileEntity> files) {
    final List<WorkflowFileEdo> edoList = new ArrayList<>();

    for (final WorkflowFileEntity model : files) {
      edoList.add(toFileEdo(model));
    }

    return edoList;
  }

  private WorkflowFileEdo toFileEdo(final WorkflowFileEntity model) {
    final WorkflowFileEdo edo = new WorkflowFileEdo();
    edo.setTitle(model.getTitle());
    edo.setExtention(model.getExtention());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setCreatedByIdentity(usersDao.getById(model.getCreatedByUserId()).getIdentity());
    edo.setActiveFilePath(model.getActiveFilePath());
    edo.setActiveFileVersion(model.getActiveFileVersion());
    edo.setIdentity(model.getIdentity());

    edo.setFileVersions(toWorkflowFileVersionEdoList(model.getFileVersions()));

    return edo;
  }

  private List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<WorkflowFileVersionEntity> fileVersions) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();

    for (final WorkflowFileVersionEntity model : fileVersions) {
      edoList.add(toFileVersionEdo(model));
    }

    return edoList;
  }

  private WorkflowFileVersionEdo toFileVersionEdo(final WorkflowFileVersionEntity model) {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setCreatedByIdentity(usersDao.getById(model.getCreatedByUserId()).getIdentity());
    edo.setFilePath(model.getFilePath());
    edo.setFileVersion(model.getFileVersion());

    return edo;
  }

  private List<WorkflowActionEdo> toWorkflowActionEdoList(final List<WorkflowActionEntity> actions) {
    final List<WorkflowActionEdo> edoList = new ArrayList<>();

    for (final WorkflowActionEntity model : actions) {
      edoList.add(toActionEdo(model));
    }

    return edoList;
  }
}
