package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowType;

public interface IWorkflowTypeHandler {

  List<WorkflowType> readWorkflowTypeList(final String companyIdentity, String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
