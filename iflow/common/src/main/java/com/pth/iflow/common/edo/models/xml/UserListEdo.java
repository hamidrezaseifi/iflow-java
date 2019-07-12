package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListEdo {

  @XmlElementWrapper(name = "UserList")
  @XmlElement(name = "UserEdo")
  private final List<UserEdo> users = new ArrayList<>();

  public UserListEdo() {

  }

  public UserListEdo(final List<UserEdo> users) {
    setUsers(users);
  }

  public List<UserEdo> getUsers() {
    return users;
  }

  public void setUsers(final List<UserEdo> users) {
    this.users.clear();
    if (users != null) {
      this.users.addAll(users);
    }
  }

}
