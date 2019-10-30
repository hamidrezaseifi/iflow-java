package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class CompanyDao extends DaoBasicClass<Company> implements ICompanyDao {

  public CompanyDao() {

  }

  @Override
  public Company getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM companies where id=?", "Company");
  }

  @Override
  public Company getByIdentity(final String identity) {
    return getModelByStringId(identity, "SELECT * FROM companies where identity=?", "Company");
  }

  @Override
  protected Company modelFromResultSet(final ResultSet rs) throws SQLException {
    final Company company = new Company();
    company.setId(rs.getLong("id"));
    company.setCompanyName(rs.getString("company_name"));
    company.setStatus(rs.getInt("status"));
    company.setIdentity(rs.getString("identity"));
    company.setVersion(rs.getInt("version"));
    company.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    company.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));

    return company;
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Company model, final PreparedStatement ps) throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setString(2, model.getCompanyName());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Company model, final PreparedStatement ps) throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setString(2, model.getCompanyName());
    ps.setInt(3, model.getVersion());
    ps.setInt(4, model.getStatus());
    ps.setLong(5, model.getId());

    return ps;
  }

  @Override
  public Company create(final Company model) throws IFlowStorageException {
    final String sql = "INSERT INTO companies (identifyid, company_name, version, status)" + "VALUES (?, ?, ?, ?)";

    return getById(createModel(model, "Company", sql, true));
  }

  @Override
  public Company update(final Company model) throws IFlowStorageException {
    final String sql = "UPDATE companies SET identifyid = ?, company_name = ?, version = ?, status =  WHERE id = ?";

    updateModel(model, "Company", sql, true);

    return getById(model.getId());
  }

  @Override
  protected String generateIdentity(final Company model) {

    final Random rand = new Random();
    return String.format("c%d-%06d", System.currentTimeMillis(), rand.nextInt(1000000));
  }

}
