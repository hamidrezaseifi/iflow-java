package com.pth.iflow.gui.models;

import org.apache.commons.lang3.StringUtils;

import com.pth.iflow.common.enums.EOcrType;

public class CompanyWorkflowtypeItemOcrSettingPresetItem {

  private String propertyName;

  private String value;

  private Integer ocrType;

  private Integer status;

  private Integer version;

  public String getPropertyName() {

    return this.propertyName;
  }

  public void setPropertyName(final String propertyName) {

    this.propertyName = propertyName;
  }

  public String getValue() {

    return this.value;
  }

  public void setValue(final String value) {

    this.value = value;
  }

  public Integer getOcrType() {

    return this.ocrType;
  }

  public EOcrType getOcrTypeEnum() {

    return EOcrType.valueFromInteger(this.ocrType);
  }

  public void setOcrType(final Integer ocrType) {

    this.ocrType = ocrType;
  }

  public Integer getStatus() {

    return this.status;
  }

  public void setStatus(final Integer status) {

    this.status = status;
  }

  public Integer getVersion() {

    return this.version;
  }

  public void setVersion(final Integer version) {

    this.version = version;
  }

  public boolean hasValue() {

    return StringUtils.isNotEmpty(this.value);
  }

  public void prepare() {

    this.status = this.status == null ? 1 : this.status;
    this.version = this.version == null ? 1 : this.version;
  }

}
