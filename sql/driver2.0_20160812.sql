/*
SQLyog Community
MySQL - 5.6.26 : Database - drivers
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `cadet` */

DROP TABLE IF EXISTS `cadet`;

CREATE TABLE `cadet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `weixin_num` varchar(20) DEFAULT NULL COMMENT '微信号',
  `idcard_num` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学员信息';

/*Data for the table `cadet` */

insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`phone`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values 
(1,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','2016-08-11 12:16:59','2016-08-11 12:16:59',1),
(3,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(4,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(5,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(6,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(7,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(8,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(9,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(10,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1),
(11,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);

/*Table structure for table `cadet_course` */

DROP TABLE IF EXISTS `cadet_course`;

CREATE TABLE `cadet_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `course` tinyint(1) NOT NULL COMMENT '目前课程',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员信息_课程情况';

/*Data for the table `cadet_course` */

/*Table structure for table `cadet_pay` */

DROP TABLE IF EXISTS `cadet_pay`;

CREATE TABLE `cadet_pay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `pay_status` tinyint(1) NOT NULL COMMENT '缴费状态',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员信息_缴费信息';

/*Data for the table `cadet_pay` */

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `name` varchar(20) NOT NULL COMMENT '驾校名称',
  `logo` tinyblob COMMENT '驾校logo',
  `logo_url` varchar(100) DEFAULT NULL COMMENT '驾校logo地址',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) DEFAULT NULL COMMENT '电子邮箱',
  `addr` varchar(50) DEFAULT NULL COMMENT '驾校地址',
  `introduction` text COMMENT '驾校简介',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='驾校信息';

/*Data for the table `school` */

insert  into `school`(`id`,`name`,`logo`,`logo_url`,`mobile`,`phone`,`email`,`addr`,`introduction`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values 
(1,'驾校23',NULL,NULL,'12345678123','12345678123','12345678123','12345678123',NULL,'admin','admin','2016-08-12 11:17:03','2016-08-12 18:49:47',1);

/*Table structure for table `school_tuition` */

DROP TABLE IF EXISTS `school_tuition`;

CREATE TABLE `school_tuition` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `school_id` bigint(20) NOT NULL COMMENT '驾校信息数据ID',
  `tuition` decimal(10,0) NOT NULL COMMENT '学费',
  `tuition_explain` varchar(100) DEFAULT NULL COMMENT '学费说明',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='驾校信息_学费信息';

/*Data for the table `school_tuition` */

/*Table structure for table `suggestion` */

DROP TABLE IF EXISTS `suggestion`;

CREATE TABLE `suggestion` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) DEFAULT NULL COMMENT '学员信息数据ID',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `content` text COMMENT '投诉内容',
  `business_status` tinyint(1) DEFAULT NULL COMMENT '业务状态',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉建议';

/*Data for the table `suggestion` */

/*Table structure for table `suggestion_feekback` */

DROP TABLE IF EXISTS `suggestion_feekback`;

CREATE TABLE `suggestion_feekback` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `suggestion_id` bigint(20) NOT NULL COMMENT '投诉建议数据ID',
  `content` text COMMENT '反馈信息',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉建议_反馈信息';

/*Data for the table `suggestion_feekback` */

/*Table structure for table `sys_manager` */

DROP TABLE IF EXISTS `sys_manager`;

CREATE TABLE `sys_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `avatar_url` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统管理员信息';

/*Data for the table `sys_manager` */

insert  into `sys_manager`(`id`,`username`,`password`,`avatar_url`,`name`,`age`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values 
(1,'admin','admin',NULL,'admin',27,'admin','admin','2016-08-12 16:01:37','2016-08-12 16:01:37',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
