package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Repository
public class CompanyDao extends EntityDaoBase<CompanyEntity> implements ICompanyDao {

  public CompanyDao() {

  }

  @Override
  protected Class<CompanyEntity> entityClass() {

    return CompanyEntity.class;
  }

  @Override
  public List<CompanyWorkflowTypeControllerEntity> readCompanyWorkflowTypeController(final Long id) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<CompanyWorkflowTypeControllerEntity> query = criteriaBuilder.createQuery(CompanyWorkflowTypeControllerEntity.class);
    final Root<CompanyWorkflowTypeControllerEntity> root = query.from(CompanyWorkflowTypeControllerEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("id").get("companyId"), id);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowTypeControllerEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowTypeControllerEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity> readCompanyWorkflowtypeItemOcrSettings(final Long id) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowtypeItemOcrSettingEntity> query = criteriaBuilder.createQuery(CompanyWorkflowtypeItemOcrSettingEntity.class);
    final Root<CompanyWorkflowtypeItemOcrSettingEntity> root = query.from(CompanyWorkflowtypeItemOcrSettingEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("company").get("id"), id);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowtypeItemOcrSettingEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowtypeItemOcrSettingEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity> saveCompanyWorkflowtypeItemOcrSettings(final Long id,
      final List<CompanyWorkflowtypeItemOcrSettingEntity> list) {

    // TODO Auto-generated method stub
    return null;
  }

}
