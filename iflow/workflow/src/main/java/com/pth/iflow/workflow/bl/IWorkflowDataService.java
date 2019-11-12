package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.base.IWorkflow;

public interface IWorkflowDataService<W extends IWorkflow> {

  public W save(final W model, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public W getByIdentity(final String identity, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListForUser(final String identity, int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListByIdentityList(final Set<String> idList, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> search(final WorkflowSearchFilter workflowSearchFilter, String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
