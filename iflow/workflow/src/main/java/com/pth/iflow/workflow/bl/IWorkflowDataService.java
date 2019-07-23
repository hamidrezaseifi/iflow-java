package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface IWorkflowDataService {

  public Workflow save(Workflow model) throws WorkflowCustomizedException, MalformedURLException;

  public Workflow getById(Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByTypeId(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListForUser(final Long id, int status) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException;
}
