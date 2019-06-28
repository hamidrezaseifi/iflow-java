package com.pth.iflow.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.cahced.CompanyCached;
import com.pth.iflow.core.service.ICompanyCachedDataService;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@Service
public class CompanyCachedDataService implements ICompanyCachedDataService {

  private final Map<Long, CompanyCached> companies = new HashMap<>();

  private final ICompanyDao companyDao;
  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;
  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public CompanyCachedDataService(@Autowired final ICompanyDao companyDao, @Autowired final IUserDao userDao,
      @Autowired final IUserGroupDao userGroupDao, @Autowired final IDepartmentDao departmentDao,
      @Autowired final IDepartmentGroupDao departmentGroupDao, @Autowired final IWorkflowTypeDao workflowDao,
      @Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.workflowTypeDao = workflowDao;
    this.workflowTypeStepDao = workflowStepDao;

  }

  @Override
  public Company getById(final Long id) {

    return companies.keySet().contains(id) ? companies.get(id) : null;
  }

  @Override
  public Company getByIdentifyId(final String identifyId) {
    for (final Long id : companies.keySet()) {
      if (companies.get(id).getIdentifyid().equals(identifyId)) {
        return companies.get(id);
      }
    }

    return null;
  }

  @PostConstruct
  public void reload() {

    companies.clear();
    final List<Long> idList = companyDao.getAllCompanyIdList();
    for (final Long itemId : idList) {
      companies.put(itemId, loadCompanyCashed(itemId));
    }
  }

  protected CompanyCached loadCompanyCashed(final Long itemId) {
    final CompanyCached cashed = new CompanyCached(companyDao, userDao, userGroupDao, departmentDao, departmentGroupDao,
        workflowTypeDao, workflowTypeStepDao);
    cashed.setId(itemId);
    cashed.reload();
    return cashed;
  }

}
