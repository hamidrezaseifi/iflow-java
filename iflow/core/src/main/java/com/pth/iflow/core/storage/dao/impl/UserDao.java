package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class UserDao extends DaoBasicClass<User> implements IUserDao {

  public UserDao() {

  }

  @Override
  protected User modelFromResultSet(final ResultSet rs) throws SQLException {
    final User user = new User();
    user.setId(rs.getLong("id"));
    user.setCompanyId(rs.getLong("company_id"));
    user.setEmail(rs.getString("email"));
    user.setFirstName(rs.getString("firstname"));
    user.setLastName(rs.getString("lastname"));
    user.setStatus(rs.getInt("status"));
    user.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    user.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    user.setVersion(rs.getInt("version"));
    user.setPermission(rs.getInt("permission"));
    user.setGroups(getGroupIdListById(user.getId()));
    user.setDepartments(getDepartmentIdListIdById(user.getId()));
    user.setDeputies(getDeputyIdListById(user.getId()));

    return user;
  }

  @Override
  public User getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM users where id=?", "User");
  }

  @Override
  public List<User> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM users where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "User");
  }

  private List<Long> getDeputyIdListById(final Long id) throws IFlowStorageException {

    return getIdListById(id, "SELECT * FROM user_deputy where user_id=?", "deputy_id", "User Deputies");
  }

  private List<Long> getGroupIdListById(final Long id) throws IFlowStorageException {

    return getIdListById(id, "SELECT * FROM user_usergroup where user_id=?", "user_group", "User Groups");
  }

  private List<Long> getDepartmentIdListIdById(final Long id) throws IFlowStorageException {

    return getIdListById(id, "SELECT * FROM user_departments where user_id=?", "department_id", "User Departments");
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
          return modelFromResultSet(rs);
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
  protected PreparedStatement prepareInsertPreparedStatement(final User model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getEmail());
    ps.setString(3, model.getFirstName());
    ps.setString(4, model.getLastName());
    ps.setInt(5, model.getPermission());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final User model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getEmail());
    ps.setString(3, model.getFirstName());
    ps.setString(4, model.getLastName());
    ps.setInt(5, model.getPermission());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus());
    ps.setLong(8, model.getId());

    return ps;
  }

  @Override
  public User create(final User model) throws IFlowStorageException {
    final String sql = "INSERT INTO users (company_id, email, firstname, lastname, permission, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    final TransactionStatus transactionStatus = startTransaction(true);
    try {
      final Long createdId = createModel(model, "User", sql, false);

      createUserGroups(model, createdId);

      createUserDepartments(model, createdId);

      createUserDeputies(model, createdId);

      commitTransaction(true, transactionStatus);
      return getById(createdId);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create user:{} {}", model.getEmail(), e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createUserGroups(final User model, final Long userId) {

    deleteUserGroups(userId);

    final String insSql = "INSERT INTO user_usergroup (user_id, user_group) VALUES (?, ?)";

    for (final Long groupId : model.getGroups()) {
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(insSql);
        ps.setLong(1, userId);
        ps.setLong(2, groupId);
        return ps;
      });

    }
  }

  private void createUserDepartments(final User model, final Long userId) {

    deleteUserDepartments(userId);

    final String insSql = "INSERT INTO user_departments (user_id, department_id) VALUES (?, ?)";

    for (final Long groupId : model.getGroups()) {
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(insSql);
        ps.setLong(1, userId);
        ps.setLong(2, groupId);
        return ps;
      });

    }
  }

  private void createUserDeputies(final User model, final Long userId) {

    deleteUserDeputies(userId);

    final String insSql = "INSERT INTO user_deputy (user_id, deputy_id) VALUES (?, ?)";

    for (final Long groupId : model.getGroups()) {
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(insSql);
        ps.setLong(1, userId);
        ps.setLong(2, groupId);
        return ps;
      });

    }
  }

  @Override
  public User update(final User model) throws IFlowStorageException {
    final String sql = "UPDATE users SET company_id = ?, email = ?, firstname = ?, lastname = ?,"
        + " permission = ?, version = ?, status = ? WHERE id = ?";

    updateModel(model, "User", sql, true);

    return getById(model.getId());
  }

  @Override
  public void deleteById(final Long id) throws IFlowStorageException {
    final TransactionStatus transactionStatus = startTransaction(true);
    try {

      deleteUserGroups(id);

      deleteUserDepartments(id);

      deleteUserDeputies(id);

      deleteModel(id, "User", "Delete from users where id=?", false, true);

      commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete user:{} {}", id, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void deleteUserDeputies(final Long id) {
    deleteModel(id, "User Deputies", "Delete FROM user_deputy where user_id=?", false, false);
  }

  private void deleteUserDepartments(final Long id) {
    deleteModel(id, "User Departments", "Delete FROM user_departments where user_id=?", false, false);
  }

  private void deleteUserGroups(final Long id) {
    deleteModel(id, "User Groups", "Delete FROM user_usergroup where user_id=?", false, false);
  }

  @Override
  public List<User> getListByCompanyId(final Long id) throws IFlowStorageException {
    final List<Long> idList = getIdListById(id, "SELECT * FROM users where company_id=?", "id", "User");

    return getListByIdList(idList);
  }

}
