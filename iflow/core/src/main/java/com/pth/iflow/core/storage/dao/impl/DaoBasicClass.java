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

import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public abstract class DaoBasicClass<M> {
  protected static final Logger logger = LoggerFactory.getLogger(DaoBasicClass.class);
  protected final JdbcTemplate jdbcTemplate;
  protected final PlatformTransactionManager platformTransactionManager;

  protected abstract M modelFromResultSet(final ResultSet rs) throws SQLException;

  public DaoBasicClass(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  protected M getModelById(final Long id, final String sqlSelect, final String modelName) throws IFlowStorageException {
    logger.info("Dao Read {} by id: {}", modelName, id);

    M model;

    try {

      model = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return modelFromResultSet(rs);
        } else {
          return null;
        }
      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to retrieve " + modelName + " data: " + e.toString());
    }

    return model;
  }

  protected List<M> getModelListById(final Long id, final String sqlSelect, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} by id: {}", modelName, id);

    List<M> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return list;
  }

  protected List<Long> getIdListById(final Long id, final String sqlSelect, final String columnName,
      final String modelName) throws IFlowStorageException {
    logger.info("Dao read {} by id: {}", modelName, id);

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong(columnName);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return list;
  }

  protected List<M> getModelListByIdList(final List<Long> idList, final String sqlSelect, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} list: {}", modelName, idList);

    List<M> list = new ArrayList<>();

    if (idList.isEmpty()) {
      return list;
    }

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        int index = 1;
        for (final Long id : idList) {
          ps.setLong(index++, id);
        }

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " list from list: " + e.toString());
    }

    return list;
  }

}
