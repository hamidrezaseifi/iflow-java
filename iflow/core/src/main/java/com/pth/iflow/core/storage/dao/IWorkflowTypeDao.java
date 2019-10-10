package com.pth.iflow.core.storage.dao;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeDao {

  public WorkflowType create(WorkflowType model) throws IFlowStorageException;

  public WorkflowType update(WorkflowType model) throws IFlowStorageException;

  public WorkflowType getById(Long id) throws IFlowStorageException;

  public WorkflowType getByIdentity(String identity) throws IFlowStorageException;

  public List<WorkflowType> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowType> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public List<WorkflowType> getListByCompanyIdentity(String companyIdentity) throws IFlowStorageException;

}
