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

import com.pth.iflow.core.model.workflow.TestThreeTaskWorkflow;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class TestThreeTaskWorkflowDao extends DaoBasicClass<TestThreeTaskWorkflow> implements IWorkflowDao<TestThreeTaskWorkflow> {

  @Autowired
  private WorkflowDaoHelper<TestThreeTaskWorkflow> workflowDaoHelper;

  public TestThreeTaskWorkflowDao() {

  }

  @Override
  public TestThreeTaskWorkflow getById(final Long id) throws IFlowStorageException {
    final TestThreeTaskWorkflow workflow = this.getModelById(id, "SELECT * FROM workflow where id=?", "TestThreeTaskWorkflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
    }
    return workflow;
  }

  @Override
  public TestThreeTaskWorkflow getByIdentity(final String identity) throws IFlowStorageException {
    final TestThreeTaskWorkflow workflow = this.getModelByIdentity(identity, "SELECT * FROM workflow where identity=?",
        "TestThreeTaskWorkflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
    }
    return workflow;
  }

  @Override
  public List<TestThreeTaskWorkflow> getListByIdList(final Set<Long> idList) throws IFlowStorageException {

    return this.readWorkflowListFromIdList(idList);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListByIdentityList(final Collection<String> idList) {

    String sqlSelect = "SELECT  * FROM workflow where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "TestThreeTaskWorkflow");

  }

  @Override
  protected TestThreeTaskWorkflow modelFromResultSet(final ResultSet rs) throws SQLException {
    final TestThreeTaskWorkflow model = new TestThreeTaskWorkflow();
    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setIdentity(rs.getString("identity"));

    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));
    model.setCurrentStepId(rs.getLong("current_step"));
    model.setControllerId(rs.getLong("controller"));
    model.setCreatedById(rs.getLong("created_by"));

    workflowDaoHelper.verifyCurrentStepById(model, rs.getLong("current_step"));
    workflowDaoHelper.verifyControllerById(model, rs.getLong("controller"));
    workflowDaoHelper.verifyCreatedByById(model, rs.getLong("created_by"));

    return model;
  }

  private List<TestThreeTaskWorkflow> readWorkflowListFromIdList(final Collection<Long> idList) {
    final List<TestThreeTaskWorkflow> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(this.getById(wId));
    }
    return list;
  }

  @Override
  public TestThreeTaskWorkflow create(final TestThreeTaskWorkflow workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow (identity, workflow_type_id, current_step, comments, controller, created_by, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    workflowDaoHelper.verifyWorkflowTypeByIdentity(workflow);
    workflowDaoHelper.verifyCurrentStepByIdentity(workflow);
    workflowDaoHelper.verifyControllerByIdentity(workflow);
    workflowDaoHelper.verifyCreatedByByIdentity(workflow);

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      final Long workflowId = this.createModel(workflow, "TestThreeTaskWorkflow", sql, false);

      workflowDaoHelper.createWorkflowActions(workflow, workflowId, false);

      workflowDaoHelper.createWorkflowFiles(workflow, workflowId, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowId);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create TestThreeTaskWorkflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  @Override
  public TestThreeTaskWorkflow update(final TestThreeTaskWorkflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, current_step = ?, comments = ?,"
        + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    workflowDaoHelper.verifyWorkflowTypeByIdentity(workflow);
    workflowDaoHelper.verifyCurrentStepByIdentity(workflow);
    workflowDaoHelper.verifyControllerByIdentity(workflow);
    workflowDaoHelper.verifyCreatedByByIdentity(workflow);

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.updateModel(workflow, "TestThreeTaskWorkflow", sql, false);

      workflowDaoHelper.createWorkflowActions(workflow, workflow.getId(), false);

      workflowDaoHelper.createWorkflowFiles(workflow, workflow.getId(), false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflow.getId());
    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update TestThreeTaskWorkflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {
      this.workflowDaoHelper.deleteWorkflowDetails(workflowId, false);

      this.deleteModel(workflowId, "TestThreeTaskWorkflow", "Delete from workflow where id=?", false, true);

      this.commitTransaction(true, transactionStatus);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete TestThreeTaskWorkflow:{} {}", workflowId, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final TestThreeTaskWorkflow model, final PreparedStatement ps)
      throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getWorkflowTypeId());
    ps.setLong(3, model.getCurrentStepId());
    ps.setString(4, model.getComments());
    ps.setLong(5, model.getControllerId());
    ps.setLong(6, model.getCreatedById());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatusInt());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final TestThreeTaskWorkflow model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getWorkflowTypeId());
    ps.setLong(2, model.getCurrentStepId());
    ps.setString(3, model.getComments());
    ps.setLong(4, model.getControllerId());
    ps.setLong(5, model.getCreatedById());
    ps.setInt(6, model.getVersion());
    ps.setInt(7, model.getStatusInt());
    ps.setLong(8, model.getId());

    return ps;
  }

  @Override
  public List<TestThreeTaskWorkflow> getListForUserEmail(final String email, final int status) throws IFlowStorageException {

    logger.info("Dao read TestThreeTaskWorkflow for user");

    final String sql = "SELECT * FROM workflow where workflow.id in (select workflow_id from workflow_actions inner join users on users.id=workflow_actions.assign_to where users.email=?) "
        + (status > -1 ? " and status=?" : "");

    final List<TestThreeTaskWorkflow> workflowList = this.getModelListByIdentity(email, sql, "TestThreeTaskWorkflow");

    return workflowList;
  }

  @Override
  protected String generateIdentity(final TestThreeTaskWorkflow model) {

    final Random rand = new Random();
    return String.format("t%sw%s-%s", identityLongToHex(model.getWorkflowTypeId()), identityLongToHex(System.currentTimeMillis()),
        identityIntToHex(rand.nextInt(1000000), 6));
  }

}
