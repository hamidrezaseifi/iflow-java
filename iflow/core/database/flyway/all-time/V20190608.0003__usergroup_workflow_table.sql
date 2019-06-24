
DROP TABLE IF EXISTS `user_usergroup`;

DROP TABLE IF EXISTS `user_group`;

DROP TABLE IF EXISTS `user_departments`;

DROP TABLE IF EXISTS `workflow_type_step`;

DROP TABLE IF EXISTS `workflow_type`;

DROP TABLE IF EXISTS `departments_group`;

DROP TABLE IF EXISTS `departments`;

DROP TABLE IF EXISTS `user_deputy`;

DROP TABLE IF EXISTS `users`;

DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifyid` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifyid_UNIQUE` (`identifyid`)
) ENGINE=InnoDB AUTO_INCREMENT=2;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` smallint(6) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_USERS_COMPANIES_idx` (`company_id`),
  CONSTRAINT `FK_USERS_COMPANIES` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3;

CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_USERGROUP_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_USERGROUP_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `user_usergroup` (
  `user_id` int(11) NOT NULL,
  `user_group` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`, `user_group`),
  KEY `FK_USERGROUPUSER_GROUP_idx` (`user_group`),
  CONSTRAINT `FK_USERGROUPUSER_GROUP` FOREIGN KEY (`user_group`) REFERENCES `user_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERGROUPUSER_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `workflow_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `workflow_base_type` int(11) NOT NULL DEFAULT '0',
  `title` varchar(200) NOT NULL,
  `commecnts` text,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWTYPE_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_WORKFLOWTYPE_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `workflow_type_step` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workflow_type_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `commecnts` text,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_WORKFLOWTYPESTEP_WORKFLOWTYPE_idx` (`workflow_type_id`),
  CONSTRAINT `FK_WORKFLOWTYPESTEP_WORKFLOWTYPE` FOREIGN KEY (`workflow_type_id`) REFERENCES `workflow_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL DEFAULT '1',
  `title` varchar(200) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_DEPARTMENTS_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_DEPARTMENTS_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `user_departments` (
  `user_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`department_id`),
  KEY `FK_USERDEPARTMENTS_DEPARTMENTS_idx` (`department_id`),
  CONSTRAINT `FK_USERDEPARTMENTS_DEPARTMENTS` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERDEPARTMENTS_USERS` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `departments_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '1',
  `version` int(11) NOT NULL DEFAULT '1',
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FK_DEPARTMENTGROUP_DEPARTMENT_idx` (`department_id`),
  CONSTRAINT `FK_DEPARTMENTGROUP_DEPARTMENT` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `user_deputy` (
  `user_id` int(11) NOT NULL,
  `deputy_id` int(11) NOT NULL,
  `created_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`user_id`,`deputy_id`),
  KEY `FK_USERDEPUTY_DEPUTY_idx` (`deputy_id`),
  CONSTRAINT `FK_USERDEPUTY_DEPUTY` FOREIGN KEY (`deputy_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERDEPUTY_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


