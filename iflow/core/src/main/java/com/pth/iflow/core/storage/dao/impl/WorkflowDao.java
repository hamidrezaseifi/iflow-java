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

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowDao extends DaoBasicClass<Workflow> implements IWorkflowDao {

  public WorkflowDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow where id=?", "Workflow");
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "Workflow");
  }

  @Override
  protected Workflow modelFromResultSet(final ResultSet rs) throws SQLException {
    final Workflow model = new Workflow();
    model.setId(rs.getLong("id"));

    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setController(rs.getLong("controller"));
    model.setCurrentStep(rs.getLong("current_step"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));

    return model;
  }

  @Override
  public List<Workflow> getListByWorkflowTypeId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow where workflow_type_id=?", "Workflow");
  }

  @Override
  public Workflow create(final Workflow workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow (workflow_type_id, title, current_step, comments, controller, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(workflow, "Workflow", sql));
  }

  @Override
  public Workflow update(final Workflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, title = ?, current_step = ?, comments = ?,"
        + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    updateModel(workflow, "Workflow", sql);

    return getById(workflow.getId());
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getController());
    ps.setLong(6, model.getCreatedBy());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getController());
    ps.setLong(6, model.getCreatedBy());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

}
