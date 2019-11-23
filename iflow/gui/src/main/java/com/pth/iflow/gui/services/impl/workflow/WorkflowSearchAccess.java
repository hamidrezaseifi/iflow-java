package com.pth.iflow.gui.services.impl.workflow;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.WorkflowResult;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowSearchAccess;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowAccess;

@Service
public class WorkflowSearchAccess implements IWorkflowSearchAccess {

  private static final Logger                               logger = LoggerFactory.getLogger(TestThreeTaskWorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;
  private final SessionUserInfo                             sessionUserInfo;

  public WorkflowSearchAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig,
      @Autowired final SessionUserInfo sessionUserInfo) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public List<WorkflowResult> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Search workflow");

    final WorkflowResultListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(workflowSearchFilter), WorkflowResultListEdo.class, this.sessionUserInfo.getToken(),
        true);

    return GuiModelEdoMapper.fromWorkflowResultEdoList(responseListEdo.getWorkflows());

  }

}
