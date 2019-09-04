package com.pth.iflow.gui.services;

import java.io.IOException;
import java.util.List;

import com.pth.iflow.gui.models.ui.UploadFileLoadingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;

public interface IUploadFileManager {

  public boolean saveInTemp(List<UploadFileSavingData> files) throws IOException;

  public boolean save(List<UploadFileSavingData> files) throws IOException;

  public List<String> getFilePath(List<UploadFileLoadingData> files) throws IOException;

}
