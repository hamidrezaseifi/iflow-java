

DROP TABLE IF EXISTS `workflow_files_versions`;

DROP TABLE IF EXISTS `workflow_properties_value`;

DROP TABLE IF EXISTS `workflow_files`;

DROP TABLE IF EXISTS `workflow_actions`;

DROP TABLE IF EXISTS `workflow`;

DROP TABLE IF EXISTS `workflow_type_step`;

DROP TABLE IF EXISTS `workflow_type_properties`;

DROP TABLE IF EXISTS `workflow_type`;

DROP TABLE IF EXISTS `user_usergroup`;

DROP TABLE IF EXISTS `user_deputy`;

DROP TABLE IF EXISTS `user_department_groups`;

DROP TABLE IF EXISTS `user_departments`;

DROP TABLE IF EXISTS `departments_group`;

DROP TABLE IF EXISTS `departments`;

DROP TABLE IF EXISTS `user_group`;

DROP TABLE IF EXISTS `users`;

DROP TABLE IF EXISTS `companies`;

 
CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`)
) ENGINE=InnoDB AUTO_INCREMENT=2 ;


CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `title` varchar(200) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_DEPARTMENTS_COMPANY_idx` (`company_id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  CONSTRAINT `FK_DEPARTMENTS_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 ;


 
CREATE TABLE `departments_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_DEPARTMENTGROUP_DEPARTMENT_idx` (`department_id`),
  CONSTRAINT `FK_DEPARTMENTGROUP_DEPARTMENT` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 ;


 
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birthdate` date DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '-',
  `firstname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` smallint(6) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_USERS_COMPANIES_idx` (`company_id`),
  CONSTRAINT `FK_USERS_COMPANIES` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

 
CREATE TABLE `user_departments` (
  `user_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`department_id`),
  KEY `FK_USERDEPARTMENTS_DEPARTMENTS_idx` (`department_id`),
  CONSTRAINT `FK_USERDEPARTMENTS_DEPARTMENTS` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERDEPARTMENTS_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;

CREATE TABLE `user_department_groups` (
  `user_id` int(11) NOT NULL,
  `department_group_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`department_group_id`),
  KEY `FK_USERDEPARTMENTGROUPS_DEPARTMENTS_idx` (`department_group_id`),
  CONSTRAINT `FK_USERDEPARTMENTGROUPS_DEPARTMENTGROUPS` FOREIGN KEY (`department_group_id`) REFERENCES `departments_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERDEPARTMENTGROUPS_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

 
CREATE TABLE `user_deputy` (
  `user_id` int(11) NOT NULL,
  `deputy_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`deputy_id`),
  KEY `FK_USERDEPUTY_DEPUTY_idx` (`deputy_id`),
  CONSTRAINT `FK_USERDEPUTY_DEPUTY` FOREIGN KEY (`deputy_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERDEPUTY_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;


 
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_USERGROUP_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_USERGROUP_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 ;

 
CREATE TABLE `user_usergroup` (
  `user_id` int(11) NOT NULL,
  `user_group` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`user_group`),
  KEY `FK_USERGROUPUSER_GROUP_idx` (`user_group`),
  CONSTRAINT `FK_USERGROUPUSER_GROUP` FOREIGN KEY (`user_group`) REFERENCES `user_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERGROUPUSER_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;



CREATE TABLE `workflow_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `workflow_base_type` varchar(45) NOT NULL DEFAULT '0',
  `title` varchar(200) NOT NULL,
  `assign_type` SMALLINT(2) NOT NULL DEFAULT 1,
  `send_to_controller` smallint(2) NOT NULL DEFAULT '1',
  `increase_step_automatic` smallint(2) DEFAULT '0',
  `allow_assign` smallint(2) DEFAULT '0',
  `commecnts` text,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_WORKFLOWTYPE_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_WORKFLOWTYPE_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 ;

 
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
) ENGINE=InnoDB ;


 
CREATE TABLE `workflow_type_step` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `workflow_type_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `step_index` smallint(6) NOT NULL DEFAULT 0,
  `view_name` varchar(150) NOT NULL DEFAULT '-',
  `expire_days` smallint(6) NOT NULL,
  `commecnts` text,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_WORKFLOWTYPESTEP_WORKFLOWTYPE_idx` (`workflow_type_id`),
  CONSTRAINT `FK_WORKFLOWTYPESTEP_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;

 
CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(45) DEFAULT NULL,
  `workflow_type_id` int(11) NOT NULL,
  `current_step` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `comments` text,
  `controller` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_WORKFLOW_WORKFLOWTYPE_idx` (`workflow_type_id`),
  KEY `FK_WORKFLOW_WORKFLOWTYPESTEP_idx` (`current_step`),
  KEY `FK_WORKFLOW_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOW_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOW_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOW_WORKFLOWTYPESTEP` FOREIGN KEY (`current_step`) REFERENCES `workflow_type_step` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 ;

 
CREATE TABLE `workflow_actions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `assign_to` int(11) NOT NULL DEFAULT '0',
  `current_step_id` int(11) NOT NULL DEFAULT '0',
  `comments` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_WORKFLOWACTION_WORKFLOW_idx` (`workflow_id`),
  CONSTRAINT `FK_WORKFLOWACTION_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 ;

 
CREATE TABLE `workflow_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `extention` varchar(10) NOT NULL,
  `active_filepath` varchar(500) NOT NULL,
  `comments` text,
  `active_version` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  KEY `FK_WORKFLOWFILE_WORKFLOW_idx` (`workflow_id`),
  KEY `FK_WORKFLOWFILE_USERS_idx` (`created_by`),
  CONSTRAINT `FK_WORKFLOWFILE_USERS` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WORKFLOWFILE_WORKFLOW` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 ;

 
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
) ENGINE=InnoDB ;


CREATE TABLE `workflow_files_versions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_file_id` int(11) NOT NULL,
  `filepath` varchar(500) NOT NULL,
  `comments` text,
  `file_version` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWFILEVERSION_WORKFLOWFILE_idx` (`workflow_file_id`),
  CONSTRAINT `FK_WORKFLOWFILEVERSION_WORKFLOWFILE` FOREIGN KEY (`workflow_file_id`) REFERENCES `workflow_files` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


