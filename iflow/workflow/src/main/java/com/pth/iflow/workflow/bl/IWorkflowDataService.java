package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;

public interface IWorkflowDataService {

  public Workflow save(final Workflow model, final String token) throws WorkflowCustomizedException, MalformedURLException;

  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListForUser(final Long id, int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException;

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, String token)
      throws WorkflowCustomizedException, MalformedURLException;

}
