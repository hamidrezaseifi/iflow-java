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

@XmlRootElement(name = "UserList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserListEdo {

  @NotNull
  @XmlElementWrapper(name = "UserList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<UserEdo> users = new HashSet<>();

  public UserListEdo() {

  }

  public UserListEdo(final Set<UserEdo> users) {
    this.setUsers(users);
  }

  public Set<UserEdo> getUsers() {
    return this.users;
  }

  @JsonSetter
  public void setUsers(final Set<UserEdo> users) {
    this.users.clear();
    if (users != null) {
      this.users.addAll(users);
    }
  }

}
