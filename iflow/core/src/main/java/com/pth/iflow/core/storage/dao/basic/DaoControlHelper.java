/**
 *
 */
package com.pth.iflow.core.storage.dao.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 */
public class DaoControlHelper {

  private static final Logger logger = LoggerFactory.getLogger(DaoControlHelper.class);

  static TransactionStatus createNewTransaction(@NonNull final PlatformTransactionManager platformTransactionManager) {
    final DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    return platformTransactionManager.getTransaction(defaultTransactionDefinition);
  }

  static void commitCurrentTransaction(@NonNull final PlatformTransactionManager platformTransactionManager,
      @NonNull final TransactionStatus transactionStatus) {
    platformTransactionManager.commit(transactionStatus);
  }

  static void rollbackCurrentTransaction(@NonNull final PlatformTransactionManager platformTransactionManager,
      @NonNull final TransactionStatus transactionStatus) {
    platformTransactionManager.rollback(transactionStatus);
  }

}
