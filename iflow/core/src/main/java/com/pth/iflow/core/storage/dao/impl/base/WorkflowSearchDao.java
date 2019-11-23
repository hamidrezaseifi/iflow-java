package com.pth.iflow.core.storage.dao.impl.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.workflow.WorkflowResult;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.IWorkflowSearchDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class WorkflowSearchDao implements IWorkflowSearchDao {

  private final Logger logger = LoggerFactory.getLogger(WorkflowSearchDao.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public WorkflowSearchDao() {

  }

  private WorkflowResult modelFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowResult model = new WorkflowResult();

    model.setIdentity(rs.getString("identity"));
    model.setStatus(rs.getInt("status"));

    model.setWorkflowTypeIdentity(rs.getString("workflow_type_identity"));

    model.setCurrentStepIdentity(rs.getString("current_step_identity"));
    model.setCreatedByIdentity(rs.getString("createdby_identity"));
    model.setControllerIdentity(rs.getString("controller_identity"));

    return model;
  }

  @Override
  public List<WorkflowResult> search(final WorkflowSearchFilter workflowSearchFilter) {
    logger.info("Dao search WorkflowResult ");

    List<WorkflowResult> resultList = new ArrayList<>();

    final String whereClause = this.prepareSearchWhereClause(workflowSearchFilter);

    final String searchSql = "SELECT "
        + "workflow.*, workflow_type.identity as workflow_type_identity, steps.identity as current_step_identity, "
        + "controlleruser.email as controller_identity,createdbyuser.email as createdby_identity  \r\n"
        + "FROM                                                                                   \r\n"
        + "(((workflow inner join workflow_type on workflow_type.id = workflow.workflow_type_id) \r\n"
        + "inner join workflow_type_step steps on steps.id = workflow.current_step)\r\n"
        + "left outer join users controlleruser on controlleruser.id = workflow.controller)\r\n"
        + "left outer join users createdbyuser on createdbyuser.id = workflow.created_by where " + whereClause;

    try {
      resultList = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(searchSql);

        int index = 1;

        for (final String identity : workflowSearchFilter.getAssignedUserIdentitySet()) {
          ps.setString(index, identity);
          index++;
        }

        for (final Integer id : workflowSearchFilter.getStatusSet()) {
          ps.setInt(index, id);
          index++;
        }

        for (final String identity : workflowSearchFilter.getWorkflowStepIdentitySet()) {
          ps.setString(index, identity);
          index++;
        }

        for (final String identity : workflowSearchFilter.getWorkflowTypeIdentitySet()) {
          ps.setString(index, identity);
          index++;
        }

        return ps;

      }, (rs, rowNum) -> {

        return modelFromResultSet(rs);

      });

    } catch (final Exception e) {
      throw new IFlowStorageException("Unable to search WorkflowResult : " + e.toString());
    }

    return resultList;

  }

  private String prepareSearchWhereClause(final WorkflowSearchFilter workflowSearchFilter) {
    String whereClause = "";
    if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {
      whereClause += " workflow.id in (select workflow_id from workflow_actions inner join users on workflow_actions.assign_to=users.id where users.email in ("
          + StringUtils.repeat("?,", workflowSearchFilter.getAssignedUserIdentitySet().size()) + ")) ";
    }
    if (workflowSearchFilter.getStatusSet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " workflow.status in (" + StringUtils.repeat("?,", workflowSearchFilter.getStatusSet().size()) + ") ";
    }
    if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " steps.identity in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowStepIdentitySet().size())
          + ") ";
    }
    if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
      whereClause += whereClause.isEmpty() ? "" : "and";
      whereClause += " workflow_type.identity in ("
          + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowTypeIdentitySet().size()) + ") ";
    }

    whereClause = whereClause.replace(",)", ")");
    return whereClause;
  }

}
