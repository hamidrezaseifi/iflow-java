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
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class UserDao implements IUserDao {

  private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
  private final JdbcTemplate jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  public UserDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public User getById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read User by id: " + id);
    final String sqlSelect = "SELECT * FROM users where id=?";

    User user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve User data: " + e.toString());
    }

    return user;
  }

  private List<Long> getDeputyIdListById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read User Deputies by id: " + id);
    final String sqlSelect = "SELECT * FROM user_deputy where user_id=?";

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("deputy_id");

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read User Deputies: " + e.toString());
    }

    return list;
  }

  private List<Long> getGroupIdListById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read User Deputies by id: " + id);
    final String sqlSelect = "SELECT * FROM user_usergroup where user_id=?";

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("user_group");

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read User Deputies: " + e.toString());
    }

    return list;
  }

  private List<Long> getDepartmentIdListIdById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read User Deputies by id: " + id);
    final String sqlSelect = "SELECT * FROM user_departments where user_id=?";

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("department_id");

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read User Deputies: " + e.toString());
    }

    return list;
  }

  @Override
  public User getByEmail(final String email) throws IFlowStorageException {
    logger.info("Dao Read User by email: " + email);
    final String sqlSelect = "SELECT *  FROM users where email=?";

    User user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, email);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve User data: " + e.toString());
    }

    return user;
  }

  private User userFromResultSet(final ResultSet rs) throws SQLException {
    final User user = new User();
    user.setId(rs.getLong("id"));
    user.setCompanyId(rs.getLong("companyid"));
    user.setEmail(rs.getString("email"));
    user.setFirstName(rs.getString("firstname"));
    user.setPassword(rs.getString("password"));
    user.setLastName(rs.getString("lastname"));
    user.setStatus(rs.getInt("status"));
    user.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    user.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    user.setVersion(rs.getInt("version"));
    user.setGroups(getGroupIdListById(user.getId()));
    user.setDepartments(getDepartmentIdListIdById(user.getId()));
    user.setDeputies(getDeputyIdListById(user.getId()));

    return user;
  }

  @Override
  public User getUserByUsername(final String username) {
    logger.info("Dao Read User by username: " + username);
    final String sqlSelect = "SELECT * FROM users where email='?'";

    User user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, username);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve User data: " + e.toString());
    }

    return user;
  }

  @Override
  public List<User> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    logger.info("Dao Read User list: ");

    List<User> list = new ArrayList<>();

    if (idList.isEmpty()) {
      return list;
    }

    String sqlSelect = "SELECT * FROM users where id in (";
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

        return userFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read User list from list: " + e.toString());
    }

    return list;
  }

}
