package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserGroupDao implements IUserGroupDao {
  private static final Logger logger = LoggerFactory.getLogger(UserGroupDao.class);
  private final JdbcTemplate jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  public UserGroupDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public UserGroup getById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read UserGroup by id: " + id);
    final String sqlSelect = "SELECT * FROM user_group where id=?";

    UserGroup model;

    try {

      model = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userGroupFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve UserGroup data: " + e.toString());
    }

    return model;
  }

  @Override
  public List<UserGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    logger.info("Dao read UserGroup list: ");

    List<UserGroup> list = new ArrayList<>();

    if (idList.isEmpty()) {
      return list;
    }

    String sqlSelect = "SELECT * FROM user_group where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    final String sqlSelectFinal = sqlSelect;

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelectFinal);
        int index = 1;
        for (final Long id : idList) {
          ps.setLong(index++, id);
        }

        return ps;

      }, (rs, rowNum) -> {

        return userGroupFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read UserGroup list from list: " + e.toString());
    }

    return list;
  }

  private UserGroup userGroupFromResultSet(final ResultSet rs) throws SQLException {
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
