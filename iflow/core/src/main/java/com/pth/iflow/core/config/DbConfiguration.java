package com.pth.iflow.core.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
@PropertySource("classpath:config/db.properties")
public class DbConfiguration {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Value("${poolName}")
  private String       poolName;

  @Value("${jdbcUrl}")
  private String       jdbcUrl;

  @Value("${dbUserName}")
  private String       dbUserName;

  @Value("${password}")
  private String       password;

  @Value("${minIdleConnections}")
  private Integer      minIdleConnections;

  @Value("${maxPoolSize}")
  private Integer      maxPoolSize;

  @Value("${cachePreparedStatements}")
  private Boolean      cachePreparedStatements;

  @Value("${preparedStatementsCacheSize}")
  private Integer      preparedStatementsCacheSize;

  @Value("${preparedStatementsCacheSqlLimit}")
  private Integer      preparedStatementsCacheSqlLimit;

  @Value("${useServerSidePreparedStatements}")
  private Boolean      useServerSidePreparedStatements;

  @Value("${className}")
  private String       className;

  @Bean
  public DataSource dataSource() {
    log.info("DB config: {}@{}", dbUserName, jdbcUrl);

    final HikariConfig configuration = new HikariConfig();
    configuration.setAutoCommit(false);
    configuration.setPoolName(poolName);
    configuration.setDriverClassName(className);
    configuration.setMinimumIdle(minIdleConnections);
    configuration.setJdbcUrl(jdbcUrl);
    configuration.setIdleTimeout(120000L);
    configuration.setMaximumPoolSize(maxPoolSize);
    configuration.setUsername(dbUserName);
    configuration.setPassword(password);
    configuration.setTransactionIsolation("TRANSACTION_READ_COMMITTED");

    configuration.addDataSourceProperty("cachePrepStmts", this.cachePreparedStatements);
    configuration.addDataSourceProperty("prepStmtCacheSize", this.preparedStatementsCacheSize);
    configuration.addDataSourceProperty("prepStmtCacheSqlLimit", this.preparedStatementsCacheSqlLimit);
    configuration.addDataSourceProperty("useServerPrepStmts", this.useServerSidePreparedStatements);

    final HikariDataSource ds = new HikariDataSource(configuration);
    ds.validate();
    return ds;
  }

  public String getPoolName() {
    return poolName;
  }

  public void setPoolName(final String poolName) {
    this.poolName = poolName;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public void setJdbcUrl(final String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
  }

  public String getDbUserName() {
    return dbUserName;
  }

  public void setDbUserName(final String dbUserName) {
    this.dbUserName = dbUserName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public Integer getMinIdleConnections() {
    return minIdleConnections;
  }

  public void setMinIdleConnections(final Integer minIdleConnections) {
    this.minIdleConnections = minIdleConnections;
  }

  public Integer getMaxPoolSize() {
    return maxPoolSize;
  }

  public void setMaxPoolSize(final Integer maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public Boolean getCachePreparedStatements() {
    return cachePreparedStatements;
  }

  public void setCachePreparedStatements(final Boolean cachePreparedStatements) {
    this.cachePreparedStatements = cachePreparedStatements;
  }

  public Integer getPreparedStatementsCacheSize() {
    return preparedStatementsCacheSize;
  }

  public void setPreparedStatementsCacheSize(final Integer preparedStatementsCacheSize) {
    this.preparedStatementsCacheSize = preparedStatementsCacheSize;
  }

  public Integer getPreparedStatementsCacheSqlLimit() {
    return preparedStatementsCacheSqlLimit;
  }

  public void setPreparedStatementsCacheSqlLimit(final Integer preparedStatementsCacheSqlLimit) {
    this.preparedStatementsCacheSqlLimit = preparedStatementsCacheSqlLimit;
  }

  public Boolean getUseServerSidePreparedStatements() {
    return useServerSidePreparedStatements;
  }

  public void setUseServerSidePreparedStatements(final Boolean useServerSidePreparedStatements) {
    this.useServerSidePreparedStatements = useServerSidePreparedStatements;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(final String className) {
    this.className = className;
  }

  public static EntityManager getEntityManager() {

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.pth.iflow.core");

    final EntityManager entityManager = emf.createEntityManager();

    // entityManager.setProperty(propertyName, value);

    return entityManager;
  }

}
