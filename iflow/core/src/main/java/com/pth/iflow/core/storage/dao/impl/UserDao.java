package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    user.setBirthDate(rs.getDate("birthdate"));
    user.setFirstName(rs.getString("firstname"));
    user.setLastName(rs.getString("lastname"));
    user.setStatus(rs.getInt("status"));
    user.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    user.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    user.setVersion(rs.getInt("version"));
    user.setPermission(rs.getInt("permission"));
    user.setGroups(this.getGroupIdListById(user.getId()));
    user.setDepartments(this.getDepartmentIdListIdById(user.getId()));
    user.setDeputies(this.getDeputyIdListById(user.getId()));
    user.setRoles(this.getRoleListById(user.getId()));

    return user;
  }

  @Override
  public User getById(final Long id) throws IFlowStorageException {
    return this.getModelById(id, "SELECT * FROM users where id=?", "User");
  }

  @Override
  public List<User> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM users where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdList(idList, sqlSelect, "User");
  }

  private List<Long> getDeputyIdListById(final Long id) throws IFlowStorageException {

    return this.getIdListById(id, "SELECT * FROM user_deputy where user_id=?", "deputy_id", "User Deputies");
  }

  private List<Long> getGroupIdListById(final Long id) throws IFlowStorageException {

    return this.getIdListById(id, "SELECT * FROM user_usergroup where user_id=?", "user_group", "User Groups");
  }

  private List<Long> getDepartmentIdListIdById(final Long id) throws IFlowStorageException {

    return this.getIdListById(id, "SELECT * FROM user_departments where user_id=?", "department_id", "User Departments");
  }

  private List<Integer> getRoleListById(final Long id) throws IFlowStorageException {

    return this.getIdListById(id, "SELECT * FROM user_roles where user_id=?", "role", "User Roles").stream().map(r -> r.intValue())
        .collect(Collectors.toList());
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
          return this.modelFromResultSet(rs);
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
    ps.setDate(3, model.getBirthDate() != null ? new java.sql.Date(model.getBirthDate().getTime()) : null);
    ps.setString(4, model.getFirstName());
    ps.setString(5, model.getLastName());
    ps.setInt(6, model.getPermission());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final User model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getEmail());
    ps.setDate(3, model.getBirthDate() != null ? new java.sql.Date(model.getBirthDate().getTime()) : null);
    ps.setString(4, model.getFirstName());
    ps.setString(5, model.getLastName());
    ps.setInt(6, model.getPermission());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

  @Override
  public User create(final User model) throws IFlowStorageException {
    final String sql = "INSERT INTO users (company_id, email, birthdate, firstname, lastname, permission, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {
      final Long createdId = this.createModel(model, "User", sql, false);

      this.createUserGroups(model, createdId);

      this.createUserDepartments(model, createdId);

      this.createUserDeputies(model, createdId);

      this.createUserRoles(model, createdId);

      this.commitTransaction(true, transactionStatus);
      return this.getById(createdId);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create user:{} {}", model.getEmail(), e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createUserGroups(final User model, final Long userId) {

    this.deleteUserGroups(userId);

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

    this.deleteUserDepartments(userId);

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

    this.deleteUserDeputies(userId);

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

  private void createUserRoles(final User model, final Long userId) {

    this.deleteUserRoles(userId);

    final String insSql = "INSERT INTO user_roles (user_id, role) VALUES (?, ?)";

    for (final Integer role : model.getRoles()) {
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(insSql);
        ps.setLong(1, userId);
        ps.setInt(2, role);
        return ps;
      });

    }
  }

  @Override
  public User update(final User model) throws IFlowStorageException {
    final String sql = "UPDATE users SET company_id = ?, email = ?, birthdate = ? , firstname = ?, lastname = ?,"
        + " permission = ?, version = ?, status = ? WHERE id = ?";

    this.updateModel(model, "User", sql, true);

    this.createUserGroups(model, model.getId());

    this.createUserDepartments(model, model.getId());

    this.createUserDeputies(model, model.getId());

    this.createUserRoles(model, model.getId());

    return this.getById(model.getId());
  }

  @Override
  public void deleteById(final Long id) throws IFlowStorageException {
    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.deleteUserGroups(id);

      this.deleteUserDepartments(id);

      this.deleteUserDeputies(id);

      this.deleteModel(id, "User", "Delete from users where id=?", false, true);

      this.commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete user:{} {}", id, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void deleteUserDeputies(final Long id) {
    this.deleteModel(id, "User Deputies", "Delete FROM user_deputy where user_id=?", false, false);
  }

  private void deleteUserRoles(final Long id) {
    this.deleteModel(id, "User Roles", "Delete FROM user_roles where user_id=?", false, false);
  }

  private void deleteUserDepartments(final Long id) {
    this.deleteModel(id, "User Departments", "Delete FROM user_departments where user_id=?", false, false);
  }

  private void deleteUserGroups(final Long id) {
    this.deleteModel(id, "User Groups", "Delete FROM user_usergroup where user_id=?", false, false);
  }

  @Override
  public List<User> getListByCompanyId(final Long id) throws IFlowStorageException {
    final List<Long> idList = this.getIdListById(id, "SELECT * FROM users where company_id=?", "id", "User");

    return this.getListByIdList(idList);
  }

}
