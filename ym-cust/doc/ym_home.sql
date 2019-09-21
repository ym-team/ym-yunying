/*
Navicat MySQL Data Transfer

Source Server         : 47.106.222.97
Source Server Version : 50532
Source Host           : 47.106.222.97:3306
Source Database       : ym_home

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2019-08-28 22:00:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cust_consumer
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_consumer`;
CREATE TABLE `t_cust_consumer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `consu_name` varchar(255) NOT NULL COMMENT '顾客姓名',
  `consu_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '店家id',
  `consu_age` int(3) NOT NULL COMMENT '客户年龄',
  `consu_confirm_item` varchar(512) DEFAULT NULL COMMENT '确定项目',
  `consu_wantto_item` varchar(512) DEFAULT NULL COMMENT '意向项目',
  `enjoy_policy` varchar(255) DEFAULT NULL COMMENT '享受政策',
  `service_consult` varchar(255) DEFAULT NULL COMMENT '服务顾问',
  `consu_anaylise` varchar(512) DEFAULT NULL COMMENT '顾客分析',
  `consu_work` varchar(512) DEFAULT NULL COMMENT '顾客工作',
  `consu_character` varchar(512) DEFAULT NULL COMMENT '顾客性格',
  `consu_income` varchar(512) DEFAULT NULL COMMENT '顾客年收入',
  `consu_value` varchar(512) DEFAULT NULL COMMENT '顾客消费价值观',
  `consu_pre_count` varchar(512) DEFAULT NULL COMMENT '铺垫次数',
  `consu_max_reject` varchar(512) DEFAULT NULL COMMENT '最大的抗拒点',
  `bussiness_user_id` bigint(20) DEFAULT NULL COMMENT '业务员id',
  `consu_status` int(2) DEFAULT '1' COMMENT '1 正常  2 不正常',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客信息';

-- ----------------------------
-- Records of t_cust_consumer
-- ----------------------------

-- ----------------------------
-- Table structure for t_cust_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_shop`;
CREATE TABLE `t_cust_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `shop_name` varchar(255) NOT NULL COMMENT '店面名称',
  `shop_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `shop_desc` varchar(1024) DEFAULT NULL COMMENT '店面描述',
  `shop_user_name` varchar(255) NOT NULL COMMENT '店面负责人名称',
  `shop_phone` varchar(255) DEFAULT NULL COMMENT '手机电话',
  `shop_id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  `shop_xieyi_status` int(2) DEFAULT '1' COMMENT '1 已签约  2 未签约  3 作废',
  `bussiness_user_id` bigint(20) DEFAULT NULL COMMENT '业务员id t_user',
  `user_id` bigint(20) DEFAULT NULL COMMENT '店家用户id t_user',
  `shop_status` tinyint(2) DEFAULT '1' COMMENT '1 正常  2 不正常',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店面入驻';

-- ----------------------------
-- Records of t_cust_shop
-- ----------------------------

-- ----------------------------
-- Table structure for t_hospital
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital`;
CREATE TABLE `t_hospital` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '医院名称',
  `address` varchar(50) NOT NULL COMMENT '医院地址',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `phone` varchar(12) DEFAULT NULL COMMENT '手机号码',
  `remark` varchar(500) DEFAULT '' COMMENT '医院介绍',
  `contactor` varchar(100) DEFAULT NULL COMMENT '联系人',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='医院表';

-- ----------------------------
-- Records of t_hospital
-- ----------------------------
INSERT INTO `t_hospital` VALUES ('1', '广州南方医院', '广州市广州大道北1838号', 'logo', '13800138000', '南方医院系南方医科大学（原第一军医大学）第一附属医院、第一临床医学院，是一所集医疗、教学、科研和预防保健为一体的大型综合性三级甲等医院，全国百佳医院。医院创建于1941年，2004年8月随大学由军队移交广东省。', '李院长', null, null, null, '2019-08-01 22:46:18');

-- ----------------------------
-- Table structure for t_hospital_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital_doctor`;
CREATE TABLE `t_hospital_doctor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `name` varchar(255) DEFAULT NULL COMMENT '医生名称',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `hospital_id` bigint(20) DEFAULT NULL COMMENT '医院Id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者Id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hospital_doctor
-- ----------------------------
INSERT INTO `t_hospital_doctor` VALUES ('1', '陈其庆', '主治医师', 'logo', '13800138000', '1', null, null, '2019-08-01 23:25:14', null, null);

-- ----------------------------
-- Table structure for t_saleman
-- ----------------------------
DROP TABLE IF EXISTS `t_saleman`;
CREATE TABLE `t_saleman` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户Id',
  `real_name` varchar(16) DEFAULT NULL COMMENT '业务员真实姓名',
  `id_card` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `audit_status` tinyint(11) DEFAULT '2' COMMENT '认证状态(1：认证通过  2：未认证  3：认证不通过',
  `sfz_sc` varchar(255) DEFAULT NULL COMMENT '身份证手持',
  `sfz_zm` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `sfz_fm` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) DEFAULT NULL COMMENT '创建者Id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='业务员表';

-- ----------------------------
-- Records of t_saleman
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin`;
CREATE TABLE `t_sys_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(16) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `mobile` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱帐号',
  `type` tinyint(1) DEFAULT '2' COMMENT '用户类型（1：管理员，2：普通用户）',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态( 0：禁用  1：启用 )',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_admin
-- ----------------------------
INSERT INTO `t_sys_admin` VALUES ('1', 'admin', '691b14d79bf0fa2215f155235df5e670b64394cc', '13800000000', 'it@seebon', '1', '1', '2018-08-02 18:02:42', '2018-08-02 18:02:42');

-- ----------------------------
-- Table structure for t_sys_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin_role`;
CREATE TABLE `t_sys_admin_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `admin_id` int(20) NOT NULL COMMENT '用户ID(t_sys_user.id)',
  `role_id` int(20) NOT NULL COMMENT '角色id(t_sys_role.id)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_role_id_idx` (`admin_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='系统用户的角色';

-- ----------------------------
-- Records of t_sys_admin_role
-- ----------------------------
INSERT INTO `t_sys_admin_role` VALUES ('29', '1', '2');
INSERT INTO `t_sys_admin_role` VALUES ('30', '1', '3');
INSERT INTO `t_sys_admin_role` VALUES ('31', '1', '5');
INSERT INTO `t_sys_admin_role` VALUES ('32', '1', '6');
INSERT INTO `t_sys_admin_role` VALUES ('27', '4', '3');
INSERT INTO `t_sys_admin_role` VALUES ('28', '4', '6');
INSERT INTO `t_sys_admin_role` VALUES ('9', '8', '3');
INSERT INTO `t_sys_admin_role` VALUES ('10', '9', '3');
INSERT INTO `t_sys_admin_role` VALUES ('11', '10', '3');
INSERT INTO `t_sys_admin_role` VALUES ('12', '11', '3');
INSERT INTO `t_sys_admin_role` VALUES ('14', '13', '3');
INSERT INTO `t_sys_admin_role` VALUES ('15', '13', '6');
INSERT INTO `t_sys_admin_role` VALUES ('16', '14', '3');
INSERT INTO `t_sys_admin_role` VALUES ('17', '15', '5');
INSERT INTO `t_sys_admin_role` VALUES ('18', '16', '3');
INSERT INTO `t_sys_admin_role` VALUES ('19', '17', '3');
INSERT INTO `t_sys_admin_role` VALUES ('20', '18', '3');
INSERT INTO `t_sys_admin_role` VALUES ('21', '19', '3');
INSERT INTO `t_sys_admin_role` VALUES ('22', '19', '5');
INSERT INTO `t_sys_admin_role` VALUES ('23', '19', '6');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('2', 'admin', '管理员', '2018-07-10 17:51:13');
INSERT INTO `t_sys_role` VALUES ('3', 'devPerson', '开发人员', '2018-07-10 17:51:56');
INSERT INTO `t_sys_role` VALUES ('5', 'test', '测试人员', '2018-07-11 10:44:23');
INSERT INTO `t_sys_role` VALUES ('6', 'serverMgr', '服务管理员', '2018-08-29 17:22:40');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `type` tinyint(1) DEFAULT NULL COMMENT '用户类型( 1：业务员  2：店家 3：消费者 )',
  `status` tinyint(1) DEFAULT NULL COMMENT '用户状态( 1：有效  2：失效 )',
  `invite_code` varchar(255) DEFAULT NULL COMMENT '邀请码',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '邀请用户Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) DEFAULT NULL COMMENT '创建者Id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
