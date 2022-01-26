/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 47.99.48.23:3306
 Source Schema         : sevenhome_hotel

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 26/01/2022 12:08:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `grorder_id` int(0) DEFAULT NULL COMMENT '客房      订单外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (17, 55);
INSERT INTO `business` VALUES (18, 49);
INSERT INTO `business` VALUES (19, 85);
INSERT INTO `business` VALUES (20, 86);
INSERT INTO `business` VALUES (21, 87);
INSERT INTO `business` VALUES (22, 95);
INSERT INTO `business` VALUES (23, 96);
INSERT INTO `business` VALUES (24, 97);
INSERT INTO `business` VALUES (25, 98);
INSERT INTO `business` VALUES (26, 99);
INSERT INTO `business` VALUES (27, 106);

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `checkin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登记人姓名',
  `checkin_idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登记人身份证号',
  `ckeckin_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登记人电话',
  `checkin_intime` datetime(0) DEFAULT NULL COMMENT '到店时间',
  `checkin_leavetime` datetime(0) DEFAULT NULL COMMENT '离店时间',
  `checkin_deposit` decimal(10, 2) DEFAULT NULL COMMENT '押金',
  `checkin_roomrate` decimal(10, 2) DEFAULT NULL COMMENT '房费',
  `vip_id` int(0) DEFAULT NULL COMMENT 'vip表',
  `checkin_origin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '客户来源',
  `room_id` int(0) DEFAULT NULL COMMENT '房间表外键',
  `checkin_paytype` int(0) DEFAULT NULL COMMENT '支付方式(1:支付宝,2:微信,3:现金,4:银联,5:vip)',
  `checkin_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `employee_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '员工id外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vip_check`(`vip_id`) USING BTREE,
  CONSTRAINT `vip_check` FOREIGN KEY (`vip_id`) REFERENCES `vip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of check_in
-- ----------------------------
INSERT INTO `check_in` VALUES (86, '和好', '123321', '12345678909', '2022-01-26 00:00:00', '2022-01-26 09:55:43', 100.00, 0.00, 1, '2', 11, 1, NULL, '4');
INSERT INTO `check_in` VALUES (87, 'szqz', '123321', '12332112345', '2022-01-26 09:00:00', '2022-01-26 10:11:04', 100.00, 0.00, 1, '2', 17, 2, NULL, '5');
INSERT INTO `check_in` VALUES (88, 'wry', '123456', '12345678909', '2022-01-26 09:03:00', '2022-01-26 10:13:40', 100.00, 0.00, 1, '2', 12, 3, NULL, '5');
INSERT INTO `check_in` VALUES (89, 'wry', '123321', '12345678909', '2022-01-26 00:00:00', '2022-01-26 10:16:41', 100.00, 0.00, 1, '2', 18, 5, NULL, '7');
INSERT INTO `check_in` VALUES (90, 'hh', '123', '17371265673', '2022-01-26 00:00:00', '2022-01-26 10:19:55', 100.00, 0.00, NULL, '2', 12, 3, NULL, '8');
INSERT INTO `check_in` VALUES (91, 'wry', '123321', '12345678909', '2022-01-26 14:00:00', '2022-01-27 12:00:00', 100.00, 498.00, 1, '2', 1, 2, NULL, '8');
INSERT INTO `check_in` VALUES (92, 'zz', '12344444', '12341234123', '2022-01-26 00:00:00', '2022-01-29 14:00:00', 100.00, 1080.00, NULL, '2', 8, 3, NULL, '7');
INSERT INTO `check_in` VALUES (99, 'qwer', '42722', '12341233432', '2022-01-25 00:00:00', '2022-01-26 11:10:09', 100.00, 200.00, NULL, '2', 13, 3, NULL, '4');
INSERT INTO `check_in` VALUES (100, 'szqz', '123321', '12345678909', '2022-01-26 18:00:00', '2022-01-27 12:00:00', 100.00, 758.00, 1, '2', 10, 1, NULL, '6');
INSERT INTO `check_in` VALUES (101, 'lkk', '123123', '15671496068', '2022-01-27 00:00:00', '2022-01-28 00:00:00', 100.00, 482.16, 1, '2', 26, 2, NULL, '4');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `deposit_total` decimal(10, 2) DEFAULT NULL,
  `roomgoods_total` decimal(10, 2) DEFAULT NULL COMMENT '房间物品金额',
  `deposit_returnmoney` decimal(10, 2) DEFAULT NULL COMMENT '需退回金额=押金总额-房间物品金额',
  `order_id` int(0) DEFAULT NULL COMMENT '订单表外键',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '订单状态 y/已退  n/未退',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deposit_order`(`order_id`) USING BTREE,
  CONSTRAINT `deposit_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES (49, 100.00, 0.00, 100.00, 95, 'y');
INSERT INTO `deposit` VALUES (50, 100.00, 0.00, 100.00, 96, 'n');
INSERT INTO `deposit` VALUES (51, 100.00, 0.00, 100.00, 97, 'n');
INSERT INTO `deposit` VALUES (52, 100.00, 0.00, 100.00, 98, 'n');
INSERT INTO `deposit` VALUES (53, 100.00, 0.00, 100.00, 99, 'n');
INSERT INTO `deposit` VALUES (54, 100.00, 0.00, 100.00, 100, 'n');
INSERT INTO `deposit` VALUES (55, 100.00, 0.00, 100.00, 103, 'n');
INSERT INTO `deposit` VALUES (56, 100.00, 0.00, 100.00, 104, 'n');
INSERT INTO `deposit` VALUES (57, 100.00, 0.00, 100.00, 105, 'n');
INSERT INTO `deposit` VALUES (58, 100.00, 0.00, 100.00, 106, 'n');
INSERT INTO `deposit` VALUES (59, 100.00, 0.00, 100.00, 107, 'n');
INSERT INTO `deposit` VALUES (60, 100.00, 0.00, 100.00, 108, 'n');
INSERT INTO `deposit` VALUES (61, 100.00, 0.00, 100.00, 109, 'n');
INSERT INTO `deposit` VALUES (62, 100.00, 0.00, 100.00, 110, 'n');

-- ----------------------------
-- Table structure for depositdetail
-- ----------------------------
DROP TABLE IF EXISTS `depositdetail`;
CREATE TABLE `depositdetail`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `roomgoods_id` int(0) DEFAULT NULL COMMENT '房间物品表外键',
  `depositdetail_num` int(0) DEFAULT NULL COMMENT '数量',
  `deposit_id` int(0) DEFAULT NULL COMMENT '押金表外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deposot_detail`(`deposit_id`) USING BTREE,
  INDEX `roomgoods_id`(`roomgoods_id`) USING BTREE,
  CONSTRAINT `depositdetail_ibfk_1` FOREIGN KEY (`roomgoods_id`) REFERENCES `roomgoods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `deposot_detail` FOREIGN KEY (`deposit_id`) REFERENCES `deposit` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depositdetail
-- ----------------------------
INSERT INTO `depositdetail` VALUES (81, 1, 1, 49);
INSERT INTO `depositdetail` VALUES (82, 2, 1, 49);
INSERT INTO `depositdetail` VALUES (83, 3, 1, 49);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `empname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `emp_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '员工图片',
  `emp_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '工号',
  `emp_salary` decimal(10, 2) DEFAULT NULL COMMENT '工资',
  `emp_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `hotel_id` int(0) NOT NULL COMMENT '酒店（外键）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hotel id`(`hotel_id`) USING BTREE,
  CONSTRAINT `hotel id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (4, '付梓文', '男', 'admin1', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9528', 18000.00, 'y', 1);
INSERT INTO `employee` VALUES (5, '帅在旗中', '男', 'szqz', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9601', 2000.00, 'y', 1);
INSERT INTO `employee` VALUES (6, '魏如元', '男', 'wry', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9602', 2000.00, 'y', 1);
INSERT INTO `employee` VALUES (7, '何好', '男', 'hh', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9603', 2000.00, 'y', 1);
INSERT INTO `employee` VALUES (8, '李尹龙', '男', 'lyl', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9604', 2000.00, 'y', 1);
INSERT INTO `employee` VALUES (9, 'szqz', '男', 'szqz2', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '9605', 2000.00, 'y', 2);
INSERT INTO `employee` VALUES (11, 'lyl', '男', 'lyl2', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '8601', 2000.00, 'y', 2);
INSERT INTO `employee` VALUES (12, 'wry', '男', 'wry2', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '8602', 2000.00, 'y', 2);
INSERT INTO `employee` VALUES (13, 'hh', '男', 'hh2', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '8603', 2000.00, 'y', 2);
INSERT INTO `employee` VALUES (14, 'fzw', '男', 'fzw2', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '8604', 2000.00, 'y', 2);
INSERT INTO `employee` VALUES (15, '梅涛', '男', 'mt', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '7601', 2000.00, 'y', 3);
INSERT INTO `employee` VALUES (16, '罗坤', '男', 'lk', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '7602', 2000.00, 'y', 3);
INSERT INTO `employee` VALUES (17, '吴彦祖', '男', 'wyz', '$2a$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '7603', 2000.00, 'y', 3);
INSERT INTO `employee` VALUES (18, '彭于晏', '男', 'pyy', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '7604', 2000.00, 'y', 3);
INSERT INTO `employee` VALUES (19, '成龙', '男', 'cl', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '7605', 2000.00, 'y', 3);
INSERT INTO `employee` VALUES (20, '图图', '男', 'tt', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '6601', 2000.00, 'y', 4);
INSERT INTO `employee` VALUES (21, '牛爷爷', '男', 'nyy', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '6602', 2000.00, 'y', 4);
INSERT INTO `employee` VALUES (22, '小耳朵', '男', 'xed', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '6603', 2000.00, 'y', 4);
INSERT INTO `employee` VALUES (23, '哥斯拉', '男', 'gsl', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '6604', 2000.00, 'y', 4);
INSERT INTO `employee` VALUES (24, '超人', '男', 'cr', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '6605', 2000.00, 'y', 4);
INSERT INTO `employee` VALUES (25, '金刚狼', '男', 'jgl', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '5501', 20000.00, 'y', 5);
INSERT INTO `employee` VALUES (26, '美国队长', '男', 'mgdz', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '5502', 2000.00, 'y', 5);
INSERT INTO `employee` VALUES (27, '蜘蛛侠', '男', 'zzx', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '5503', 2000.00, 'y', 5);
INSERT INTO `employee` VALUES (28, '蚂蚁', '男', 'my', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '5504', 2000.00, 'y', 5);
INSERT INTO `employee` VALUES (29, '老鼠', '男', 'ls', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '5505', 2000.00, 'y', 5);
INSERT INTO `employee` VALUES (30, '杰克', '男', 'jk', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '4401', 2000.00, 'y', 6);
INSERT INTO `employee` VALUES (31, '汤姆', '男', 'tm', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '4402', 2000.00, 'y', 6);
INSERT INTO `employee` VALUES (32, '马瑞', '女', 'mr', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '4403', 2000.00, 'y', 6);
INSERT INTO `employee` VALUES (33, 'Druk', '男', 'druk', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '4404', 2000.00, 'y', 6);
INSERT INTO `employee` VALUES (34, 'mark', '男', 'mark', '$10$xnslfw/g/Q6mZd8cOrYN5u.Jcy6CS4sW1qrc4DHkT7BkTAbCQ.APi', NULL, '4405', 2000.00, 'y', 6);

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hotel_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店名称',
  `area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店区域（省，市，区）',
  `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '详细地址',
  `longitude` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '经度',
  `latitude` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '纬度',
  `hotel_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店联系电话',
  `hotel_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店描述',
  `homepage_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店首页图',
  `detail_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店详情图',
  `hotel_facility` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店公共设施',
  `hotel_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '酒店状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (1, '柒家-金融港店', '湖北省武汉市江夏区', '金融港A3栋6楼', '127.12165', '95.65423', '0710-66666', '酒店是一家高档商务酒店。酒店地处***商贸中心,位于**街与**大道相交处,酒店紧靠*** ***酒店装修时尚高雅,设施齐全,环境舒适。拥有跃层商务客房,酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等,服务配套与娱乐设施一应俱全。酒店以“宾客至上,服务第一”为经营宗旨,采用了科学的经营机制和管理方法,不断追求卓越,得到了社会的认可,更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐,都是您的理想之选', 'imges://00000.png', 'images:/11111', '电梯，吊顶灯，中央空调...', 'y');
INSERT INTO `hotel` VALUES (2, '柒家-上海打浦桥店', '上海市,黄浦区', '瞿溪路1151号', '121.472087', '31.198944', '0710-77777', '酒店是一家高档商务酒店。酒店地处***商贸中心,位于**街与**大道相交处,酒店紧靠*** ***酒店装修时尚高雅,设施齐全,环境舒适。拥有跃层商务客房,酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等,服务配套与娱乐设施一应俱全。酒店以“宾客至上,服务第一”为经营宗旨,采用了科学的经营机制和管理方法,不断追求卓越,得到了社会的认可,更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐,都是您的理想之选', 'images://1111.png', 'images://1111', '电梯，吊顶灯，中央空调...', 'y');
INSERT INTO `hotel` VALUES (3, '柒家-江汉路店', '湖北武汉市江夏区', '江汉路79号', '127.14.47', '96.121', '0711-8888', 'nb', 'images://1111.png', 'images://1111.png', '电梯，吊顶灯，中央空调...', 'y');
INSERT INTO `hotel` VALUES (4, '柒家-上海徐家汇店', '上海市,徐家汇', '徐家汇中心', '1245.45466', '50.133', '0710-88088', '酒店是一家高档商务酒店。酒店地处***商贸中心,位于**街与**大道相交处,酒店紧靠*** ***酒店装修时尚高雅,设施齐全,环境舒适。拥有跃层商务客房,酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等,服务配套与娱乐设施一应俱全。酒店以“宾客至上,服务第一”为经营宗旨,采用了科学的经营机制和管理方法,不断追求卓越,得到了社会的认可,更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐,都是您的理想之选', 'images://1111.png', 'images://1111.png', '电梯，吊顶灯，中央空调...', 'y');
INSERT INTO `hotel` VALUES (5, '柒家-北街店', '湖北省襄阳市襄城区', '北街', '123.52336', '50.133', '0710-88088', '酒店是一家高档商务酒店。酒店地处***商贸中心,位于**街与**大道相交处,酒店紧靠*** ***酒店装修时尚高雅,设施齐全,环境舒适。拥有跃层商务客房,酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等,服务配套与娱乐设施一应俱全。酒店以“宾客至上,服务第一”为经营宗旨,采用了科学的经营机制和管理方法,不断追求卓越,得到了社会的认可,更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐,都是您的理想之选', 'images://1111.png', 'images://1111.png', '电梯，吊顶灯，中央空调...', 'y');
INSERT INTO `hotel` VALUES (6, '柒家-藏龙岛店', '湖北省武汉市江夏区', '藏龙岛', '123.52336', '50.133', '0710-88088', '酒店是一家高档商务酒店。酒店地处***商贸中心,位于**街与**大道相交处,酒店紧靠*** ***酒店装修时尚高雅,设施齐全,环境舒适。拥有跃层商务客房,酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等,服务配套与娱乐设施一应俱全。酒店以“宾客至上,服务第一”为经营宗旨,采用了科学的经营机制和管理方法,不断追求卓越,得到了社会的认可,更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐,都是您的理想之选', 'images://1111.png', 'images://1111.png', NULL, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `orderno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `subscribe_id` int(0) DEFAULT NULL COMMENT '预约表外键',
  `checkin_id` int(0) DEFAULT NULL COMMENT '登记表外键',
  `order_totalprice` decimal(10, 1) DEFAULT NULL COMMENT '总费用',
  `order_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '1:已完成,2:已取消,3:已缴费,4.已生效',
  `order_generatetime` datetime(0) DEFAULT NULL COMMENT '生成订单时间',
  `room_id` int(0) DEFAULT NULL COMMENT '房间外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_subscribe`(`subscribe_id`) USING BTREE,
  INDEX `order_checkin`(`checkin_id`) USING BTREE,
  INDEX `order_room`(`room_id`) USING BTREE,
  CONSTRAINT `order_checkin` FOREIGN KEY (`checkin_id`) REFERENCES `check_in` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_subscribe` FOREIGN KEY (`subscribe_id`) REFERENCES `subscribe` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (95, '2022947362', NULL, 86, 100.0, '1', '2022-01-26 09:40:06', 11);
INSERT INTO `orders` VALUES (96, '2022786182', NULL, 87, 0.0, '1', '2022-01-26 10:08:32', 17);
INSERT INTO `orders` VALUES (97, '2022546889', NULL, 88, 100.0, '1', '2022-01-26 10:13:19', 12);
INSERT INTO `orders` VALUES (98, '2022088128', NULL, 89, 100.0, '1', '2022-01-26 10:15:31', 18);
INSERT INTO `orders` VALUES (99, '2022172638', NULL, 90, 100.0, '1', '2022-01-26 10:19:44', 12);
INSERT INTO `orders` VALUES (100, '2022445103', NULL, 91, 598.0, '4', '2022-01-26 10:23:18', 1);
INSERT INTO `orders` VALUES (103, '2022302967', 63, NULL, 336.2, '2', '2022-01-26 10:31:15', 2);
INSERT INTO `orders` VALUES (104, '2022106949', 64, NULL, 582.2, '3', '2022-01-26 10:33:33', 25);
INSERT INTO `orders` VALUES (105, '2022935004', NULL, 92, 1080.0, '4', '2022-01-26 11:00:36', 8);
INSERT INTO `orders` VALUES (106, '2022318625', NULL, 99, 300.0, '1', '2022-01-26 11:04:04', 13);
INSERT INTO `orders` VALUES (107, '2022449109', NULL, 100, 858.0, '4', '2022-01-26 11:07:53', 10);
INSERT INTO `orders` VALUES (108, '2022583720', 64, 101, 582.2, '4', '2022-01-26 11:12:16', 26);
INSERT INTO `orders` VALUES (109, '2022106584', 65, NULL, 344.4, '3', '2022-01-26 11:18:07', 1);
INSERT INTO `orders` VALUES (110, '2022943946', 66, NULL, 344.4, '3', '2022-01-26 11:26:33', 3);

-- ----------------------------
-- Table structure for perms
-- ----------------------------
DROP TABLE IF EXISTS `perms`;
CREATE TABLE `perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `perm_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限名',
  `per_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限编码',
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'url连接',
  `parentid` int(0) DEFAULT NULL COMMENT '父菜单id',
  `perm_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限类型',
  `perm_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perms
-- ----------------------------
INSERT INTO `perms` VALUES (1, '订单管理', '', 'order', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (2, '线上订单列表', 'order:list', 'order/list', 1, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (3, '订单修改', 'order:update', 'order/update', 1, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (4, '线下订单列表', 'order:reality', 'order/reality', 1, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (5, '押金管理', '', 'deposit', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (6, '押金列表', 'deposit:list', 'deposit/list', 5, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (7, '押金明细', 'deposit:detail', 'deposit/detail', 5, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (8, '押金状态修改', 'deposit:update', 'deposit/update', 5, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (9, '客房管理', '', 'findundeterminedClear', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (10, '待清房列表', 'business:findundeterminedClear', 'business/findundeterminedClear', 9, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (11, '消费商品添加', 'business:batchAdd', 'business/batchAdd', 9, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (12, '房态列表', 'room:roomStatus', 'room/roomStatus', 7, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (13, '预订管理', '', 'subscribe', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (14, '预订列表', 'subscribe:list', 'subscribe/list', 13, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (15, '预订房间下拉列表', 'subscribe:roomTypeList', 'subscribe/roomTypeList', 13, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (16, '预订酒店下拉列表', 'subscribe:hotelList', 'subscribe/hotelList', 13, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (17, '取消预约', 'subscribe:updateStatus', 'subscribe/updateStatus', 13, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (18, '预订详情', 'subscribe:querySubscribeDetail', 'subscribe/querySubscribeDetail', 13, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (19, '登记', '', 'checkin', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (20, '登记员工下拉列表', 'checkin:getEmpList', 'checkin/getEmpList', 19, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (21, '线下登记', 'checkin:insertCheckin', 'checkin/insertCheckin', 19, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (22, '提交支付类型', 'checkin:updatePayType', 'checkin/updatePayType', 19, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (23, '计算总金额', 'checkin:getTotal', 'checkin/getTotal', 19, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (24, '退房管理', '', 'checkout', 23, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (25, '查看退房列表', 'checkout:getRoomInUse', 'checkout/getRoomInUse', 23, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (26, '立即退房', 'checkout:checkOutRightNow', 'checkout/checkOutRightNow', 23, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (27, '修改退房时间', 'checkout:cancelSection', 'checkout/cancelSection', 23, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (28, '可选退房日期', 'checkout:showCancelSection', 'checkout/showCancelSection', 23, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (30, '线上用户', '', 'useronline', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (31, '用户注册', 'useronline:add', 'useronline/add', 30, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (32, '会员管理', NULL, 'vip', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (33, '查询是否是会员', 'vip:check', 'vip/check', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (34, '会员办理', 'vip:add', 'vip/add', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (35, '会员列表', 'vip:list', 'vip/list', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (36, '会员详情', 'vip:detail', 'vip/detail', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (37, '会员修改', 'vip:update', 'vip/update', NULL, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (38, '会员修改', 'vip:update', 'vip/update', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (39, '冻结会员', 'vip:freeze', 'vip/freeze', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (40, '激活会员', 'vip:activate', 'vip/activate', 32, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (41, '会员类型管理', NULL, 'viptype', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (42, '添加会员类型', 'viptype:add', 'viptype/add', 41, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (43, '修改会员类型', 'viptype:update', 'viptype/update', 41, 'p', 'y', NULL);
INSERT INTO `perms` VALUES (44, '会员类型列表', 'viptype:list', 'viptype:list', 41, 'p', 'y', NULL);

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `id` int(0) NOT NULL,
  `reserve_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `reserve_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `reserve_three` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `reserve_four` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `reserve_five` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名',
  `rcode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '前厅部 （Front desk）', 'ROLE:1');
INSERT INTO `role` VALUES (2, '客房部 （HD）', 'ROLE:2');
INSERT INTO `role` VALUES (3, '区域经理 Area Manager', 'ROLE:3');
INSERT INTO `role` VALUES (4, '总部 Project Manager', 'ROLE:4');

-- ----------------------------
-- Table structure for role_employee
-- ----------------------------
DROP TABLE IF EXISTS `role_employee`;
CREATE TABLE `role_employee`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(0) DEFAULT NULL COMMENT '角色外键',
  `employee_id` int(0) DEFAULT NULL COMMENT '员工外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE,
  CONSTRAINT `role_employee_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_employee_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_employee
-- ----------------------------
INSERT INTO `role_employee` VALUES (1, 1, 4);
INSERT INTO `role_employee` VALUES (2, 1, 5);
INSERT INTO `role_employee` VALUES (3, 1, 6);
INSERT INTO `role_employee` VALUES (4, 2, 7);
INSERT INTO `role_employee` VALUES (5, 1, 8);
INSERT INTO `role_employee` VALUES (6, 1, 9);
INSERT INTO `role_employee` VALUES (7, 1, 11);
INSERT INTO `role_employee` VALUES (10, 2, 12);
INSERT INTO `role_employee` VALUES (11, 2, 13);
INSERT INTO `role_employee` VALUES (12, 2, 14);
INSERT INTO `role_employee` VALUES (13, 3, 15);
INSERT INTO `role_employee` VALUES (14, 4, 16);

-- ----------------------------
-- Table structure for role_perms
-- ----------------------------
DROP TABLE IF EXISTS `role_perms`;
CREATE TABLE `role_perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_id` int(0) DEFAULT NULL,
  `perm_id` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `perm_id`(`perm_id`) USING BTREE,
  CONSTRAINT `role_perms_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_perms_ibfk_2` FOREIGN KEY (`perm_id`) REFERENCES `perms` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_perms
-- ----------------------------
INSERT INTO `role_perms` VALUES (1, 1, 1);
INSERT INTO `role_perms` VALUES (2, 1, 2);
INSERT INTO `role_perms` VALUES (3, 1, 3);
INSERT INTO `role_perms` VALUES (4, 1, 4);
INSERT INTO `role_perms` VALUES (5, 1, 5);
INSERT INTO `role_perms` VALUES (6, 1, 6);
INSERT INTO `role_perms` VALUES (7, 1, 7);
INSERT INTO `role_perms` VALUES (8, 1, 8);
INSERT INTO `role_perms` VALUES (9, 1, 9);
INSERT INTO `role_perms` VALUES (10, 1, 10);
INSERT INTO `role_perms` VALUES (11, 1, 11);
INSERT INTO `role_perms` VALUES (12, 1, 12);
INSERT INTO `role_perms` VALUES (13, 1, 13);
INSERT INTO `role_perms` VALUES (14, 1, 14);
INSERT INTO `role_perms` VALUES (15, 1, 15);
INSERT INTO `role_perms` VALUES (16, 1, 16);
INSERT INTO `role_perms` VALUES (17, 1, 17);
INSERT INTO `role_perms` VALUES (18, 1, 18);
INSERT INTO `role_perms` VALUES (19, 1, 19);
INSERT INTO `role_perms` VALUES (20, 1, 20);
INSERT INTO `role_perms` VALUES (21, 1, 21);
INSERT INTO `role_perms` VALUES (22, 1, 22);
INSERT INTO `role_perms` VALUES (23, 1, 23);
INSERT INTO `role_perms` VALUES (24, 1, 24);
INSERT INTO `role_perms` VALUES (25, 1, 25);
INSERT INTO `role_perms` VALUES (26, 1, 26);
INSERT INTO `role_perms` VALUES (27, 1, 27);
INSERT INTO `role_perms` VALUES (28, 1, 28);
INSERT INTO `role_perms` VALUES (29, 1, 30);
INSERT INTO `role_perms` VALUES (30, 1, 31);
INSERT INTO `role_perms` VALUES (31, 1, 32);
INSERT INTO `role_perms` VALUES (32, 1, 33);
INSERT INTO `role_perms` VALUES (33, 1, 34);
INSERT INTO `role_perms` VALUES (34, 1, 35);
INSERT INTO `role_perms` VALUES (35, 1, 36);
INSERT INTO `role_perms` VALUES (36, 1, 37);
INSERT INTO `role_perms` VALUES (37, 1, 38);
INSERT INTO `role_perms` VALUES (38, 1, 39);
INSERT INTO `role_perms` VALUES (39, 1, 40);
INSERT INTO `role_perms` VALUES (40, 1, 41);
INSERT INTO `role_perms` VALUES (41, 1, 42);
INSERT INTO `role_perms` VALUES (42, 1, 43);
INSERT INTO `role_perms` VALUES (43, 1, 44);
INSERT INTO `role_perms` VALUES (44, 2, 11);
INSERT INTO `role_perms` VALUES (45, 2, 12);
INSERT INTO `role_perms` VALUES (46, 2, 10);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rommno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房间编号',
  `roomtype_id` int(0) DEFAULT NULL COMMENT '房间类型编号',
  `room_floor` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房间楼层',
  `room_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房间状态 1.干净 2.脏 3.待维修 4.维修中',
  `hotel_id` int(0) DEFAULT NULL COMMENT '所属酒店（外键）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hotel_id`(`hotel_id`) USING BTREE,
  INDEX `roomtype_id`(`roomtype_id`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `room_ibfk_2` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '1001', 1, '1', '1', 1);
INSERT INTO `room` VALUES (2, '1002', 2, '1', '1', 1);
INSERT INTO `room` VALUES (3, '1003', 1, '1', '1', 1);
INSERT INTO `room` VALUES (4, '1004', 2, '1', '1', 1);
INSERT INTO `room` VALUES (5, '1005', 1, '1', '1', 1);
INSERT INTO `room` VALUES (6, '1006', 1, '1', '1', 1);
INSERT INTO `room` VALUES (7, '5006', 4, '1', '1', 1);
INSERT INTO `room` VALUES (8, '1007', 4, '1', '1', 1);
INSERT INTO `room` VALUES (9, '1008', 3, '1', '1', 1);
INSERT INTO `room` VALUES (10, '1009', 4, '1', '1', 1);
INSERT INTO `room` VALUES (11, '1010', 1, '1', '2', 1);
INSERT INTO `room` VALUES (12, '2001', 1, '2', '2', 1);
INSERT INTO `room` VALUES (13, '2002', 2, '2', '2', 1);
INSERT INTO `room` VALUES (14, '2003', 3, '2', '1', 1);
INSERT INTO `room` VALUES (15, '2004', 4, '2', '1', 1);
INSERT INTO `room` VALUES (16, '2005', 1, '2', '1', 1);
INSERT INTO `room` VALUES (17, '2006', 2, '2', '2', 1);
INSERT INTO `room` VALUES (18, '2007', 3, '2', '2', 1);
INSERT INTO `room` VALUES (19, '2008', 4, '2', '2', 1);
INSERT INTO `room` VALUES (20, '2009', 1, '2', '1', 1);
INSERT INTO `room` VALUES (21, '2010', 2, '2', '2', 1);
INSERT INTO `room` VALUES (22, '3001', 1, '3', '3', 1);
INSERT INTO `room` VALUES (23, '3002', 2, '3', '2', 1);
INSERT INTO `room` VALUES (24, '3003', 3, '3', '2', 1);
INSERT INTO `room` VALUES (25, '3004', 4, '3', '1', 1);
INSERT INTO `room` VALUES (26, '3005', 4, '3', '1', 1);
INSERT INTO `room` VALUES (27, '3006', 1, '3', '1', 1);
INSERT INTO `room` VALUES (28, '3007', 2, '3', '1', 1);
INSERT INTO `room` VALUES (29, '3008', 1, '3', '1', 1);
INSERT INTO `room` VALUES (30, '3009', 1, '3', '1', 1);
INSERT INTO `room` VALUES (31, '3010', 2, '3', '1', 1);
INSERT INTO `room` VALUES (32, '4001', 1, '4', '1', 1);
INSERT INTO `room` VALUES (33, '4002', 1, '4', '2', 1);
INSERT INTO `room` VALUES (34, '4003', 2, '4', '2', 1);
INSERT INTO `room` VALUES (35, '4004', 2, '4', '1', 1);
INSERT INTO `room` VALUES (36, '4005', 3, '4', '1', 1);
INSERT INTO `room` VALUES (37, '4006', 3, '4', '2', 1);
INSERT INTO `room` VALUES (38, '4000', 3, '4', '2', 1);
INSERT INTO `room` VALUES (39, '4007', 4, '4', '1', 1);
INSERT INTO `room` VALUES (40, '4008', 4, '4', '1', 1);
INSERT INTO `room` VALUES (41, '4009', 1, '4', '2', 1);
INSERT INTO `room` VALUES (42, '4010', 2, '4', '1', 1);
INSERT INTO `room` VALUES (44, '5001', 1, '1', '1', 2);
INSERT INTO `room` VALUES (45, '5002', 1, '1', '1', 2);
INSERT INTO `room` VALUES (47, '5003', 2, '1', '1', 3);
INSERT INTO `room` VALUES (48, '5004', 2, '1', '1', 4);
INSERT INTO `room` VALUES (49, '5005', 3, '1', '1', 5);

-- ----------------------------
-- Table structure for roomgoods
-- ----------------------------
DROP TABLE IF EXISTS `roomgoods`;
CREATE TABLE `roomgoods`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `roomgoods_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '物品名称',
  `roomgoods_price` decimal(10, 2) DEFAULT NULL COMMENT '物品价格',
  `goodstype` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '物品类型（设施/商品）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roomgoods
-- ----------------------------
INSERT INTO `roomgoods` VALUES (1, '薯条', 2.00, '商品');
INSERT INTO `roomgoods` VALUES (2, '可乐', 800.00, '设施');
INSERT INTO `roomgoods` VALUES (3, '薯片', 5.00, '商品');

-- ----------------------------
-- Table structure for roomhandle
-- ----------------------------
DROP TABLE IF EXISTS `roomhandle`;
CREATE TABLE `roomhandle`  (
  `id` int(0) NOT NULL,
  `handletype` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '处理类型(保洁/维修)',
  `handledate` datetime(0) DEFAULT NULL COMMENT '处理日期',
  `room_id` int(0) DEFAULT NULL COMMENT '房间id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `room_id`(`room_id`) USING BTREE,
  CONSTRAINT `roomhandle_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roomstatus
-- ----------------------------
DROP TABLE IF EXISTS `roomstatus`;
CREATE TABLE `roomstatus`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `room_id` int(0) DEFAULT NULL COMMENT '房间id',
  `roomstatus` int(0) DEFAULT NULL COMMENT '房间状态（0:可入住/1:已预约/2:已入住）',
  `roomstatus_date` date DEFAULT NULL COMMENT '房态日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `room_id`(`room_id`) USING BTREE,
  CONSTRAINT `roomstatus_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 233 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roomstatus
-- ----------------------------
INSERT INTO `roomstatus` VALUES (1, 1, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (233, 2, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (234, 3, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (235, 4, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (236, 5, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (237, 6, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (238, 8, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (239, 9, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (240, 10, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (241, 11, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (242, 12, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (243, 13, 2, '2022-01-26');
INSERT INTO `roomstatus` VALUES (244, 14, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (245, 15, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (246, 16, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (247, 17, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (248, 18, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (249, 19, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (250, 20, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (251, 21, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (252, 22, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (253, 23, 0, '2022-01-27');
INSERT INTO `roomstatus` VALUES (254, 24, 0, '2022-01-27');
INSERT INTO `roomstatus` VALUES (255, 25, 2, '2022-01-27');
INSERT INTO `roomstatus` VALUES (256, 26, 2, '2022-01-27');
INSERT INTO `roomstatus` VALUES (257, 27, 0, '2022-01-27');
INSERT INTO `roomstatus` VALUES (258, 28, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (259, 29, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (260, 30, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (261, 31, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (262, 32, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (263, 1, 2, '2022-01-28');
INSERT INTO `roomstatus` VALUES (264, 2, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (265, 3, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (266, 4, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (267, 5, 0, '2022-01-28');
INSERT INTO `roomstatus` VALUES (268, 23, 0, '2022-01-26');
INSERT INTO `roomstatus` VALUES (269, 13, 2, '2022-01-25');

-- ----------------------------
-- Table structure for roomtype
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roomtype_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房性名称',
  `market_price` decimal(10, 2) DEFAULT NULL COMMENT '门市价格',
  `online_price` decimal(10, 2) DEFAULT NULL COMMENT '线上价格',
  `roomtype_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房间类型状态',
  `roomtype_area` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房型面积',
  `bed_number` int(0) DEFAULT NULL COMMENT '床数',
  `bed_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '床型',
  `breakfast` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '有无早餐',
  `smoking` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否禁烟',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES (1, '大床房', 398.00, 298.00, '可用', '30', 1, '大床（1.8m*2.0m）', '含早', '禁烟');
INSERT INTO `roomtype` VALUES (2, '标准间', 358.00, 288.00, '可用', '30', 2, '双床（1.5m*2.0m）', '不含早', '禁烟');
INSERT INTO `roomtype` VALUES (3, '商务间', 458.00, 318.00, '可用', '35', 2, '双床（1.5m*2.0m）', '含早', '不禁烟');
INSERT INTO `roomtype` VALUES (4, '豪华套间', 658.00, 588.00, '可用', '40', 3, '大床（1.5m*2.0m）', '含早', '不禁烟');

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subscribe_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '预约人姓名',
  `subscribe_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '预约人电话',
  `subscribe_intime` datetime(0) DEFAULT NULL COMMENT '到店时间',
  `subscribe_leavetime` datetime(0) DEFAULT NULL COMMENT '离店时间',
  `subscribe_origin` int(0) DEFAULT NULL COMMENT '客户来源(1:线上,2:线下)',
  `subscribe_deposit` decimal(10, 2) DEFAULT NULL COMMENT '押金',
  `subscribe_roomrate` decimal(10, 2) DEFAULT NULL COMMENT '房费',
  `vip_id` int(0) DEFAULT NULL COMMENT 'vip外键',
  `roomtype_id` int(0) DEFAULT NULL COMMENT '房型外键',
  `employee_id` int(0) DEFAULT NULL COMMENT '员工外键',
  `subscribe_paytype` int(0) DEFAULT NULL COMMENT '支付方式:1:支付宝,2:微信,3:现金,4:银联,5:vip',
  `subscribe_status` int(0) DEFAULT NULL COMMENT '状态:1:已支付,:2:已取消',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vip_id`(`vip_id`) USING BTREE,
  INDEX `roomtype_id`(`roomtype_id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE,
  CONSTRAINT `subscribe_ibfk_1` FOREIGN KEY (`vip_id`) REFERENCES `vip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `subscribe_ibfk_2` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `subscribe_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe` VALUES (63, 'lkk', '15671496068', '2022-01-26 00:00:00', '2022-01-27 00:00:00', 1, 100.00, 236.16, 6, 2, 4, 1, 2);
INSERT INTO `subscribe` VALUES (64, 'lkk', '15671496068', '2022-01-27 00:00:00', '2022-01-28 00:00:00', 1, 100.00, 482.16, 6, 4, 4, 1, 1);
INSERT INTO `subscribe` VALUES (65, 'mtt', '18207149575', '2022-01-28 00:00:00', '2022-01-29 00:00:00', 1, 100.00, 244.36, 6, 1, 4, 1, 1);
INSERT INTO `subscribe` VALUES (66, 'tom', '123456789', '2022-01-26 00:00:00', '2022-01-27 00:00:00', 1, 100.00, 244.36, 6, 1, 4, 1, 1);

-- ----------------------------
-- Table structure for useronline
-- ----------------------------
DROP TABLE IF EXISTS `useronline`;
CREATE TABLE `useronline`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `useronline_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `useronline_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `useronline_totalpay` decimal(10, 2) DEFAULT NULL COMMENT '用户累计消费',
  `useronline_sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `useronline_idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of useronline
-- ----------------------------
INSERT INTO `useronline` VALUES (1, 'lkk', '123456', '15671496068', NULL, 15258.16, '1', '123456');
INSERT INTO `useronline` VALUES (2, 'szqz', '123456', '17354414035', NULL, 1000.00, '1', '654321');
INSERT INTO `useronline` VALUES (3, 'mtt', '123456', '18207149575', NULL, 15000.00, '1', '987654');
INSERT INTO `useronline` VALUES (4, 'tom', '123456', '123456789', NULL, 8795.00, '1', '165156');
INSERT INTO `useronline` VALUES (5, 'lee', '123456', '123456787', NULL, 2321.00, '1', '321123');
INSERT INTO `useronline` VALUES (6, 'Mark', '123456', '1234567891', NULL, 1233.00, '0', '12315641');
INSERT INTO `useronline` VALUES (7, 'Miss', '123456', '1234567892', NULL, 1233.00, '0', '12315641');
INSERT INTO `useronline` VALUES (9, '15616546', '123456', '15616546', NULL, 0.00, '0', '16516516');
INSERT INTO `useronline` VALUES (10, '1764862156', '123456', '1764862156', NULL, 0.00, '1', '641641641');
INSERT INTO `useronline` VALUES (11, '1561615646', '123456', '1561615646', NULL, 0.00, '1', '1564641651');
INSERT INTO `useronline` VALUES (12, '15616165', '123456', '15616165', NULL, 0.00, '1', '4541561');
INSERT INTO `useronline` VALUES (13, '456454164', '123456', '456454164', NULL, 0.00, '1', 'c15615613');
INSERT INTO `useronline` VALUES (14, '1651564165', '123456', '1651564165', NULL, 0.00, '1', '156161');
INSERT INTO `useronline` VALUES (15, '17354415626', '123456', '17354415626', NULL, 0.00, '1', '4290061998010520');
INSERT INTO `useronline` VALUES (16, '15616595156', '123456', '15616595156', NULL, 0.00, '1', '156165516');
INSERT INTO `useronline` VALUES (17, '12345691', '123456', '12345691', NULL, 0.00, '1', '423622333');

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `vip_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `vip_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '1:正常,2:冻结,3:过期',
  `vip_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `viptype_id` int(0) DEFAULT NULL COMMENT 'viptype外键',
  `vip_starttime` datetime(0) DEFAULT NULL COMMENT 'vip开始时间',
  `vip_endtime` datetime(0) DEFAULT NULL COMMENT 'vip结束时间',
  `useronline_id` int(0) DEFAULT NULL COMMENT 'useronline外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vip_type`(`viptype_id`) USING BTREE,
  INDEX `user_vip`(`useronline_id`) USING BTREE,
  CONSTRAINT `user_vip` FOREIGN KEY (`useronline_id`) REFERENCES `useronline` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vip_type` FOREIGN KEY (`viptype_id`) REFERENCES `viptype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES (1, '8808', '2', 'wry', 6, '2022-01-13 15:10:01', '2022-01-26 00:00:00', 1);
INSERT INTO `vip` VALUES (2, '9909', '1', NULL, 6, '2022-01-15 11:22:37', '2022-04-23 11:22:41', 2);
INSERT INTO `vip` VALUES (3, '1101', '1', NULL, 6, '2022-01-13 16:59:38', '2022-11-13 16:59:41', 3);
INSERT INTO `vip` VALUES (4, '3303', '1', NULL, 6, '2022-01-13 16:59:38', '2022-11-13 16:59:41', 4);
INSERT INTO `vip` VALUES (5, '6606', '1', NULL, 6, '2022-01-20 09:55:24', '2022-12-20 09:55:26', 5);
INSERT INTO `vip` VALUES (6, '1332', '1', NULL, 6, '2022-01-20 09:55:24', '2022-12-20 09:55:26', 6);
INSERT INTO `vip` VALUES (9, '1123', '1', NULL, 1, '2022-01-20 12:29:28', '2022-01-27 00:00:00', 13);
INSERT INTO `vip` VALUES (10, 'V1651564165859', '1', 'cx', 1, '2022-01-25 12:27:46', '2022-01-29 00:00:00', 14);
INSERT INTO `vip` VALUES (12, 'V17354415626608', '1', '2022', 1, '2022-01-25 14:22:32', '2022-01-26 00:00:00', 15);
INSERT INTO `vip` VALUES (13, 'V15616595156705', '1', '收到', 1, '2022-01-25 16:56:07', '2022-01-27 00:02:00', 16);
INSERT INTO `vip` VALUES (15, 'V12345691505', '1', '已开启', 1, '2022-01-26 10:50:30', '2022-01-30 00:00:00', 17);
INSERT INTO `vip` VALUES (16, 'V459', '1', '收到', 1, '2022-01-26 10:51:45', '2022-01-28 00:00:00', 7);
INSERT INTO `vip` VALUES (17, 'V979', '1', '收到', 1, '2022-01-26 10:51:51', '2022-01-28 00:00:00', 7);

-- ----------------------------
-- Table structure for viptype
-- ----------------------------
DROP TABLE IF EXISTS `viptype`;
CREATE TABLE `viptype`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `viptype_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `viptype_level` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '等级',
  `viptype_discount` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '折扣',
  `viptype_step` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '升级门槛',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of viptype
-- ----------------------------
INSERT INTO `viptype` VALUES (1, '普通用户', '0', '1.00', '0');
INSERT INTO `viptype` VALUES (2, '普通会员', '1', '0.95', '500');
INSERT INTO `viptype` VALUES (3, '白银会员', '2', '0.92', '1000');
INSERT INTO `viptype` VALUES (4, '黄金会员', '3', '0.88', '2000');
INSERT INTO `viptype` VALUES (5, '白金会员', '4', '0.85', '5000');
INSERT INTO `viptype` VALUES (6, '钻石会员', '5', '0.82', '10000');
INSERT INTO `viptype` VALUES (16, '永久会员', '4', '0.80', '10000');
INSERT INTO `viptype` VALUES (17, '永久会员', '4', '0.70', '5000');

SET FOREIGN_KEY_CHECKS = 1;
