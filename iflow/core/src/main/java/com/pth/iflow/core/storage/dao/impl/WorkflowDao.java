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

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowDao extends DaoBasicClass<Workflow> implements IWorkflowDao {

  @Autowired
  private IWorkflowActionDao workflowActionDao;

  @Autowired
  private IWorkflowFileDao workflowFileDao;

  public WorkflowDao() {

  }

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    final Workflow workflow = getModelById(id, "SELECT * FROM workflow where id=?", "Workflow");

    if (workflow != null) {
      workflow.setActions(workflowActionDao.getListByWorkflowId(workflow.getId()));
      workflow.setFiles(workflowFileDao.getListByWorkflowId(workflow.getId()));
    }
    return workflow;
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws IFlowStorageException {

    final List<Workflow> list = readWorkflowListFromIdList(idList);

    return list;
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
    model.setAssignTo(rs.getLong("assign_to"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));

    return model;
  }

  @Override
  public List<Workflow> getListByWorkflowTypeId(final Long id) throws IFlowStorageException {

    final List<Long> idList = getModelIdListById(id, "SELECT * FROM workflow where workflow_type_id=?", "Workflow", "id");
    final List<Workflow> list = readWorkflowListFromIdList(idList);

    return list;
  }

  private List<Workflow> readWorkflowListFromIdList(final List<Long> idList) {
    final List<Workflow> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(getById(wId));
    }
    return list;
  }

  @Override
  public Workflow create(final Workflow workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow (workflow_type_id, title, current_step, assign_to, comments, controller, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = startTransaction(true);
    try {

      final Long workflowId = createModel(workflow, "Workflow", sql, false);

      createWorkflowActions(workflow, workflowId);

      createWorkflowFiles(workflow, workflowId);

      commitTransaction(true, transactionStatus);

      return getById(workflowId);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void createWorkflowActions(final Workflow workflow, final Long workflowId) {

    workflowActionDao.deleteByWorkflowId(workflowId, false);

    final List<WorkflowAction> resultList = new ArrayList<>();

    for (final WorkflowAction model : workflow.getActions()) {
      model.setWorkflowId(workflowId);
      resultList.add(workflowActionDao.create(model, false));

    }

    workflow.setActions(resultList);
  }

  private void createWorkflowFiles(final Workflow workflow, final Long workflowId) {

    workflowFileDao.deleteByWorkflowId(workflowId, false);

    final List<WorkflowFile> resultList = new ArrayList<>();

    for (final WorkflowFile model : workflow.getFiles()) {
      model.setWorkflowId(workflowId);
      resultList.add(workflowFileDao.create(model, false));

    }

    workflow.setFiles(resultList);
  }

  @Override
  public Workflow update(final Workflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, title = ?, current_step = ?, assign_to=?, comments = ?,"
        + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    final TransactionStatus transactionStatus = startTransaction(true);
    try {

      updateModel(workflow, "Workflow", sql, false);

      createWorkflowActions(workflow, workflow.getId());

      createWorkflowFiles(workflow, workflow.getId());

      commitTransaction(true, transactionStatus);

      return getById(workflow.getId());
    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    final TransactionStatus transactionStatus = startTransaction(true);
    try {
      workflowActionDao.deleteByWorkflowId(workflowId, false);

      workflowFileDao.deleteByWorkflowId(workflowId, false);

      deleteModel(workflowId, "Workflow", "Delete from workflow where id=?", false, true);

      commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete Workflow:{} {}", workflowId, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep());
    ps.setLong(4, model.getAssignTo());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getController());
    ps.setLong(7, model.getCreatedBy());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep());
    ps.setLong(4, model.getAssignTo());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getController());
    ps.setLong(7, model.getCreatedBy());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatus());
    ps.setLong(10, model.getId());

    return ps;
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status) throws IFlowStorageException {

    logger.info("Dao read Workflow for user id: {}", id);

    List<Long> idList = new ArrayList<>();
    final String sql = "SELECT * FROM workflow where assign_to=?" + (status > -1 ? " and status=?" : "");

    try {
      idList = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        if (status > -1) {
          ps.setInt(2, status);
        }

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("id");

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to read Workflow for user id: " + id + " : " + e.toString());
    }

    final List<Workflow> workflowList = readWorkflowListFromIdList(idList);

    return workflowList;
  }

}
