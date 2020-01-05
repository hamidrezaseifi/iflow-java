package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ISingleTaskWorkflowService extends ICoreModelEdoMapperService<SingleTaskWorkflowEntity, SingleTaskWorkflowEdo> {

  public SingleTaskWorkflowEntity save(SingleTaskWorkflowEntity model);

  public SingleTaskWorkflowEntity getByIdentity(String identity);

  public List<SingleTaskWorkflowEntity> getListForUser(final String email, final int status);

  public List<SingleTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
