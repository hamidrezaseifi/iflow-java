package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowFileVersion;
import com.pth.iflow.core.storage.dao.IWorkflowFileVersionDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowFileVersionDao extends DaoBasicClass<WorkflowFileVersion> implements IWorkflowFileVersionDao {

  public WorkflowFileVersionDao() {

  }

  @Override
  public WorkflowFileVersion create(final WorkflowFileVersion model, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_files_versions (workflow_file_id, filepath, file_version, comments, created_by, version, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

    return getById(createModel(model, "WorkflowFileVersion", sql, withTransaction));
  }

  @Override
  public WorkflowFileVersion update(final WorkflowFileVersion model, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "UPDATE workflow_files_versions SET workflow_file_id = ?, filepath = ?, file_version = ?, comments = ?,"
        + " created_by = ?, version = ?, status = ? WHERE id = ?";

    updateModel(model, "WorkflowFile", sql, withTransaction);

    return getById(model.getId());
  }

  @Override
  public WorkflowFileVersion getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_files_versions where id=?", "WorkflowFileVersion");
  }

  @Override
  public void deleteById(final Long id) throws IFlowStorageException {
    deleteModel(id, "WorkflowFileVersion", "Delete from workflow_files_versions where id=?", true, true);
  }

  @Override
  public void deleteByWorkflowFileId(final Long id, final boolean withTransaction, final boolean checkDeleted)
      throws IFlowStorageException {
    deleteModel(id, "WorkflowFileVersion", "Delete from workflow_files_versions where workflow_file_id=?", withTransaction,
        checkDeleted);
  }

  @Override
  public List<WorkflowFileVersion> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_files_versions where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "WorkflowFileVersion");
  }

  @Override
  public List<WorkflowFileVersion> getListByWorkflowFileId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_files_versions where workflow_file_id=?", "WorkflowFileVersion");
  }

  @Override
  protected WorkflowFileVersion modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowFileVersion model = new WorkflowFileVersion();

    model.setId(rs.getLong("id"));
    model.setFilePath(rs.getString("filepath"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setFileVersion(rs.getInt("file_version"));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setWorkflowFileId(rs.getLong("workflow_file_id"));

    return model;
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowFileVersion model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowFileId());
    ps.setString(2, model.getFilePath());
    ps.setInt(3, model.getFileVersion());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getCreatedBy());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus());
    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowFileVersion model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowFileId());
    ps.setString(2, model.getFilePath());
    ps.setInt(3, model.getFileVersion());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getCreatedBy());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatus());
    ps.setLong(8, model.getId());
    return ps;
  }

}
