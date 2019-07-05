package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowTypeStepDao extends DaoBasicClass<WorkflowTypeStep> implements IWorkflowTypeStepDao {

  public WorkflowTypeStepDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public WorkflowTypeStep getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_type_step where id=?", "WorkflowStep");
  }

  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type_step where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "WorkflowStep");
  }

  @Override
  protected WorkflowTypeStep modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setId(rs.getLong("id"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));

    return model;
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId) throws IFlowStorageException {
    return getModelListById(workflowId, "SELECT * FROM workflow_type_step where workflow_type_id=?", "WorkflowStep");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowTypeStep model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getComments());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowTypeStep model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getComments());
    ps.setInt(4, model.getVersion());
    ps.setInt(5, model.getStatus());
    ps.setLong(6, model.getId());

    return ps;
  }

  @Override
  public WorkflowTypeStep create(final WorkflowTypeStep model) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_type_step (workflow_type_id, title, comments, version, status)"
        + "VALUES (?, ?, ?, ?, ?)";

    return getById(createModel(model, "WorkflowTypeStep", sql, true));
  }

  @Override
  public WorkflowTypeStep update(final WorkflowTypeStep model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_type_step SET workflow_type_id = ?, title = ?, comments = ?,"
        + " version = ?, status = ? WHERE id = ?";

    updateModel(model, "WorkflowTypeStep", sql, true);

    return getById(model.getId());
  }
}
