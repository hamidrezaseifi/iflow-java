package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserGroupListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserGroupListEdo {

  @XmlElementWrapper(name = "UserGroupList")
  @XmlElement(name = "UserGroupEdo")
  private final List<UserGroupEdo> userGroups = new ArrayList<>();

  public UserGroupListEdo() {

  }

  public UserGroupListEdo(final List<UserGroupEdo> userGroups) {
    setUserGroups(userGroups);
  }

  public List<UserGroupEdo> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(final List<UserGroupEdo> users) {
    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

}
