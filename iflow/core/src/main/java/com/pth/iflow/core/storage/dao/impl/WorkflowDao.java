package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
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

  @Autowired
  private IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowDao() {

  }

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    final Workflow workflow = this.getModelById(id, "SELECT * FROM workflow where id=?", "Workflow");

    if (workflow != null) {
      workflow.setActions(this.workflowActionDao.getListByWorkflowId(workflow.getId()));
      workflow.setFiles(this.workflowFileDao.getListByWorkflowId(workflow.getId()));
    }
    return workflow;
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws IFlowStorageException {

    final List<Workflow> list = this.readWorkflowListFromIdList(idList);

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
    model.setCurrentStep(this.workflowTypeStepDao.getById(rs.getLong("current_step")));
    model.setCreatedBy(rs.getLong("created_by"));
    model.setAssignTo(rs.getLong("assign_to"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));

    return model;
  }

  @Override
  public List<Workflow> getListByWorkflowTypeId(final Long id) throws IFlowStorageException {

    final List<Long> idList = this.getModelIdListById(id, "SELECT * FROM workflow where workflow_type_id=?", "Workflow", "id");
    final List<Workflow> list = this.readWorkflowListFromIdList(idList);

    return list;
  }

  private List<Workflow> readWorkflowListFromIdList(final List<Long> idList) {
    final List<Workflow> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(this.getById(wId));
    }
    return list;
  }

  @Override
  public Workflow create(final Workflow workflow) throws IFlowStorageException {
    final String sql =
                     "INSERT INTO workflow (workflow_type_id, title, current_step, assign_to, comments, controller, created_by, version, status)"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      final Long workflowId = this.createModel(workflow, "Workflow", sql, false);

      this.createWorkflowActions(workflow, workflowId);

      this.createWorkflowFiles(workflow, workflowId);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowId);

    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void createWorkflowActions(final Workflow workflow, final Long workflowId) {

    this.workflowActionDao.deleteByWorkflowId(workflowId, false);

    final List<WorkflowAction> resultList = new ArrayList<>();

    for (final WorkflowAction model : workflow.getActions()) {
      model.setWorkflowId(workflowId);
      resultList.add(this.workflowActionDao.create(model, false));

    }

    workflow.setActions(resultList);
  }

  private void createWorkflowFiles(final Workflow workflow, final Long workflowId) {

    this.workflowFileDao.deleteByWorkflowId(workflowId, false);

    final List<WorkflowFile> resultList = new ArrayList<>();

    for (final WorkflowFile model : workflow.getFiles()) {
      model.setWorkflowId(workflowId);
      resultList.add(this.workflowFileDao.create(model, false));

    }

    workflow.setFiles(resultList);
  }

  @Override
  public Workflow update(final Workflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, title = ?, current_step = ?, assign_to=?, comments = ?,"
                       + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.updateModel(workflow, "Workflow", sql, false);

      this.createWorkflowActions(workflow, workflow.getId());

      this.createWorkflowFiles(workflow, workflow.getId());

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflow.getId());
    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update Workflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {
      this.workflowActionDao.deleteByWorkflowId(workflowId, false);

      this.workflowFileDao.deleteByWorkflowId(workflowId, false);

      this.deleteModel(workflowId, "Workflow", "Delete from workflow where id=?", false, true);

      this.commitTransaction(true, transactionStatus);

    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete Workflow:{} {}", workflowId, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep().getId());
    ps.setLong(4, model.getAssignTo());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getController());
    ps.setLong(7, model.getCreatedBy());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatusInt());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setString(2, model.getTitle());
    ps.setLong(3, model.getCurrentStep().getId());
    ps.setLong(4, model.getAssignTo());
    ps.setString(5, model.getComments());
    ps.setLong(6, model.getController());
    ps.setLong(7, model.getCreatedBy());
    ps.setInt(8, model.getVersion());
    ps.setInt(9, model.getStatusInt());
    ps.setLong(10, model.getId());

    return ps;
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status) throws IFlowStorageException {

    logger.info("Dao read Workflow for user id: {}", id);

    List<Long> idList = new ArrayList<>();
    final String sql = "SELECT * FROM workflow where assign_to=?" + (status > -1 ? " and status=?" : "");

    try {
      idList = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        if (status > -1) {
          ps.setInt(2, status);
        }

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("id");

      });

    }
    catch (final Exception e) {
      throw new IFlowStorageException("Unable to read Workflow for user id: " + id + " : " + e.toString());
    }

    final List<Workflow> workflowList = this.readWorkflowListFromIdList(idList);

    return workflowList;
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter) {
    logger.info("Dao search Workflow ");

    List<Long> idList = new ArrayList<>();

    final String whereClause = this.prepareSearchWhereClause(workflowSearchFilter);

    final String searchSql = "SELECT * FROM workflow where " + whereClause;

    logger.info("Dao search Workflow sql: \n{}", searchSql);

    try {
      idList = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(searchSql);

        int index = 1;
        if (workflowSearchFilter.getAssignedUserIdList().isEmpty() == false) {
          for (final Long id : workflowSearchFilter.getAssignedUserIdList()) {
            ps.setLong(index, id);
            index++;
          }
        }

        if (workflowSearchFilter.getStatusList().isEmpty() == false) {
          for (final Integer id : workflowSearchFilter.getStatusList()) {
            ps.setInt(index, id);
            index++;
          }
        }
        if (workflowSearchFilter.getWorkflowStepeIdList().isEmpty() == false) {
          for (final Long id : workflowSearchFilter.getWorkflowStepeIdList()) {
            ps.setLong(index, id);
            index++;
          }
        }
        if (workflowSearchFilter.getWorkflowTypeIdList().isEmpty() == false) {
          for (final Long id : workflowSearchFilter.getWorkflowTypeIdList()) {
            ps.setLong(index, id);
            index++;
          }
        }
        if (StringUtils.isNotEmpty(workflowSearchFilter.getTitle())) {
          ps.setString(index, workflowSearchFilter.getTitle());
          index++;
        }

        return ps;

      }, (rs, rowNum) -> {

        return rs.getLong("id");

      });

    }
    catch (final Exception e) {
      throw new IFlowStorageException("Unable to search Workflow : " + e.toString());
    }

    final List<Workflow> workflowList = this.readWorkflowListFromIdList(idList);

    return workflowList;

  }

  private String prepareSearchWhereClause(final WorkflowSearchFilter workflowSearchFilter) {
    String whereClause = "";
    if (workflowSearchFilter.getAssignedUserIdList().isEmpty() == false) {
      whereClause += "assign_to in (" + StringUtils.repeat("?,", workflowSearchFilter.getAssignedUserIdList().size()) + ") ";
    }
    if (workflowSearchFilter.getStatusList().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " status in (" + StringUtils.repeat("?,", workflowSearchFilter.getStatusList().size()) + ") ";
    }
    if (workflowSearchFilter.getWorkflowStepeIdList().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " current_step in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowStepeIdList().size()) + ") ";
    }
    if (workflowSearchFilter.getWorkflowTypeIdList().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " workflow_type_id in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowTypeIdList().size()) + ") ";
    }
    if (StringUtils.isNotEmpty(workflowSearchFilter.getTitle())) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " title like '%" + workflowSearchFilter.getTitle() + "%' ";
    }
    whereClause = whereClause.replace(",)", ")");
    return whereClause;
  }
}
