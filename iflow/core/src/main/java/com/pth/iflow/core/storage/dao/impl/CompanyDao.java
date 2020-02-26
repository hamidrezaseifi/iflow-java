package com.pth.iflow.core.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
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
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(final Long id) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowtypeItemOcrSettingPresetEntity> query = criteriaBuilder
            .createQuery(CompanyWorkflowtypeItemOcrSettingPresetEntity.class);
    final Root<
        CompanyWorkflowtypeItemOcrSettingPresetEntity> root = query.from(CompanyWorkflowtypeItemOcrSettingPresetEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("company").get("id"), id);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowtypeItemOcrSettingPresetEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity>
      readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(final String identity) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<
        CompanyWorkflowtypeItemOcrSettingPresetEntity> query = criteriaBuilder
            .createQuery(CompanyWorkflowtypeItemOcrSettingPresetEntity.class);
    final Root<
        CompanyWorkflowtypeItemOcrSettingPresetEntity> root = query.from(CompanyWorkflowtypeItemOcrSettingPresetEntity.class);
    query.select(root);

    final Predicate predicate = criteriaBuilder.equal(root.get("company").get("identity"), identity);
    query.where(predicate);

    final TypedQuery<CompanyWorkflowtypeItemOcrSettingPresetEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> results = typedQuery.getResultList();
    session.close();
    return results;
  }

  @Override
  @Transactional
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> list) {

    final Session session = this.createSession();

    final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> savedList = new ArrayList<>();

    for (final CompanyWorkflowtypeItemOcrSettingPresetEntity model : list) {
      if (model.isNew() == false) {
        for (final CompanyWorkflowtypeItemOcrSettingPresetItemEntity itemEntity : model.getItems()) {
          session.getTransaction().begin();

          final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
          final CriteriaDelete<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> criteriaDelete = criteriaBuilder
              .createCriteriaDelete(CompanyWorkflowtypeItemOcrSettingPresetItemEntity.class);

          final Root<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> root = criteriaDelete
              .from(CompanyWorkflowtypeItemOcrSettingPresetItemEntity.class);

          final Predicate pPropertyName = criteriaBuilder.equal(root.get("propertyName"), itemEntity.getPropertyName());
          final Predicate pCompany = criteriaBuilder.equal(root.get("preset").get("id"), model.getId());

          final Query<?> query = session.createQuery(criteriaDelete.where(criteriaBuilder.and(pPropertyName, pCompany)));

          query.executeUpdate();
          session.getTransaction().commit();
        }
      }
    }

    for (final CompanyWorkflowtypeItemOcrSettingPresetEntity model : list) {
      session.getTransaction().begin();

      session.persist(model);
      session.getTransaction().commit();
      savedList.add(model);
    }

    return savedList;
  }

}
