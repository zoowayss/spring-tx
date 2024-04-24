/*
 Navicat MySQL Data Transfer

 Source Server         : myself-aliyun
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : 120.26.138.131:3326
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 30/04/2024 10:50:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_demo
-- ----------------------------
DROP TABLE IF EXISTS `t_demo`;
CREATE TABLE `t_demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `emails` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1785138535779713026 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_demo
-- ----------------------------
BEGIN;
INSERT INTO `t_demo` (`id`, `status`, `content`, `emails`) VALUES (1781245270718291969, 1, 'ef6ce', '');
INSERT INTO `t_demo` (`id`, `status`, `content`, `emails`) VALUES (1785138535779713025, 1, '7f01c', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
