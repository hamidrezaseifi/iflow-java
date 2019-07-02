
DROP TABLE IF EXISTS `workflow_files`;

DROP TABLE IF EXISTS `workflow_actions`;

DROP TABLE IF EXISTS `workflow`;

CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_type_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `current_step` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `comments` text DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `created_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
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
  `action` varchar(200) DEFAULT NULL,
  `old_step` int(11) NOT NULL DEFAULT 0,
  `new_step` int(11) NOT NULL DEFAULT 0,
  `created_by` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT 1,
  `created_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
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
  `comments` text DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT 1,
  `version` int(11) NOT NULL DEFAULT 1,
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWFILE_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_WORKFLOWFILE_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOWFILE_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOWFILE_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB;

