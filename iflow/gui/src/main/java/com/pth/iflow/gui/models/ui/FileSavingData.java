package com.pth.iflow.gui.models.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileSavingData {

  public static String[] AVAILEABLE_EXTENTIONS = { "pdf", "jpg", "gif", "png", "doc", "docx" };

  private String title;
  private String fileExtention;
  private String filePath;
  private String tempFilePath;

  public FileSavingData(final String fileExtention) {

    this.fileExtention = fileExtention;
  }

  public FileSavingData(final String title, final String fileExtention) {

    this.title = title;
    this.fileExtention = fileExtention;

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

  public String getTempFilePath() {

    return this.tempFilePath;
  }

  public void setTempFilePath(final String tempFilePath) {

    this.tempFilePath = tempFilePath;
  }

  public File getFile() {

    return new File(this.filePath);
  }

  public File getTempFile() {

    return new File(this.tempFilePath);
  }

  /**
   * @return the saving file temp path preffix
   */
  public static String generateSavingFilePathPreffix(final String fileExtention) {

    final LocalDate dt = LocalDate.now();
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");

    return String.format("%s/temp_%d.%s", dt.format(formatter), System.currentTimeMillis(), fileExtention);
  }

  public String generateNameExtention() {

    return String.format("%s.%s", this.title, this.fileExtention);
  }

  /**
   * @return the saving file temp path preffix
   */
  public static String generateSavingFileFullPath(final String basePath, final String fileExtention) {

    String path = basePath + "/" + FileSavingData.generateSavingFilePathPreffix(fileExtention);
    path = clearFilePath(path);

    return path;
  }

  private static String clearFilePath(final String path) {

    return path.replace("//", "/").replace("..", ".");
  }

  public MediaType getMediaType() {

    MediaType mediaType = MediaType.parseMediaType("application/pdf");
    if (this.isFilePdf()) {
      mediaType = MediaType.parseMediaType("application/pdf");
    }
    if (this.isFileJpg()) {
      mediaType = MediaType.IMAGE_JPEG;
    }
    if (this.isFileGif()) {
      mediaType = MediaType.IMAGE_GIF;
    }
    if (this.isFilePng()) {
      mediaType = MediaType.IMAGE_PNG;
    }
    if (this.isFileWord()) {
      mediaType = MediaType.parseMediaType("application/word");
    }

    return mediaType;
  }

  public String getMediaTypeString() {

    String mediaType = "";
    if (this.isFilePdf()) {
      mediaType = "application/pdf";
    }
    if (this.isFileJpg()) {
      mediaType = MediaType.IMAGE_JPEG_VALUE;
    }
    if (this.isFileGif()) {
      mediaType = MediaType.IMAGE_GIF_VALUE;
    }
    if (this.isFilePng()) {
      mediaType = MediaType.IMAGE_PNG_VALUE;
    }
    if (this.isFileWord()) {
      mediaType = "application/word";
    }

    return mediaType;
  }

  public boolean isFilePdf() {

    return this.fileExtention.toLowerCase().equals("pdf");
  }

  public boolean isFileJpg() {

    return this.fileExtention.toLowerCase().equals("jpg");
  }

  public boolean isFileGif() {

    return this.fileExtention.toLowerCase().equals("gif");
  }

  public boolean isFilePng() {

    return this.fileExtention.toLowerCase().equals("png");
  }

  public boolean isFileWord() {

    return this.fileExtention.toLowerCase().equals("doc") || this.fileExtention.toLowerCase().equals("docx");
  }

  public boolean isFileImage() {

    return this.isFileJpg() || this.isFileGif() || this.isFilePng();
  }

  public static String getExtention(final MultipartFile file) {

    final String fileName = file.getOriginalFilename();
    final int pointIndex = fileName.lastIndexOf(".");
    final String ext = pointIndex > 2 ? fileName.substring(pointIndex + 1) : "";
    return ext;
  }

  public ResponseEntity<InputStreamResource> generateFileReposneEntity(final String readFilePath) throws FileNotFoundException {

    final File file = new File(readFilePath);
    final HttpHeaders respHeaders = new HttpHeaders();
    respHeaders.setContentType(this.getMediaType());
    respHeaders.setContentLength(file.length());
    respHeaders.setContentDispositionFormData("attachment", file.getName());
    final InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
    final ResponseEntity<InputStreamResource> respEntity = new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    return respEntity;
  }

  public void prepareReposne(final String readFilePath, final HttpServletResponse response) throws IOException {

    final File file = new File(readFilePath);

    response.setContentType(this.getMediaTypeString());
    response.setContentLengthLong(file.length());

    FileUtils.copyFile(file, response.getOutputStream());

    final String fileName = this.generateNameExtention();

    response.setHeader("Content-disposition", "attachment;filename=" + fileName);
    response.flushBuffer();
  }

  public static String getExtention(final String filePath) {

    final int pointIndex = filePath.lastIndexOf(".");
    final String ext = pointIndex > 2 ? filePath.substring(pointIndex + 1) : "";
    return ext;
  }

  public static FileSavingData generateFromFilePath(final String filePath) {

    final String extention = FileSavingData.getExtention(filePath);
    final FileSavingData fileSaveData = new FileSavingData(extention);
    fileSaveData.setFilePath(filePath);

    return fileSaveData;
  }

}
