package com.pth.iflow.core.storage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowFileVersion;
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

    startTransaction(true);
    try {

      final Long workflowId = createModel(workflow, "Workflow", sql, false);

      createWorkflowActions(workflow, workflowId);

      createWorkflowFiles(workflow, workflowId);

      commitTransaction(true);

      return getById(workflowId);

    } catch (final Exception e) {
      rollbackTransaction();
      logger.error("Unable to create Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void createWorkflowActions(final Workflow workflow, final Long workflowId) {

    deleteWorkflowActions(workflowId, false, false);

    final String sql = "INSERT INTO workflow_actions (workflow_id, action, old_step, new_step, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    for (final WorkflowAction model : workflow.getActions()) {

      final PreparedStatementCreator psc = new PreparedStatementCreator() {

        @Override
        public PreparedStatement createPreparedStatement(final Connection con) throws SQLException {
          final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

          ps.setLong(1, workflowId);
          ps.setString(2, model.getAction());
          ps.setLong(3, model.getOldStep());
          ps.setLong(4, model.getNewStep());
          ps.setString(5, model.getComments());
          ps.setLong(6, model.getCreatedBy());
          ps.setInt(7, model.getVersion());
          ps.setInt(8, model.getStatus());

          return ps;
        }
      };

      createModelWithStatementNoTransaction("WorkflowAction", psc);
    }
  }

  private void deleteWorkflowActions(final Long workflowId, final boolean withTransaction, final boolean checkDeleted) {
    deleteModel(workflowId, "WorkflowAction", "Delete from workflow_actions where workflow_id=?", withTransaction, checkDeleted);
  }

  private void createWorkflowFiles(final Workflow workflow, final Long workflowId) {

    deleteWorkflowFiles(workflowId, false, false);

    final String sql = "INSERT INTO workflow_files (workflow_id, title, active_filepath, active_version, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    for (final WorkflowFile model : workflow.getFiles()) {

      final PreparedStatementCreator psc = new PreparedStatementCreator() {

        @Override
        public PreparedStatement createPreparedStatement(final Connection con) throws SQLException {
          final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

          ps.setLong(1, workflowId);
          ps.setString(2, model.getTitle());
          ps.setString(3, model.getActiveFilePath());
          ps.setInt(4, model.getActiveFileVersion());
          ps.setString(5, model.getComments());
          ps.setLong(6, model.getCreatedBy());
          ps.setInt(7, model.getVersion());
          ps.setInt(8, model.getStatus());

          return ps;
        }
      };

      final Long fileId = createModelWithStatementNoTransaction("WorkflowFile", psc);

      createWorkflowFileVersion(model, fileId);
    }
  }

  private void deleteWorkflowFiles(final Long workflowId, final boolean withTransaction, final boolean checkDeleted) {

    final delete all file final version before delete file
    deleteWorkflowFileVersions(workflowId, withTransaction, checkDeleted);
  }

  private void createWorkflowFileVersion(final WorkflowFile workflowFile, final Long workflowFileId) {

    deleteModel(workflowFileId, "WorkflowFileVersion", "Delete from workflow_files_versions where workflow_file_id=?", false, false);

    final String verionSql = "INSERT INTO workflow_files_versions (workflow_file_id, filepath, file_version, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    for (final WorkflowFileVersion model : workflowFile.getFileVersions()) {
      final PreparedStatementCreator vpsc = new PreparedStatementCreator() {

        @Override
        public PreparedStatement createPreparedStatement(final Connection con) throws SQLException {
          final PreparedStatement ps = con.prepareStatement(verionSql, Statement.RETURN_GENERATED_KEYS);

          ps.setLong(1, workflowFileId);
          ps.setString(2, model.getFilePath());
          ps.setInt(3, model.getFileVersion());
          ps.setString(4, model.getComments());
          ps.setLong(5, model.getCreatedBy());
          ps.setInt(6, model.getVersion());
          ps.setInt(7, model.getStatus());

          return ps;
        }
      };

      createModelWithStatementNoTransaction("WorkflowFileVersion", vpsc);
    }
  }

  private void deleteWorkflowFileVersions(final Long workflowFileId, final boolean withTransaction, final boolean checkDeleted) {
    deleteModel(workflowFileId, "WorkflowFileVersion", "Delete from workflow_files_versions where workflow_file_id=?", withTransaction,
        checkDeleted);
  }

  @Override
  public Workflow update(final Workflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, title = ?, current_step = ?, comments = ?,"
        + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    startTransaction(true);
    try {

      updateModel(workflow, "Workflow", sql, false);

      createWorkflowActions(workflow, workflow.getId());

      createWorkflowFiles(workflow, workflow.getId());

      return getById(workflow.getId());
    } catch (final Exception e) {
      rollbackTransaction();
      logger.error("Unable to update Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    startTransaction(true);
    try {
      deleteWorkflowActions(workflowId, false, false);
      deleteWorkflowFiles(workflowId, false, false);
      deleteModel(workflowId, "Workflow", "Delete from workflow where id=?", false, true);
    } catch (final Exception e) {
      rollbackTransaction();
      logger.error("Unable to update Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
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
