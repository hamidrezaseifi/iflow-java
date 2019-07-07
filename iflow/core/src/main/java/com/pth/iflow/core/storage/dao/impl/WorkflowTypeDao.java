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
    return getModelById(id, "SELECT * FROM workflow_type where id=?", "Workflow");
  }

  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_type where id in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "Workflow");
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
    model.setManualAssign(rs.getInt("manual_assign") == 1);
    model.setSteps(workflowTypeStepDao.getListByWorkflowTypeId(model.getId()));

    return model;
  }

  @Override
  public List<WorkflowType> getListByCompanyId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_type where company_id=?", "Workflow");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setLong(2, model.getBaseTypeId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.getManualAssign() ? 1 : 0);
    ps.setInt(5, model.getSendToController() ? 1 : 0);
    ps.setString(6, model.getComments());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    ps.setLong(1, model.getCompanyId());
    ps.setLong(2, model.getBaseTypeId());
    ps.setString(3, model.getTitle());
    ps.setInt(4, model.getManualAssign() ? 1 : 0);
    ps.setInt(5, model.getSendToController() ? 1 : 0);
    ps.setString(6, model.getComments());
    ps.setInt(7, model.getVersion());
    ps.setInt(8, model.getStatus());
    ps.setLong(9, model.getId());

    return ps;
  }

  @Override
  public WorkflowType create(final WorkflowType model) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow_type (company_id, workflow_base_type, title, manual_assign, send_to_controller, comments, version, status)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    final TransactionStatus transactionStatus = startTransaction(true);
    try {
      final Long workflowTypeId = createModel(model, "WorkflowType", sql, true);

      createWorkflowActions(model, workflowTypeId);

      commitTransaction(true, transactionStatus);

      return getById(workflowTypeId);

    } catch (final Exception e) {
      rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create WorkflowType:{} {}", model.getTitle(), e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  private void createWorkflowActions(final WorkflowType workflowType, final Long workflowTypeId) {

    workflowTypeStepDao.deleteByWorkflowTypeId(workflowTypeId, false);

    final List<WorkflowTypeStep> resultList = new ArrayList<>();

    for (final WorkflowTypeStep model : workflowType.getSteps()) {
      model.setWorkflowTypeId(workflowTypeId);
      resultList.add(workflowTypeStepDao.create(model, false));

    }

    workflowType.setSteps(resultList);
  }

  @Override
  public WorkflowType update(final WorkflowType model) throws IFlowStorageException {
    final String sql = "UPDATE workflow_type SET company_id = ?, workflow_base_type = ?, title = ?, manual_assign = ?, send_to_controller = ?, comments = ?,"
        + " version = ?, status = ? WHERE id = ?";

    updateModel(model, "WorkflowType", sql, true);

    return getById(model.getId());
  }
}
