package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;

public interface ISingleTaskWorkflowService {

  public SingleTaskWorkflowEntity save(SingleTaskWorkflowEntity model);

  public SingleTaskWorkflowEntity getByIdentity(String identity);

  public List<SingleTaskWorkflowEntity> getListForUser(final String email, final int status);

  public List<SingleTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
