/*
Navicat MySQL Data Transfer

Source Server         : bcts
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : bcts-service-admin

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001
Author                :zhangyunfei

Date: 2020-04-05 17:24:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bcts_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `bcts_sys_user`;
CREATE TABLE `bcts_sys_user` (
  `user_code` varchar(100) NOT NULL COMMENT '用户编码',
  `login_code` varchar(100) NOT NULL COMMENT '登录账号',
  `user_name` varchar(100) NOT NULL COMMENT '用户昵称',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `email` varchar(300) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(100) DEFAULT NULL COMMENT '办公电话',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别',
  `avatar` varchar(1000) DEFAULT NULL COMMENT '头像路径',
  `sign` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `wx_openid` varchar(100) DEFAULT NULL COMMENT '绑定的微信号',
  `mobile_imei` varchar(100) DEFAULT NULL COMMENT '绑定的手机串号',
  `user_type` varchar(16) NOT NULL COMMENT '用户类型',
  `ref_code` varchar(64) DEFAULT NULL COMMENT '用户类型引用编号',
  `ref_name` varchar(100) DEFAULT NULL COMMENT '用户类型引用姓名',
  `mgr_type` char(1) NOT NULL COMMENT '管理员类型（0非管理员 1系统管理员  2二级管理员）',
  `pwd_security_level` decimal(1,0) DEFAULT NULL COMMENT '密码安全级别（0初始 1很弱 2弱 3安全 4很安全）',
  `pwd_update_date` datetime DEFAULT NULL COMMENT '密码最后更新时间',
  `pwd_update_record` varchar(1000) DEFAULT NULL COMMENT '密码修改记录',
  `pwd_question` varchar(200) DEFAULT NULL COMMENT '密保问题',
  `pwd_question_answer` varchar(200) DEFAULT NULL COMMENT '密保问题答案',
  `pwd_question_2` varchar(200) DEFAULT NULL COMMENT '密保问题2',
  `pwd_question_answer_2` varchar(200) DEFAULT NULL COMMENT '密保问题答案2',
  `pwd_question_3` varchar(200) DEFAULT NULL COMMENT '密保问题3',
  `pwd_question_answer_3` varchar(200) DEFAULT NULL COMMENT '密保问题答案3',
  `pwd_quest_update_date` datetime DEFAULT NULL COMMENT '密码问题修改时间',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `freeze_date` datetime DEFAULT NULL COMMENT '冻结时间',
  `freeze_cause` varchar(200) DEFAULT NULL COMMENT '冻结原因',
  `user_weight` decimal(8,0) DEFAULT '0' COMMENT '用户权重（降序）',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1删除 2停用 3冻结）',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `corp_code` varchar(64) NOT NULL DEFAULT '0' COMMENT '归属集团Code',
  `corp_name` varchar(100) NOT NULL DEFAULT 'iToken' COMMENT '归属集团Name',
  `extend_s1` varchar(500) DEFAULT NULL COMMENT '扩展 String 1',
  `extend_s2` varchar(500) DEFAULT NULL COMMENT '扩展 String 2',
  `extend_s3` varchar(500) DEFAULT NULL COMMENT '扩展 String 3',
  `extend_i1` decimal(19,0) DEFAULT NULL COMMENT '扩展 Integer 1',
  `extend_i2` decimal(19,0) DEFAULT NULL COMMENT '扩展 Integer 2',
  `extend_f1` decimal(19,4) DEFAULT NULL COMMENT '扩展 Float 1',
  `extend_f2` decimal(19,4) DEFAULT NULL COMMENT '扩展 Float 2',
  `extend_d1` datetime DEFAULT NULL COMMENT '扩展 Date 1',
  `extend_d2` datetime DEFAULT NULL COMMENT '扩展 Date 2',
  PRIMARY KEY (`user_code`),
  KEY `idx_sys_user_lc` (`login_code`),
  KEY `idx_sys_user_email` (`email`(255)),
  KEY `idx_sys_user_mobile` (`mobile`),
  KEY `idx_sys_user_wo` (`wx_openid`),
  KEY `idx_sys_user_imei` (`mobile_imei`),
  KEY `idx_sys_user_rt` (`user_type`),
  KEY `idx_sys_user_rc` (`ref_code`),
  KEY `idx_sys_user_mt` (`mgr_type`),
  KEY `idx_sys_user_us` (`user_weight`),
  KEY `idx_sys_user_ud` (`update_date`),
  KEY `idx_sys_user_status` (`status`),
  KEY `idx_sys_user_cc` (`corp_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
