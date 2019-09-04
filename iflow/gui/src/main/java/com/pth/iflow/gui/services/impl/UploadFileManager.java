package com.pth.iflow.gui.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
  public List<String> saveInTemp(final List<UploadFileSavingData> files) throws IOException {

    final List<String> tempFilePathList = new ArrayList<>();

    for (final UploadFileSavingData file : files) {
      final String path = file.generateSavingTempFileFullPath(getBaseDir());
      final File oFile = createFileAndFolders(path);
      file.getFile().transferTo(oFile);
      tempFilePathList.add(path);
    }
    return tempFilePathList;
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

  private File createFileAndFolders(final String path) {
    final File oFile = new File(path);
    if (!oFile.getParentFile().exists()) {
      oFile.getParentFile().mkdirs();
    }
    return oFile;
  }

}
