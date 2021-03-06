CREATE TABLE `sample_resource` (
  `id` varchar(32) NOT NULL,
  `list` int(11) NOT NULL,
  `logo_pic` varchar(100) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  `menu_type` varchar(10) NOT NULL,
  `name` varchar(200) NOT NULL,
  `request_method` varchar(10) NOT NULL,
  `type_code` varchar(20) NOT NULL,
  `url` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_role` (
  `id` varchar(32) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `list` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `system` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `SAMPLE_ROLE_UK` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_role_resource` (
  `id` varchar(32) NOT NULL,
  `resource_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SAMPLE_ROLE_RESOURCE_RES_FK` (`resource_id`),
  KEY `SAMPLE_ROLE_RESOURCE_ROLE_FK` (`role_id`),
  CONSTRAINT `SAMPLE_ROLE_RESOURCE_RES_FK` FOREIGN KEY (`resource_id`) REFERENCES `sample_resource` (`id`),
  CONSTRAINT `SAMPLE_ROLE_RESOURCE_ROLE_FK` FOREIGN KEY (`role_id`) REFERENCES `sample_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_user` (
  `id` varchar(32) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `login_name` varchar(20) NOT NULL,
  `male` bit(1) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `name_py` varchar(100) NOT NULL,
  `passwd` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `SAMPLE_USER_UK` (`login_name`),
  KEY `SAMPLE_USER_ROLE_FK` (`role_id`),
  CONSTRAINT `SAMPLE_USER_ROLE_FK` FOREIGN KEY (`role_id`) REFERENCES `sample_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_schedule_log` (
  `id` varchar(32) NOT NULL,
  `by_system` bit(1) NOT NULL,
  `current_cron` varchar(50) NOT NULL,
  `end_time` datetime NOT NULL,
  `exec_time` bigint(20) NOT NULL,
  `start_time` datetime NOT NULL,
  `task_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SAMPLE_SCHEDULE_LOG_IX1` (`exec_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_system_info` (
  `id` varchar(32) NOT NULL,
  `conf_type` varchar(20) NOT NULL,
  `json_str` varchar(4000) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  `ziped` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `SAMPLE_SYSTEM_INFO_UK` (`conf_type`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_system_log` (
  `id` varchar(32) NOT NULL,
  `info` varchar(300) NOT NULL,
  `ip` varchar(50) NOT NULL,
  `log_type` varchar(10) NOT NULL,
  `optime` datetime NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SAMPLE_SYS_LOG_USER_FK` (`user_id`),
  KEY `SAMPLE_SYS_LOG_IX1` (`log_type`),
  CONSTRAINT `SAMPLE_SYS_LOG_USER_FK` FOREIGN KEY (`user_id`) REFERENCES `sample_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sample_cron_exclusive_task` (
  `id` varchar(200) NOT NULL,
  `running` int(1) NOT NULL DEFAULT '0',
  `update_time` datetime NOT NULL,
  `node_tag` varchar(100) NOT NULL,
  `md5` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

