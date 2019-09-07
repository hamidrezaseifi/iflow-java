package com.pth.iflow.gui.models.ui;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileSavingData extends FileSavingData {

  private MultipartFile file;

  public UploadFileSavingData(final String fileExtention) {
    super(fileExtention);
  }

  public UploadFileSavingData(final MultipartFile file,
                              final String title,
                              final String fileExtention,
                              final Long workflowId,
                              final Long actionId,
                              final Long companyId) {
    super(title, fileExtention, workflowId, actionId, companyId);
    this.file = file;

  }

  /**
   * @return the file
   */
  public MultipartFile getMultipartFile() {
    return this.file;
  }

  /**
   * @param file the file to set
   */
  public void setFile(final MultipartFile file) {
    this.file = file;
  }

  public FileSavingData toFileSavingData() {
    final FileSavingData file = new FileSavingData(getTitle(), getFileExtention(), getWorkflowId(), getActionId(), getCompanyId());
    file.setFilePath(getFilePath());
    return file;
  }

  public static List<FileSavingData> toFileSavingDataList(final List<UploadFileSavingData> uploadFileList) {

    final List<FileSavingData> filList = uploadFileList.stream().map(up -> up.toFileSavingData()).collect(Collectors.toList());

    return filList;
  }

}
