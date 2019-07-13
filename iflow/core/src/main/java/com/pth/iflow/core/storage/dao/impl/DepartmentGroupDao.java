package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
  public List<DepartmentGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {

    String sqlSelect = "SELECT * FROM departments_group where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "Department Group");
  }

  @Override
  protected DepartmentGroup modelFromResultSet(final ResultSet rs) throws SQLException {
    final DepartmentGroup model = new DepartmentGroup();
    model.setId(rs.getLong("id"));
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
  protected PreparedStatement prepareInsertPreparedStatement(final DepartmentGroup model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getDepartmentId());
    ps.setString(2, model.getTitle());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());

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
    final String sql = "INSERT INTO departments_group (department_id, title, version, status)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(model, "DepartmentGroup", sql, true));
  }

  @Override
  public DepartmentGroup update(final DepartmentGroup model) throws IFlowStorageException {
    final String sql = "UPDATE departments_group SET department_id = ?, title = ?, version = ?, status = ? WHERE id = ?";

    updateModel(model, "DepartmentGroup", sql, true);

    return getById(model.getId());
  }

  @Override
  public List<Long> getAllUserIdListByDepartmentGroupId(final Long id) throws IFlowStorageException {
    final List<Long> idList = getModelIdListById(id, "SELECT user_id FROM user_department_groups where department_group_id=?", "User",
        "user_id");

    return idList;
  }

}
