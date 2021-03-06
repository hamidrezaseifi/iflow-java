package com.pth.iflow.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config/db.properties")
public class HibernateConfig {

  @Value("${poolName}")
  private String poolName;

  @Value("${jdbcUrl}")
  private String jdbcUrl;

  @Value("${dbUserName}")
  private String dbUserName;

  @Value("${password}")
  private String password;

  @Value("${minIdleConnections}")
  private Integer minIdleConnections;

  @Value("${maxPoolSize}")
  private Integer maxPoolSize;

  @Value("${cachePreparedStatements}")
  private Boolean cachePreparedStatements;

  @Value("${preparedStatementsCacheSize}")
  private Integer preparedStatementsCacheSize;

  @Value("${preparedStatementsCacheSqlLimit}")
  private Integer preparedStatementsCacheSqlLimit;

  @Value("${useServerSidePreparedStatements}")
  private Boolean useServerSidePreparedStatements;

  @Value("${className}")
  private String className;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {

    final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

    sessionFactory.setDataSource(this.restDataSource());
    sessionFactory.setPackagesToScan(new String[] { "com.pth.iflow.core.model.entity", "com.pth.iflow.core.model.entity.workflow" });
    sessionFactory.setHibernateProperties(HibernateConfig.hibernateProperties());

    return sessionFactory;
  }

  @Bean
  public DataSource restDataSource() {

    final HikariConfig configuration = new HikariConfig();
    configuration.setAutoCommit(false);
    configuration.setPoolName(this.poolName);
    configuration.setDriverClassName(this.className);
    configuration.setMinimumIdle(this.minIdleConnections);
    configuration.setJdbcUrl(this.jdbcUrl);
    configuration.setIdleTimeout(600000);
    configuration.setMaximumPoolSize(this.maxPoolSize);
    configuration.setUsername(this.dbUserName);
    configuration.setPassword(this.password);
    configuration.setTransactionIsolation("TRANSACTION_READ_COMMITTED");
    configuration.setMaxLifetime(30000);
    configuration.setConnectionTimeout(30000);
    configuration.setInitializationFailTimeout(600000);

    configuration.addDataSourceProperty("cachePrepStmts", this.cachePreparedStatements);
    configuration.addDataSourceProperty("prepStmtCacheSize", this.preparedStatementsCacheSize);
    configuration.addDataSourceProperty("prepStmtCacheSqlLimit", this.preparedStatementsCacheSqlLimit);
    configuration.addDataSourceProperty("useServerPrepStmts", this.useServerSidePreparedStatements);

    final HikariDataSource ds = new HikariDataSource(configuration);
    ds.validate();
    return ds;
  }

  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {

    final HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);
    return txManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

    final PersistenceExceptionTranslationPostProcessor proc = new PersistenceExceptionTranslationPostProcessor();

    return proc;
  }

  /*
   * @Bean public EntityManager entityManager(final LocalSessionFactoryBean sessionFactory) {
   *
   * return sessionFactory.getObject().createEntityManager(); }
   */

  public static Properties hibernateProperties() {

    return new Properties() {

      /**
      *
      */
      private static final long serialVersionUID = 1L;

      {
        this.setProperty("hibernate.hbm2ddl.auto", "none");
        this.setProperty("hibernate.show_sql", "true");
        this.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        this.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");

      }
    };
  }
}
