/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : messageboard

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 03/07/2019 16:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for logins
-- ----------------------------
DROP TABLE IF EXISTS `logins`;
CREATE TABLE `logins`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(11) NOT NULL,
  `time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logins
-- ----------------------------
INSERT INTO `logins` VALUES (1, '123', '123', 1, '2019-07-03');
INSERT INTO `logins` VALUES (2, '22', '22', 0, '2019-07-04');
INSERT INTO `logins` VALUES (3, '33', '33', 0, '2019-07-05');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言的主键',
  `login_id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `login_id`(`login_id`) USING BTREE,
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `logins` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (1, 2, '22', '2018-12-25', '第一次', '孙大圣在此一游，今天是2018年12月25日。');
INSERT INTO `messages` VALUES (2, 2, '22', '2018-12-25', '第二次', '社会主义核心价值观。');
INSERT INTO `messages` VALUES (3, 2, '22', '2018-12-25', '第三次', '留言板实验写好了。');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `message_id` int(11) NOT NULL COMMENT '留言id外键',
  `reply_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复内容',
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复的主键',
  `reply_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复时间',
  PRIMARY KEY (`reply_id`) USING BTREE,
  INDEX `message_id`(`message_id`) USING BTREE,
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`message_id`) REFERENCES `messages` (`message_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
