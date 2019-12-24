package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeDao {

  public WorkflowTypeEntity create(WorkflowTypeEntity model) throws IFlowStorageException;

  public WorkflowTypeEntity update(WorkflowTypeEntity model) throws IFlowStorageException;

  public WorkflowTypeEntity getById(Long id) throws IFlowStorageException;

  public WorkflowTypeEntity getByIdentity(String identity) throws IFlowStorageException;

  public List<WorkflowTypeEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  public List<WorkflowTypeEntity> getListByCompanyIdentity(String companyIdentity) throws IFlowStorageException;

  void deleteById(Long id) throws IFlowStorageException;

}
