/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : coursedesign

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 08/07/2019 16:36:28
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '123', '123', '123');
INSERT INTO `admin` VALUES (2, 'admin', 'admin', 'admin');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1295 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1283, '1', '111', '111', '11123', '2019-07-05 15:51:34', '123');
INSERT INTO `message` VALUES (1286, '1', 'rtg', 'trg', 'grtgr', '2019-07-05 12:44:44', '123');
INSERT INTO `message` VALUES (1287, 'aaa', 'erfer', 'fer', 'ferf', '2019-07-05 12:59:48', 'aaa');
INSERT INTO `message` VALUES (1288, 'aaa', 'erfe', 'ferf', 'ferfe', '2019-07-05 13:00:00', 'aaa');
INSERT INTO `message` VALUES (1290, '发热发热', 'evr是的VR额', 'verve', '二发热', 'fre', '111');
INSERT INTO `message` VALUES (1291, 'aaa', 'chifan', '是的发热膜', '而反方二分', '2019-07-05 16:47:17', 'aaa');
INSERT INTO `message` VALUES (1292, 'aaa', '恩恩恩', '恩恩恩', '恩恩恩', '2019-07-05 16:48:30', 'aaa');
INSERT INTO `message` VALUES (1293, 'aaa', 'fefef', 'refref', 'refref', '2019-07-08 15:32:49', 'aaa');
INSERT INTO `message` VALUES (1294, 'admin', '吃饭', '吃饭', '123456今天要吃饭', '2019-07-08 16:27:04', 'admin');

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
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`MsgId`) REFERENCES `message` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (2, '123', '11111', '2019-07-04 18:23:08', 1283);
INSERT INTO `reply` VALUES (3, '12313null', '11111', '2019-07-04 18:33:59', 1283);
INSERT INTO `reply` VALUES (4, 'null123', '11111', '2019-07-04 18:56:31', 1283);
INSERT INTO `reply` VALUES (5, 'null123', '11111', '2019-07-04 19:07:37', 1283);
INSERT INTO `reply` VALUES (6, 'null23', '11111', '2019-07-04 19:09:12', 1283);
INSERT INTO `reply` VALUES (7, 'null33', '11111', '2019-07-04 19:48:00', 1283);
INSERT INTO `reply` VALUES (11, 'null', 'erfre', '2019-07-05 15:53:33', 1283);
INSERT INTO `reply` VALUES (12, 'null', 'efef', '2019-07-05 15:53:38', 1283);
INSERT INTO `reply` VALUES (13, 'null', 'evewvew', '2019-07-05 15:53:49', 1283);
INSERT INTO `reply` VALUES (14, 'null', '', '2019-07-05 15:55:25', 1283);
INSERT INTO `reply` VALUES (17, 'aaa', 'ff34f34f', '2019-07-05 19:31:56', 1283);
INSERT INTO `reply` VALUES (18, 'aaa', 'dwedwedwed', '2019-07-08 15:31:45', 1287);
INSERT INTO `reply` VALUES (19, 'aaa', 'fefef', '2019-07-08 15:32:25', 1283);
INSERT INTO `reply` VALUES (20, 'admin', '厉害啊，老哥', '2019-07-08 16:27:22', 1294);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '123', 'aaa');
INSERT INTO `user` VALUES (2, 'admin', 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
