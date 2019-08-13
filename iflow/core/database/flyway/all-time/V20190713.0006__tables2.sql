

DROP TABLE IF EXISTS `user_department_groups`;

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

