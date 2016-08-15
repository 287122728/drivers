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
/*Table structure for table `cadet` */

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
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员信息';

/*Table structure for table `cadet_course` */

CREATE TABLE `cadet_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `course` tinyint(1) NOT NULL COMMENT '目前课程',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员信息_课程情况';

/*Table structure for table `cadet_pay` */

CREATE TABLE `cadet_pay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `cadet_id` bigint(20) NOT NULL COMMENT '学员信息数据ID',
  `pay_status` tinyint(1) NOT NULL COMMENT '缴费状态',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员信息_缴费信息';

/*Table structure for table `school` */

CREATE TABLE `school` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `name` varchar(20) NOT NULL COMMENT '驾校名称',
  `logo` tinyblob COMMENT '驾校logo',
  `logo_url` varchar(100) DEFAULT NULL COMMENT '驾校logo地址',
  `introduction` text COMMENT '驾校简介',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='驾校信息';

/*Table structure for table `school_tuition` */

CREATE TABLE `school_tuition` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `school_id` bigint(20) NOT NULL COMMENT '驾校信息数据ID',
  `tuition` decimal(10,0) NOT NULL COMMENT '学费',
  `tuition_explain` varchar(100) DEFAULT NULL COMMENT '学费说明',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='驾校信息_学费信息';

/*Table structure for table `suggestion` */

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
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉建议';

/*Table structure for table `suggestion_feekback` */

CREATE TABLE `suggestion_feekback` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `suggestion_id` bigint(20) NOT NULL COMMENT '投诉建议数据ID',
  `content` text COMMENT '反馈信息',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉建议_反馈信息';

/*Table structure for table `sys_manager` */

CREATE TABLE `sys_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `username` varchar(20) NOT NULL COMMENT 'username',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `data_creator` varchar(20) NOT NULL COMMENT '数据创建者',
  `data_updater` varchar(20) NOT NULL COMMENT '数据更新者',
  `data_create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期时间',
  `data_update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期时间',
  `data_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '数据有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理员信息';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
