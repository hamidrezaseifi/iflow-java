package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;
import com.pth.ifow.workflow.models.WorkflowStep;

public interface IWorkflowService {

  public Workflow getById(Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdCompanyId(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowStep> getStepsById(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException;
}
