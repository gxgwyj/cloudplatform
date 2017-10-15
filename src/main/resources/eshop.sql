/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-10-15 14:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product_brand
-- ----------------------------
DROP TABLE IF EXISTS `product_brand`;
CREATE TABLE `product_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `b_name` varchar(32) DEFAULT NULL COMMENT '品牌名称',
  `b_place` varchar(32) DEFAULT NULL COMMENT '产地',
  `b_code` varchar(20) NOT NULL COMMENT '品牌编码',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品品牌表';

-- ----------------------------
-- Records of product_brand
-- ----------------------------
INSERT INTO `product_brand` VALUES ('1', '美特斯邦威', '中国浙江', '0001', '2016-11-22', '2016-11-22');
INSERT INTO `product_brand` VALUES ('2', '鸿星尔克', '中国厦门', '0002', '2016-11-22', '2016-11-22');
INSERT INTO `product_brand` VALUES ('3', '冠云', '山西平遥', '0080', null, null);
INSERT INTO `product_brand` VALUES ('4', '魅族', '上海', '', null, null);
INSERT INTO `product_brand` VALUES ('5', '联想', '北京', '', null, null);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(10) NOT NULL COMMENT '类别编码',
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  `p_code` varchar(10) NOT NULL COMMENT '父类code',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '0010', '服装', '000');
INSERT INTO `product_category` VALUES ('2', '0020', '鞋', '000');
INSERT INTO `product_category` VALUES ('3', '0030', '家具', '000');
INSERT INTO `product_category` VALUES ('4', '0040', '电器', '000');
INSERT INTO `product_category` VALUES ('5', '0050', '食品', '000');
INSERT INTO `product_category` VALUES ('6', '0060', '图书', '000');
INSERT INTO `product_category` VALUES ('7', '0060', '女装', '000');
INSERT INTO `product_category` VALUES ('8', '0070', '手机', '000');
INSERT INTO `product_category` VALUES ('9', '0090', '奶粉', '000');
INSERT INTO `product_category` VALUES ('10', '0090', '化妆品', '000');
INSERT INTO `product_category` VALUES ('11', '0050', '餐具', '000');
INSERT INTO `product_category` VALUES ('15', '0050', '文具', '000');
INSERT INTO `product_category` VALUES ('19', '0056', '水果', '000');
INSERT INTO `product_category` VALUES ('20', '0023', '酒水', '000');
INSERT INTO `product_category` VALUES ('22', '0023', '饮料', '000');

-- ----------------------------
-- Table structure for product_main
-- ----------------------------
DROP TABLE IF EXISTS `product_main`;
CREATE TABLE `product_main` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `p_name` varchar(32) NOT NULL COMMENT '商品名称',
  `p_price` decimal(10,0) NOT NULL COMMENT '商品价格',
  `p_code` varchar(32) NOT NULL COMMENT '商品编码',
  `p_brand` bigint(20) NOT NULL COMMENT '商品品牌Id',
  `p_category` bigint(20) NOT NULL COMMENT '商品类别Id',
  `p_comment` varchar(200) NOT NULL COMMENT '商品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息主表';

-- ----------------------------
-- Records of product_main
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
