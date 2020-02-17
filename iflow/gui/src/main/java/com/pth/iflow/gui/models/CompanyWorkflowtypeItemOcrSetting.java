package com.pth.iflow.gui.models;

public class CompanyWorkflowtypeItemOcrSetting {

  private String workflowIdentity;

  private String propertyName;

  private String value;

  private Integer status;

  private Integer version;

  public String getWorkflowIdentity() {

    return workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {

    this.workflowIdentity = workflowIdentity;
  }

  public String getPropertyName() {

    return propertyName;
  }

  public void setPropertyName(final String propertyName) {

    this.propertyName = propertyName;
  }

  public String getValue() {

    return value;
  }

  public void setValue(final String value) {

    this.value = value;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {

    return this.status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {

    this.status = status;
  }

  /**
   * @return the version
   */

  public Integer getVersion() {

    return this.version;
  }

  /**
   * @param version the version to set
   */

  public void setVersion(final Integer version) {

    this.version = version;
  }

}
