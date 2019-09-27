

DROP TABLE IF EXISTS `user_department_groups`;

DROP TABLE IF EXISTS `user_roles`;

DROP TABLE IF EXISTS `invoice_workflow`;

CREATE TABLE `user_department_groups` (
  `user_id` int(11) NOT NULL,
  `department_group_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`department_group_id`)
) ENGINE=InnoDB;


CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`user_id`,`role`)
) ENGINE=InnoDB;

CREATE TABLE `invoice_workflow` (
  `workflow_id` int(11) NOT NULL,
  `sender` varchar(80) NOT NULL,
  `ext_reg_number` varchar(45) DEFAULT NULL,
  `invoce_date` date DEFAULT NULL,
  `partner_code` varchar(45) DEFAULT NULL,
  `vendor_number` varchar(45) DEFAULT NULL,
  `vendor_name` varchar(45) DEFAULT NULL,
  `contract` varchar(45) DEFAULT NULL,
  `direct_debit` smallint(6) NOT NULL DEFAULT '0',
  `workman_invoice` smallint(6) NOT NULL DEFAULT '0',
  `ending_invoice` smallint(6) NOT NULL DEFAULT '0',
  `discount_entry` date NOT NULL,
  `discount_rate` int(11) NOT NULL DEFAULT '0',
  `discount_deadline` int(11) NOT NULL DEFAULT '0',
  `discount_date` date NOT NULL,
  `assignments` varchar(500) DEFAULT NULL,
  `payment_amount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`workflow_id`)
) ENGINE=InnoDB;

ALTER TABLE `iflow`.`workflow_type` 
CHANGE COLUMN `manual_assign` `assign_type` SMALLINT(2) NOT NULL DEFAULT 1 ;


UPDATE `iflow`.`workflow_type` SET `assign_type` = '1' WHERE (`id` = '1');
UPDATE `iflow`.`workflow_type` SET `assign_type` = '1' WHERE (`id` = '2');

INSERT INTO `workflow_type` VALUES (3,1,0,'Rechung Wrokflow',2,0,1,1,NULL,1,1,'2019-09-22 16:57:54.654451','2019-09-22 16:57:54.654451');

INSERT INTO `workflow_type_step` VALUES (7,3,'Rechungsverteilung',1,'workflow/invoice_assign',NULL,1,1,'2019-09-22 17:04:52.329953','2019-09-22 17:04:52.329953'),(8,3,'Rechungsprüfung ',2,'workflow/invoice_testing',NULL,1,1,'2019-09-22 17:04:52.331101','2019-09-22 17:04:52.331101'),(9,3,'Rechungsfreigabe ',3,'workflow/invoice_release',NULL,1,1,'2019-09-22 17:04:52.331350','2019-09-22 17:04:52.331350');

CREATE TABLE `workflow_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message` varchar(500) NOT NULL DEFAULT 'no message',
  `created_by` int(11) NOT NULL,
  `message_type` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) DEFAULT NULL,
  `expire_days` smallint(6) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWOFFER_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_WORKFLOWOFFER_USER_idx` (`user_id`),
  CONSTRAINT `FK_WORKFLOWOFFER_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FK_WORKFLOWOFFER_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB;

INSERT INTO `iflow`.`workflow_message` (`workflow_id`, `user_id`, `created_by`, `status`, `expire_days`) VALUES ('2', '1', '1', '1', '10'), ('3', '1', '1', '1', '20');

