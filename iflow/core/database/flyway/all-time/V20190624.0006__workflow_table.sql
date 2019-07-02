
DROP TABLE IF EXISTS `workflow_properties_value`;

DROP TABLE IF EXISTS `workflow_files`;

DROP TABLE IF EXISTS `workflow_actions`;

DROP TABLE IF EXISTS `workflow_type_properties`;

DROP TABLE IF EXISTS `workflow`;

CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_type_id` int(11) NOT NULL,
  `title` varchar(2000) NOT NULL,
  `current_step` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `comments` text,
  `controller` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOW_WORKFLOWTYPE_idx` (`workflow_type_id`),
  KEY `FK_WORKFLOW_WORKFLOWTYPESTEP_idx` (`current_step`),
  KEY `FK_WORKFLOW_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOW_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOW_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOW_WORKFLOWTYPESTEP` FOREIGN KEY (`current_step`) REFERENCES `workflow_type_step` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `workflow_actions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `action` varchar(2000) DEFAULT NULL,
  `old_step` int(11) NOT NULL DEFAULT '0',
  `new_step` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(45) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWACTION_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_WORKFLOWACTION_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOWACTION_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOWACTION_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `workflow_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `tilte` varchar(200) NOT NULL,
  `filepath` varchar(500) NOT NULL,
  `comments` text,
  `file_version` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWFILE_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_WORKFLOWFILE_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOWFILE_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOWFILE_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `workflow_type_properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(50) NOT NULL,
  `workflow_type_id` int(11) NOT NULL,
  `property_type` smallint(6) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWTYPEPROPERTY_WORKFLOWTYPE_idx` (`workflow_type_id`),
  CONSTRAINT `FK_WORKFLOWTYPEPROPERTY_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `workflow_properties_value` (
  `workflow_properties_id` int(11) NOT NULL,
  `workflow_id` int(11) NOT NULL,
  `property_value_str` varchar(2000) DEFAULT NULL,
  `property_value_int` int(11) NOT NULL DEFAULT '0',
  `created_by` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`workflow_properties_id`,`workflow_id`),
  KEY `FK_WORKFLOWPROPERTYVALUE_WORKFLOW_idx` (`workflow_id`),
  CONSTRAINT `FK_WORKFLOWPROPERTYVALUE_PROPERTY` FOREIGN KEY (`workflow_properties_id`) REFERENCES `workflow_type_properties` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOWPROPERTYVALUE_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;




