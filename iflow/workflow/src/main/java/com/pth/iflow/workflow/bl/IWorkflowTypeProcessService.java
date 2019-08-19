package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeProcessService {
  
  public WorkflowType getById(Long id, final String token) throws WorkflowCustomizedException, MalformedURLException;
  
  public List<WorkflowType> getListByIdCompanyId(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException;
  
  public List<WorkflowTypeStep> getStepsById(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException;
  
  public List<WorkflowType> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException;
}
