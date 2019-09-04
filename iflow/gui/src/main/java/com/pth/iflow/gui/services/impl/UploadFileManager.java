package com.pth.iflow.gui.services.impl;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pth.iflow.gui.models.ui.UploadFileLoadingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;

@Service
public class UploadFileManager implements IUploadFileManager {

  protected final Logger log = LoggerFactory.getLogger(UploadFileManager.class);

  @Value("${iflow.gui.uploadfile.temp.basedir}")
  private String tempBaseDir;

  @Value("${iflow.gui.uploadfile.archive.basedir}")
  private String arhiveBaseDir;

  @Override
  public boolean saveInTemp(final List<UploadFileSavingData> files) throws IOException {

    for (final UploadFileSavingData file : files) {
      final String path = file.generateSavingTempFileFullPath(getBaseDir());

    }
    return false;
  }

  @Override
  public boolean save(final List<UploadFileSavingData> files) throws IOException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<String> getFilePath(final List<UploadFileLoadingData> files) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  private String getBaseDir() throws IOException {
    final URL url = this.getClass().getClassLoader().getResource("/");
    return url.getPath();
  }
}
