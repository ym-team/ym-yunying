/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : ym

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-07-30 21:33:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_hospital
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital`;
CREATE TABLE `t_hospital` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典主键ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医院名称',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医院地址',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'logo',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '医院介绍',
  `contactor` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医院表';

-- ----------------------------
-- Records of t_hospital
-- ----------------------------

-- ----------------------------
-- Table structure for t_hospital_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital_doctor`;
CREATE TABLE `t_hospital_doctor` (
  `id` int(11) NOT NULL COMMENT '主键Id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生名称',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `hospital_id` int(11) DEFAULT NULL COMMENT '医院Id',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hospital_doctor
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典主键ID',
  `dict_key` varchar(50) DEFAULT NULL COMMENT '字典类型',
  `dict_code` varchar(50) NOT NULL COMMENT '字典的code',
  `dict_name` varchar(255) DEFAULT NULL COMMENT '字典的name',
  `dict_sort` int(11) DEFAULT NULL COMMENT '字典的顺序 从0开始计数',
  `status` varchar(1) DEFAULT '0' COMMENT '字典状态 0有效 1无效',
  `comment` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dict_code` (`dict_code`) USING BTREE,
  KEY `idx_dict_key` (`dict_key`) USING BTREE,
  KEY `idx_dict_key_dict_code` (`dict_key`,`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21970 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of t_sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名',
  `action` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `parent_id` int(10) DEFAULT NULL COMMENT '父菜单id',
  `status` tinyint(10) DEFAULT '1' COMMENT '0:无效、1有效',
  `level` int(10) DEFAULT '999' COMMENT '菜单深度',
  `sort` int(10) DEFAULT '999' COMMENT '排序',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统菜单';

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', 'root', '主页', 'root', '0', '1', '999', '999', '1', '2018-07-12 11:32:37');
INSERT INTO `t_sys_menu` VALUES ('2', 'workflow', '流程管理', 'menu', '1', '1', '999', '1', '1', '2018-07-11 17:13:52');
INSERT INTO `t_sys_menu` VALUES ('3', 'config', '配置中心', 'menu', '1', '1', '999', '2', '1', '2018-07-11 17:15:50');
INSERT INTO `t_sys_menu` VALUES ('4', 'workflowDesign', '流程设计', '/models', '2', '1', '999', '2', '1', '2018-07-12 10:44:37');
INSERT INTO `t_sys_menu` VALUES ('5', 'key', '配置项', '/key/list', '3', '1', '999', '1', '1', '2018-07-12 10:44:55');
INSERT INTO `t_sys_menu` VALUES ('6', 'EnvironmentConfig', '环境配置', '/keyValue/list?profileId=', '3', '1', '999', '2', '1', '2018-07-12 11:14:33');
INSERT INTO `t_sys_menu` VALUES ('7', 'services', '服务管理', 'menu', '1', '1', '999', '3', '1', '2018-07-12 14:10:15');
INSERT INTO `t_sys_menu` VALUES ('9', 'systemManager', '系统管理', 'menu', '1', '1', '999', '5', '1', '2018-07-12 14:10:47');
INSERT INTO `t_sys_menu` VALUES ('10', 'monitorManager', '监控管理', '/monitor/list', '3', '1', '999', '3', '1', '2018-07-12 14:22:02');
INSERT INTO `t_sys_menu` VALUES ('11', 'Services', '服务查询', '/governance/services/?profileId=', '7', '1', '999', '999', '1', '2018-07-12 14:29:45');
INSERT INTO `t_sys_menu` VALUES ('12', 'log', '异常日志', '/logging', '7', '1', '999', '1', '1', '2018-07-12 14:30:13');
INSERT INTO `t_sys_menu` VALUES ('13', 'userManager', '用户管理', '/user/list', '9', '1', '999', '4', '1', '2018-07-12 14:30:41');
INSERT INTO `t_sys_menu` VALUES ('14', 'roleManager', '角色管理', '/role/list', '9', '1', '999', '5', '1', '2018-07-12 14:32:14');
INSERT INTO `t_sys_menu` VALUES ('15', 'menuManager', '菜单管理', '/menu/list', '9', '1', '999', '3', '1', '2018-07-12 14:32:33');
INSERT INTO `t_sys_menu` VALUES ('16', 'profileManager', '环境管理', '/profile/list', '9', '1', '999', '2', '1', '2018-07-12 14:32:51');
INSERT INTO `t_sys_menu` VALUES ('17', 'appManager', '应用管理', '/app/list', '9', '1', '999', '1', '1', '2018-07-12 14:33:09');
INSERT INTO `t_sys_menu` VALUES ('19', 'zkManager', 'zk地址管理', '/zk/list', '9', '1', '999', '8', '1', '2018-07-19 19:10:52');
INSERT INTO `t_sys_menu` VALUES ('25', 'workflowProfile', '流程环境', '/workflowProfile/list', '9', '1', '999', '1', '1', '2018-08-02 18:42:24');
INSERT INTO `t_sys_menu` VALUES ('26', 'deploy', '应用部署', '/deploy/page', '7', '0', '999', '20', '1', '2018-08-16 11:49:56');
INSERT INTO `t_sys_menu` VALUES ('27', 'serverNode', '节点管理', '/governance/nodes', '7', '0', '999', '10', '1', '2018-08-22 17:01:46');
INSERT INTO `t_sys_menu` VALUES ('28', 'loadBalanceConfig', '负载管理', '/governance/loadBalances/?profileId=', '7', '0', '999', '30', '1', '2018-08-30 14:59:00');
INSERT INTO `t_sys_menu` VALUES ('29', 'fileManager', '文件管理', 'menu', '1', '1', '999', '6', '1', '2018-09-25 15:46:28');
INSERT INTO `t_sys_menu` VALUES ('30', 'file', '文件管理', '/file', '29', '1', '999', '1', '1', '2018-09-25 15:47:59');
INSERT INTO `t_sys_menu` VALUES ('31', 'cacheTableManager', '缓存表管理', '/cacheTable/list', '9', '1', '999', '6', '1', '2018-12-17 14:35:37');
INSERT INTO `t_sys_menu` VALUES ('33', 'projectManager', '项目管理', '/project/list', '9', '1', '999', '7', '1', '2019-01-16 15:19:19');
INSERT INTO `t_sys_menu` VALUES ('40', 'config', '配置中心', 'menu', '1', '1', '999', '2', '1', '2019-01-23 14:53:11');
INSERT INTO `t_sys_menu` VALUES ('41', 'key', '配置项', '/key/list', '40', '1', '999', '1', '1', '2019-01-23 14:54:54');
INSERT INTO `t_sys_menu` VALUES ('42', 'EnvironmentConfig', '环境配置', '/keyValue/list?profileId=', '40', '1', '999', '2', '1', '2019-01-23 14:55:21');
INSERT INTO `t_sys_menu` VALUES ('43', 'services', '服务管理', 'menu', '1', '1', '999', '3', '1', '2019-01-23 14:57:42');
INSERT INTO `t_sys_menu` VALUES ('44', 'Services', '服务查询', '/governance/services/?profileId=', '43', '1', '999', '1', '1', '2019-01-23 14:58:08');
INSERT INTO `t_sys_menu` VALUES ('45', 'log', '日志查询', '/logging', '43', '1', '999', '2', '1', '2019-01-23 14:58:37');
INSERT INTO `t_sys_menu` VALUES ('46', 'config', '配置中心', 'menu', '1', '1', '999', '1', '1', '2019-02-20 17:18:22');
INSERT INTO `t_sys_menu` VALUES ('47', 'key', '配置项', '/key/list', '46', '1', '999', '1', '1', '2019-02-20 17:18:56');
INSERT INTO `t_sys_menu` VALUES ('48', 'EnvironmentConfig', '环境配置', '/keyValue/list?profileId=', '46', '1', '999', '2', '1', '2019-02-20 17:19:19');
INSERT INTO `t_sys_menu` VALUES ('49', 'workflow', '流程管理', 'menu', '1', '1', '999', '1', '1', '2019-02-28 09:47:00');
INSERT INTO `t_sys_menu` VALUES ('50', 'workflowDesign', '流程设计', '/models', '49', '1', '999', '2', '1', '2019-02-28 09:47:29');
INSERT INTO `t_sys_menu` VALUES ('51', 'Tracer', '链路日志', '/tracer/list', '7', '1', '999', '2', '1', '2019-03-01 15:41:46');

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '按钮名称',
  `code` varchar(255) NOT NULL COMMENT '按钮编码',
  `url` varchar(500) NOT NULL COMMENT '按钮url',
  `menu_id` int(10) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` int(11) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='按钮权限表';

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('1', '添加', 'workflow:add', '', '25', null, '2019-01-21 16:03:20', '4', '2019-01-22 13:40:50');
INSERT INTO `t_sys_permission` VALUES ('2', '删除', 'workflow:delete', '', '25', null, '2019-01-21 16:17:23', '4', '2019-01-22 13:41:33');
INSERT INTO `t_sys_permission` VALUES ('3', '删除', 'keyValue:delete', '', '6', '1', '2019-01-21 16:33:29', '1', '2019-01-22 14:37:22');
INSERT INTO `t_sys_permission` VALUES ('4', '配置内容更新', 'keyValue:edit', '', '6', '1', '2019-01-21 16:34:00', '1', '2019-01-22 14:38:32');
INSERT INTO `t_sys_permission` VALUES ('5', '删除', 'key:delete', '/api/key/delete', '5', '1', '2019-01-21 16:34:34', '1', '2019-01-22 14:23:10');
INSERT INTO `t_sys_permission` VALUES ('6', '编辑', 'workflow:edit', '', '25', '4', '2019-01-22 13:41:54', '4', '2019-01-22 13:41:54');
INSERT INTO `t_sys_permission` VALUES ('7', '添加', 'key:add', '', '5', '1', '2019-01-22 14:23:32', '1', '2019-01-22 14:23:32');
INSERT INTO `t_sys_permission` VALUES ('8', '编辑', 'key:edit', '', '5', '1', '2019-01-22 14:23:46', '1', '2019-01-22 14:23:46');
INSERT INTO `t_sys_permission` VALUES ('9', '添加', 'app:add', '', '17', '1', '2019-01-22 14:46:10', '1', '2019-01-22 14:46:10');
INSERT INTO `t_sys_permission` VALUES ('10', '编辑', 'app:edit', '', '17', '1', '2019-01-22 14:46:26', '1', '2019-01-22 14:46:26');
INSERT INTO `t_sys_permission` VALUES ('11', '删除', 'app:delete', '', '17', '1', '2019-01-22 14:46:39', '1', '2019-01-22 14:46:39');
INSERT INTO `t_sys_permission` VALUES ('12', '添加', 'profile:add', '', '16', '1', '2019-01-22 15:09:17', '1', '2019-01-22 15:09:17');
INSERT INTO `t_sys_permission` VALUES ('13', '编辑', 'profile:edit', '', '16', '1', '2019-01-22 15:09:29', '1', '2019-01-22 15:09:29');
INSERT INTO `t_sys_permission` VALUES ('14', '删除', 'profile:delete', '', '16', '1', '2019-01-22 15:09:43', '1', '2019-01-22 15:09:43');
INSERT INTO `t_sys_permission` VALUES ('15', '启动/禁用', 'profile:enable', '', '16', '1', '2019-01-22 15:14:36', '1', '2019-01-22 15:14:36');
INSERT INTO `t_sys_permission` VALUES ('16', '克隆', 'profile:clone', '', '16', '1', '2019-01-22 15:15:07', '1', '2019-01-22 15:15:07');
INSERT INTO `t_sys_permission` VALUES ('17', '同步缓存/ZK', 'profile:synData', '', '16', '1', '2019-01-22 15:15:54', '1', '2019-01-22 15:15:54');
INSERT INTO `t_sys_permission` VALUES ('18', '添加', 'zk:add', '', '19', '1', '2019-01-22 15:21:25', '1', '2019-01-22 15:21:25');
INSERT INTO `t_sys_permission` VALUES ('19', '删除', 'zk:delete', '', '19', '1', '2019-01-22 15:21:39', '1', '2019-01-22 15:21:39');
INSERT INTO `t_sys_permission` VALUES ('20', '编辑', 'zk:edit', '', '19', '1', '2019-01-22 15:21:52', '1', '2019-01-22 15:21:52');
INSERT INTO `t_sys_permission` VALUES ('21', '添加', 'cacheTable:add', '', '31', '1', '2019-01-22 15:25:23', '1', '2019-01-22 15:25:23');
INSERT INTO `t_sys_permission` VALUES ('22', '删除', 'cacheTable:delete', '', '31', '1', '2019-01-22 15:25:37', '1', '2019-01-22 15:25:37');
INSERT INTO `t_sys_permission` VALUES ('23', '编辑', 'cacheTable:edit', '', '31', '1', '2019-01-22 15:25:55', '1', '2019-01-22 15:25:55');
INSERT INTO `t_sys_permission` VALUES ('24', '同步缓存', 'cacheTable:sysData', '', '31', '1', '2019-01-22 15:26:09', '1', '2019-01-22 15:26:09');
INSERT INTO `t_sys_permission` VALUES ('25', '批量更新', 'keyValue:batchUpdate', '', '6', '1', '2019-01-23 17:59:21', '1', '2019-01-23 17:59:36');

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
-- Table structure for t_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `create_id` int(11) NOT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1079 DEFAULT CHARSET=utf8 COMMENT='菜单-角色对应关系表';

-- ----------------------------
-- Records of t_sys_role_menu
-- ----------------------------
INSERT INTO `t_sys_role_menu` VALUES ('163', '4', '1', '1', '2018-07-12 15:54:21');
INSERT INTO `t_sys_role_menu` VALUES ('164', '4', '2', '1', '2018-07-12 15:54:21');
INSERT INTO `t_sys_role_menu` VALUES ('165', '4', '4', '1', '2018-07-12 15:54:21');
INSERT INTO `t_sys_role_menu` VALUES ('560', '3', '1', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('561', '3', '2', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('562', '3', '4', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('563', '3', '3', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('564', '3', '5', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('565', '3', '22', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('566', '3', '6', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('567', '3', '20', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('568', '3', '7', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('569', '3', '11', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('570', '3', '8', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('571', '3', '12', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('572', '3', '29', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('573', '3', '30', '1', '2018-09-25 15:49:32');
INSERT INTO `t_sys_role_menu` VALUES ('574', '5', '1', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('575', '5', '2', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('576', '5', '4', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('577', '5', '3', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('578', '5', '6', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('579', '5', '7', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('580', '5', '11', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('581', '5', '8', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('582', '5', '12', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('583', '5', '29', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('584', '5', '30', '1', '2018-09-25 15:49:38');
INSERT INTO `t_sys_role_menu` VALUES ('905', '6', '1', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('906', '6', '7', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('907', '6', '12', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('908', '6', '11', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('909', '6', '9', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('910', '6', '17', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('911', '6', '29', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('912', '6', '30', '1', '2019-01-22 18:08:32');
INSERT INTO `t_sys_role_menu` VALUES ('1042', '2', '1', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1043', '2', '9', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1044', '2', '17', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1045', '2', '25', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1046', '2', '16', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1047', '2', '15', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1048', '2', '13', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1049', '2', '14', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1050', '2', '31', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1051', '2', '33', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1052', '2', '19', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1053', '2', '1', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1054', '2', '2', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1055', '2', '4', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1056', '2', '3', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1057', '2', '5', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1058', '2', '6', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1059', '2', '10', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1060', '2', '7', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1061', '2', '12', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1062', '2', '51', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1063', '2', '11', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1064', '2', '29', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1065', '2', '30', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1066', '2', '1', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1067', '2', '49', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1068', '2', '50', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1069', '2', '40', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1070', '2', '41', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1071', '2', '42', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1072', '2', '1', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1073', '2', '46', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1074', '2', '47', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1075', '2', '48', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1076', '2', '43', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1077', '2', '44', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_menu` VALUES ('1078', '2', '45', '1', '2019-03-01 15:42:11');

-- ----------------------------
-- Table structure for t_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_permission`;
CREATE TABLE `t_sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  `create_id` int(11) NOT NULL COMMENT '创建人Id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8 COMMENT='角色与按钮权限的关系表';

-- ----------------------------
-- Records of t_sys_role_permission
-- ----------------------------
INSERT INTO `t_sys_role_permission` VALUES ('196', '2', '1', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('197', '2', '2', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('198', '2', '3', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('199', '2', '4', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('200', '2', '5', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('201', '2', '6', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('202', '2', '7', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('203', '2', '8', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('204', '2', '9', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('205', '2', '10', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('206', '2', '11', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('207', '2', '12', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('208', '2', '13', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('209', '2', '14', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('210', '2', '15', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('211', '2', '16', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('212', '2', '17', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('213', '2', '18', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('214', '2', '19', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('215', '2', '20', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('216', '2', '21', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('217', '2', '22', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('218', '2', '23', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('219', '2', '24', '1', '2019-03-01 15:42:11');
INSERT INTO `t_sys_role_permission` VALUES ('220', '2', '25', '1', '2019-03-01 15:42:11');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '691b14d79bf0fa2215f155235df5e670b64394cc', '13800000000', 'it@seebon', '1', '1', '2018-08-02 18:02:42', '2018-08-02 18:02:42');

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(20) NOT NULL COMMENT '用户ID(t_sys_user.id)',
  `role_id` int(20) NOT NULL COMMENT '角色id(t_sys_role.id)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_role_id_idx` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='系统用户的角色';

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', '1', '2');
INSERT INTO `t_sys_user_role` VALUES ('2', '1', '3');
INSERT INTO `t_sys_user_role` VALUES ('3', '1', '5');
INSERT INTO `t_sys_user_role` VALUES ('4', '1', '6');
INSERT INTO `t_sys_user_role` VALUES ('5', '2', '3');
INSERT INTO `t_sys_user_role` VALUES ('27', '4', '3');
INSERT INTO `t_sys_user_role` VALUES ('28', '4', '6');
INSERT INTO `t_sys_user_role` VALUES ('9', '8', '3');
INSERT INTO `t_sys_user_role` VALUES ('10', '9', '3');
INSERT INTO `t_sys_user_role` VALUES ('11', '10', '3');
INSERT INTO `t_sys_user_role` VALUES ('12', '11', '3');
INSERT INTO `t_sys_user_role` VALUES ('14', '13', '3');
INSERT INTO `t_sys_user_role` VALUES ('15', '13', '6');
INSERT INTO `t_sys_user_role` VALUES ('16', '14', '3');
INSERT INTO `t_sys_user_role` VALUES ('17', '15', '5');
INSERT INTO `t_sys_user_role` VALUES ('18', '16', '3');
INSERT INTO `t_sys_user_role` VALUES ('19', '17', '3');
INSERT INTO `t_sys_user_role` VALUES ('20', '18', '3');
INSERT INTO `t_sys_user_role` VALUES ('21', '19', '3');
INSERT INTO `t_sys_user_role` VALUES ('22', '19', '5');
INSERT INTO `t_sys_user_role` VALUES ('23', '19', '6');
