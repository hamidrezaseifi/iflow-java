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
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class DepartmentDao extends DaoBasicClass<Department> implements IDepartmentDao {
  
  public DepartmentDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
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
    model.setGroups(getGroupIdListById(model.getId()));
    
    return model;
  }
  
  @Override
  public Department getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM departments where id=?", "Department");
  }
  
  @Override
  public List<Department> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM departments where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }
    
    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";
    
    return getModelListByIdList(idList, sqlSelect, "User");
  }
  
  private List<Long> getGroupIdListById(final Long id) throws IFlowStorageException {
    return getIdListById(id, "SELECT * FROM departments_group where department_id=?", "id", "Department Groups");
  }
  
  @Override
  public List<Department> getListByCompanyId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM departments where company_id=?", "Department");
  }
  
}
