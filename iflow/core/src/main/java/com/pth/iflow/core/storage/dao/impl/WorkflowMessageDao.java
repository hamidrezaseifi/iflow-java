package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.IWorkflowMessageDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowMessageDao extends DaoBasicClass<WorkflowMessage> implements IWorkflowMessageDao {

  public WorkflowMessageDao() {

  }

  @Override
  public WorkflowMessage create(final WorkflowMessage model) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_message (workflow_id, user_id, message, created_by, message_type, version, status, expire_days)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      final Long workflowId = this.createModel(model, "WorkflowMessage", sql, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowId);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowMessage: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  @Override
  public WorkflowMessage update(final WorkflowMessage model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_message SET workflow_id = ?, user_id = ?, message=?, created_by = ?, message_type = ?, version = ?, status = ?, expire_days = ? WHERE id = ?";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.updateModel(model, "Workflow", sql, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(model.getId());
    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update WorkflowMessage: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void updateStatusByWorkflow(final Long workflowId, final Integer status) throws IFlowStorageException {
    final String sql = "UPDATE workflow_message SET status = ? WHERE workflow_id = ?";

    logger.debug("Updating WorkflowMessage ...");
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
      logger.error("Unable to update WorkflowMessage: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  @Override
  public WorkflowMessage getById(final Long id) throws IFlowStorageException {
    final WorkflowMessage model = this.getModelById(id, "SELECT * FROM workflow_message where id=?", "WorkflowMessage");

    return model;
  }

  @Override
  public List<WorkflowMessage> getNotExpiredListByUserId(final Long userId, final Integer status) throws IFlowStorageException {
    logger.info("Dao read WorkflowMessage for user id: {}", userId);

    List<WorkflowMessage> list = new ArrayList<>();
    final String sql = "SELECT * FROM workflow_message where user_id=? and TIMESTAMPDIFF(DAY, created_at, now()) < expire_days "
        + (status > 0 ? " and status=?" : "");

    try {
      list = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, userId);
        if (status > 0) {
          ps.setInt(2, status);
        }

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read WorkflowMessage for user id: " + userId + " : " + e.toString());
    }

    return list;
  }

  @Override
  public List<WorkflowMessage> getListByWorkflowId(final Long workflowId, final Long lastid, final Integer status)
      throws IFlowStorageException {
    logger.info("Dao read WorkflowMessage for workflow id: {}", workflowId);

    List<WorkflowMessage> list = new ArrayList<>();
    final String sql = "SELECT * FROM workflow_message where workflow_id=? and id>?" + (status > 0 ? " and status=?" : "");

    try {
      list = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflowId);
        ps.setLong(2, lastid);
        if (status > 0) {
          ps.setInt(3, status);
        }

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read WorkflowMessage for workflow id: " + workflowId + " : " + e.toString());
    }

    return list;
  }

  @Override
  protected WorkflowMessage modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowMessage model = new WorkflowMessage();
    model.setId(rs.getLong("id"));
    model.setWorkflowId(rs.getLong("workflow_id"));
    model.setUserId(rs.getLong("user_id"));
    model.setMessage(rs.getString("message"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setVersion(rs.getInt("version"));
    model.setMessageType(EWorkflowMessageType.ofValue(rs.getInt("message_type")));
    model.setStatus(EWorkflowMessageStatus.ofValue(rs.getInt("status")));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setExpireDays(rs.getInt("expire_days"));

    return model;
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowMessage model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setLong(2, model.getUserId());
    ps.setString(3, model.getMessage());
    ps.setLong(4, model.getCreatedBy());
    ps.setInt(5, model.getMessageType().getValue());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus().getValue());
    ps.setInt(8, model.getExpireDays());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowMessage model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setLong(2, model.getUserId());
    ps.setString(3, model.getMessage());
    ps.setLong(4, model.getCreatedBy());
    ps.setInt(5, model.getMessageType().getValue());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus().getValue());
    ps.setInt(8, model.getExpireDays());
    ps.setLong(9, model.getId());

    return ps;
  }

  @Override
  public void deleteWorkflowMessage(final Long messageId) throws IFlowStorageException {
    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.deleteModel(messageId, "Workflow", "Delete from workflow_message where id=?", false, true);

      this.commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete WorkflowMessage:{} {}", messageId, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

}