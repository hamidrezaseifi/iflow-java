package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    user.setCompanyIid(rs.getLong("companyid"));
    user.setEmail(rs.getString("email"));
    user.setFirstName(rs.getString("firstname"));
    user.setPassword(rs.getString("password"));
    user.setLastName(rs.getString("lastname"));
    user.setStatus(rs.getInt("status"));
    user.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    user.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    user.setVersion(rs.getInt("version"));

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

}
