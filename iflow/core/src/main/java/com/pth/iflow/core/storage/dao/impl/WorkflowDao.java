package com.pth.iflow.core.storage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.utils.SqlUtils;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class WorkflowDao extends DaoBasicClass<Workflow> implements IWorkflowDao {

  public WorkflowDao(final @Autowired JdbcTemplate jdbcTemplate,
      final @Autowired PlatformTransactionManager platformTransactionManager) {
    super(jdbcTemplate, platformTransactionManager);
  }

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    return getModelById(id, "SELECT * FROM workflow where id=?", "Workflow");
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    String sqlSelect = "SELECT * FROM workflow where id in (";
    for (final Long id : idList) {
      sqlSelect += "?, ";
    }

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return getModelListByIdList(idList, sqlSelect, "Workflow");
  }

  @Override
  protected Workflow modelFromResultSet(final ResultSet rs) throws SQLException {
    final Workflow model = new Workflow();
    model.setId(rs.getLong("id"));
    model.setCompanyId(rs.getLong("company_id"));
    model.setTitle(rs.getString("title"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setSteps(getworkflowStepIdListById(model.getId()));

    return model;
  }

  private List<Long> getworkflowStepIdListById(final Long id) throws IFlowStorageException {
    return getIdListById(id, "SELECT * FROM workflow_step where workflow_id=?", "id", "Workflow Step IDs");
  }

  @Override
  public List<Workflow> getListByCompanyId(final Long id) throws IFlowStorageException {
    return getModelListById(id, "SELECT * FROM workflow where company_id=?", "Workflow");
  }
}
