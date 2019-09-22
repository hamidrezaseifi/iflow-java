

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

