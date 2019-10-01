package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowActionDao extends DaoBasicClass<WorkflowAction> implements IWorkflowActionDao {

  public WorkflowActionDao() {

  }

  @Override
  public WorkflowAction getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_actions where id=?", "WorkflowAction");
  }

  @Override
  public List<WorkflowAction> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_actions where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "WorkflowAction");
  }

  @Override
  protected WorkflowAction modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowAction model = new WorkflowAction();

    model.setId(rs.getLong("id"));
    model.setAction(rs.getString("action"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setOldStep(rs.getLong("old_step"));
    model.setNewStep(rs.getLong("new_step"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setWorkflowId(rs.getLong("workflow_id"));
    model.setAssignTo(rs.getLong("assign_to"));

    return model;
  }

  @Override
  public List<WorkflowAction> getListByWorkflowId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_actions where workflow_id=?", "WorkflowAction");
  }

  @Override
  public WorkflowAction create(final WorkflowAction workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_actions (workflow_id, action, old_step, new_step, comments, created_by, assign_to, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(workflow, "WorkflowAction", sql, withTransaction));
  }

  @Override
  public WorkflowAction update(final WorkflowAction workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "UPDATE workflow_actions SET workflow_id = ?, action = ?, old_step = ?, new_step = ?, comments = ?,"
        + " created_by = ?, assign_to=?, version = ?, status = ? WHERE id = ?";

    updateModel(workflow, "WorkflowAction", sql, withTransaction);

    return getById(workflow.getId());
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowAction model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setString(2, model.getAction());
    ps.setLong(3, model.getOldStep());
    ps.setLong(4, model.getNewStep());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getCreatedBy());
    ps.setLong(7, model.getAssignTo());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowAction model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setString(2, model.getAction());
    ps.setLong(3, model.getOldStep());
    ps.setLong(4, model.getNewStep());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getCreatedBy());
    ps.setLong(7, model.getAssignTo());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatus());
    ps.setLong(10, model.getId());

    return ps;
  }

  @Override
  public void deleteById(final Long id, final boolean withTransaction) throws IFlowStorageException {
    deleteModel(id, "WorkflowAction", "Delete from workflow_actions where id=?", withTransaction, true);
  }

  @Override
  public void deleteByWorkflowId(final Long id, final boolean withTransaction) throws IFlowStorageException {
    deleteModel(id, "WorkflowAction", "Delete from workflow_actions where workflow_id=?", withTransaction, false);
  }

}
