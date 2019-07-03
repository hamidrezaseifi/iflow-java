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

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowTypeDao extends DaoBasicClass<WorkflowType> implements IWorkflowTypeDao {

  public WorkflowTypeDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
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
    model.setSteps(getworkflowStepIdListById(model.getId()));

    return model;
  }

  private List<Long> getworkflowStepIdListById(final Long id) throws IFlowStorageException {
    return getIdListById(id, "SELECT * FROM workflow_type_step where workflow_type_id=?", "id", "Workflow Step IDs");
  }

  @Override
  public List<WorkflowType> getListByCompanyId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow_type where company_id=?", "Workflow");
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final WorkflowType model, final PreparedStatement ps)
      throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }
}
