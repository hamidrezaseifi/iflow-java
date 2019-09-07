package com.pth.iflow.gui.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;

@Service
public class UploadFileManager implements IUploadFileManager {

  protected final Logger log = LoggerFactory.getLogger(UploadFileManager.class);

  @Value("${iflow.gui.uploadfile.temp.basedir}")
  private String         tempBaseDir;

  @Value("${iflow.gui.uploadfile.archive.basedir}")
  private String         arhiveBaseDir;

  @Override
  public List<UploadFileSavingData> saveInTemp(final List<UploadFileSavingData> files) throws IOException {

    final List<UploadFileSavingData> tempFilePathList = new ArrayList<>();

    for (final UploadFileSavingData file : files) {
      final String tempPath = file.generateSavingTempFileFullPath(this.tempBaseDir);
      final File oFile = this.createFileAndFolders(tempPath);
      file.getMultipartFile().transferTo(oFile);
      file.setFilePath(tempPath);
      tempFilePathList.add(file);
    }
    return tempFilePathList;
  }

  @Override
  public List<FileSavingData> moveFromTempToArchive(final List<FileSavingData> files) throws IOException {
    final List<FileSavingData> tempFilePathList = new ArrayList<>();

    for (final FileSavingData file : files) {
      final String archiveath = file.generateSavingFileFullPath(this.arhiveBaseDir);
      final File archiveFile = this.createFileAndFolders(archiveath);
      final File tempFile = file.getFile();
      tempFile.renameTo(archiveFile);
      file.setFilePath(archiveath);

      tempFilePathList.add(file);
    }
    return tempFilePathList;
  }

  @Override
  public List<FileSavingData> copyFromTempToArchive(final List<FileSavingData> files) throws IOException {
    final List<FileSavingData> tempFilePathList = new ArrayList<>();

    for (final FileSavingData file : files) {
      final String archiveath = file.generateSavingFileFullPath(this.arhiveBaseDir);

      final File archiveFile = this.createFileAndFolders(archiveath);
      final File tempFile = file.getTempFile();

      FileUtils.copyFile(tempFile, archiveFile);

      file.setFilePath(archiveath);

      tempFilePathList.add(file);
    }
    return tempFilePathList;
  }

  @Override
  public void deleteFromTemp(final List<FileSavingData> files) throws IOException {
    for (final FileSavingData file : files) {

      final File tempFile = file.getFile();
      tempFile.delete();
    }
  }

  @Override
  public boolean save(final List<UploadFileSavingData> files) throws IOException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<String> getFilesPath(final List<FileSavingData> files) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getFilePath(final FileSavingData file) throws IOException {
    final String realPath = file.generateSavingFileFullPath(this.arhiveBaseDir);

    return realPath;
  }

  private File createFileAndFolders(final String path) {
    final File oFile = new File(path);
    if (!oFile.getParentFile().exists()) {
      oFile.getParentFile().mkdirs();
    }
    return oFile;
  }

}
