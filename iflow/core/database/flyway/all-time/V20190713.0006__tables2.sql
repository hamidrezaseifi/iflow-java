

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
  `direct_debit_permission` smallint(6) NOT NULL DEFAULT '0',
  `invoice_type` smallint(6) NOT NULL DEFAULT '1',
  `discount_enter` date NOT NULL,
  `discount_rate` double NOT NULL DEFAULT '0',
  `discount_deadline` int(11) NOT NULL DEFAULT '0',
  `discount_date` date NOT NULL,
  `payment_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`workflow_id`)
) ENGINE=InnoDB;


INSERT INTO `workflow_type`(id, identity, company_id, workflow_base_type, title, assign_type, send_to_controller, increase_step_automatic, allow_assign, commecnts, status, version) VALUES (1, 'singletaskworkflowtype', 1,'','Einzel Aufgabe',1,1,1,0,NULL,1,1);
INSERT INTO `workflow_type`(id, identity, company_id, workflow_base_type, title, assign_type, send_to_controller, increase_step_automatic, allow_assign, commecnts, status, version) VALUES (2,'threetaskworkflowtype', 1,'','Drei Schritt Aufgabe',2,0,1,1,NULL,1,1);
INSERT INTO `workflow_type`(id, identity, company_id, workflow_base_type, title, assign_type, send_to_controller, increase_step_automatic, allow_assign, commecnts, status, version) VALUES (3,'invoiceworkflowtype', 1,'','Rechnung Wrokflow',2,0,1,1,NULL,1,1);

INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (1,'singletasktypestep', 1,'Augabe',1,'workflow/edit',15,NULL,1,1);

INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (2,'threetasktype1step', 2,'Schritt 1',1,'workflow/edit',15,NULL,1,1);
INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (3,'threetasktype1step', 2,'Schritt 2',2,'workflow/edit',15,NULL,1,1);
INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (4,'threetasktype1step', 2,'Schritt 3',3,'workflow/edit',15,NULL,1,1);

INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (5,'invocetasktype1step', 3,'Rechungsverteilung',1,'workflow/invoce/invoice_assign',15,NULL,1,1);
INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (6,'invocetasktype1step', 3,'Rechungsprüfung',2,'workflow/invoce/invoice_testing',15,NULL,1,1);
INSERT INTO `workflow_type_step`(id, identity, workflow_type_id, title, step_index, view_name, expire_days, commecnts, status, version) VALUES (7,'invocetasktype1step', 3,'Rechungsfreigabe',3,'workflow/invoce/invoice_release',15,NULL,1,1);

CREATE TABLE `workflow_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `step_id` int(11) NOT NULL DEFAULT '0',
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



