package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowFileVersion;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileVersionDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowFileDao extends DaoBasicClass<WorkflowFile> implements IWorkflowFileDao {

  @Autowired
  private IWorkflowFileVersionDao workflowFileVersionDao;

  public WorkflowFileDao() {

  }

  @Override
  public WorkflowFile getById(final Long id) throws IFlowStorageException {

    final WorkflowFile workflowFile = getModelById(id, "SELECT * FROM workflow_files where id=?", "WorkflowFile");
    workflowFile.setFileVersions(workflowFileVersionDao.getListByWorkflowFileId(id));
    return workflowFile;
  }

  @Override
  public List<WorkflowFile> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    final List<WorkflowFile> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(getById(wId));
    }
    return list;
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

    final List<Long> idList = getModelIdListById(id, "SELECT * FROM workflow_files where workflow_id=?", "WorkflowFile", "id");
    final List<WorkflowFile> list = getListByIdList(idList);

    return list;

  }

  @Override
  public WorkflowFile create(final WorkflowFile workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_files (workflow_id, title, active_filepath, active_version, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = startTransaction(withTransaction);
    try {
      final Long workflowFileId = createModel(workflow, "WorkflowFile", sql, withTransaction);
      workflow.setId(workflowFileId);
      createWorkflowFileVersions(workflow, workflowFileId);

      commitTransaction(withTransaction, transactionStatus);
      return getById(workflowFileId);
    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowFile: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public WorkflowFile update(final WorkflowFile workflowFile, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "UPDATE workflow_files SET workflow_id = ?, title = ?, active_filepath = ?, active_version = ?, comments = ?,"
        + " created_by = ?, version = ?, status = ? WHERE id = ?";

    final TransactionStatus transactionStatus = startTransaction(withTransaction);
    try {

      updateModel(workflowFile, "WorkflowFile", sql, withTransaction);

      createWorkflowFileVersions(workflowFile, workflowFile.getId());

      commitTransaction(withTransaction, transactionStatus);
      return getById(workflowFile.getId());
    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update WorkflowFile: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createWorkflowFileVersions(final WorkflowFile workflowFile, final Long workflowFileId) {

    workflowFileVersionDao.deleteByWorkflowFileId(workflowFileId, false, false);

    final List<WorkflowFileVersion> resultList = new ArrayList<>();

    for (final WorkflowFileVersion model : workflowFile.getFileVersions()) {

      model.setWorkflowFileId(workflowFileId);
      resultList.add(workflowFileVersionDao.create(model, false));

    }

    workflowFile.setFileVersions(resultList);

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

  @Override
  public void deleteById(final Long id, final boolean withTransaction) throws IFlowStorageException {

    workflowFileVersionDao.deleteByWorkflowFileId(id, withTransaction, false);

    deleteModel(id, "WorkflowFile", "Delete from workflow_files where id=?", withTransaction, true);
  }

  @Override
  public void deleteByWorkflowId(final Long id, final boolean withTransaction) throws IFlowStorageException {

    final List<WorkflowFile> workflowFiles = getListByWorkflowId(id);

    for (final WorkflowFile workflowFile : workflowFiles) {
      workflowFileVersionDao.deleteByWorkflowFileId(workflowFile.getId(), withTransaction, false);
      deleteModel(workflowFile.getId(), "WorkflowFile", "Delete from workflow_files where id=?", withTransaction, false);
    }

  }

}
