package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class GuiCachDataDataService implements IGuiCachDataDataService {

  private static final Logger logger = LoggerFactory.getLogger(GuiCachDataDataService.class);

  private final IRestTemplateCall restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public GuiCachDataDataService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {

    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public void resetCachDataForUser(final String companyIdentity, final String userIdentity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Reset cach data request for user");

    this.restTemplate
        .callRestGet(
            this.moduleAccessConfig
                .generateGuieUrl(IflowRestPaths.GuiModule.CAL_CACHDATA_USER_DATARESET(companyIdentity, userIdentity)),
            token, EModule.CORE, Void.class, true);

  }

  @Override
  public void resetCachDataForUserList(final String companyIdentity, final Set<String> userIdentityList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Reset cach data request for user list");

    final IdentityListEdo idListEdo = new IdentityListEdo(userIdentityList);
    this.restTemplate
        .callRestPost(
            this.moduleAccessConfig.generateGuieUrl(IflowRestPaths.GuiModule.CAL_CACHDATA_USERLIST_DATARESET(companyIdentity)),
            token, EModule.CORE, idListEdo, Void.class, true);

  }

  @Override
  public void resetCachDataForWorkflow(final String companyIdentity, final String workflowIdentity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Reset cach data request for workflow");

    this.restTemplate
        .callRestGet(
            this.moduleAccessConfig
                .generateGuieUrl(IflowRestPaths.GuiModule.CAL_CACHDATA_WORKFLOW_DATARESET(companyIdentity, workflowIdentity)),
            token, EModule.CORE, Void.class, true);

  }

}
