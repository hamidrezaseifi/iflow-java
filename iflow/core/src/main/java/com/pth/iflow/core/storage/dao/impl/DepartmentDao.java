package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class DepartmentDao extends DaoBasicClass<Department> implements IDepartmentDao {

  @Autowired
  private IDepartmentGroupDao departmentGroupDao;

  public DepartmentDao() {

  }

  @Override
  protected Department modelFromResultSet(final ResultSet rs) throws SQLException {
    final Department model = new Department();
    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setCompanyId(rs.getLong("company_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setDepartmentGroups(this.departmentGroupDao.getListByDepartmentId(model.getId()));

    return model;
  }

  @Override
  public Department getById(final Long id) throws IFlowStorageException {
    return this.getModelById(id, "SELECT * FROM departments where id=?", "Department");
  }

  @Override
  public Department getByIdentity(final String identity) throws IFlowStorageException {
    return this.getModelByIdentity(identity, "SELECT * FROM departments where identity=?", "Department");
  }

  @Override
  public List<Department> getListByIdList(final Set<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM departments where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdList(idList, sqlSelect, "Department");
  }

  @Override
  public List<Department> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM departments where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "Department");
  }

  @Override
  public List<Department> getListByCompanyId(final Long id) throws IFlowStorageException {
    return this.getModelListById(id, "SELECT * FROM departments where company_id=?", "Department");
  }

  @Override
  public List<Department> getListByCompanyIdentity(final String identity) throws IFlowStorageException {
    return this.getModelListByIdentity(identity,
        "SELECT departments.* FROM departments inner join companies on departments.company_id=companies.id where companies.identity=?",
        "Department");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Department model, final PreparedStatement ps) throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getCompanyId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus());

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
    final String sql = "INSERT INTO departments (identity, company_id, title, version, status)" + "VALUES (?, ?, ?, ?, ?)";

    return this.getById(this.createModel(model, "Department", sql, true));
  }

  @Override
  public Department update(final Department model) throws IFlowStorageException {
    final String sql = "UPDATE departments SET company_id = ?, title = ?, version = ?, status =  WHERE id = ?";

    this.updateModel(model, "Department", sql, true);

    return this.getById(model.getId());
  }

  @Override
  public Set<String> getAllUserIdentityListByDepartmentId(final Long id) throws IFlowStorageException {
    final Set<String> idList = this.getModelIdentityListById(id,
        "SELECT email FROM user_departments inner join users on users.id=user_departments.user_id where department_id=?", "User",
        "email");

    return idList;
  }

  @Override
  protected String generateIdentity(final Department model) {

    final Random rand = new Random();
    return String.format("c%sd%s-%s", identityLongToHex(model.getCompanyId()), identityLongToHex(System.currentTimeMillis()),
        identityIntToHex(rand.nextInt(1000000), 6));
  }

}
