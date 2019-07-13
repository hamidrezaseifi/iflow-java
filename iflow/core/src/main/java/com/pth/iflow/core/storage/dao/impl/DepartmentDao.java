package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class DepartmentDao extends DaoBasicClass<Department> implements IDepartmentDao {

  public DepartmentDao() {

  }

  @Override
  protected Department modelFromResultSet(final ResultSet rs) throws SQLException {
    final Department model = new Department();
    model.setId(rs.getLong("id"));
    model.setCompanyId(rs.getLong("company_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setGroups(this.getGroupIdListById(model.getId()));

    return model;
  }

  @Override
  public Department getById(final Long id) throws IFlowStorageException {
    return this.getModelById(id, "SELECT * FROM departments where id=?", "Department");
  }

  @Override
  public List<Department> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM departments where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdList(idList, sqlSelect, "User");
  }

  private List<Long> getGroupIdListById(final Long id) throws IFlowStorageException {
    return this.getIdListById(id, "SELECT * FROM departments_group where department_id=?", "id", "Department Groups");
  }

  @Override
  public List<Department> getListByCompanyId(final Long id) throws IFlowStorageException {
    return this.getModelListById(id, "SELECT * FROM departments where company_id=?", "Department");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Department model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getTitle());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Department model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setString(2, model.getTitle());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());
    ps.setLong(5, model.getId());

    return ps;
  }

  @Override
  public Department create(final Department model) throws IFlowStorageException {
    final String sql = "INSERT INTO departments (company_id, title, version, status)" + "VALUES (?, ?, ?, ?)";

    return this.getById(this.createModel(model, "Department", sql, true));
  }

  @Override
  public Department update(final Department model) throws IFlowStorageException {
    final String sql = "UPDATE departments SET company_id = ?, title = ?, version = ?, status =  WHERE id = ?";

    this.updateModel(model, "Department", sql, true);

    return this.getById(model.getId());
  }

  @Override
  public List<Long> getAllUserIdListByDepartmentId(final Long id) throws IFlowStorageException {
    final List<Long> idList = this.getModelIdListById(id, "SELECT user_id FROM user_departments where department_id=?", "User",
        "user_id");

    return idList;
  }

}
