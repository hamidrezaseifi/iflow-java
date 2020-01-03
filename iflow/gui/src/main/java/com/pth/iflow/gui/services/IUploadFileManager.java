package com.pth.iflow.gui.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pth.iflow.gui.models.UploadededFile;
import com.pth.iflow.gui.models.ui.FileSavingData;

public interface IUploadFileManager {

  public String saveSingleMultipartInTemp(final MultipartFile file) throws IOException;

  public List<FileSavingData> moveFromTempToArchive(List<UploadededFile> files) throws IOException;

}
