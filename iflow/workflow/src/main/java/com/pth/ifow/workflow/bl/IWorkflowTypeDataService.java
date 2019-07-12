package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeDataService {

  public WorkflowType getById(Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowType> getListByIdCompanyId(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowTypeStep> getStepsById(final Long id) throws WorkflowCustomizedException, MalformedURLException;

  public List<WorkflowType> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException;
}
