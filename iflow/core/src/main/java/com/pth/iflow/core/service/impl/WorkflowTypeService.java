package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Service
public class WorkflowTypeService extends CoreModelEdoMapperService<WorkflowTypeEntity, WorkflowTypeEdo>
    implements IWorkflowTypeService {

  private final IWorkflowTypeDao workflowTypeDao;

  public WorkflowTypeService(@Autowired final IWorkflowTypeDao workflowDao) {
    this.workflowTypeDao = workflowDao;
  }

  @Override
  public WorkflowTypeEntity getByIdentity(final String identity) {
    return this.workflowTypeDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStepEntity> getStepsByIdentity(final String identity) {
    final WorkflowTypeEntity workflow = getByIdentity(identity);
    return workflow.getSteps();
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdCompanyId(final String identity) {
    return this.workflowTypeDao.getListByCompanyIdentity(identity);
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList) {
    return this.workflowTypeDao.getListByIdentityList(idList);
  }

  @Override
  public WorkflowTypeEntity save(final WorkflowTypeEntity model) {
    if (model.isNew()) {
      return workflowTypeDao.create(model);
    }

    final WorkflowTypeEntity exists = workflowTypeDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);

    return workflowTypeDao.update(model);
  }

  protected WorkflowTypeEntity prepareSavingModel(final WorkflowTypeEntity model) {
    return model;
  }

  @Override
  public WorkflowTypeEntity fromEdo(final WorkflowTypeEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowTypeStepService stepService = new WorkflowTypeStepService(null, null);

    final WorkflowTypeEntity model = new WorkflowTypeEntity();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.getCompany().setIdentity(edo.getCompanyIdentity());
    model.setBaseTypeIdentity(edo.getBaseTypeIdentity());
    model.setSendToController(edo.getSendToController());
    model.setAssignType(EWorkflowTypeAssignType.ofValue(edo.getAssignType()));
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(stepService.fromEdoList(edo.getSteps()));

    return model;
  }

  @Override
  public WorkflowTypeEdo toEdo(final WorkflowTypeEntity model) {

    final WorkflowTypeStepService stepService = new WorkflowTypeStepService(null, null);

    final WorkflowTypeEdo edo = new WorkflowTypeEdo();

    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompany().getIdentity());
    edo.setBaseTypeIdentity(model.getBaseTypeIdentity());
    edo.setSendToController(model.getSendToController());
    edo.setAssignType(model.geAssignType().getValue());
    edo.setIncreaseStepAutomatic(model.getIncreaseStepAutomatic());
    edo.setAllowAssign(model.getAllowAssign());
    edo.setSteps(stepService.toEdoList(model.getSteps()));
    edo.setVersion(model.getVersion());

    return edo;
  }

}
