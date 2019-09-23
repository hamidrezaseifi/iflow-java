package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.WorkflowOfferListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowOfferDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowOffer;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowOfferDataService implements IWorkflowOfferDataService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowCoreConnectService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowOfferDataService(@Autowired final IRestTemplateCall restTemplate,
                                  @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public List<WorkflowOffer> getListForUser(final Long userId, final Long lastId, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow offer list for user id {}", userId);

    final WorkflowOfferListEdo edoList = this.restTemplate.callRestGet(
                                                                       this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOWOFFER_READ_BY_USER),
                                                                       token,
                                                                       EModule.CORE,
                                                                       WorkflowOfferListEdo.class,
                                                                       true,
                                                                       userId,
                                                                       status);

    return WorkflowModelEdoMapper.fromWorkflowOfferEdoList(edoList.getWorkflowOffers());
  }

}
