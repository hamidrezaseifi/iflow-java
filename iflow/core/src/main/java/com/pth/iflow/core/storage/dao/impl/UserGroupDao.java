package com.pth.iflow.core.storage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.utils.SqlUtils;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class UserGroupDao extends DaoBasicClass<UserGroup> implements IUserGroupDao {
  public UserGroupDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public UserGroup getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM user_group where id=?", "User Group");
  }

  @Override
  public List<UserGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {

    String sqlSelect = "SELECT * FROM user_group where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "User Group");
  }

  @Override
  protected UserGroup modelFromResultSet(final ResultSet rs) throws SQLException {
    final UserGroup model = new UserGroup();
    model.setId(rs.getLong("id"));
    model.setCompanyId(rs.getLong("companyid"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));

    return model;
  }

}
