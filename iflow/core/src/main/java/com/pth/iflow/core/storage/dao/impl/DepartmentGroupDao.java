package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class DepartmentGroupDao extends DaoBasicClass<DepartmentGroup> implements IDepartmentGroupDao {

  public DepartmentGroupDao() {

  }

  @Override
  public DepartmentGroup getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM departments_group where id=?", "Department Group");
  }

  @Override
  public DepartmentGroup getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM departments_group where identity=?", "Department Group");
  }

  @Override
  public List<DepartmentGroup> getListByIdList(final Set<Long> idList) throws IFlowStorageException {

    String sqlSelect = "SELECT * FROM departments_group where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "Department Group");
  }

  @Override
  public List<DepartmentGroup> getListByIdentityList(final Set<String> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM departments_group where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "Department Group");
  }

  @Override
  protected DepartmentGroup modelFromResultSet(final ResultSet rs) throws SQLException {
    final DepartmentGroup model = new DepartmentGroup();
    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setDepartmentId(rs.getLong("department_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));

    return model;
  }

  @Override
  public List<DepartmentGroup> getListByDepartmentId(final Long departmentId) {
    return getModelListById(departmentId, "SELECT * FROM departments_group where department_id=?", "Department Group");
  }

  @Override
  public List<DepartmentGroup> getListByDepartmentIdentity(final String departmentIdentity) {
    return getModelListByIdentity(departmentIdentity,
        "SELECT departments_group.* FROM departments_group inner join departments on departments.id=departments_group.department_id where departments.identity=?",
        "Department Group");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final DepartmentGroup model, final PreparedStatement ps)
      throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getDepartmentId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final DepartmentGroup model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getDepartmentId());
    ps.setString(2, model.getTitle());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());
    ps.setLong(5, model.getId());

    return ps;
  }

  @Override
  public DepartmentGroup create(final DepartmentGroup model) throws IFlowStorageException {
    final String sql = "INSERT INTO departments_group (identity, department_id, title, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(model, "DepartmentGroup", sql, true));
  }

  @Override
  public DepartmentGroup update(final DepartmentGroup model) throws IFlowStorageException {
    final String sql = "UPDATE departments_group SET department_id = ?, title = ?, version = ?, status = ? WHERE id = ?";

    updateModel(model, "DepartmentGroup", sql, true);

    return getById(model.getId());
  }

  @Override
  public Set<String> getAllUserIdentityListByDepartmentGroupId(final Long id) throws IFlowStorageException {
    final Set<String> idList = getModelIdentityListById(id,
        "SELECT email FROM user_department_groups inner join users on users.id=user_department_groups.user_id where department_group_id=?",
        "User", "email");

    return idList;
  }

  @Override
  protected String generateIdentity(final DepartmentGroup model) {

    return String.format("d%ddgrp%d", model.getDepartmentId(), System.currentTimeMillis());
  }

}
