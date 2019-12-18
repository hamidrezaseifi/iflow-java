package com.pth.iflow.core.service.impl.workflow;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowEdo;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IWorkflowSearchService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowSearchDao;

@Service
public class WorkflowSearchService extends CoreModelEdoMapperService<WorkflowEntity, WorkflowEdo> implements IWorkflowSearchService {

  private final IWorkflowSearchDao workflowSearchDao;
  private final IWorkflowService   workflowService;

  public WorkflowSearchService(@Autowired final IWorkflowSearchDao workflowSearchDao, @Autowired final IWorkflowService workflowService) {
    this.workflowSearchDao = workflowSearchDao;
    this.workflowService = workflowService;
  }

  @Override
  public List<WorkflowEntity> search(final WorkflowSearchFilter workflowSearchFilter) {

    return workflowSearchDao.search(workflowSearchFilter);
  }

  @Override
  public List<WorkflowEntity> readByIdentityList(final Set<String> identityList) {

    return workflowSearchDao.readByIdentityList(identityList);
  }

  @Override
  public WorkflowEntity fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {

    return null;
  }

  @Override
  public WorkflowEdo toEdo(final WorkflowEntity model) {

    return this.workflowService.toEdo(model);
  }

  @Override
  public WorkflowSearchFilter fromWorkflowSearchFilterEdo(final WorkflowSearchFilterEdo workflowSearchFilterEdo) {

    final WorkflowSearchFilter searchFilter = new WorkflowSearchFilter();
    searchFilter.setStatusSet(workflowSearchFilterEdo.getStatusSet());
    searchFilter.setAssignedUserIdentitySet(workflowSearchFilterEdo.getAssignedUserIdentitySet());
    searchFilter.setWorkflowStepIdentitySet(workflowSearchFilterEdo.getWorkflowStepeIdentitySet());
    searchFilter.setWorkflowTypeIdentitySet(workflowSearchFilterEdo.getWorkflowTypeIdentitySet());

    return searchFilter;
  }

}
