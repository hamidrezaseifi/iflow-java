
CREATE TABLE `company_workflowtype_controller` (
  `company_id` int(11) NOT NULL,
  `workflow_type_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `priority` smallint(6) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`company_id`,`workflow_type_id`,`user_id`,`priority`),
  KEY `FK_COMPANY_WORKFLOWTYPE_CONTROLLER_WORKFLOWTYPE_idx` (`workflow_type_id`),
  KEY `FK_COMPANY_WORKFLOWTYPE_CONTROLLER_USER_idx` (`user_id`),
  CONSTRAINT `FK_COMPANY_WORKFLOWTYPE_CONTROLLER_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_COMPANY_WORKFLOWTYPE_CONTROLLER_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_COMPANY_WORKFLOWTYPE_CONTROLLER_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO `iflow`.`company_workflowtype_controller` (`company_id`, `workflow_type_id`, `user_id`, `priority`) VALUES ('1', '1', '1', '1');
INSERT INTO `iflow`.`company_workflowtype_controller` (`company_id`, `workflow_type_id`, `user_id`, `priority`) VALUES ('1', '2', '1', '1');
INSERT INTO `iflow`.`company_workflowtype_controller` (`company_id`, `workflow_type_id`, `user_id`, `priority`) VALUES ('1', '3', '1', '1');
INSERT INTO `iflow`.`company_workflowtype_controller` (`company_id`, `workflow_type_id`, `user_id`, `priority`) VALUES ('1', '1', '2', '2');
INSERT INTO `iflow`.`company_workflowtype_controller` (`company_id`, `workflow_type_id`, `user_id`, `priority`) VALUES ('1', '3', '2', '2');


