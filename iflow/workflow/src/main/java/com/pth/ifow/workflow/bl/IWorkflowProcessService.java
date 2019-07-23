package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;

public interface IWorkflowProcessService {

  public Workflow save(Workflow model, String token) throws WorkflowCustomizedException, MalformedURLException;

  public Workflow getById(Long id, String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByTypeId(final Long id, String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListForUser(final Long id, int status, String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdList(final List<Long> idList, String token) throws WorkflowCustomizedException, MalformedURLException;
}
