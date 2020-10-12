/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db_spin_demo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 12/10/2020 17:11:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_perm
-- ----------------------------
DROP TABLE IF EXISTS `tb_perm`;
CREATE TABLE `tb_perm`  (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_perm
-- ----------------------------
INSERT INTO `tb_perm` VALUES (1, 0, '首页', 'fa fa-home', '/spindemo/indexContent', NULL, NULL, 'homeInfo', 0);
INSERT INTO `tb_perm` VALUES (2, 0, '智汇云考试系统', NULL, '/spindemo/index', 'layuimini/images/logo.png', NULL, 'logoInfo', 0);
INSERT INTO `tb_perm` VALUES (3, 0, '我的桌面', 'fa fa-desktop', '', NULL, NULL, 'menuInfo', 0);
INSERT INTO `tb_perm` VALUES (4, 3, '题库管理', 'fa fa-gears', '', NULL, '_self', NULL, 3);
INSERT INTO `tb_perm` VALUES (5, 3, '课程管理', 'fa fa-book', 'teacher/courseManage', NULL, '_self', NULL, 2);
INSERT INTO `tb_perm` VALUES (6, 4, '我的题库', 'fa fa-book', 'teacher/myRepo', NULL, '_self', NULL, 1);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('admin', '管理员');
INSERT INTO `tb_role` VALUES ('student', '学生');
INSERT INTO `tb_role` VALUES ('teacher', '教师');

-- ----------------------------
-- Table structure for tb_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_perm`;
CREATE TABLE `tb_role_perm`  (
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`, `perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_perm
-- ----------------------------
INSERT INTO `tb_role_perm` VALUES ('admin', 1);
INSERT INTO `tb_role_perm` VALUES ('admin', 2);
INSERT INTO `tb_role_perm` VALUES ('admin', 3);
INSERT INTO `tb_role_perm` VALUES ('admin', 4);
INSERT INTO `tb_role_perm` VALUES ('student', 1);
INSERT INTO `tb_role_perm` VALUES ('student', 2);
INSERT INTO `tb_role_perm` VALUES ('student', 3);
INSERT INTO `tb_role_perm` VALUES ('student', 5);
INSERT INTO `tb_role_perm` VALUES ('teacher', 1);
INSERT INTO `tb_role_perm` VALUES ('teacher', 2);
INSERT INTO `tb_role_perm` VALUES ('teacher', 3);
INSERT INTO `tb_role_perm` VALUES ('teacher', 4);
INSERT INTO `tb_role_perm` VALUES ('teacher', 5);
INSERT INTO `tb_role_perm` VALUES ('teacher', 6);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('174173315', '125dabef62136d880ec1172964e6aa8d', '174173315', 1);
INSERT INTO `tb_user` VALUES ('174173342', '13f7df70b085c57a17fd2f34d9e859e8', '174173342', 1);
INSERT INTO `tb_user` VALUES ('174173345', '19effbd1469335e5176e7567d807cef4', '174173345', 1);
INSERT INTO `tb_user` VALUES ('admin', 'df655ad8d3229f3269fad2a8bab59b6c', '管理员', 1);
INSERT INTO `tb_user` VALUES ('student1', '0b9d6b119a5fa33dd342a91d3ced6bef', '李四', 1);
INSERT INTO `tb_user` VALUES ('student2', '88561fe2a5639567a971d65855fc94d3', 'student2', 1);
INSERT INTO `tb_user` VALUES ('student21', '78382768d0d7faceb61c3608f1c5c8f7', '华哥', 1);
INSERT INTO `tb_user` VALUES ('student22', '24fadd88b1aba7415e948c613be5952a', '打', 1);
INSERT INTO `tb_user` VALUES ('student23', '4612bb8705d15b3eeb1c026ce8ed1a58', '国防', 1);
INSERT INTO `tb_user` VALUES ('student3', 'cc8fb239c956b5d7a69cc82b6911de8a', '王五', 1);
INSERT INTO `tb_user` VALUES ('student4', 'f3e15557f5759096de9bd5d0d5c3b0cb', 'student4', 1);
INSERT INTO `tb_user` VALUES ('student5', '103c6ae7b4ff99a531cc917330aa2587', 'student5', 1);
INSERT INTO `tb_user` VALUES ('teacher1', 'a9364a890a7c7fa3af25afb9645dc061', '张三', 1);

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `user_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('17412312', 'student');
INSERT INTO `tb_user_role` VALUES ('174173315', 'student');
INSERT INTO `tb_user_role` VALUES ('174173342', 'student');
INSERT INTO `tb_user_role` VALUES ('174173345', 'student');
INSERT INTO `tb_user_role` VALUES ('admin', 'admin');
INSERT INTO `tb_user_role` VALUES ('student1', 'student');
INSERT INTO `tb_user_role` VALUES ('student2', 'student');
INSERT INTO `tb_user_role` VALUES ('student21', 'student');
INSERT INTO `tb_user_role` VALUES ('student22', 'student');
INSERT INTO `tb_user_role` VALUES ('student23', 'student');
INSERT INTO `tb_user_role` VALUES ('student3', 'student');
INSERT INTO `tb_user_role` VALUES ('student4', 'student');
INSERT INTO `tb_user_role` VALUES ('student5', 'student');
INSERT INTO `tb_user_role` VALUES ('teacher1', 'teacher');

SET FOREIGN_KEY_CHECKS = 1;
