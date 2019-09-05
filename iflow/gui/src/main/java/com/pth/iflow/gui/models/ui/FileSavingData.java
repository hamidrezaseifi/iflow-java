package com.pth.iflow.gui.models.ui;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class FileSavingData {

  private String title;
  private String fileExtention;
  private Long   workflowId;
  private Long   actionId;
  private Long   companyId;
  private String filePath;

  public FileSavingData(final String fileExtention) {
    this.fileExtention = fileExtention;
  }

  public FileSavingData(final String title,
                        final String fileExtention,
                        final Long workflowId,
                        final Long actionId,
                        final Long companyId) {
    this.title = title;
    this.fileExtention = fileExtention;
    this.workflowId = workflowId;
    this.actionId = actionId;
    this.companyId = companyId;
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
  public String getFileExtention() {
    return this.fileExtention;
  }

  /**
   * @param fileEtention the fileEtention to set
   */
  public void setFileExtention(final String fileEtention) {
    this.fileExtention = fileEtention;
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
   * @return the filePath
   */
  public String getFilePath() {
    return this.filePath;
  }

  /**
   * @param tempPath the filePath to set
   */
  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public File getFile() {
    return new File(this.filePath);
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingFilePathPreffix() {
    return String.format("%d/%d/%d/%s.%s", this.companyId, this.workflowId, this.actionId, this.title, this.fileExtention);
  }

  /**
   * @return the saving file temp path preffix
   */
  public String generateSavingTempFilePathPreffix() {

    final LocalDate dt = LocalDate.now();
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");

    return String.format("%s/temp_%d.%s", dt.format(formatter), System.currentTimeMillis(), this.fileExtention);
  }

  /**
   * @return the saving file path preffix
   */
  public String generateSavingFileFullPath(final String basePath) {
    String path = basePath + "/" + generateSavingFilePathPreffix();
    path = clearFilePath(path);

    return path;
  }

  /**
   * @return the saving file temp path preffix
   */
  public String generateSavingTempFileFullPath(final String basePath) {
    String path = basePath + "/" + generateSavingTempFilePathPreffix();
    path = clearFilePath(path);

    return path;
  }

  private String clearFilePath(final String path) {
    return path.replace("//", "/").replace("..", ".");
  }

  public static String getExtention(final MultipartFile file) {
    final String fileName = file.getOriginalFilename();
    final int pointIndex = fileName.lastIndexOf(".");
    final String ext = pointIndex > 2 ? fileName.substring(pointIndex + 1) : "";
    return ext;
  }
}
