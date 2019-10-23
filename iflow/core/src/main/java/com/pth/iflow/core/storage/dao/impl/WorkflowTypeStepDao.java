package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowTypeStepDao extends DaoBasicClass<WorkflowTypeStep> implements IWorkflowTypeStepDao {

  public WorkflowTypeStepDao() {

  }

  @Override
  public WorkflowTypeStep getById(final Long id) throws IFlowStorageException {
    return this.getModelById(id, "SELECT * FROM workflow_type_step where id=?", "WorkflowTypeStep");
  }

  @Override
  public WorkflowTypeStep getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM workflow_type_step where identity=?", "WorkflowTypeStep");
  }

  @Override
  public List<WorkflowTypeStep> getListByIdList(final Set<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type_step where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdList(idList, sqlSelect, "WorkflowTypeStep");
  }

  @Override
  public List<WorkflowTypeStep> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type_step where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "WorkflowTypeStep");
  }

  @Override
  protected WorkflowTypeStep modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setId(rs.getLong("id"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));
    model.setTitle(rs.getString("title"));
    model.setIdentity(rs.getString("identity"));
    model.setViewName(rs.getString("view_name"));
    model.setStatus(rs.getInt("status"));
    model.setExpireDays(rs.getInt("expire_days"));
    model.setStepIndex(rs.getInt("step_index"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));

    return model;
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId) throws IFlowStorageException {
    return this.getModelListById(workflowId, "SELECT * FROM workflow_type_step where workflow_type_id=?", "WorkflowTypeStep");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowTypeStep model, final PreparedStatement ps)
      throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getWorkflowTypeId());
    ps.setString(3, model.getTitle());
    ps.setString(4, model.getViewName());
    ps.setInt(5, model.getExpireDays());
    ps.setInt(6, model.getStepIndex());
    ps.setString(7, model.getComments());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowTypeStep model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getViewName());
    ps.setInt(4, model.getExpireDays());
    ps.setInt(5, model.getStepIndex());
    ps.setString(6, model.getComments());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

  @Override
  public WorkflowTypeStep create(final WorkflowTypeStep model, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_type_step (identity, workflow_type_id, title, view_name, expire_days, step_index, comments, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    return this.getById(this.createModel(model, "WorkflowTypeStep", sql, withTransaction));
  }

  @Override
  public CoreModelHelper update(final WorkflowTypeStep model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_type_step SET workflow_type_id = ?, title = ?, view_name=?, expire_days=?, step_index = ?, comments = ?,"
        + " version = ?, status = ? WHERE id = ?";

    this.updateModel(model, "WorkflowTypeStep", sql, true);

    return this.getById(model.getId());
  }

  @Override
  public void deleteByWorkflowTypeId(final Long id, final boolean withTransaction) throws IFlowStorageException {
    this.deleteModel(id, "WorkflowAction", "Delete from workflow_type_step where workflow_type_id=?", withTransaction, false);
  }

  @Override
  public void deleteById(final Long id, final boolean withTransaction) throws IFlowStorageException {
    this.deleteModel(id, "WorkflowTypeStep", "Delete from workflow_type_step where id=?", withTransaction, true);
  }

  @Override
  protected String generateIdentity(final WorkflowTypeStep model) {

    final Random rand = new Random();
    return String.format("t%ss%s-%s", identityLongToHex(model.getWorkflowTypeId()), identityLongToHex(System.currentTimeMillis()),
        identityIntToHex(rand.nextInt(1000000), 6));
  }
}
