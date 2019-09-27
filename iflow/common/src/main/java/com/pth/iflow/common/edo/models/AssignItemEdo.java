package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.validation.AEnumNameValidator;
import com.pth.iflow.common.enums.EAssignType;

@XmlRootElement(name = "AssignItem", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "AssignItem" + IFlowJaxbDefinition.TYPE_PREFIX)
public class AssignItemEdo {

  @NotNull(message = "ItemID must not be null")
  @XmlElement(name = "ItemID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long   itemId;

  @NotNull(message = "ItemType must not be null")
  @AEnumNameValidator(enumClazz = EAssignType.class)
  @XmlElement(name = "ItemType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String itemType;

  public AssignItemEdo() {

  }

  public AssignItemEdo(final Long itemId, final String itemType) {
    this.setItemId(itemId);
    this.setItemType(itemType);
  }

  public Long getItemId() {
    return this.itemId;
  }

  public void setItemId(final Long itemId) {
    this.itemId = itemId;
  }

  public String getItemType() {
    return this.itemType;
  }

  public void setItemType(final String itemType) {
    this.itemType = itemType;
  }

}
