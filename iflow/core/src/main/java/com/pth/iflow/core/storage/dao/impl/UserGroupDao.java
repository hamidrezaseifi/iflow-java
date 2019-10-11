package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class UserGroupDao extends DaoBasicClass<UserGroup> implements IUserGroupDao {

  @Autowired
  private ICompanyDao companyDao;

  public UserGroupDao() {

  }

  @Override
  public UserGroup getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM user_group where id=?", "User Group");
  }

  @Override
  public UserGroup getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM user_group where identity=?", "User Group");
  }

  @Override
  public List<UserGroup> getListByIdList(final Set<Long> idList) throws IFlowStorageException {

    String sqlSelect = "SELECT * FROM user_group where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "User Group");
  }

  @Override
  public List<UserGroup> getListByIdentityList(final Set<String> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM user_group where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "User Group");
  }

  @Override
  protected UserGroup modelFromResultSet(final ResultSet rs) throws SQLException {
    final UserGroup model = new UserGroup();
    model.setId(rs.getLong("id"));
    model.setCompanyId(rs.getLong("company_id"));
    model.setTitle(rs.getString("title"));
    model.setCompanyIdentity(companyDao.getById(model.getCompanyId()).getIdentity());
    model.setIdentity(rs.getString("identity"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));

    return model;
  }

  @Override
  public List<UserGroup> getListByCompanyId(final Long companyId) throws IFlowStorageException {

    return getModelListById(companyId, "SELECT * FROM user_group where company_id=?", "User Group");
  }

  @Override
  public List<UserGroup> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return getModelListByIdentity(identity,
        "SELECT user_group.* FROM user_group inner join companies on user_group.company_id=companies.id where companies.identity?",
        "User Group");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final UserGroup model, final PreparedStatement ps) throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getCompanyId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final UserGroup model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getTitle());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());
    ps.setLong(5, model.getId());

    return ps;
  }

  @Override
  public UserGroup create(final UserGroup model) throws IFlowStorageException {
    final String sql = "INSERT INTO user_group (identity, company_id, title, version, status)" + "VALUES (?, ?, ?, ?, ?)";

    return getById(createModel(model, "UserGroup", sql, true));
  }

  @Override
  public UserGroup update(final UserGroup model) throws IFlowStorageException {
    final String sql = "UPDATE user_group SET company_id = ?, title = ?, version = ?, status =  WHERE id = ?";

    updateModel(model, "UserGroup", sql, true);

    return getById(model.getId());
  }

  @Override
  protected String generateIdentity(final UserGroup model) {

    return String.format("c%dgrp%d", model.getCompanyId(), System.currentTimeMillis());
  }

}
