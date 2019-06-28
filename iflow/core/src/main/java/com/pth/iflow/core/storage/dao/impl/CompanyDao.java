package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class CompanyDao extends DaoBasicClass<Company> implements ICompanyDao {

  public CompanyDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public Company getById(final Long id) throws IFlowStorageException {

    return getModelById(id, "SELECT * FROM companies where id=?", "Company");

  }

  @Override
  public Company getByIdentifyId(final String identifyId) {
    // TODO Auto-generated method stub
    return null;
  }

  private List<Long> getDepartmentIdList(final Long id) {
    return getIdListById(id, "SELECT * FROM departments where company_id=?", "id", "Company Departments");
  }

  private List<Long> getGroupIdList(final Long id) {
    return getIdListById(id, "SELECT * FROM user_group where company_id=?", "id", "Company Groups");
  }

  private List<Long> getWorkflowTypeIdList(final Long id) {
    return getIdListById(id, "SELECT * FROM workflow_type where company_id=?", "id", "Company WorkflowTypes");
  }

  private List<Long> getUserIdList(final Long id) {
    return getIdListById(id, "SELECT * FROM users where company_id=?", "id", "Company Users");
  }

  @Override
  protected Company modelFromResultSet(final ResultSet rs) throws SQLException {
    final Company company = new Company();
    company.setId(rs.getLong("id"));
    company.setCompanyName(rs.getString("company_name"));
    company.setStatus(rs.getInt("status"));
    company.setIdentifyid(rs.getString("identifyid"));
    company.setVersion(rs.getInt("version"));
    company.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    company.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));

    company.setDepartmentIds(getDepartmentIdList(company.getId()));
    company.setGroupIds(getGroupIdList(company.getId()));
    company.setWorkflowTypeIds(getWorkflowTypeIdList(company.getId()));
    company.setUserIds(getUserIdList(company.getId()));

    return company;
  }

  @Override
  public List<Long> getAllCompanyIdList() {
    logger.info("Dao read all companies");

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement("SELECT * FROM companies");

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("id");

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read companies : " + e.toString());
    }

    return list;
  }

}
