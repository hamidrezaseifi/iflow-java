package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.utils.SqlUtils;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class DepartmentGroupDao implements IDepartmentGroupDao {
  private static final Logger logger = LoggerFactory.getLogger(DepartmentGroupDao.class);
  private final JdbcTemplate jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  public DepartmentGroupDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public DepartmentGroup getById(final Long id) throws IFlowStorageException {
    logger.info("Dao Read department group by id: " + id);
    final String sqlSelect = "SELECT * FROM departments_group where id=?";

    DepartmentGroup department;

    try {

      department = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return departmentFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve department group data: " + e.toString());
    }

    return department;
  }

  @Override
  public List<DepartmentGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    logger.info("Dao read department group list: ");

    List<DepartmentGroup> list = new ArrayList<>();

    if (idList.isEmpty()) {
      return list;
    }

    String sqlSelect = "SELECT * FROM departments_group where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    final String sqlSelectFinal = sqlSelect;

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelectFinal);
        int index = 1;
        for (final Long id : idList) {
          ps.setLong(index++, id);
        }

        return ps;

      }, (rs, rowNum) -> {

        return departmentFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read department group list from list: " + e.toString());
    }

    return list;
  }

  private DepartmentGroup departmentFromResultSet(final ResultSet rs) throws SQLException {
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

}
