package com.pth.iflow.gui.models.workflow;

import java.util.List;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.gui.models.AssignItem;

public interface IWorkflowSaveRequest<W extends IWorkflow> {

  /**
   * @return the workflow
   */
  public W getWorkflow();

  public void setWorkflow(W workflow);

  public Integer getExpireDays();

  public List<AssignItem> getAssigns();

  public EWorkflowProcessCommand getCommand();

  public boolean isAssignCommand();

  public boolean isArchiveCommand();

  public boolean isCreateCommand();

  public boolean isDoneCommand();

  public boolean isSaveCommand();

  public String getSessionKey();

  public void setSessionKey(String sessionKey);

  void setAssignUser(final String userId);

}