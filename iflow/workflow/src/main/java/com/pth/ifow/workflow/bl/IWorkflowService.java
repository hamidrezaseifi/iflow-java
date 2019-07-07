package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;

public interface IWorkflowService {

  public Workflow save(Workflow model) throws WorkflowCustomizedException, MalformedURLException;

  public Workflow getById(Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByTypeId(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListForUser(final Long id, int status) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException;
}
