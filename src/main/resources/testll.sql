/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : testll

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-02-13 13:41:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', 'admin@163.com', '18968698698', '0', '', '123456', '0', '0', '2019-02-12 16:25:27', null, '手动修改');
INSERT INTO `sys_user` VALUES ('4', 'testman002', '测试男孩2', 'ceshiman_1314@163.com', '15548569024', '0', '', '123456', '0', '0', '2019-02-13 11:11:18', null, '');
INSERT INTO `sys_user` VALUES ('5', 'testgirl001', '测试女1', '805543598@qq.com', '18555552120', '1', '', '12346', '0', '0', '2019-02-13 11:11:56', null, '');
INSERT INTO `sys_user` VALUES ('6', 'testman002', '测试男孩3', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', null, '');
INSERT INTO `sys_user` VALUES ('7', 'testman003', '测试男孩5', 'ceshiman_1314@163.com', '15548569024', '0', '', '123456', '0', '0', '2019-02-13 11:11:18', '2019-02-12 11:35:30', '');
INSERT INTO `sys_user` VALUES ('8', 'testgirl002', '测试女2', '805543598@qq.com', '18555552120', '1', '', '12346', '0', '0', '2019-02-13 11:11:56', '2019-02-19 11:35:35', '');
INSERT INTO `sys_user` VALUES ('9', 'testman004', '测试男孩4', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
INSERT INTO `sys_user` VALUES ('10', 'testman005', '测试男孩5', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
INSERT INTO `sys_user` VALUES ('11', 'testman006', '测试男孩6', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
INSERT INTO `sys_user` VALUES ('12', 'testman007', '测试男孩7', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
INSERT INTO `sys_user` VALUES ('13', 'testman008', '测试男孩8', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
INSERT INTO `sys_user` VALUES ('14', 'testman009', '测试男孩9', '805543598@qq.com', '15548569854', '0', '', '1234165', '0', '0', '2019-02-13 11:34:03', '2019-02-13 11:35:27', '');
