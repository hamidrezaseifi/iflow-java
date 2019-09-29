package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "IdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "IdList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class IdLongListEdo {

  @NotNull(message = "IdList must not be null")
  @XmlElementWrapper(name = "IdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<Long> idList = new HashSet<>();

  public IdLongListEdo() {

  }

  public IdLongListEdo(final Set<Long> idList) {
    this.setIdList(idList);
  }

  public Set<Long> getIdList() {
    return this.idList;
  }

  @JsonSetter
  public void setIdList(final Set<Long> idList) {
    this.idList.clear();
    if (idList != null) {
      this.idList.addAll(idList);
    }
  }

}
