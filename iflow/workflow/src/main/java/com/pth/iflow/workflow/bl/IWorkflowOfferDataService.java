package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowOffer;

public interface IWorkflowOfferDataService {

  public List<WorkflowOffer> getListForUser(final Long userId, final Long lastId, int status, String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
