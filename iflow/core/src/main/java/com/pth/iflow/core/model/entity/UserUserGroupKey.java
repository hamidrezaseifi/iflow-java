package com.pth.iflow.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserUserGroupKey implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 8478136576086004241L;

  @Column(name = "user_id")
  Long                      userId;

  @Column(name = "user_group")
  Long                      userGroup;
}
