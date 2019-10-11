package com.pth.iflow.core.storage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowTypeDao extends DaoBasicClass<WorkflowType> implements IWorkflowTypeDao {

  @Autowired
  private IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowTypeDao() {

  }

  @Override
  public WorkflowType getById(final Long id) throws IFlowStorageException {
    return this.getModelById(id, "SELECT * FROM workflow_type where id=?", "WorkflowType");
  }

  @Override
  public WorkflowType getByIdentity(final String identity) throws IFlowStorageException {
    return getModelByIdentity(identity, "SELECT * FROM workflow_type where identity=?", "WorkflowType");
  }

  @Override
  public List<WorkflowType> getListByIdList(final Set<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdList(idList, sqlSelect, "WorkflowType");
  }

  @Override
  public List<WorkflowType> getListByIdentityList(final Set<String> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "WorkflowType");
  }

  @Override
  protected WorkflowType modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowType model = new WorkflowType();
    model.setId(rs.getLong("id"));
    model.setCompanyId(rs.getLong("company_id"));
    model.setBaseTypeId(rs.getLong("workflow_base_type"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setSendToController(rs.getInt("send_to_controller") == 1);
    model.setAssignType(EWorkflowTypeAssignType.ofValue(rs.getInt("assign_type")));
    model.setIncreaseStepAutomatic(rs.getInt("increase_step_automatic") == 1);
    model.setAllowAssign(rs.getInt("allow_assign") == 1);
    model.setSteps(this.workflowTypeStepDao.getListByWorkflowTypeId(model.getId()));
    model.setIdentity(rs.getString("identity"));
    return model;
  }

  @Override
  public List<WorkflowType> getListByCompanyIdentity(final String companyIdentity) throws IFlowStorageException {
    return this.getModelListByIdentity(companyIdentity,
        "SELECT * FROM workflow_type inner join companies on workflow_type.company_id=companies.id where companies.identity=?",
        "WorkflowType");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    ps.setString(1, model.getIdentity());
    ps.setLong(2, model.getCompanyId());
    ps.setLong(3, model.getBaseTypeId());
    ps.setString(4, model.getTitle());
    ps.setInt(5, model.geAssignType().getValue());
    ps.setInt(6, model.getSendToController() ? 1 : 0);
    ps.setInt(7, model.getIncreaseStepAutomatic() ? 1 : 0);
    ps.setInt(8, model.getAllowAssign() ? 1 : 0);
    ps.setString(9, model.getComments());
    ps.setInt(10, model.getVersion());
    ps.setInt(11, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setLong(2, model.getBaseTypeId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.geAssignType().getValue());
    ps.setInt(5, model.getSendToController() ? 1 : 0);
    ps.setInt(6, model.getIncreaseStepAutomatic() ? 1 : 0);
    ps.setInt(7, model.getAllowAssign() ? 1 : 0);
    ps.setString(8, model.getComments());
    ps.setInt(9, model.getVersion());
    ps.setInt(10, model.getStatus());
    ps.setLong(11, model.getId());

    return ps;
  }

  @Override
  public WorkflowType create(final WorkflowType model) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_type (identity, company_id, workflow_base_type, title, assign_type, send_to_controller, increase_step_automatic, allow_assign, comments, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {
      final Long workflowTypeId = this.createModel(model, "WorkflowType", sql, true);

      this.createWorkflowActions(model, workflowTypeId);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowTypeId);

    } catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowType:{} {}", model.getTitle(), e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createWorkflowActions(final WorkflowType workflowType, final Long workflowTypeId) {

    this.workflowTypeStepDao.deleteByWorkflowTypeId(workflowTypeId, false);

    final List<WorkflowTypeStep> resultList = new ArrayList<>();

    for (final WorkflowTypeStep model : workflowType.getSteps()) {
      model.setWorkflowTypeId(workflowTypeId);
      resultList.add(this.workflowTypeStepDao.create(model, false));

    }

    workflowType.setSteps(resultList);
  }

  @Override
  public WorkflowType update(final WorkflowType model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_type SET company_id = ?, workflow_base_type = ?, title = ?, assign_type = ?, send_to_controller = ?, increase_step_automatic = ?, allow_assign = ?, comments = ?,"
        + " version = ?, status = ? WHERE id = ?";

    this.updateModel(model, "WorkflowType", sql, true);

    return this.getById(model.getId());
  }

  @Override
  protected String generateIdentity(final WorkflowType model) {
    return String.format("c%dt%d", model.getCompanyId(), System.currentTimeMillis());
  }
}
