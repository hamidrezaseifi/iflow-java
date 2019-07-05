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

import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowFileDao extends DaoBasicClass<WorkflowFile> implements IWorkflowFileDao {

  public WorkflowFileDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public WorkflowFile getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_files where id=?", "WorkflowFile");
  }

  @Override
  public List<WorkflowFile> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_files where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "WorkflowFile");
  }

  @Override
  protected WorkflowFile modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowFile model = new WorkflowFile();

    model.setId(rs.getLong("id"));
    model.setTitle(rs.getString("title"));
    model.setActiveFilePath(rs.getString("active_filepath"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setActiveFileVersion(rs.getInt("active_version"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setWorkflowId(rs.getLong("workflow_id"));

    return model;
  }

  @Override
  public List<WorkflowFile> getListByWorkflowId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_files where workflow_id=?", "WorkflowFile");
  }

  @Override
  public WorkflowFile create(final WorkflowFile workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_files (workflow_id, title, active_filepath, active_version, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(workflow, "WorkflowFile", sql, true));
  }

  @Override
  public WorkflowFile update(final WorkflowFile workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow_files SET workflow_id = ?, title = ?, active_filepath = ?, active_version = ?, comments = ?,"
        + " created_by = ?, version = ?, status = ? WHERE id = ?";

    updateModel(workflow, "WorkflowFile", sql, true);

    return getById(workflow.getId());
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowFile model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getActiveFilePath());
    ps.setInt(4, model.getActiveFileVersion());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getCreatedBy());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowFile model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getActiveFilePath());
    ps.setInt(4, model.getActiveFileVersion());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getCreatedBy());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

}
