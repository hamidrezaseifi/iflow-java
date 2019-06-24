package com.pth.iflow.core.storage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowStep;
import com.pth.iflow.core.storage.dao.IWorkflowStepDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowStepDao extends DaoBasicClass<WorkflowStep> implements IWorkflowStepDao {
  
  public WorkflowStepDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }
  
  @Override
  public WorkflowStep getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow_step where id=?", "WorkflowStep");
  }
  
  @Override
  public List<WorkflowStep> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow_step where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }
    
    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";
    
    return getModelListByIdList(idList, sqlSelect, "WorkflowStep");
  }
  
  @Override
  protected WorkflowStep modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowStep model = new WorkflowStep();
    model.setId(rs.getLong("id"));
    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    
    return model;
  }
  
  @Override
  public List<WorkflowStep> getListByWorkflowId(final Long workflowId) throws IFlowStorageException {
    return getModelListById(workflowId, "SELECT * FROM workflow_step where workflow_type_id=?", "WorkflowStep");
  }
}
