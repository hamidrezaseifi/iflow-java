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

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class CompanyDao implements ICompanyDao {

  private static final Logger logger = LoggerFactory.getLogger(CompanyDao.class);
  private final JdbcTemplate jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  public CompanyDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public Company getById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read Company by id: " + id);
    final String sqlSelect = "SELECT * FROM companies where id=?";

    Company company;

    try {

      company = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return companyFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve Company data: " + e.toString());
    }

    return company;
  }

  @Override
  public Company getByIdentifyId(final String identifyId) {
    // TODO Auto-generated method stub
    return null;
  }

  private Company companyFromResultSet(final ResultSet rs) throws SQLException {
    final Company company = new Company();
    company.setId(rs.getLong("id"));
    company.setCompanyName(rs.getString("company_name"));
    company.setStatus(rs.getInt("status"));
    company.setIdentifyid(rs.getString("identifyid"));
    company.setVersion(rs.getInt("version"));
    company.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    company.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));

    return company;
  }

}
