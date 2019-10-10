package com.pth.iflow.core.storage.dao.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public abstract class DaoBasicClass<M> {

  protected static final Logger        logger = LoggerFactory.getLogger(DaoBasicClass.class);

  @Autowired
  protected JdbcTemplate               jdbcTemplate;

  @Autowired
  protected PlatformTransactionManager platformTransactionManager;

  public DaoBasicClass() {

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

  protected M getModelByIdentity(final String identity, final String sqlSelect, final String modelName) throws IFlowStorageException {
    logger.info("Dao Read {} by identity: {}", modelName, identity);

    M model;

    try {

      model = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, identity);
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

  protected List<M> getModelListByIdentity(final String id, final String sqlSelect, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} by id: {}", modelName, id);

    List<M> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return list;
  }

  protected Set<Long> getModelIdListById(final Long id, final String sqlSelect, final String modelName, final String idFieldName)
      throws IFlowStorageException {
    logger.info("Dao read {} id list by id: {}", modelName, id);

    List<Long> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong(idFieldName);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return new HashSet<>(list.stream().collect(Collectors.toSet()));
  }

  protected Set<String> getModelIdentityListById(final Long id, final String sqlSelect, final String modelName,
      final String idFieldName) throws IFlowStorageException {
    logger.info("Dao read {} id list by id: {}", modelName, id);

    List<String> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getString(idFieldName);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return new HashSet<>(list.stream().collect(Collectors.toSet()));
  }

  protected Set<Long> getIdListById(final Long id, final String sqlSelect, final String columnName, final String modelName)
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

    return new HashSet<>(list.stream().collect(Collectors.toSet()));
  }

  protected Set<String> getIdentityListById(final Long id, final String sqlSelect, final String columnName, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} by id: {}", modelName, id);

    List<String> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);

        return ps;

      }, (rs, rowNum) -> {

        return rs.getString(columnName);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to Read " + modelName + " : " + e.toString());
    }

    return new HashSet<>(list.stream().collect(Collectors.toSet()));
  }

  protected List<M> getModelListByIdList(final Set<Long> idList, final String sqlSelect, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} list: {}", modelName, idList);

    List<M> list = new ArrayList<>();

    if (idList.isEmpty() == false) {

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
    }
    return list;
  }

  protected List<M> getModelListByIdentityList(final Set<String> idList, final String sqlSelect, final String modelName)
      throws IFlowStorageException {
    logger.info("Dao read {} list: {}", modelName, idList);

    List<M> list = new ArrayList<>();

    if (idList.isEmpty() == false) {

      try {
        list = jdbcTemplate.query(con -> {
          final PreparedStatement ps = con.prepareStatement(sqlSelect);
          int index = 1;
          for (final String id : idList) {
            ps.setString(index++, id);
          }

          return ps;

        }, (rs, rowNum) -> {

          return modelFromResultSet(rs);

        });

      } catch (final Exception e) {
        throw new IFlowStorageException("Unable to Read " + modelName + " list from list: " + e.toString());
      }
    }
    return list;
  }

  protected Long createModel(final M model, final String modelName, final String insertSql, final boolean withTransaction)
      throws IFlowStorageException {
    logger.debug("insert " + modelName + " ...");

    validateIdentity(model, modelName);

    final TransactionStatus transactionStatus = startTransaction(withTransaction);
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      this.jdbcTemplate.update(con -> {
        PreparedStatement ps = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        ps = prepareInsertPreparedStatement(model, ps);
        return ps;
      }, keyHolder);

      commitTransaction(withTransaction, transactionStatus);
    } catch (final Exception e) {
      rollbackTransaction(withTransaction, transactionStatus);
      logger.error("Unable to insert \" + modelName + \": {}", modelName, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
    return keyHolder.getKey().longValue();

  }

  private void validateIdentity(final M model, final String modelName) {
    if (model instanceof ICoreIdentityModel) {

      final ICoreIdentityModel identityMode = (ICoreIdentityModel) model;
      if (EWorkflowIdentity.isNotSet(identityMode.getIdentity())) {
        final String identity = modelName.toLowerCase() + System.currentTimeMillis();
        identityMode.setIdentity(identity);
      }

    }
  }

  protected Long createModelWithStatementNoTransaction(final String modelName, final PreparedStatementCreator statement)
      throws IFlowStorageException {
    logger.debug("insert " + modelName + " ...");
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    this.jdbcTemplate.update(statement, keyHolder);

    return keyHolder.getKey().longValue();

  }

  protected void updateModel(final M model, final String modelName, final String updateSql, final boolean withTransaction)
      throws IFlowStorageException {
    logger.debug("Updating {}...", modelName);
    final TransactionStatus transactionStatus = startTransaction(withTransaction);
    try {

      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(updateSql);
        return prepareUpdatePreparedStatement(model, ps);
      });

      if (changedRows != 1) {
        throw new IFlowStorageException(String.format("Unable to update {}", modelName));
      }

      commitTransaction(withTransaction, transactionStatus);

    } catch (final Exception e) {
      rollbackTransaction(withTransaction, transactionStatus);
      logger.error("Unable to update {}: {}", modelName, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  protected void updateModelWithStatementNoTransaction(final String modelName, final PreparedStatementCreator statement)
      throws IFlowStorageException {
    logger.debug("Updating {}...", modelName);

    final int changedRows = jdbcTemplate.update(statement);

    if (changedRows != 1) {
      throw new IFlowStorageException(String.format("Unable to update {}", modelName));
    }

  }

  protected void deleteModel(final Long id, final String modelName, final String deleteSql, final boolean withTransaction,
      final boolean checkDeleted) throws IFlowStorageException {
    logger.debug("Deleting {} by id:{} ...", modelName, id);

    final TransactionStatus transactionStatus = startTransaction(withTransaction);

    try {

      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setLong(1, id);
        return ps;
      });

      if (checkDeleted && deletedRows != 1) {
        throw new IFlowStorageException(String.format("Unable to delete {}  [{}]", modelName, id));
      }

      commitTransaction(withTransaction, transactionStatus);

    } catch (final Exception e) {
      rollbackTransaction(withTransaction, transactionStatus);
      logger.error("Error by deleting {} by id:{}: {}", modelName, id, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  protected TransactionStatus startTransaction(final boolean withTransaction) {
    if (withTransaction) {
      return DaoControlHelper.createNewTransaction(platformTransactionManager);

    }
    return null;
  }

  protected void rollbackTransaction(final boolean withTransaction, final TransactionStatus transactionStatus) {
    if (withTransaction && transactionStatus != null) {
      DaoControlHelper.rollbackCurrentTransaction(platformTransactionManager, transactionStatus);
    }
  }

  protected void commitTransaction(final boolean withTransaction, final TransactionStatus transactionStatus) {
    if (withTransaction && transactionStatus != null) {
      DaoControlHelper.commitCurrentTransaction(platformTransactionManager, transactionStatus);
    }
  }

  protected abstract M modelFromResultSet(final ResultSet rs) throws SQLException;

  protected abstract PreparedStatement prepareInsertPreparedStatement(M model, final PreparedStatement ps) throws SQLException;

  protected abstract PreparedStatement prepareUpdatePreparedStatement(M model, final PreparedStatement ps) throws SQLException;

}
