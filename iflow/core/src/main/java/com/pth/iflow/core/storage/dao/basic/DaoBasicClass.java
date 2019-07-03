package com.pth.iflow.core.storage.dao.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

  protected M getModelByStringId(final String id, final String sqlSelect, final String modelName) throws IFlowStorageException {
    logger.info("Dao Read {} by id: {}", modelName, id);

    M model;

    try {

      model = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, id);
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

  protected List<M> getModelListById(final Long id, final String sqlSelect, final String modelName) throws IFlowStorageException {
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

  protected List<Long> getIdListById(final Long id, final String sqlSelect, final String columnName, final String modelName)
      throws IFlowStorageException {
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

  public Long createModel(final M model, final String modelName, final String insertSql) throws IFlowStorageException {
    logger.debug("insert " + modelName + " ...");
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        return prepareInsertPreparedStatement(model, ps);
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    } catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert \" + modelName + \": {}", modelName, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
    return keyHolder.getKey().longValue();

  }

  public void updateModel(final M model, final String modelName, final String updateSql) throws IFlowStorageException {
    logger.debug("Updating {}...", modelName);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(updateSql);
        return prepareUpdatePreparedStatement(model, ps);
      });

      if (changedRows != 1) {
        throw new IFlowStorageException(String.format("Unable to update {}", modelName));
      }

      this.platformTransactionManager.commit(transactionStatus);
    } catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update {}: {}", modelName, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  protected abstract PreparedStatement prepareInsertPreparedStatement(M model, final PreparedStatement ps) throws SQLException;

  protected abstract PreparedStatement prepareUpdatePreparedStatement(M model, final PreparedStatement ps) throws SQLException;

}
