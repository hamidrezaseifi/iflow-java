package com.pth.iflow.core.storage.dao.impl;

import javax.persistence.TypedQuery;

import com.pth.iflow.core.model.entity.UserEntity;

public class DaoHelper {

  public static String retreiveRawSql(final TypedQuery<UserEntity> typedQuery) {
    return typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
  }

}
