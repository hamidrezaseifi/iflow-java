package com.pth.iflow.gui.services;

import java.io.IOException;
import java.util.List;

import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;

public interface IUploadFileManager {

  public List<UploadFileSavingData> saveInTemp(List<UploadFileSavingData> files) throws IOException;

  public List<FileSavingData> copyFromTempToArchive(List<FileSavingData> files) throws IOException;

  public List<FileSavingData> moveFromTempToArchive(List<FileSavingData> files) throws IOException;

  public void deleteFromTemp(List<FileSavingData> files) throws IOException;

  public boolean save(List<UploadFileSavingData> files) throws IOException;

  public List<String> getFilesPath(List<FileSavingData> files) throws IOException;

  public String getFilePath(FileSavingData file) throws IOException;

}
