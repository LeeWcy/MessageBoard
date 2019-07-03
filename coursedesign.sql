/*
Navicat MySQL Data Transfer

Source Server         : olive
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : coursedesign

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-04-06 20:01:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(10) NOT NULL,
  `adminPassword` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', '123');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` char(20) CHARACTER SET utf8mb4 NOT NULL,
  `MessageThem` char(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `MessageTitle` char(30) CHARACTER SET utf8mb4 NOT NULL,
  `MessageContent` char(255) CHARACTER SET utf8mb4 NOT NULL,
  `MessageReply` char(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `udate` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `replydate` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1245 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1239', '1231245', '12312354', 'QWEQWDFGVD', 'ASDASDSAXCZCZXCXZ', null, '2018-03-28 21:28:47', null);
INSERT INTO `message` VALUES ('1240', '221', 'é»å°æ°å³', 'ASDAS', 'xcvbvcbfg', null, '2018-03-29 10:07:38', null);
INSERT INTO `message` VALUES ('1241', '221', 'é»å°æ°å³', 'ASDAS', 'xcvbvcbfg', null, '2018-03-29 10:14:13', null);
INSERT INTO `message` VALUES ('1242', '221', 'é»å°æ°å³', 'ASDAS', 'xcvbvcbfg', null, '2018-03-29 10:15:17', null);
INSERT INTO `message` VALUES ('1243', '上的擦拭', '阿萨大苏打', '阿斯顿擦拭联系', '撒擦拭擦拭的', null, '2018-03-29 15:29:51', null);
INSERT INTO `message` VALUES ('1244', '都是', '自行车', '中心城中心', '风的造型出现在', null, '2018-03-29 17:02:15', null);
