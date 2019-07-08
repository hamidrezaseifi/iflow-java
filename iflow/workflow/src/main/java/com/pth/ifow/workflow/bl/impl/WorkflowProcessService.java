package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.ifow.workflow.bl.IWorkflowDataService;
import com.pth.ifow.workflow.bl.IWorkflowProcessService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;

@Service
public class WorkflowProcessService implements IWorkflowProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowDataService workflowDataService;
  
  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {

    this.workflowDataService = workflowDataService;
  }
  
  @Override
  public Workflow save(final Workflow model, final String token) throws WorkflowCustomizedException, MalformedURLException {
    
    return null;
  }

  @Override
  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    tokenCanReadWorkflow(id, token);
    return this.workflowDataService.getById(id);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    final List<Workflow> list = this.workflowDataService.getListByTypeId(id);
    tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);
    
    return list;
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    final List<Workflow> list = this.workflowDataService.getListForUser(id, status);
    tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);
    
    return list;
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList, final String token) throws WorkflowCustomizedException, MalformedURLException {
    tokenCanReadWorkflowList(idList, token);
    
    final List<Workflow> list = this.workflowDataService.getListByIdList(idList);
    
    return list;
  }

  private boolean tokenCanReadWorkflow(final Long workflowId, final String token) {
    // TODO token read access must be implemented
    return true;
  }

  private boolean tokenCanReadWorkflowList(final List<Long> list, final String token) {
    // TODO token read access must be implemented
    return true;
  }
  
}
