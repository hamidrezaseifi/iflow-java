package com.pth.iflow.gui.services.impl.workflow.singletask;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class SingleTaskWorkflowAccess implements IWorkflowAccess<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> {

  private static final Logger logger = LoggerFactory.getLogger(SingleTaskWorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public SingleTaskWorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
                                  @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public SingleTaskWorkflow readWorkflow(final String workflowIdentity, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final SingleTaskWorkflowEdo responseEdo =
                                            this.restTemplate.callRestGet(this.moduleAccessConfig.getReadSingleTaskWorkflowUri(workflowIdentity),
                                                                          EModule.WORKFLOW,
                                                                          SingleTaskWorkflowEdo.class,
                                                                          token,
                                                                          true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<SingleTaskWorkflow> createWorkflow(final SingleTaskWorkflowSaveRequest createRequest, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    final SingleTaskWorkflowListEdo responseListEdo =
                                                    this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateSingleTaskWorkflowUri(),
                                                                                   EModule.WORKFLOW,
                                                                                   GuiModelEdoMapper.toEdo(createRequest),
                                                                                   SingleTaskWorkflowListEdo.class,
                                                                                   token,
                                                                                   true);

    return GuiModelEdoMapper.fromSingleTaskWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public SingleTaskWorkflow saveWorkflow(final SingleTaskWorkflowSaveRequest request, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    final SingleTaskWorkflowEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSaveSingleTaskWorkflowUri(),
                                                                             EModule.WORKFLOW,
                                                                             GuiModelEdoMapper.toEdo(request),
                                                                             SingleTaskWorkflowEdo.class,
                                                                             token,
                                                                             true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
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

  @Override
  public List<SingleTaskWorkflow> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Search workflow");

    final SingleTaskWorkflowListEdo responseListEdo =
                                                    this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchSingleTaskWorkflowUri(),
                                                                                   EModule.WORKFLOW,
                                                                                   GuiModelEdoMapper.toEdo(workflowSearchFilter),
                                                                                   SingleTaskWorkflowListEdo.class,
                                                                                   token,
                                                                                   true);

    return GuiModelEdoMapper.fromSingleTaskWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public void validateWorkflow(final SingleTaskWorkflowSaveRequest request, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    this.restTemplate.callRestPost(this.moduleAccessConfig.getValidateSingleTaskWorkflowUri(),
                                   EModule.WORKFLOW,
                                   GuiModelEdoMapper.toEdo(request),
                                   Void.class,
                                   token,
                                   true);

  }

}
