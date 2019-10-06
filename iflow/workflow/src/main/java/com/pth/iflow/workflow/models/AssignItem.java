package com.pth.iflow.workflow.models;

import com.pth.iflow.common.enums.EAssignType;

public class AssignItem {

  private Long        itemId;

  private EAssignType itemType;

  public AssignItem() {

  }

  public AssignItem(final Long itemId, final EAssignType itemType) {
    this.setItemId(itemId);
    this.setItemType(itemType);
  }

  public Long getItemId() {
    return this.itemId;
  }

  public void setItemId(final Long itemId) {
    this.itemId = itemId;
  }

  public EAssignType getItemType() {
    return this.itemType;
  }

  public void setItemType(final EAssignType itemType) {
    this.itemType = itemType;
  }

}
