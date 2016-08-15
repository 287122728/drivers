/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.26 : Database - drivers
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drivers` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `cadet` */

CREATE TABLE `cadet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码',
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

insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','2016-08-11 12:16:59','2016-08-11 12:16:59',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (3,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (4,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (5,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (6,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (7,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (8,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (9,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (10,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);
insert  into `cadet`(`id`,`username`,`password`,`name`,`age`,`mobile`,`weixin_num`,`idcard_num`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (11,'a','a','a',21,'18782271111','18782271111','18782271111','admin','admin','2016-08-11 11:18:05','2016-08-11 11:18:05',1);

/*Table structure for table `cadet_course` */

CREATE TABLE `cadet_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `course` tinyint(1) NOT NULL COMMENT '目前课程',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学员信息_课程情况';

/*Data for the table `cadet_course` */

insert  into `cadet_course`(`id`,`cadet_id`,`course`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,1,'admin','admin','2016-08-13 17:23:06','2016-08-13 17:23:06');
insert  into `cadet_course`(`id`,`cadet_id`,`course`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (2,2,2,'admin','admin','2016-08-13 17:23:20','2016-08-13 17:23:20');

/*Table structure for table `cadet_pay` */

CREATE TABLE `cadet_pay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `pay_status` tinyint(1) NOT NULL COMMENT '缴费状态',
  `pay_amount` decimal(10,0) DEFAULT NULL COMMENT '缴费金额',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学员信息_缴费信息';

/*Data for the table `cadet_pay` */

insert  into `cadet_pay`(`id`,`cadet_id`,`pay_status`,`pay_amount`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,1,'3500','admin','admin','2016-08-13 17:23:33','2016-08-13 18:06:12');
insert  into `cadet_pay`(`id`,`cadet_id`,`pay_status`,`pay_amount`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (2,2,2,'1548','admin','admin','2016-08-13 17:23:39','2016-08-13 18:06:23');

/*Table structure for table `school` */

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

insert  into `school`(`id`,`name`,`logo`,`logo_url`,`mobile`,`phone`,`email`,`addr`,`introduction`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'天天驾校',NULL,'/images/log/logo.jpg','18782275356','028-8145523','jiaxiao@163.com','四川省眉山市',NULL,'admin','admin','2016-08-12 11:17:03','2016-08-13 21:19:07',1);

/*Table structure for table `school_tuition` */

CREATE TABLE `school_tuition` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `school_id` bigint(20) NOT NULL COMMENT '驾校信息数据ID',
  `tuition` decimal(10,2) NOT NULL COMMENT '学费',
  `tuition_explain` varchar(100) DEFAULT NULL COMMENT '学费说明',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='驾校信息_学费信息';

/*Data for the table `school_tuition` */

insert  into `school_tuition`(`id`,`school_id`,`tuition`,`tuition_explain`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`) values (1,1,'3600.45','所有学费','admin','admin','2016-08-13 22:06:16','2016-08-13 23:26:23');

/*Table structure for table `suggestion` */

CREATE TABLE `suggestion` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) DEFAULT NULL COMMENT '学员信息数据ID',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `content` varchar(1000) DEFAULT NULL COMMENT '投诉内容',
  `business_status` tinyint(1) DEFAULT NULL COMMENT '业务状态',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='投诉建议';

/*Data for the table `suggestion` */

insert  into `suggestion`(`id`,`cadet_id`,`name`,`mobile`,`content`,`business_status`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,1,'user1','18785545656','本宝宝不高兴',1,'admin','admin','2016-08-13 21:05:02','2016-08-15 01:28:10',1);

/*Table structure for table `suggestion_feekback` */

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

insert  into `sys_manager`(`id`,`username`,`password`,`avatar_url`,`name`,`age`,`data_creator`,`data_updater`,`data_create_datetime`,`data_update_datetime`,`data_status`) values (1,'admin','admin',NULL,'admin',27,'admin','admin','2016-08-12 16:01:37','2016-08-12 16:01:37',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
