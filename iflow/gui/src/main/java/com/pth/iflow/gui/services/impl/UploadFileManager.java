package com.pth.iflow.gui.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pth.iflow.gui.models.UploadedFile;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;

@Service
public class UploadFileManager implements IUploadFileManager {

  protected final Logger log = LoggerFactory.getLogger(UploadFileManager.class);

  @Value("${iflow.gui.uploadfile.temp.basedir}")
  private String tempBaseDir;

  @Value("${iflow.gui.uploadfile.archive.basedir}")
  private String arhiveBaseDir;

  @Override
  public String saveSingleMultipartInTemp(final MultipartFile file) throws IOException {

    final String ext = FileSavingData.getExtention(file);
    final String tempPath = FileSavingData.generateSavingFileFullPath(this.tempBaseDir, ext);
    final File oFile = this.createFileAndFolders(tempPath);
    file.transferTo(oFile);
    return tempPath;
  }

  @Override
  public List<FileSavingData> moveFromTempToArchive(final List<UploadedFile> files) throws IOException {

    final List<FileSavingData> list = new ArrayList<>();

    for (final UploadedFile tempUploadedFile : files) {
      final FileSavingData fileSave = FileSavingData.generateFromFilePath(tempUploadedFile.getFilePath());

      final String archiveFilePath = FileSavingData.generateSavingFileFullPath(this.arhiveBaseDir, fileSave.getFileExtention());

      final FileSavingData archiveSaveFile = FileSavingData.generateFromFilePath(archiveFilePath);
      archiveSaveFile.setTitle(tempUploadedFile.getFileName());

      final File tempFile = fileSave.getFile();
      tempFile.renameTo(archiveSaveFile.getFile());

      list.add(archiveSaveFile);
    }
    return list;
  }

  private File createFileAndFolders(final String path) {

    final File oFile = new File(path);
    if (!oFile.getParentFile().exists()) {
      oFile.getParentFile().mkdirs();
    }
    return oFile;
  }

}
