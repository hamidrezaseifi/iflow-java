package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;

import com.pth.iflow.common.enums.EUserDepartmentMemberType;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@NamedQueries(
  {
      @NamedQuery(
                  name = "findDepartmentMember", query = "u from (DepartmentEntity d inner join UserDepartmentEntity ud on d.id = ud.department_id) "
                      + "inner join UserEntity u on u.id=ud.user_id where d.identity = :identity and ud.member_type = :memtype", fetchSize = 1, readOnly = true
      )
  }
)

@Repository
public class DepartmentDao extends EntityDaoBase<DepartmentEntity> implements IDepartmentDao {

  @Override
  protected Class<DepartmentEntity> entityClass() {

    return DepartmentEntity.class;
  }

  @Override
  public List<DepartmentEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<DepartmentEntity> query = criteriaBuilder.createQuery(DepartmentEntity.class);
    final Root<DepartmentEntity> root = query.from(DepartmentEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<DepartmentEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<DepartmentEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;

  }

  @Override
  public UserEntity getDepartmentManager(final String identity) {

    final EntityManager entityManager = createEntityManager();
    final TypedQuery<UserEntity> query = entityManager.createNamedQuery("findEmployeeByName", UserEntity.class);
    query.setParameter("identity", identity);
    query.setParameter("memtype", EUserDepartmentMemberType.MANAGER.getValue());

    final List<UserEntity> results = query.getResultList();

    entityManager.close();

    return results.size() > 0 ? results.get(0) : null;
  }

  @Override
  public UserEntity getDepartmentDeputy(final String identity) {

    final EntityManager entityManager = createEntityManager();
    final TypedQuery<UserEntity> query = entityManager.createNamedQuery("findEmployeeByName", UserEntity.class);
    query.setParameter("identity", identity);
    query.setParameter("memtype", EUserDepartmentMemberType.DEPUTY.getValue());

    final List<UserEntity> results = query.getResultList();

    entityManager.close();

    return results.size() > 0 ? results.get(0) : null;
  }

}
