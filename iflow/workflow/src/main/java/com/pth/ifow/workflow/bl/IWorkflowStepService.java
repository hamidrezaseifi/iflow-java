package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowStep;

public interface IWorkflowStepService {

  public WorkflowStep getById(Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowStep> getListByWorkflowId(final Long workflowId) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowStep> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException;
}
