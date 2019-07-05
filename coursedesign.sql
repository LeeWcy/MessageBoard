/*
 Navicat Premium Data Transfer

 Source Server         : aliyun_3306
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : coursedesign

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 05/07/2019 11:55:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `adminPassword` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `account` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '123', '123', '123');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MessageThem` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `MessageTitle` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MessageContent` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `udate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `account` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1286 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1283, '1', 'sssss', 'ssssss', 'ssssssssss', '2019-07-04 16:44:05', '123');
INSERT INTO `message` VALUES (1284, '1', 'qqqq', 'qqq', 'qqqqq', '2019-07-04 18:06:22', '123');
INSERT INTO `message` VALUES (1285, '2', 'rrrr', 'rrr', 'rrr', '2019-07-05 12:23:56', '222');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ReplyContent` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Replydate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MsgId` int(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `MSG_ID`(`MsgId`) USING BTREE,
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`MsgId`) REFERENCES `message` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (2, '123', '11111', '2019-07-04 18:23:08', 1283);
INSERT INTO `reply` VALUES (3, '12313null', '11111', '2019-07-04 18:33:59', 1283);
INSERT INTO `reply` VALUES (4, 'null123', '11111', '2019-07-04 18:56:31', 1283);
INSERT INTO `reply` VALUES (5, 'null123', '11111', '2019-07-04 19:07:37', 1283);
INSERT INTO `reply` VALUES (6, 'null23', '11111', '2019-07-04 19:09:12', 1283);
INSERT INTO `reply` VALUES (7, 'null33', '11111', '2019-07-04 19:48:00', 1283);
INSERT INTO `reply` VALUES (8, 'sdefe', 'fwef', '2019-07-05 18:20:56', 1284);
INSERT INTO `reply` VALUES (9, 'vvv', 'vvvv', '2019-07-05 18:20:56', 1285);
INSERT INTO `reply` VALUES (10, 'df', 'df', '2019-07-05 18:20:56', 1285);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '123', 'aaa');

SET FOREIGN_KEY_CHECKS = 1;
