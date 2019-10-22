/*
SQLyog Community v10.3 
MySQL - 5.5.62-log : Database - hpos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hpos` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hpos`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `unit_name` varchar(20) DEFAULT NULL COMMENT '单位名称',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(50) DEFAULT NULL COMMENT '企业/工作室所在地点',
  `role_id` int(5) DEFAULT NULL COMMENT '角色',
  `delete_status` int(5) DEFAULT '1',
  `description` varchar(100) DEFAULT NULL COMMENT '企业/工作室描述',
  `image` varchar(200) DEFAULT NULL COMMENT '头像路径',
  `finished_project_num` int(20) DEFAULT '0' COMMENT '已完成项目数量',
  `experienced_project_type` varchar(20) DEFAULT NULL COMMENT '擅长项目',
  `is_examined` int(5) DEFAULT '0' COMMENT '0表示未审核，1表示审核通过，2表示审核未通过',
  `evaluate` float DEFAULT NULL COMMENT '评价',
  `evaluate_demand` float DEFAULT NULL COMMENT '需求指标评分',
  `evaluate_ability` float DEFAULT NULL COMMENT '能力指标评分',
  `evaluate_plan` float DEFAULT NULL COMMENT '计划指标评分',
  PRIMARY KEY (`username`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`account_id`,`username`,`password`,`unit_name`,`email`,`telephone`,`address`,`role_id`,`delete_status`,`description`,`image`,`finished_project_num`,`experienced_project_type`,`is_examined`,`evaluate`,`evaluate_demand`,`evaluate_ability`,`evaluate_plan`) values (1,'admin','123456','admin','132686@qq.com','132231','北京',1,1,'admin',NULL,0,NULL,1,NULL,NULL,NULL,NULL),(2,'company','123456','发猿地','32432324@qq.com','43652462','广州',3,1,'发猿地',NULL,39,'Web网站',1,18,6.9626,0.0160278,0),(4,'hello','123456','田丁科技','3244322343@qq.com','3242313','杭州',2,1,'田丁科技是一家专注于中高端APP开发和网站建设的公司，同样也是一家致力于行业软件及解决方案的公司。专注于互联网，为客户提供互联网相关的技术产品和后续服务。',NULL,13,'Web网站',1,4,4,4,5),(5,'test','123456','益鼎网络','32425239@qq.com','34322131','杭州',3,1,'益鼎网络公司成立于2017年3月23日，是一所小型企业',NULL,0,NULL,1,NULL,NULL,NULL,NULL),(3,'user','123456','程序员','324224324@qq.com','343422','山西',2,1,'程序员',NULL,32,'APP开发',1,3,5,5,4),(7,'wcy','1234','芝信公司','123@qq.com','123456','宁波',3,1,'test',NULL,0,NULL,2,NULL,NULL,NULL,NULL),(6,'wwq','123','温州邮箱公司','844086765@qq.com','13166620000','温州',2,1,NULL,NULL,0,NULL,1,NULL,NULL,NULL,NULL);

/*Table structure for table `advertisement` */

DROP TABLE IF EXISTS `advertisement`;

CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(50) DEFAULT NULL COMMENT '申请广告位的 用户名',
  `application_days` varchar(50) DEFAULT NULL COMMENT '申请天数',
  `amount` varchar(50) DEFAULT NULL COMMENT '金额',
  `attachment_id` int(5) DEFAULT NULL COMMENT '图片id',
  `audit_results` int(5) DEFAULT '0' COMMENT '0为未审核，1未审核通过，2为审核不通过',
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `advertisement` */

insert  into `advertisement`(`id`,`unit_name`,`application_days`,`amount`,`attachment_id`,`audit_results`,`update_date`) values (18,'发猿地','30','1500',9,0,'2019-04-04 20:15:30'),(19,'发猿地','30','1500',10,1,'2019-04-05 20:15:35'),(20,'发猿地','30','1500',11,2,'2019-03-26 20:15:33'),(21,'益鼎网络','30','1500',15,2,'2019-04-21 22:30:11'),(22,'益鼎网络','30','1500',16,2,'2019-04-22 19:58:01'),(23,'发猿地','30','1500',17,1,'2019-04-25 10:01:50');

/*Table structure for table `apply_for_final_payment` */

DROP TABLE IF EXISTS `apply_for_final_payment`;

CREATE TABLE `apply_for_final_payment` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `company_name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `apply_for_final_payment` */

insert  into `apply_for_final_payment`(`id`,`project_name`,`studio_name`,`company_name`,`update_date`) values (7,'校园平台开发','程序员','发猿地','2019-04-15 21:44:04'),(8,'房产类H5项目BUG修复以及优化','田丁科技','益鼎网络','2019-04-21 21:57:52');

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` int(5) NOT NULL COMMENT '附件ID',
  `attachment_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `attachment_path` varchar(200) DEFAULT NULL COMMENT '存储路径(相对)',
  `upload_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `attachment_title` varchar(200) DEFAULT NULL COMMENT '文件显示标题（即原文件名）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`attachment_name`,`attachment_path`,`upload_time`,`attachment_title`) values (1,'1','1','2019-04-11 21:51:24','1'),(2,'20190411-215650-5063.png','/hpos/attachments/attachment','2019-04-11 13:56:51','4870.png'),(3,'20190411-220406-8971.png','/hpos/attachments/attachment','2019-04-11 14:04:09','4870.png'),(4,'20190411-220603-9884.png','/hpos/attachments/attachment','2019-04-11 14:06:09','4500.png'),(5,'20190411-220753-4987.png','/hpos/attachments/attachment','2019-04-11 14:08:01','4870.png'),(6,'20190411-220914-3353.png','/hpos/attachments/attachment','2019-04-11 14:09:14','4870.png'),(7,'20190411-221840-0404.png','/hpos/attachments/attachment','2019-04-11 14:18:40','4750.png'),(8,'20190411-222109-6190.png','/hpos/attachments/attachment','2019-04-11 14:21:09','4870.png'),(9,'20190411-222536-9687.png','/hpos/attachments/attachment','2019-04-11 22:25:28','4870.png'),(10,'20190416-100212-3021.txt','/hpos/attachments/attachment','2019-04-16 10:02:07','账号.txt'),(11,'20190416-100242-7596.jpg','/hpos/attachments/attachment','2019-04-16 10:02:38','6000.jpg'),(12,'20190416-105136-0717.jpg','/hpos/attachments/attachment','2019-04-16 10:51:40','3907124358119115a0fd26f0da582e6.jpg'),(13,'20190416-105402-7743.jpg','/hpos/attachments/attachment','2019-04-16 10:58:38','3907124358119115a0fd26f0da582e6.jpg'),(14,'20190416-105833-8571.jpg','/hpos/attachments/attachment','2019-04-16 10:58:38','3907124358119115a0fd26f0da582e6.jpg'),(15,'20190421-223011-9076.jpg','/hpos/attachments/attachment','2019-04-21 22:30:11','1191168722f9ed1789o.jpg'),(16,'20190422-195801-2554.jpg','/hpos/attachments/attachment','2019-04-22 19:58:01','152256930931.jpg'),(17,'20190425-100152-9761.png','/hpos/attachments/attachment','2019-04-25 10:01:50','4870.png');

/*Table structure for table `company_finished` */

DROP TABLE IF EXISTS `company_finished`;

CREATE TABLE `company_finished` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `evaluate` int(5) DEFAULT NULL COMMENT '评价',
  `delete_status` int(5) DEFAULT NULL COMMENT '删除状态(1为删除,0为未删除)',
  `company_name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `budget` float DEFAULT NULL COMMENT '项目金额',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  `evaluate_demand` float DEFAULT NULL COMMENT '需求指标评分',
  `evaluate_ability` float DEFAULT NULL COMMENT '能力指标评分',
  `evaluate_plan` float DEFAULT NULL COMMENT '计划指标评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Data for the table `company_finished` */

insert  into `company_finished`(`id`,`project_name`,`studio_name`,`evaluate`,`delete_status`,`company_name`,`budget`,`project_description`,`evaluate_demand`,`evaluate_ability`,`evaluate_plan`) values (38,'商城网站建设','程序员',18,1,'发猿地',2222,NULL,6.9626,0.0160278,0),(47,'房产类H5项目BUG修复以及优化','田丁科技',5,1,'益鼎网络',200,'网站需要在微信端打开，房产类的一个项目，目前已经接近尾声，需要做一些小BUG的修复，以及网页的整体优化工作。',2.5,1.5,2),(51,'网站建设wap网站制作','程序员',19,1,'发猿地',666,'网站建设wap网站制作',1.66667,2.5,3),(64,'商城网站建设','田丁科技',18,1,'发猿地',2222,'内容要求不限，能上各大市场就行',6.9626,0.0160278,0),(68,'商城网站建设','田丁科技',18,1,'发猿地',2222,'内容要求不限，能上各大市场就行',6.9626,0.0160278,0);

/*Table structure for table `company_not_recruited` */

DROP TABLE IF EXISTS `company_not_recruited`;

CREATE TABLE `company_not_recruited` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `tender_status` varchar(20) DEFAULT NULL COMMENT '招标状态(0.招标中 1.招标完成',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `apply_num` int(10) DEFAULT NULL COMMENT '招标人数',
  `delete_status` int(5) DEFAULT NULL COMMENT '删除状态(0为删除,1为未删除)',
  `deposit` float DEFAULT NULL COMMENT '定金',
  `company_name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `company_not_recruited` */

insert  into `company_not_recruited`(`id`,`project_name`,`tender_status`,`studio_name`,`apply_num`,`delete_status`,`deposit`,`company_name`,`project_description`) values (1,'商城网站建设','1','田丁科技',1,1,222.2,'发猿地','内容要求不限，能上各大市场就行'),(14,'房产类H5项目BUG修复以及优化','1','田丁科技',1,1,200,'益鼎网络','网站需要在微信端打开，房产类的一个项目，目前已经接近尾声，需要做一些小BUG的修复，以及网页的整体优化工作。'),(15,'网站建设wap网站制作','1','程序员',1,0,66.6,'发猿地','网站建设wap网站制作'),(16,'安卓马甲包打包或者上架人员','1','程序员',2,1,100,'益鼎网络','内容要求不限，能上各大市场就行'),(17,'教务系统','1','温州邮箱公司',1,1,900,'益鼎网络','需要開發一個教务系统'),(18,'开发一个教务系统','0',NULL,0,1,10,'NIT','1'),(19,'kaifa','0',NULL,0,1,1.1,'发猿地','1'),(20,'kaifa2','0',NULL,0,1,2.2,'发猿地','2'),(21,'xiangmu','0',NULL,0,1,2.2,'发猿地','123'),(22,'10tiao`','0',NULL,0,1,3.2,'发猿地','12');

/*Table structure for table `company_progress` */

DROP TABLE IF EXISTS `company_progress`;

CREATE TABLE `company_progress` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `project_progress` varchar(500) DEFAULT NULL COMMENT '项目进度（实时修改，文字描述）',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `delete_status` int(5) DEFAULT NULL COMMENT '删除状态(1为删除,0为未删除)',
  `company_name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `final_payment` float DEFAULT NULL COMMENT '尾款',
  `apply_for_final_payment` int(5) DEFAULT '0' COMMENT '1为已申请，0为未申请',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `company_progress` */

insert  into `company_progress`(`id`,`project_name`,`project_progress`,`studio_name`,`delete_status`,`company_name`,`final_payment`,`apply_for_final_payment`,`project_description`) values (2,'网站建设wap网站制作','完成','程序员',0,'发猿地',599.4,0,'网站建设wap网站制作'),(29,'商城网站建设',NULL,'田丁科技',1,'发猿地',1999.8,0,'商城网站建设'),(31,'房产类H5项目BUG修复以及优化',NULL,'田丁科技',1,'益鼎网络',1800,0,'网站需要在微信端打开，房产类的一个项目，目前已经接近尾声，需要做一些小BUG的修复，以及网页的整体优化工作。'),(32,'安卓马甲包打包或者上架人员',NULL,'程序员',0,'益鼎网络',900,0,'内容要求不限，能上各大市场就行'),(33,'商城网站建设',NULL,'田丁科技',0,'发猿地',1999.8,0,'内容要求不限，能上各大市场就行'),(34,'安卓马甲包打包或者上架人员',NULL,'程序员',0,'益鼎网络',900,0,'内容要求不限，能上各大市场就行'),(39,'教务系统',NULL,'温州邮箱公司',1,'益鼎网络',8100,0,'需要開發一個教务系统');

/*Table structure for table `cost_management` */

DROP TABLE IF EXISTS `cost_management`;

CREATE TABLE `cost_management` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室名称',
  `company_name` varchar(20) DEFAULT NULL COMMENT '企业名称',
  `project_start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '项目开始时间',
  `deposit` float DEFAULT NULL COMMENT '定金',
  `final_payment` float DEFAULT NULL COMMENT '尾款',
  `deposit_isPayed` int(2) NOT NULL DEFAULT '0' COMMENT '定金是否支付(0为未支付，1为已支付)',
  `final_payment_isPayed` int(2) NOT NULL DEFAULT '0' COMMENT '尾款是否支付(0为未支付，1为已支付)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cost_management` */

insert  into `cost_management`(`id`,`project_name`,`studio_name`,`company_name`,`project_start_date`,`deposit`,`final_payment`,`deposit_isPayed`,`final_payment_isPayed`) values (1,'网站建设wap网站制作','程序员','发猿地','2019-05-12 20:01:38',66.6,599.4,1,0),(2,'商城网站建设','田丁科技','益鼎网络','2019-05-12 20:04:06',222.2,1999.8,1,1),(3,'房产类H5项目BUG修复以及优化','田丁科技','益鼎网络','2019-04-22 21:17:07',200,1800,0,0),(4,'安卓马甲包打包或者上架人员','程序员','发猿地','2019-05-12 19:58:18',100,900,0,0);

/*Table structure for table `demand` */

DROP TABLE IF EXISTS `demand`;

CREATE TABLE `demand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目描述',
  `demand_type` varchar(20) DEFAULT NULL COMMENT '需求类型(人力外包/项目外包)',
  `project_cycle` varchar(20) DEFAULT NULL COMMENT '项目周期',
  `project_budget` float DEFAULT NULL COMMENT '项目预算',
  `recruitment_role` varchar(20) DEFAULT NULL COMMENT '招募角色',
  `project_demand` varchar(100) DEFAULT NULL COMMENT '项目需求',
  `tender_status` varchar(20) DEFAULT '1' COMMENT '招标状态(1:招标中，2：已结束)',
  `apply_num` int(20) DEFAULT '0' COMMENT '报名人数',
  `project_type` varchar(20) DEFAULT NULL COMMENT '项目类型(如：小程序，Web开发)',
  `employer_name` varchar(20) DEFAULT NULL COMMENT '雇佣方名称',
  `comment_money` int(5) DEFAULT '0' COMMENT '评论：钱太少',
  `comment_time` int(5) DEFAULT '0' COMMENT '评论：时间紧',
  `comment_reliable` int(5) DEFAULT '0' COMMENT '评论：不可靠',
  `comment_hard` int(5) DEFAULT '0' COMMENT '评论：太困难',
  `file_id` int(5) DEFAULT NULL COMMENT '文档id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `demand` */

insert  into `demand`(`id`,`project_name`,`project_description`,`demand_type`,`project_cycle`,`project_budget`,`recruitment_role`,`project_demand`,`tender_status`,`apply_num`,`project_type`,`employer_name`,`comment_money`,`comment_time`,`comment_reliable`,`comment_hard`,`file_id`) values (1,'网站建设wap网站制作','网站建设wap网站制作','项目外包','30',666,'前端开发','vue','1',11,'Web网站','发猿地',2,1,4,2,NULL),(2,'房产类H5项目BUG修复以及优化','网站需要在微信端打开，房产类的一个项目，目前已经接近尾声，需要做一些小BUG的修复，以及网页的整体优化工作。','项目外包','18',2000,'前端开发','最好是空余时间多一些，能尽快完成目前的BUG以及网页的优化工作','1',1,'Web网站','益鼎网络',43,5,4,3,NULL),(3,'商城网站建设','商城网站建设','项目外包','20',2222,'前端开发','vue','1',4,'APP开发','发猿地',4,3,7,4,NULL),(4,'安卓马甲包打包或者上架人员','根据我们提供的APP名字来开发内容，内容要求不限，能上各大市场就行','人力外包','1',1000,'Android开发 ','内容要求不限，能上各大市场就行','1',5,'APP开发','益鼎网络',2,4,2,2,NULL),(5,'番茄美摄公众号平台','一个平台类的公众号，用户可以在上面发布照片，照片分为免费与付费，付费照片其他用户支付费用后方可查看。','项目外包','30',15000,'前端开发','1.有公众号开发相关经验2.团队人员充足，有前端，后端及UI，进度滞后时能够保证加班完成工作','1',2,'微信公众号','发猿地',5,3,4,6,NULL),(6,'教务系统','需要開發一個教务系统','项目外包','20',9000,'设计师','使用vue，java，開發','1',1,'Web网站','益鼎网络',0,0,0,0,NULL),(7,'开发一个教务系统','1','项目外包','34',100,'设计师','432','1',0,'Web网站','NIT',0,0,0,0,NULL),(8,'kaifa','1','项目外包','11',11,'设计师','11','1',0,'Web网站','发猿地',0,0,0,0,NULL),(9,'kaifa2','2','项目外包','22',22,'设计师','22','1',0,'Web网站','发猿地',0,0,0,0,NULL),(10,'xiangmu','123','项目外包','222',22,'设计师','2','1',0,'Web网站','发猿地',0,0,0,0,NULL),(11,'10tiao`','12','项目外包','23',32,'设计师','33','1',0,'Web网站','发猿地',0,0,0,0,NULL);

/*Table structure for table `file_info` */

DROP TABLE IF EXISTS `file_info`;

CREATE TABLE `file_info` (
  `id` bigint(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `identifier` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `total_size` bigint(20) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `file_info` */

/*Table structure for table `project_progress_log` */

DROP TABLE IF EXISTS `project_progress_log`;

CREATE TABLE `project_progress_log` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) NOT NULL COMMENT '项目标题',
  `progress_log` varchar(100) DEFAULT NULL COMMENT '日志内容',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `company_name` varchar(20) DEFAULT NULL COMMENT '企业单位',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `project_progress_log` */

insert  into `project_progress_log`(`id`,`project_name`,`progress_log`,`date`,`company_name`,`studio_name`) values (1,'校园平台开发','已完成页面设计1','2019-04-04 10:23:53','发猿地','程序员'),(2,'小程序开发','已完成管理员页面','2019-04-04 10:24:02','发猿','程序员'),(3,'2','已完成游客页面','2019-04-18 19:33:30','发猿','程序员'),(4,'网站建设wap网站制作','完成1','2019-04-04 10:24:13','发猿地','程序员'),(5,'网站建设wap网站制作','+11','2019-04-04 10:24:18','发猿地','程序员'),(6,'微信','222','2019-04-04 10:31:18','发猿地','程序员'),(12,'商城网站建设','2222','2019-04-04 11:22:59','发猿地','程序员'),(16,'房产类H5项目BUG修复以及优化','已完成页面设计','2019-04-22 20:19:43','益鼎网络','田丁科技'),(17,'房产类H5项目BUG修复以及优化','已完成后台搭建','2019-04-22 20:20:04','益鼎网络','田丁科技'),(18,'房产类H5项目BUG修复以及优化','已完成微信小程序','2019-04-22 20:20:35','益鼎网络','田丁科技'),(19,'安卓马甲包打包或者上架人员','修改了项目进度的bug','2019-04-30 21:21:42','程序员','程序员');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`) values (1,'管理员'),(2,'工作室'),(3,'企业');

/*Table structure for table `studio_finished` */

DROP TABLE IF EXISTS `studio_finished`;

CREATE TABLE `studio_finished` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `budget` float DEFAULT NULL COMMENT '预算',
  `company_name` varchar(20) DEFAULT NULL COMMENT '企业单位名称',
  `evaluate` int(5) DEFAULT NULL COMMENT '评价',
  `delete_status` int(5) DEFAULT NULL COMMENT '删除状态(1为删除,0为未删除)',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  `evaluate_demand` float DEFAULT NULL COMMENT '需求指标评分',
  `evaluate_ability` float DEFAULT NULL COMMENT '能力指标评分',
  `evaluate_plan` float DEFAULT NULL COMMENT '计划指标评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `studio_finished` */

insert  into `studio_finished`(`id`,`project_name`,`budget`,`company_name`,`evaluate`,`delete_status`,`studio_name`,`project_description`,`evaluate_demand`,`evaluate_ability`,`evaluate_plan`) values (13,'商城网站建设',222.2,'发猿地',2,1,'程序员',NULL,6.9626,0.0160278,0),(18,'网站建设wap网站制作',666,'发猿地',2,1,'程序员','网站建设wap网站制作',1.66667,2.5,3),(20,'商城网站建设',2222,'发猿地',2,1,'田丁科技','内容要求不限，能上各大市场就行',6.9626,0.0160278,0);

/*Table structure for table `studio_not_recruited` */

DROP TABLE IF EXISTS `studio_not_recruited`;

CREATE TABLE `studio_not_recruited` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `deposit` float DEFAULT NULL COMMENT '定金',
  `final_payment` float DEFAULT NULL COMMENT '尾款',
  `company_name` varchar(20) DEFAULT NULL COMMENT '工作单位',
  `bid_status` int(20) DEFAULT '2' COMMENT '投标状态(1.投标失败 2.投标中 3.投标完成',
  `delete_status` int(5) DEFAULT '1' COMMENT '删除状态(0为删除，1为存在)',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `studio_not_recruited` */

insert  into `studio_not_recruited`(`id`,`project_name`,`deposit`,`final_payment`,`company_name`,`bid_status`,`delete_status`,`studio_name`,`project_description`) values (2,'网站建设wap网站制作',66.6,599.4,'发猿地',2,0,'程序员','123'),(5,'房产类H5项目BUG修复以及优化',200,1800,'益鼎网络',3,1,'田丁科技',NULL),(6,'商城网站建设',222.2,1999.8,'发猿地',1,1,'田丁科技','内容要求不限，能上各大市场就行'),(8,'安卓马甲包打包或者上架人员',100,900,'益鼎网络',1,1,'程序员','内容要求不限，能上各大市场就行'),(9,'安卓马甲包打包或者上架人员',100,900,'益鼎网络',2,1,'温州邮箱公司',NULL),(10,'安卓马甲包打包或者上架人员',100,900,'益鼎网络',2,1,'温州邮箱公司',NULL),(11,'教务系统',900,8100,'益鼎网络',1,1,'温州邮箱公司',NULL),(12,'教务系统',900,8100,'益鼎网络',1,1,'温州邮箱公司',NULL);

/*Table structure for table `studio_progress` */

DROP TABLE IF EXISTS `studio_progress`;

CREATE TABLE `studio_progress` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `deposit` float DEFAULT NULL COMMENT '定金',
  `final_payment` float DEFAULT NULL COMMENT '尾款',
  `project_progress` varchar(200) DEFAULT NULL COMMENT '项目进度修改内容',
  `company_name` varchar(20) DEFAULT NULL COMMENT '企业单位名称',
  `delete_status` int(5) DEFAULT NULL COMMENT '删除状态(1为删除,0为未删除)',
  `studio_name` varchar(20) DEFAULT NULL COMMENT '工作室单位名称',
  `project_description` varchar(100) DEFAULT NULL COMMENT '项目详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `studio_progress` */

insert  into `studio_progress`(`id`,`project_name`,`deposit`,`final_payment`,`project_progress`,`company_name`,`delete_status`,`studio_name`,`project_description`) values (9,'商城网站建设',222.2,1999.8,'2222','发猿地',1,'田丁科技','商城网站建设'),(11,'房产类H5项目BUG修复以及优化',200,1800,'已完成微信小程序','益鼎网络',1,'田丁科技','网站需要在微信端打开，房产类的一个项目，目前已经接近尾声，需要做一些小BUG的修复，以及网页的整体优化工作。'),(12,'网站建设wap网站制作',66.6,599.4,'123','发猿地',0,'程序员','网站建设wap网站制作'),(13,'安卓马甲包打包或者上架人员',100,900,'修改了项目进度的bug','益鼎网络',0,'程序员','内容要求不限，能上各大市场就行'),(14,'商城网站建设',222.2,1999.8,NULL,'发猿地',0,'田丁科技','内容要求不限，能上各大市场就行'),(15,'安卓马甲包打包或者上架人员',100,900,'修改了项目进度的bug','益鼎网络',0,'程序员','内容要求不限，能上各大市场就行');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`menu_code`,`menu_name`,`permission_code`,`permission_name`,`required_permission`) values (101,'article','文章管理','article:list','列表',1),(102,'article','文章管理','article:add','新增',2),(103,'article','文章管理','article:update','修改',2),(601,'user','用户','user:list','列表',1),(602,'user','用户','user:add','新增',2),(603,'user','用户','user:update','修改',2),(701,'role','角色权限','role:list','列表',1),(702,'role','角色权限','role:add','新增',2),(703,'role','角色权限','role:update','修改',2),(704,'role','角色权限','role:delete','删除',2);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`create_time`,`update_time`,`delete_status`) values (1,'管理员','2017-11-22 16:24:34','2017-11-22 16:24:52','1'),(2,'工作室','2019-03-12 20:13:17','2017-11-22 16:24:52','1'),(3,'企业','2019-03-12 20:13:26','2017-11-22 16:28:47','1');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL DEFAULT '0',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`id`,`role_id`,`permission_id`,`create_time`,`update_time`,`delete_status`) values (1,2,101,'2017-11-22 16:26:21','2017-11-22 16:26:32','1'),(2,2,102,'2017-11-22 16:26:21','2017-11-22 16:26:32','1'),(5,2,602,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(6,2,601,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(7,2,603,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(8,2,703,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(9,2,701,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(10,2,702,'2017-11-22 16:28:28','2017-11-22 16:28:28','1'),(11,2,704,'2017-11-22 16:28:31','2017-11-22 16:28:31','1'),(12,2,103,'2017-11-22 16:28:31','2017-11-22 16:28:31','1'),(13,3,601,'2017-11-22 16:28:47','2017-11-22 16:28:47','1'),(14,3,701,'2017-11-22 16:28:47','2017-11-22 16:28:47','1'),(15,3,702,'2017-11-22 16:35:01','2017-11-22 16:35:01','1'),(16,3,704,'2017-11-22 16:35:01','2017-11-22 16:35:01','1'),(17,3,102,'2017-11-22 16:35:01','2017-11-22 16:35:01','1'),(18,3,101,'2017-11-22 16:35:01','2017-11-22 16:35:01','1'),(19,3,603,'2017-11-22 16:35:01','2017-11-22 16:35:01','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
