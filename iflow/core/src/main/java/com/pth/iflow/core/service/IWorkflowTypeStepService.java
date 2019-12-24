package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;

public interface IWorkflowTypeStepService {

  CoreModelHelper save(WorkflowTypeStep model);

  WorkflowTypeStep getByIdentity(String identity);

  List<WorkflowTypeStep> getListByWorkflowTypeIdentity(final String workflowIdentity);

  List<WorkflowTypeStep> getListByIdentityList(final Collection<String> idList);
}