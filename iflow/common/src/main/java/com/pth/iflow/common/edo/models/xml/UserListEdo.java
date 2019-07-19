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

@XmlRootElement(name = "UserList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserListEdo {

  @XmlElementWrapper(name = "UserList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<UserEdo> users = new ArrayList<>();

  public UserListEdo() {

  }

  public UserListEdo(final List<UserEdo> users) {
    this.setUsers(users);
  }

  public List<UserEdo> getUsers() {
    return this.users;
  }

  public void setUsers(final List<UserEdo> users) {
    this.users.clear();
    if (users != null) {
      this.users.addAll(users);
    }
  }

}
