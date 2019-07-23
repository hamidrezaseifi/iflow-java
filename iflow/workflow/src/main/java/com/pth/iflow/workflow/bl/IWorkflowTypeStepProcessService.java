package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeStepProcessService {
  
  public WorkflowTypeStep getById(Long id, final String token) throws WorkflowCustomizedException, MalformedURLException;
  
  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId, final String token)
      throws WorkflowCustomizedException, MalformedURLException;
  
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException;
}
