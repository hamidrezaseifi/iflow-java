package com.pth.iflow.gui.models;

import com.pth.iflow.common.enums.EApplication;
import com.pth.iflow.gui.models.ui.UiMenuItem;

public class UserDashboardMenu {

  private String userIdentity;

  private String appId = EApplication.IFLOW.getIdentity();

  private UiMenuItem menu = null;

  private String menuId = "";

  private Integer rowIndex;

  private Integer columnIndex;

  private Integer status = 1;

  private Integer version = 1;

  public String getUserIdentity() {

    return this.userIdentity;
  }

  public void setUserIdentity(final String userIdentity) {

    this.userIdentity = userIdentity;
  }

  public UiMenuItem getMenu() {

    return this.menu;
  }

  public void setMenu(final UiMenuItem menu) {

    this.menu = menu;
  }

  public String getText() {

    return this.menu != null ? this.menu.getLabel() : "Cube " + this.rowIndex + "-" + this.columnIndex;
  }

  public String getUrl() {

    return this.menu != null ? this.menu.getUrl() : "#";
  }

  public String getImage() {

    return this.menu != null ? this.menu.getImage() : "/assets/images/no-image.png";
  }

  public String getBackColor() {

    return this.menu != null ? this.menu.getBackColor() : "#ffffff";
  }

  public String getForeColor() {

    return this.menu != null ? this.menu.getForeColor() : "#000000";
  }

  public String getStyle() {

    String style = "background-color:" + this.getBackColor() + ";";
    style += "color:" + this.getForeColor() + ";";
    return style;
  }

  public String getAppId() {

    return this.appId;
  }

  public void setAppId(final String appId) {

    this.appId = appId;
  }

  public String getMenuId() {

    return this.menuId;
  }

  public void setMenuId(final String menuId) {

    this.menuId = menuId;
  }

  public Integer getRowIndex() {

    return this.rowIndex;
  }

  public void setRowIndex(final Integer rowIndex) {

    this.rowIndex = rowIndex;
  }

  public Integer getColumnIndex() {

    return this.columnIndex;
  }

  public void setColumnIndex(final Integer columnIndex) {

    this.columnIndex = columnIndex;
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

}