package com.pth.iflow.core.service.impl.workflow;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.entity.WorkflowResultEntity;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowSearchService;
import com.pth.iflow.core.storage.dao.IWorkflowSearchDao;

@Service
public class WorkflowSearchService implements IWorkflowSearchService {

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

}