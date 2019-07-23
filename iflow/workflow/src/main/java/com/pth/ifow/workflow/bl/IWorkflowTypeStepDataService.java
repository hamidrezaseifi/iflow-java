package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeStepDataService {

  public WorkflowTypeStep getById(Long id, String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId, String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList, String token) throws WorkflowCustomizedException, MalformedURLException;
}
