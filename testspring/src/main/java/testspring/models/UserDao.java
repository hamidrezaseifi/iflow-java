package testspring.models;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Transactional
  public UserEntity create(final UserEntity model) {

//default

    // Use below code on create/update
    // final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

    this.entityManager.getTransaction().begin();
    final UserEntity savedModel = this.entityManager.merge(model);
    this.entityManager.getTransaction().commit();
    return savedModel; // this.getById(model.getId());
  }

  public UserEntity getById(final Long id) {

    // final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

    final UserEntity dbModel = this.entityManager.find(UserEntity.class, id);

    return dbModel;
  }

  public UserGroupEntity getUserGroupEntityById(final Long id) {

    // final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

    final UserGroupEntity dbModel = this.entityManager.find(UserGroupEntity.class, id);

    return dbModel;
  }

  @Transactional
  public void deleteById(final Long id) {

    // final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

    final UserEntity entity = this.getById(id);

    if (entity != null) {

      this.entityManager.getTransaction().begin();
      this.entityManager.remove(entity);
      this.entityManager.getTransaction().commit();

    }

    // repository.deleteById(id);
    // repository.flush();
  }

}
