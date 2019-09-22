package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowOfferStatus;
import com.pth.iflow.core.model.WorkflowOffer;
import com.pth.iflow.core.storage.dao.IWorkflowOfferDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowOfferDao extends DaoBasicClass<WorkflowOffer> implements IWorkflowOfferDao {

  public WorkflowOfferDao() {

  }

  @Override
  public WorkflowOffer create(final WorkflowOffer model) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_offer (workflow_id, user_id, created_by, version, status)" + "VALUES (?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      final Long workflowId = this.createModel(model, "WorkflowOffer", sql, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowId);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowOffer: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  @Override
  public WorkflowOffer update(final WorkflowOffer model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_offer SET workflow_id = ?, user_id = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.updateModel(model, "Workflow", sql, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(model.getId());
    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update WorkflowOffer: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void updateStatusByWorkflow(final Long workflowId, final Integer status) throws IFlowStorageException {
    final String sql = "UPDATE workflow_offer SET status = ? WHERE workflow_id = ?";

    logger.debug("Updating WorkflowOffer ...");
    final TransactionStatus transactionStatus = startTransaction(true);
    try {

      jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, status);
        ps.setLong(2, workflowId);

        return ps;
      });

      commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update WorkflowOffer: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  @Override
  public WorkflowOffer getById(final Long id) throws IFlowStorageException {
    final WorkflowOffer model = this.getModelById(id, "SELECT * FROM workflow_offer where id=?", "WorkflowOffer");

    return model;
  }

  @Override
  public List<WorkflowOffer> getListByUserId(final Long userId) throws IFlowStorageException {
    logger.info("Dao read WorkflowOffer for user id: {}", userId);

    List<WorkflowOffer> list = new ArrayList<>();
    final String sql = "SELECT * FROM workflow_offer where user_id=?";

    try {
      list = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, userId);

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read WorkflowOffer for user id: " + userId + " : " + e.toString());
    }

    return list;
  }

  @Override
  public List<WorkflowOffer> getListByWorkflowId(final Long workflowId) throws IFlowStorageException {
    logger.info("Dao read WorkflowOffer for workflow id: {}", workflowId);

    List<WorkflowOffer> list = new ArrayList<>();
    final String sql = "SELECT * FROM workflow_offer where workflow_id=?";

    try {
      list = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflowId);

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read WorkflowOffer for workflow id: " + workflowId + " : " + e.toString());
    }

    return list;
  }

  @Override
  protected WorkflowOffer modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowOffer model = new WorkflowOffer();
    model.setId(rs.getLong("id"));
    model.setWorkflowId(rs.getLong("workflow_id"));
    model.setUserId(rs.getLong("user_id"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(EWorkflowOfferStatus.ofValue(rs.getInt("status")));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));

    return model;
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowOffer model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setLong(2, model.getUserId());
    ps.setLong(3, model.getCreatedBy());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus().getValue());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowOffer model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setLong(2, model.getUserId());
    ps.setLong(3, model.getCreatedBy());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus().getValue());
    ps.setLong(6, model.getId());

    return ps;
  }

}
