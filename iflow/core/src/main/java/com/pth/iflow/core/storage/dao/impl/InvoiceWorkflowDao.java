package com.pth.iflow.core.storage.dao.impl;

import java.sql.Date;
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
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.core.model.workflow.InvoiceWorkflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.basic.DaoBasicClass;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.WorkflowDaoHelper;
import com.pth.iflow.core.storage.dao.utils.SqlUtils;

@Transactional
@Repository
public class InvoiceWorkflowDao extends DaoBasicClass<InvoiceWorkflow> implements IWorkflowDao<InvoiceWorkflow> {

  @Autowired
  private WorkflowDaoHelper<InvoiceWorkflow> workflowDaoHelper;

  public InvoiceWorkflowDao() {

  }

  @Override
  public InvoiceWorkflow getById(final Long id) throws IFlowStorageException {
    final InvoiceWorkflow workflow = this.getModelById(id,
                                                       "SELECT * FROM workflow inner join invoice_workflow on invoice_workflow.workflow_id=workflow.id where id=?",
                                                       "InvoiceWorkflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
    }
    return workflow;
  }

  @Override
  public InvoiceWorkflow getByIdentity(final String identity) throws IFlowStorageException {
    final InvoiceWorkflow workflow = this.getModelByIdentity(identity,
                                                             "SELECT * FROM workflow inner join invoice_workflow on invoice_workflow.workflow_id=workflow.id where identity=?",
                                                             "InvoiceWorkflow");

    if (workflow != null) {
      workflowDaoHelper.setWorkflowDetails(workflow);
    }
    return workflow;
  }

  @Override
  public List<InvoiceWorkflow> getListByIdList(final Set<Long> idList) throws IFlowStorageException {

    return this.readWorkflowListFromIdList(idList);
  }

  @Override
  public List<InvoiceWorkflow> getListByIdentityList(final Collection<String> idList) {

    String sqlSelect =
                     "SELECT  * FROM workflow inner join invoice_workflow on invoice_workflow.workflow_id=workflow.id where identity in (";
    sqlSelect += StringUtils.repeat("?, ", idList.size());

    sqlSelect = sqlSelect.trim();
    sqlSelect = sqlSelect.endsWith(",") ? sqlSelect.substring(0, sqlSelect.length() - 1) : sqlSelect;
    sqlSelect += ")";

    return this.getModelListByIdentityList(idList, sqlSelect, "InvoiceWorkflow");

  }

  @Override
  protected InvoiceWorkflow modelFromResultSet(final ResultSet rs) throws SQLException {
    final InvoiceWorkflow model = new InvoiceWorkflow();
    model.setId(rs.getLong("id"));
    model.setIdentity(rs.getString("identity"));
    model.setStatus(rs.getInt("status"));
    model.setCreatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created_at")));
    model.setUpdatedAt(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated_at")));
    model.setVersion(rs.getInt("version"));
    model.setComments(rs.getString("comments"));
    model.setIdentity(rs.getString("identity"));

    workflowDaoHelper.verifyWorkflowTypeById(model, rs.getLong("workflow_type_id"));
    workflowDaoHelper.verifyCurrentStepById(model, rs.getLong("current_step"));
    workflowDaoHelper.verifyControllerById(model, rs.getLong("controller"));
    workflowDaoHelper.verifyCreatedByById(model, rs.getLong("created_by"));

    model.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());

    model.setControllerIdentity(model.getController().getIdentity());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity(model.getCreatedBy().getIdentity());

    model.setSender(rs.getString("sender"));
    model.setRegisterNumber(rs.getString("ext_reg_number"));
    model.setInvoceDate(rs.getDate("invoce_date").toLocalDate());
    model.setPartnerCode(rs.getString("partner_code"));
    model.setVendorNumber(rs.getString("vendor_number"));
    model.setVendorName(rs.getString("vendor_name"));
    model.setIsDirectDebitPermission(rs.getInt("direct_debit_permission") == 1 ? Boolean.TRUE : Boolean.FALSE);
    model.setInvoiceType(EInvoiceType.ofValue(rs.getInt("invoice_type")));
    model.setDiscountEnterDate(rs.getDate("discount_enter").toLocalDate());
    model.setDiscountRate(rs.getDouble("discount_rate"));
    model.setDiscountDeadline(rs.getInt("discount_deadline"));
    model.setDiscountDate(rs.getDate("discount_date").toLocalDate());
    model.setPaymentAmount(rs.getDouble("payment_amount"));

    return model;
  }

  private List<InvoiceWorkflow> readWorkflowListFromIdList(final Collection<Long> idList) {
    final List<InvoiceWorkflow> list = new ArrayList<>();

    for (final Long wId : idList) {
      list.add(this.getById(wId));
    }
    return list;
  }

  @Override
  public InvoiceWorkflow create(final InvoiceWorkflow workflow) throws IFlowStorageException {
    final String sql = "INSERT INTO workflow (identity, workflow_type_id, current_step, comments, controller, created_by, version, status)"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    workflowDaoHelper.verifyWorkflowTypeByIdentity(workflow);
    workflowDaoHelper.verifyCurrentStepByIdentity(workflow);
    workflowDaoHelper.verifyControllerByIdentity(workflow);
    workflowDaoHelper.verifyCreatedByByIdentity(workflow);

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      final Long workflowId = this.createModel(workflow, "InvoiceWorkflow", sql, false);

      this.createInvoiceWorkflow(workflow, workflowId);

      workflowDaoHelper.createWorkflowActions(workflow, workflowId, false);

      workflowDaoHelper.createWorkflowFiles(workflow, workflowId, false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflowId);

    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to create InvoiceWorkflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }

  }

  private void createInvoiceWorkflow(final InvoiceWorkflow workflow, final Long workflowId) {

    final String sql = "INSERT INTO invoice_workflow"
                       + "(workflow_id, sender, ext_reg_number, invoce_date, partner_code, vendor_number, vendor_name, direct_debit_permission,"
                       + " invoice_type, discount_enter, discount_rate, discount_deadline, discount_date, payment_amount)"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    this.jdbcTemplate.update(con -> {
      PreparedStatement ps = con.prepareStatement(sql);
      ps = prepareInsertInvoicePreparedStatement(workflow, workflowId, ps);
      return ps;
    });

  }

  private void updateInvoiceWorkflow(final InvoiceWorkflow workflow) {

    final String sql = "Update invoice_workflow set sender=?, ext_reg_number=?, invoce_date=?, partner_code=?, vendor_number=?, "
                       + "vendor_name=?, direct_debit_permission=?, invoice_type=?, discount_enter=?, discount_rate=?, discount_deadline=?, "
                       + "discount_date=?, payment_amount=? where workflow_id=?";

    this.jdbcTemplate.update(con -> {
      PreparedStatement ps = con.prepareStatement(sql);
      ps = prepareUpdateInvoicePreparedStatement(workflow, ps);
      return ps;
    });

  }

  @Override
  public InvoiceWorkflow update(final InvoiceWorkflow workflow) throws IFlowStorageException {
    final String sql = "UPDATE workflow SET workflow_type_id = ?, current_step = ?, comments = ?,"
                       + " controller = ?, created_by = ?, version = ?, status = ? WHERE id = ?";

    workflowDaoHelper.verifyWorkflowTypeByIdentity(workflow);
    workflowDaoHelper.verifyCurrentStepByIdentity(workflow);
    workflowDaoHelper.verifyControllerByIdentity(workflow);
    workflowDaoHelper.verifyCreatedByByIdentity(workflow);

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {

      this.updateModel(workflow, "InvoiceWorkflow", sql, false);

      this.updateInvoiceWorkflow(workflow);

      workflowDaoHelper.createWorkflowActions(workflow, workflow.getId(), false);

      workflowDaoHelper.createWorkflowFiles(workflow, workflow.getId(), false);

      this.commitTransaction(true, transactionStatus);

      return this.getById(workflow.getId());
    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to update InvoiceWorkflow: {}", e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  public void deleteWorkflow(final Long workflowId) throws IFlowStorageException {

    final TransactionStatus transactionStatus = this.startTransaction(true);
    try {
      this.workflowDaoHelper.deleteWorkflowDetails(workflowId, false);

      this.deleteModel(workflowId, "InvoiceWorkflow", "Delete from workflow where id=?", false, true);

      this.commitTransaction(true, transactionStatus);

    }
    catch (final Exception e) {
      this.rollbackTransaction(true, transactionStatus);
      logger.error("Unable to delete InvoiceWorkflow:{} {}", workflowId, e.toString(), e);
      throw new IFlowStorageException(e.toString(), e);
    }
  }

  @Override
  protected PreparedStatement prepareInsertPreparedStatement(final InvoiceWorkflow model, final PreparedStatement ps) throws SQLException {
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

  private PreparedStatement prepareInsertInvoicePreparedStatement(final InvoiceWorkflow model, final Long workflowId, final PreparedStatement ps) throws SQLException {

    ps.setLong(1, workflowId);
    ps.setString(2, model.getSender());
    ps.setString(3, model.getRegisterNumber());
    ps.setDate(4, Date.valueOf(model.getInvoceDate()));
    ps.setString(5, model.getPartnerCode());
    ps.setString(6, model.getVendorNumber());
    ps.setString(7, model.getVendorName());
    ps.setInt(8, model.getIsDirectDebitPermission() == Boolean.TRUE ? 1 : 0);
    ps.setInt(9, model.getInvoiceType().getValue());
    ps.setDate(10, Date.valueOf(model.getDiscountEnterDate()));
    ps.setDouble(11, model.getDiscountRate());
    ps.setInt(12, model.getDiscountDeadline());
    ps.setDate(13, Date.valueOf(model.getDiscountDate()));
    ps.setDouble(14, model.getPaymentAmount());

    return ps;
  }

  private PreparedStatement prepareUpdateInvoicePreparedStatement(final InvoiceWorkflow model, final PreparedStatement ps) throws SQLException {

    ps.setString(1, model.getSender());
    ps.setString(2, model.getRegisterNumber());
    ps.setDate(3, Date.valueOf(model.getInvoceDate()));
    ps.setString(4, model.getPartnerCode());
    ps.setString(5, model.getVendorNumber());
    ps.setString(6, model.getVendorName());
    ps.setInt(7, model.getIsDirectDebitPermission() == Boolean.TRUE ? 1 : 0);
    ps.setInt(8, model.getInvoiceType().getValue());
    ps.setDate(9, Date.valueOf(model.getDiscountEnterDate()));
    ps.setDouble(10, model.getDiscountRate());
    ps.setInt(11, model.getDiscountDeadline());
    ps.setDate(12, Date.valueOf(model.getDiscountDate()));
    ps.setDouble(13, model.getPaymentAmount());
    ps.setLong(14, model.getId());

    return ps;
  }

  @Override
  protected PreparedStatement prepareUpdatePreparedStatement(final InvoiceWorkflow model, final PreparedStatement ps) throws SQLException {
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
  public List<InvoiceWorkflow> getListForUserEmail(final String email, final int status) throws IFlowStorageException {

    logger.info("Dao read InvoiceWorkflow for user");

    final String sql =
                     "SELECT * FROM (workflow inner join invoice_workflow on invoice_workflow.workflow_id=workflow.id) where workflow.id in (select workflow_id from workflow_actions inner join users on users.id=workflow_actions.assign_to where users.email=?) "
                       + (status > -1 ? " and status=?" : "");

    final List<InvoiceWorkflow> workflowList = this.getModelListByIdentity(email, sql, "InvoiceWorkflow");

    return workflowList;
  }

  @Override
  public List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter) {
    logger.info("Dao search InvoiceWorkflow ");

    workflowDaoHelper.prepareWorkflowSearchFilter(workflowSearchFilter);
    List<Long> idList = new ArrayList<>();

    final String whereClause = this.prepareSearchWhereClause(workflowSearchFilter);

    final String searchSql = "SELECT * FROM (workflow inner join invoice_workflow on invoice_workflow.workflow_id=workflow.id) where "
                             + whereClause;

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
      throw new IFlowStorageException("Unable to search InvoiceWorkflow : " + e.toString());
    }

    final List<InvoiceWorkflow> workflowList = this.readWorkflowListFromIdList(idList);

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
      whereClause += " workflow_type_id in (" + StringUtils.repeat("?,", workflowSearchFilter.getWorkflowTypeIdentitySet().size())
                     + ") ";
    }

    whereClause = whereClause.replace(",)", ")");
    return whereClause;
  }

  @Override
  protected String generateIdentity(final InvoiceWorkflow model) {

    final Random rand = new Random();
    return String.format("t%sw%s-%s",
                         identityLongToHex(model.getWorkflowType().getId()),
                         identityLongToHex(System.currentTimeMillis()),
                         identityIntToHex(rand.nextInt(1000000), 6));
  }

}
