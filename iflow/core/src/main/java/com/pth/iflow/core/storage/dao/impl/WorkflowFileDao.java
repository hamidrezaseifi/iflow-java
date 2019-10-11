package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowFileVersion;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileVersionDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowFileDao extends DaoBasicClass<WorkflowFile> implements IWorkflowFileDao {

  @Autowired
  private IUserDao                userDao;

  @Autowired
  private IWorkflowFileVersionDao workflowFileVersionDao;

  public WorkflowFileDao() {

  }

  @Override
  public WorkflowFile getById(final Long id) throws IFlowStorageException {

    final WorkflowFile workflowFile = this.getModelById(id, "SELECT * FROM workflow_files where id=?", "WorkflowFile");
    workflowFile.setFileVersions(this.workflowFileVersionDao.getListByWorkflowFileId(id));
    return workflowFile;
  }

  @Override
  public WorkflowFile getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM workflow_files where identity=?", "WorkflowFile");
  }

  @Override
  public List<WorkflowFile> getListByIdList(final Set<Long> idList) throws IFlowStorageException {
    final List<WorkflowFile> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(this.getById(wId));
    }
    return list;
  }

  @Override
  protected WorkflowFile modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowFile model = new WorkflowFile();

    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setTitle(rs.getString("title"));
    model.setExtention(rs.getString("extention"));
    model.setActiveFilePath(rs.getString("active_filepath"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setActiveFileVersion(rs.getInt("active_version"));
    model.setCreatedByIdentity(userDao.getById(rs.getLong("created_by")).getIdentity());
    model.setWorkflowId(rs.getLong("workflow_id"));

    return model;
  }

  @Override
  public List<WorkflowFile> getListByWorkflowId(final Long id) throws IFlowStorageException {

    final List<WorkflowFile> list = this.getModelListById(id, "SELECT * FROM workflow_files where workflow_id=?", "WorkflowFile");

    return list;

  }

  @Override
  public List<WorkflowFile> getListByWorkflowIdentity(final String workflowIdentity) throws IFlowStorageException {

    final List<WorkflowFile> list = this.getModelListByIdentity(workflowIdentity,
        "SELECT workflow_files.* FROM workflow_files inner join workflow on workflow.id=workflow_files.workflow_id where workflow.identity=?",
        "WorkflowFile");

    return list;

  }

  @Override
  public WorkflowFile create(final WorkflowFile workflow, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_files (identity, workflow_id, title, extention, active_filepath, active_version, comments, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = this.startTransaction(withTransaction);
    try {
      final Long workflowFileId = this.createModel(workflow, "WorkflowFile", sql, withTransaction);
      workflow.setId(workflowFileId);
      this.createWorkflowFileVersions(workflow, workflowFileId);

      this.commitTransaction(withTransaction, transactionStatus);
      return this.getById(workflowFileId);
    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowFile: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public WorkflowFile update(final WorkflowFile workflowFile, final boolean withTransaction) throws IFlowStorageException {
    final String sql = "UPDATE workflow_files SET workflow_id = ?, title = ?, extention = ?, active_filepath = ?, active_version = ?, comments = ?,"
        + " version = ?, status = ? WHERE id = ?";

    final TransactionStatus transactionStatus = this.startTransaction(withTransaction);
    try {

      this.updateModel(workflowFile, "WorkflowFile", sql, withTransaction);

      this.createWorkflowFileVersions(workflowFile, workflowFile.getId());

      this.commitTransaction(withTransaction, transactionStatus);
      return this.getById(workflowFile.getId());
    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update WorkflowFile: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createWorkflowFileVersions(final WorkflowFile workflowFile, final Long workflowFileId) {

    this.workflowFileVersionDao.deleteByWorkflowFileId(workflowFileId, false, false);

    final List<WorkflowFileVersion> resultList = new ArrayList<>();

    for (final WorkflowFileVersion model : workflowFile.getFileVersions()) {

      model.setWorkflowFileId(workflowFileId);
      if (model.getCreatedBy() == null) {
        model.setCreatedBy(userDao.getByEmail(model.getCreatedByIdentity()));
      }
      resultList.add(this.workflowFileVersionDao.create(model, false));

    }

    workflowFile.setFileVersions(resultList);

  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowFile model, final PreparedStatement ps)
      throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getWorkflowId());
    ps.setString(3, model.getTitle());
    ps.setString(4, model.getExtention());
    ps.setString(5, model.getActiveFilePath());
    ps.setInt(6, model.getActiveFileVersion());
    ps.setString(7, model.getComments());
    ps.setLong(8, userDao.getByEmail(model.getCreatedByIdentity()).getId());
    ps.setInt(9, model.getVersion());
    ps.setInt(10, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowFile model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowId());
    ps.setString(2, model.getTitle());
    ps.setString(3, model.getExtention());
    ps.setString(4, model.getActiveFilePath());
    ps.setInt(5, model.getActiveFileVersion());
    ps.setString(6, model.getComments());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

  @Override
  public void deleteById(final Long id, final boolean withTransaction) throws IFlowStorageException {

    this.workflowFileVersionDao.deleteByWorkflowFileId(id, withTransaction, false);

    this.deleteModel(id, "WorkflowFile", "Delete from workflow_files where id=?", withTransaction, true);
  }

  @Override
  public void deleteByWorkflowId(final Long id, final boolean withTransaction) throws IFlowStorageException {

    final List<WorkflowFile> workflowFiles = this.getListByWorkflowId(id);

    for (final WorkflowFile workflowFile : workflowFiles) {
      this.workflowFileVersionDao.deleteByWorkflowFileId(workflowFile.getId(), withTransaction, false);
      this.deleteModel(workflowFile.getId(), "WorkflowFile", "Delete from workflow_files where id=?", withTransaction, false);
    }

  }

  @Override
  protected String generateIdentity(final WorkflowFile model) {

    final Random rand = new Random();
    return String.format("w%df%d-%06d", model.getWorkflowId(), System.currentTimeMillis(), rand.nextInt(1000000));
  }

}
