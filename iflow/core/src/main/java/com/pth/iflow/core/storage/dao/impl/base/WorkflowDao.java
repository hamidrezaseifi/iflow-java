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
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.workflow.Workflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class WorkflowDao extends DaoBasicClass<Workflow> implements IWorkflowDao<Workflow> {

  @Autowired
  private WorkflowDaoHelper<Workflow> workflowDaoHelper;

  public WorkflowDao() {

  }

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    final Workflow workflow = this.getModelById(id, "SELECT * FROM workflow where id=?", "Workflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
    }
    return workflow;
  }

  @Override
  public Workflow getByIdentity(final String identity) throws IFlowStorageException {
    final Workflow workflow = this.getModelByIdentity(identity, "SELECT * FROM workflow where identity=?", "Workflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
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

    model.setWorkflowTypeId(rs.getLong("workflow_type_id"));
    model.setCurrentStepId(rs.getLong("current_step"));
    model.setControllerId(rs.getLong("controller"));
    model.setCreatedById(rs.getLong("created_by"));

    workflowDaoHelper.verifyCurrentStepById(model, rs.getLong("current_step"));
    workflowDaoHelper.verifyControllerById(model, rs.getLong("controller"));
    workflowDaoHelper.verifyCreatedByById(model, rs.getLong("created_by"));

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

    throw new IFlowStorageException("no create for workflow model");

  }

  @Override
  public Workflow update(final Workflow workflow) throws IFlowStorageException {
    throw new IFlowStorageException("no update for workflow model");

  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final Workflow model, final PreparedStatement ps) throws SQLException {

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

        for (final Long id : workflowSearchFilter.getAssignedUserIdSet()) {
          ps.setLong(index, id);
          index++;
        }

        for (final Integer id : workflowSearchFilter.getStatusSet()) {
          ps.setInt(index, id);
          index++;
        }

        for (final Long id : workflowSearchFilter.getWorkflowStepIdSet()) {
          ps.setLong(index, id);
          index++;
        }

        for (final Long id : workflowSearchFilter.getWorkflowTypeIdSet()) {
          ps.setLong(index, id);
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
                         identityLongToHex(model.getWorkflowTypeId()),
                         identityLongToHex(System.currentTimeMillis()),
                         identityIntToHex(rand.nextInt(1000000), 6));
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    throw new IFlowStorageException("no delete for workflow model");

  }
}
