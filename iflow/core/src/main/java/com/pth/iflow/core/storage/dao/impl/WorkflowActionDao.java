package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowActionDao extends DaoBasicClass<WorkflowAction> implements IWorkflowActionDao {

  @Autowired
  private IUserDao userDao;

  @Autowired
  private IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowActionDao() {

  }

  @Override
  public WorkflowAction getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_actions where id=?", "WorkflowAction");
  }

  @Override
  public WorkflowAction getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM workflow_actions where identity=?", "WorkflowAction");
  }

  @Override
  public List<WorkflowAction> getListByIdList(final Set<Long> idList) throws IFlowStorageException {
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
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setCurrentStepId(rs.getLong("current_step_id"));
    model.setWorkflowId(rs.getLong("workflow_id"));
    model.setAssignTo(rs.getLong("assign_to"));
    model.setIdentity(rs.getString("identity"));

    setActionAssignToIdentity(model);

    setActionCurrentStepIdentity(model);

    return model;
  }

  private void setActionCurrentStepIdentity(final WorkflowAction model) {
    final WorkflowTypeStep step = workflowTypeStepDao.getById(model.getCurrentStepId());

    model.setCurrentStepIdentity(step.getIdentity());
  }

  private void setActionAssignToIdentity(final WorkflowAction model) {
    final User user = userDao.getById(model.getAssignTo());
    model.setAssignToIdentity(user.getEmail());
  }

  @Override
  public List<WorkflowAction> getListByWorkflowId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_actions where workflow_id=?", "WorkflowAction");
  }

  @Override
  public WorkflowAction create(final WorkflowAction workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_actions (identity, workflow_id, current_step_id, comments, assign_to, version, status)"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(workflow, "WorkflowAction", sql, withTransaction));
  }

  @Override
  public WorkflowAction update(final WorkflowAction workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "UPDATE workflow_actions SET workflow_id = ?, new_step = ?, comments = ?,"
                       + " assign_to=?, version = ?, status = ? WHERE id = ?";

    updateModel(workflow, "WorkflowAction", sql, withTransaction);

    return getById(workflow.getId());
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowAction model, final PreparedStatement ps) throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getWorkflowId());
    ps.setLong(3, model.getCurrentStepId());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getAssignTo());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowAction model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setLong(2, model.getCurrentStepId());
    ps.setString(3, model.getComments());
    ps.setLong(4, model.getAssignTo());
    ps.setInt(5, model.getVersion());
    ps.setInt(6, model.getStatus());
    ps.setLong(7, model.getId());

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
