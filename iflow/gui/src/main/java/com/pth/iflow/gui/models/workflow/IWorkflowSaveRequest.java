package com.pth.iflow.gui.models.workflow;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.UploadedFile;

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

  void setAssignUser(final String userId);

  public List<UploadedFile> getUploadedFiles();

  public void setUploadedFiles(final List<UploadedFile> uploadedFiles);

}
