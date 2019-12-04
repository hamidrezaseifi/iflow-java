package com.pth.iflow.core.service.impl.workflow;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IWorkflowSearchService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowSearchDao;

@Service
public class WorkflowSearchService extends CoreModelEdoMapperService<WorkflowResultEntity, WorkflowResultEdo>
    implements IWorkflowSearchService {

  private final IWorkflowSearchDao workflowSearchDao;

  public WorkflowSearchService(@Autowired final IWorkflowSearchDao workflowSearchDao) {
    this.workflowSearchDao = workflowSearchDao;
  }

  @Override
  public List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter) {

    return workflowSearchDao.search(workflowSearchFilter);
  }

  @Override
  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList) {

    return workflowSearchDao.readByIdentityList(identityList);
  }

  @Override
  public WorkflowResultEntity fromEdo(final WorkflowResultEdo edo) throws IFlowMessageConversionFailureException {

    return null;
  }

  @Override
  public WorkflowResultEdo toEdo(final WorkflowResultEntity model) {
    final WorkflowResultEdo edo = new WorkflowResultEdo();

    edo.setStatus(model.getStatus());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());

    return edo;
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
