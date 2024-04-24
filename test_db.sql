/*
 Navicat Premium Data Transfer

 Source Server         : 120.26.138.131
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 120.26.138.131:3326
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/04/2024 10:11:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_demo
-- ----------------------------
DROP TABLE IF EXISTS `t_demo`;
CREATE TABLE `t_demo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` int DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1782671324515192834 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_demo
-- ----------------------------
BEGIN;
INSERT INTO `t_demo` VALUES (1781245270718291969, 1, 'ef6ce');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
