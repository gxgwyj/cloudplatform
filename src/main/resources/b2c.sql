/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : b2c

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-10-12 21:23:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL COMMENT '品牌id',
  `name` varchar(32) DEFAULT NULL COMMENT '品牌名称',
  `e_name` varchar(32) DEFAULT NULL COMMENT '英文名称',
  `logo` varchar(32) DEFAULT NULL COMMENT 'logo图标',
  `desc` varchar(64) DEFAULT NULL COMMENT '品牌描述',
  `e_slogan` varchar(64) DEFAULT NULL COMMENT '口号（英文）',
  `c_slogan` varchar(64) DEFAULT NULL COMMENT '口号（中文）',
  `first_character` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- ----------------------------
-- Records of t_brand
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `desc` varchar(32) DEFAULT NULL COMMENT '类别描述',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父类别id',
  `sort_number` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类目表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL COMMENT '商品Id',
  `code` varchar(32) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `sell_point` varchar(32) DEFAULT NULL COMMENT '商品卖点',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_goods
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods_param
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_param`;
CREATE TABLE `t_goods_param` (
  `id` bigint(11) DEFAULT NULL COMMENT '主键',
  `category_id` bigint(11) NOT NULL COMMENT '类目Id',
  `param_data` text COMMENT '规格参数',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of t_goods_param
-- ----------------------------

-- ----------------------------
-- Table structure for t_good_param_value
-- ----------------------------
DROP TABLE IF EXISTS `t_good_param_value`;
CREATE TABLE `t_good_param_value` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `good_param_item` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_good_param_value
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
