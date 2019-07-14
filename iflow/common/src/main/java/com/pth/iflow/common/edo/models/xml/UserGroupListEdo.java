package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "UserGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserGroupList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserGroupListEdo {

  @XmlElementWrapper(name = "UserGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "UserGroupEdo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<UserGroupEdo> userGroups = new ArrayList<>();

  public UserGroupListEdo() {

  }

  public UserGroupListEdo(final List<UserGroupEdo> userGroups) {
    this.setUserGroups(userGroups);
  }

  public List<UserGroupEdo> getUserGroups() {
    return this.userGroups;
  }

  public void setUserGroups(final List<UserGroupEdo> users) {
    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

}
