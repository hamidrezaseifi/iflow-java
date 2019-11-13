package com.pth.iflow.core.storage.dao.impl.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.workflow.Workflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.model.workflow.sub.WorkflowType;
import com.pth.iflow.core.model.workflow.sub.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowDao extends DaoBasicClass<Workflow> implements IWorkflowDao<Workflow> {

  @Autowired
  private IWorkflowActionDao workflowActionDao;

  @Autowired
  private IWorkflowFileDao workflowFileDao;

  @Autowired
  private IWorkflowTypeDao workflowTypeDao;

  @Autowired
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @Autowired
  private IUserDao userDao;

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
  public Workflow getByIdentity(final String identity) throws IFlowStorageException {
    final Workflow workflow = this.getModelByIdentity(identity, "SELECT * FROM workflow where identity=?", "Workflow");

    if (workflow != null) {
      workflow.setActions(this.workflowActionDao.getListByWorkflowId(workflow.getId()));
      workflow.setFiles(this.workflowFileDao.getListByWorkflowId(workflow.getId()));
    }
    return workflow;
  }

  @Override
  public List<Workflow> getListByIdList(final Set<Long> idList) throws IFlowStorageException {

    return this.readWorkflowListFromIdList(idList);
  }

  @Override
  public List<Workflow> getListByIdentityList(final Collection<String> idList) {

    String sqlSelect = "SELECT * FROM workflow where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "Workflow");

  }

  @Override
  protected Workflow modelFromResultSet(final ResultSet rs) throws SQLException {
    final Workflow model = new Workflow();
    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setIdentity(rs.getString("identity"));

    model.setWorkflowType(workflowTypeDao.getById(rs.getLong("workflow_type_id")));
    model.setCurrentStep(workflowTypeStepDao.getById(rs.getLong("current_step")));
    model.setController(userDao.getById(rs.getLong("controller")));
    model.setCreatedBy(userDao.getById(rs.getLong("created_by")));
    model.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());

    model.setControllerIdentity(model.getController().getIdentity());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity(model.getCreatedBy().getIdentity());

    return model;
  }

  private List<Workflow> readWorkflowListFromIdList(final Collection<Long> idList) {
    final List<Workflow> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(this.getById(wId));
    }
    return list;
  }

  @Override
  public Workflow create(final Workflow workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow (identity, workflow_type_id, current_step, comments, controller, created_by, version, status)"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    verifyWorkflowTypeByIdentity(workflow);
    verifyCurrentStepByIdentity(workflow);
    verifyControllerByIdentity(workflow);
    verifyCreatedByByIdentity(workflow);

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

  private void verifyWorkflowTypeByIdentity(final Workflow workflow) {
    if (workflow.getWorkflowType() == null) {
      final WorkflowType type = workflowTypeDao.getByIdentity(workflow.getWorkflowTypeIdentity());
      workflow.setWorkflowType(type);
    }
  }

  private void verifyCurrentStepByIdentity(final Workflow workflow) {
    if (workflow.getCurrentStep() == null) {
      final WorkflowTypeStep type = workflowTypeStepDao.getByIdentity(workflow.getCurrentStepIdentity());
      workflow.setCurrentStep(type);
    }
  }

  private void verifyControllerByIdentity(final Workflow workflow) {
    if (workflow.getController() == null) {
      final User type = userDao.getByEmail(workflow.getControllerIdentity());
      workflow.setController(type);
    }
  }

  private void verifyCreatedByByIdentity(final Workflow workflow) {
    if (workflow.getCreatedBy() == null) {
      final User type = userDao.getByEmail(workflow.getCreatedByIdentity());
      workflow.setCreatedBy(type);
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
    final String sql = "UPDATE workflow SET workflow_type_id = ?, current_step = ?, comments = ?,"
                       + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    verifyWorkflowTypeByIdentity(workflow);
    verifyCurrentStepByIdentity(workflow);
    verifyControllerByIdentity(workflow);
    verifyCreatedByByIdentity(workflow);

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
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getWorkflowType().getId());
    ps.setLong(3, model.getCurrentStep().getId());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getController().getId());
    ps.setLong(6, model.getCreatedBy().getId());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatusInt());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {
    ps.setLong(1, model.getWorkflowType().getId());
    ps.setLong(2, model.getCurrentStep().getId());
    ps.setString(3, model.getComments());
    ps.setLong(4, model.getController().getId());
    ps.setLong(5, model.getCreatedBy().getId());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatusInt());
    ps.setLong(8, model.getId());

    return ps;
  }

  @Override
  public List<Workflow> getListForUserEmail(final String email, final int status) throws IFlowStorageException {

    logger.info("Dao read Workflow for user");

    final String sql =
                     "SELECT * FROM workflow where id in (select workflow_id from workflow_actions inner join users on users.id=workflow_actions.assign_to where users.email=?) "
                       + (status > -1 ? " and status=?" : "");

    final List<Workflow> workflowList = this.getModelListByIdentity(email, sql, "Workflow");

    return workflowList;
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter) {
    logger.info("Dao search Workflow ");

    List<Long> idList = new ArrayList<>();

    final String whereClause = this.prepareSearchWhereClause(workflowSearchFilter);

    final String searchSql = "SELECT * FROM workflow where " + whereClause;

    try {
      idList = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(searchSql);

        int index = 1;

        if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {
          final List<User> list = userDao.getListByIdentityList(workflowSearchFilter.getAssignedUserIdentitySet());
          for (final User user : list) {
            ps.setLong(index, user.getId());
            index++;
          }
        }

        if (workflowSearchFilter.getStatusSet().isEmpty() == false) {
          for (final Integer id : workflowSearchFilter.getStatusSet()) {
            ps.setInt(index, id);
            index++;
          }
        }
        if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
          final List<WorkflowTypeStep> list = workflowTypeStepDao.getListByIdentityList(workflowSearchFilter.getWorkflowStepIdentitySet());
          for (final WorkflowTypeStep step : list) {
            ps.setLong(index, step.getId());
            index++;
          }
        }
        if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
          final List<WorkflowType> list = workflowTypeDao.getListByIdentityList(workflowSearchFilter.getWorkflowTypeIdentitySet());
          for (final WorkflowType type : list) {
            ps.setLong(index, type.getId());
            index++;
          }
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
    if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {
      whereClause += "id in (select workflow_id from workflow_actions where assign_to in ("
                     + StringUtils.repeat("?,", workflowSearchFilter.getAssignedUserIdentitySet().size())
                     + ")) ";
    }
    if (workflowSearchFilter.getStatusSet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " status in (" + StringUtils.repeat("?,", workflowSearchFilter.getStatusSet().size()) + ") ";
    }
    if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " current_step in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowStepIdentitySet().size()) + ") ";
    }
    if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " workflow_type_id in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowTypeIdentitySet().size()) + ") ";
    }

    whereClause = whereClause.replace(",)", ")");
    return whereClause;
  }

  @Override
  protected String generateIdentity(final Workflow model) {

    final Random rand = new Random();
    return String.format("t%sw%s-%s",
                         identityLongToHex(model.getWorkflowType().getId()),
                         identityLongToHex(System.currentTimeMillis()),
                         identityIntToHex(rand.nextInt(1000000), 6));
  }
}
