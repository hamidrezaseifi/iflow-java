package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeOcrSettingPresetEntity;
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
  public List<CompanyWorkflowTypeOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(final Long id) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowTypeOcrSettingPresetEntity> query = criteriaBuilder
            .createQuery(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    final Root<
        CompanyWorkflowTypeOcrSettingPresetEntity> root = query.from(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("company").get("id"), id);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowTypeOcrSettingPresetEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowTypeOcrSettingPresetEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  public List<CompanyWorkflowTypeOcrSettingPresetEntity>
      readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(final String identity) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowTypeOcrSettingPresetEntity> query = criteriaBuilder
            .createQuery(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    final Root<
        CompanyWorkflowTypeOcrSettingPresetEntity> root = query.from(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("company").get("identity"), identity);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowTypeOcrSettingPresetEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowTypeOcrSettingPresetEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  @Transactional
  public CompanyWorkflowTypeOcrSettingPresetEntity
      saveCompanyWorkflowtypeItemOcrSetting(final CompanyWorkflowTypeOcrSettingPresetEntity model) {

    if (model.isIdentityNew()) {

      model.setIdentity(model.generateIdentity());

    }

    if (model.isNew() == false) {
      final Session session = this.createSession();
      final CompanyWorkflowTypeOcrSettingPresetEntity existsModel = session
          .get(CompanyWorkflowTypeOcrSettingPresetEntity.class, model.getId());

      session.getTransaction().begin();
      existsModel.clearItems();
      session.saveOrUpdate(existsModel);
      session.getTransaction().commit();
      session.close();
    }

    final Session session = this.createSession();

    session.getTransaction().begin();

    session.saveOrUpdate(model);
    session.getTransaction().commit();
    session.close();

    return model;
  }

  @Override
  public CompanyWorkflowTypeOcrSettingPresetEntity readOcrSettingsByIdentity(final String identity) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowTypeOcrSettingPresetEntity> query = criteriaBuilder
            .createQuery(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    final Root<
        CompanyWorkflowTypeOcrSettingPresetEntity> root = query.from(CompanyWorkflowTypeOcrSettingPresetEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("identity"), identity);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowTypeOcrSettingPresetEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowTypeOcrSettingPresetEntity> results = typedQuery.getResultList();
    session.close();
    return results.size() > 0 ? results.get(0) : null;
  }

}
