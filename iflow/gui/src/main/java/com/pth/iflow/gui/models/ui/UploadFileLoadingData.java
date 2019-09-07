package com.pth.iflow.gui.models.ui;

public class UploadFileLoadingData {

  private String title;
  private String fileEtention;
  private Long   workflowId;
  private Long   actionId;
  private Long   companyId;

  public UploadFileLoadingData(final String fileEtention) {
    this.fileEtention = fileEtention;
  }

  public UploadFileLoadingData(final String title,
                               final String fileEtention,
                               final Long workflowId,
                               final Long actionId) {
    this.title = title;
    this.fileEtention = fileEtention;
    this.workflowId = workflowId;
    this.actionId = actionId;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * @return the fileEtention
   */
  public String getFileEtention() {
    return this.fileEtention;
  }

  /**
   * @param fileEtention the fileEtention to set
   */
  public void setFileEtention(final String fileEtention) {
    this.fileEtention = fileEtention;
  }

  /**
   * @return the workflowId
   */
  public Long getWorkflowId() {
    return this.workflowId;
  }

  /**
   * @param workflowId the workflowId to set
   */
  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId == null ? 0 : workflowId;
  }

  /**
   * @return the actionId
   */
  public Long getActionId() {
    return this.actionId;
  }

  /**
   * @param actionId the actionId to set
   */
  public void setActionId(final Long actionId) {
    this.actionId = actionId == null ? 0 : actionId;
  }

  /**
   * @return the companyId
   */
  public Long getCompanyId() {
    return this.companyId;
  }

  /**
   * @param companyId the companyId to set
   */
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId == null ? 0 : companyId;
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingFilePathPreffix() {
    return String.format("%d/%d/%d/%s", this.companyId, this.workflowId, this.actionId, this.title);
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingTempFilePathPreffix() {

    return String.format("temp_%d", System.currentTimeMillis());
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingFileFullPath(final String basePath) {
    String path = basePath + "/" + generateSavingFilePathPreffix();
    path = path.replace("//", "/");

    return path;
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingTempFileFullPath(final String basePath) {
    String path = basePath + "/" + generateSavingTempFilePathPreffix();
    path = path.replace("//", "/");

    return path;
  }

}
