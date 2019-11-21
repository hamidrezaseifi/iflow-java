package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowTypeHandler;

@Service
public class WorkflowTypeHandler implements IWorkflowTypeHandler {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowTypeHandler.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public WorkflowTypeHandler(@Autowired final IRestTemplateCall restTemplate,
                             @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public List<WorkflowType> readWorkflowTypeList(final String companyIdentity, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflow-type for company-id {}", companyIdentity);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
                                                                          this.moduleAccessConfig.getReadWorkflowTypeListUri(companyIdentity),
                                                                          EModule.WORKFLOW,
                                                                          WorkflowTypeListEdo.class,
                                                                          token,
                                                                          true);

    return GuiModelEdoMapper.fromWorkflowTypeEdoList(responseEdo.getWorkflowTypes());
  }

}
