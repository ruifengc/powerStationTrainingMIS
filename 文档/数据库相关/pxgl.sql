/*
Navicat MySQL Data Transfer

Source Server         : pxgl
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : pxgl

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-12-03 16:38:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance_time
-- ----------------------------
DROP TABLE IF EXISTS `attendance_time`;
CREATE TABLE `attendance_time` (
  `ATTENDANCE_TIME_ID` varchar(50) NOT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `START_TIME` time DEFAULT NULL,
  `END_TIME` time DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ATTENDANCE_TIME_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_time
-- ----------------------------
INSERT INTO `attendance_time` VALUES ('044aedf5-7912-417f-b903-73393cf56cf9', null, '08:30:00', '10:30:00', null);
INSERT INTO `attendance_time` VALUES ('d0d6a6f3-b118-4e88-8db6-a9d5da861870', null, '14:36:00', '16:36:00', null);

-- ----------------------------
-- Table structure for dic_system_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dic_system_dictionary`;
CREATE TABLE `dic_system_dictionary` (
  `DICTIONARY_OPTION_ID` varchar(40) NOT NULL,
  `DICTIONARY_OPTION_NAME` varchar(50) DEFAULT '',
  `UP_DICTIONARY_OPTION_ID` varchar(30) DEFAULT '',
  `IS_USE` int(11) DEFAULT '0',
  `DESCRIPTIONS` varchar(200) DEFAULT '',
  `SORT_NO` int(11) DEFAULT '0',
  `FLAG` int(11) DEFAULT '0',
  `ENGLISH_NAME` varchar(100) DEFAULT '',
  `DATA_TYPE` varchar(100) DEFAULT '',
  `REMARK1` varchar(20) DEFAULT '',
  `REMARK2` varchar(20) DEFAULT '',
  `MATCH_DIC_ID` varchar(30) DEFAULT '',
  PRIMARY KEY (`DICTIONARY_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dic_system_dictionary
-- ----------------------------
INSERT INTO `dic_system_dictionary` VALUES ('001', '培训计划类型', '0', '1', '培训计划类型', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('001001', '新员工入厂培训', '001', '1', '', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('001002', '中层管理人员培训', '001', '1', '中层管理人员培训', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('001003', '班组长培训', '001', '1', '班组长培训', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('002', '培训专业', '0', '1', '培训专业', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('002001', '电气', '002', '1', '电气', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('002002', '汽机', '002', '1', '汽机', '0', '0', '', '2', '', null, '');
INSERT INTO `dic_system_dictionary` VALUES ('002003', '锅炉', '002', '1', '锅炉', '0', '0', '', '2', '', null, '');

-- ----------------------------
-- Table structure for emp_attendance
-- ----------------------------
DROP TABLE IF EXISTS `emp_attendance`;
CREATE TABLE `emp_attendance` (
  `EMP_ATTENDANCE_ID` varchar(50) NOT NULL COMMENT '主键',
  `TRAIN_EMP_ID` varchar(50) DEFAULT NULL COMMENT '学员安排ID',
  `EMP_ID` varchar(50) DEFAULT NULL COMMENT '员工ID',
  `TRAIN_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '培训明细ID',
  `RECORD_DATE` date DEFAULT NULL COMMENT '出勤日期',
  `CLASS_START_TIME` time DEFAULT NULL COMMENT '上课时间',
  `CLASS_END_TIME` time DEFAULT NULL COMMENT '下课时间',
  `ATTENDANCE_RESULT` varchar(2) DEFAULT NULL COMMENT '考勤情况',
  `REMARK` varchar(50) DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EMP_ATTENDANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤明细表';

-- ----------------------------
-- Records of emp_attendance
-- ----------------------------
INSERT INTO `emp_attendance` VALUES ('007ba78b-3f0d-41ca-a647-eb1ee45a040b', 'db10fbef-9a87-449a-bd96-9f18b95035b1', null, null, '2015-03-30', null, null, '3', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('01ebc1b9-7b4d-439a-b09b-6484b9b6adde', 'f1ee8c33-fb29-45e2-8a89-7b10693aa5ac', null, null, '2015-04-01', null, null, '0', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('0ad9c438-b91e-4b2e-bdd2-906031855ccc', 'db10fbef-9a87-449a-bd96-9f18b95035b1', null, null, '2015-04-01', null, null, '1', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('22dfffd3-6e21-4019-ad70-05327635a615', '7bdb9612-7e75-448a-9205-41ed058745fe', null, null, '2015-04-01', null, null, '2', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('2b28a9e7-0185-446b-b5c5-df771ec6691f', '3eace26e-2db3-4d85-b71a-9007dcf04ebc', null, null, '2015-03-30', null, null, '2', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('34654159-00cd-444e-b836-32a69f43ee74', '36f7e45a-b09a-4c80-8dec-825aea217b5b', null, null, '2015-04-01', null, null, '3', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('430c7629-ac68-4ae0-a7b3-1ace2171de3f', '2c9a15dd-797e-4904-bdcd-cdc2ca03da3c', null, null, '2015-04-01', null, null, '2', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('4c4fbeef-41cf-49f8-aa3d-9e0c5e9bc824', '2c9a15dd-797e-4904-bdcd-cdc2ca03da3c', null, null, '2015-03-30', null, null, '0', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('538ac694-2450-4181-875c-9b014d69bbd9', 'f1ee8c33-fb29-45e2-8a89-7b10693aa5ac', null, null, '2015-03-30', null, null, '1', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('53fd43ef-7856-4094-99b5-7e2d939a3d62', '3eace26e-2db3-4d85-b71a-9007dcf04ebc', null, null, '2015-04-01', null, null, '0', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('55789956-0501-4c59-8c32-7ed3c6396602', '36f7e45a-b09a-4c80-8dec-825aea217b5b', null, null, '2015-03-30', null, null, '2', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('5881a960-17ef-4937-b766-d95ad23f1b7e', '2c9a15dd-797e-4904-bdcd-cdc2ca03da3c', null, null, '2015-03-30', null, null, '0', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('5b28842b-6efc-4638-87c5-58fc96d5b1ff', '8e31a6eb-57df-442c-be21-49ea4cb370c2', null, null, '2015-03-30', null, null, '0', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('6dec5248-d5ed-4763-bb65-1659edb84ff2', '36f7e45a-b09a-4c80-8dec-825aea217b5b', null, null, '2015-03-30', null, null, '3', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('7e7e7dcb-6bae-40db-ae22-ed6c0b85b075', '8e31a6eb-57df-442c-be21-49ea4cb370c2', null, null, '2015-04-01', null, null, '1', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('8808ff86-f8a2-406e-918b-ae1ab5318a0c', '8e31a6eb-57df-442c-be21-49ea4cb370c2', null, null, '2015-03-30', null, null, '0', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('8c47b83d-2939-43ae-a2c0-1beaa33461cd', 'f1ee8c33-fb29-45e2-8a89-7b10693aa5ac', null, null, '2015-03-30', null, null, '0', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('95a18f26-6089-43e7-ac5e-0509af15a756', 'db10fbef-9a87-449a-bd96-9f18b95035b1', null, null, '2015-03-30', null, null, '0', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('99bc3cc5-19c3-4624-8ca9-c5050024e979', '7bdb9612-7e75-448a-9205-41ed058745fe', null, null, '2015-03-30', null, null, '0', 'd0d6a6f3-b118-4e88-8db6-a9d5da861870', null);
INSERT INTO `emp_attendance` VALUES ('9b9f3a20-81cd-4440-82fb-9d430cba360c', '3eace26e-2db3-4d85-b71a-9007dcf04ebc', null, null, '2015-03-30', null, null, '1', '044aedf5-7912-417f-b903-73393cf56cf9', null);
INSERT INTO `emp_attendance` VALUES ('de2d427a-0b04-49a8-abd9-76c173b57fc9', '7bdb9612-7e75-448a-9205-41ed058745fe', null, null, '2015-03-30', null, null, '2', '044aedf5-7912-417f-b903-73393cf56cf9', null);

-- ----------------------------
-- Table structure for train_emp
-- ----------------------------
DROP TABLE IF EXISTS `train_emp`;
CREATE TABLE `train_emp` (
  `TRAIN_EMP_ID` varchar(50) NOT NULL COMMENT '主键',
  `TRAIN_PLAN_ID` varchar(50) DEFAULT NULL COMMENT '培训计划ID',
  `TRAIN_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '培训明细ID',
  `EMP_ID` varchar(50) DEFAULT NULL COMMENT '员工ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训学员安排表';

-- ----------------------------
-- Records of train_emp
-- ----------------------------
INSERT INTO `train_emp` VALUES ('2c9a15dd-797e-4904-bdcd-cdc2ca03da3c', '1', '40030769-6c73-46ad-b475-b3d653719e96', '3b0ee83d-5201-47d8-9707-892ea82f2d2c', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('36f7e45a-b09a-4c80-8dec-825aea217b5b', '1', '40030769-6c73-46ad-b475-b3d653719e96', '6b896b6f-e12e-4c5e-b998-8c3f8343fd8e', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('3a00e090-be69-4a0a-8823-50e67b6fd063', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', '3b0ee83d-5201-47d8-9707-892ea82f2d2c', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('3eace26e-2db3-4d85-b71a-9007dcf04ebc', '1', '40030769-6c73-46ad-b475-b3d653719e96', 'db5e292f-6f45-4f25-bf5a-41a2843f9c84', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('75c56c1b-74eb-441b-b9d8-a1828c5182fd', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', 'd96260ce-2fb4-4318-90a5-174d299149d2', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('7bdb9612-7e75-448a-9205-41ed058745fe', '1', '40030769-6c73-46ad-b475-b3d653719e96', '33c3fb72-e1a5-46bc-b4a2-2ddc6f49a079', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('8d7c3668-8742-4e30-861a-d9b342b6a56b', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', 'db5e292f-6f45-4f25-bf5a-41a2843f9c84', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('8e31a6eb-57df-442c-be21-49ea4cb370c2', '1', '40030769-6c73-46ad-b475-b3d653719e96', 'd96260ce-2fb4-4318-90a5-174d299149d2', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('9240ff2b-e259-430b-bfb7-f437eb6a71cc', '1', '40030769-6c73-46ad-b475-b3d653719e96', 'f76ea2a2-0bbc-4302-aa2a-42b1dcdc36d1', '2015-04-13 05:58:01', null);
INSERT INTO `train_emp` VALUES ('9545faae-d46f-4676-bea1-b4ccb48b60f8', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', '7552c2eb-e9f4-4a41-b9b3-5e4e3dfe2861', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('bced469e-0ecd-4512-9b7e-4f0f26bebfda', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', '0ab89a5c-728e-4721-a3bd-9b49e7c121d1', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('db10fbef-9a87-449a-bd96-9f18b95035b1', '1', '40030769-6c73-46ad-b475-b3d653719e96', '0ab89a5c-728e-4721-a3bd-9b49e7c121d1', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('f1ee8c33-fb29-45e2-8a89-7b10693aa5ac', '1', '40030769-6c73-46ad-b475-b3d653719e96', '7552c2eb-e9f4-4a41-b9b3-5e4e3dfe2861', '2015-04-12 10:27:49', null);
INSERT INTO `train_emp` VALUES ('f74d48ae-e61a-465a-915c-b3c310eeb8ee', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', '33c3fb72-e1a5-46bc-b4a2-2ddc6f49a079', '2015-04-16 16:34:05', null);
INSERT INTO `train_emp` VALUES ('fa99913e-f1aa-42ec-b450-0f0bca7cbc93', 'c5241d09-931e-4884-9861-59b7bd4983d1', '8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', 'f76ea2a2-0bbc-4302-aa2a-42b1dcdc36d1', '2015-04-16 16:34:05', null);

-- ----------------------------
-- Table structure for train_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `train_evaluation`;
CREATE TABLE `train_evaluation` (
  `TRAIN_EVALUATION_ID` varchar(50) NOT NULL COMMENT '主键',
  `TRAIN_ITME_ID` varchar(50) DEFAULT NULL COMMENT '培训细明ID',
  `EMP_ID` varchar(50) DEFAULT NULL COMMENT '员工ID\r\n',
  `EVALUATION_CONTENT` text COMMENT '评价内容',
  `EVALUATION_TIME` datetime DEFAULT NULL COMMENT '评价时间',
  `REMARK1` varchar(50) DEFAULT NULL,
  `REMARK2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_EVALUATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训评价表';

-- ----------------------------
-- Records of train_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for train_plan_info
-- ----------------------------
DROP TABLE IF EXISTS `train_plan_info`;
CREATE TABLE `train_plan_info` (
  `TRAIN_PLAN_ID` varchar(50) NOT NULL DEFAULT '' COMMENT '培训计划编号（主键）',
  `TRAIN_PLAN_NAME` varchar(50) DEFAULT '' COMMENT '计划名称',
  `TRAIN_PLAN_TYPE` varchar(50) DEFAULT '' COMMENT '计划类型',
  `TRAIN_PLAN_YEAR` varchar(8) DEFAULT '' COMMENT '年度',
  `START_TIME` date DEFAULT NULL COMMENT '开始时间',
  `END_TIME` date DEFAULT NULL COMMENT '结束时间',
  `IS_FINISH` varchar(2) DEFAULT '' COMMENT '完成情况',
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT '',
  `REMARK2` varchar(100) DEFAULT '',
  PRIMARY KEY (`TRAIN_PLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训计划表';

-- ----------------------------
-- Records of train_plan_info
-- ----------------------------
INSERT INTO `train_plan_info` VALUES ('1', '新员工基础操作培训', '001001', '2014', '2015-02-08', null, '0', '2015-02-08 23:43:16', '', null);
INSERT INTO `train_plan_info` VALUES ('6bf50068-3ec9-4378-8615-092b30c7d0f0', '2015年第一期新员工培训', '001002', '2015', '2015-03-21', null, '0', '2015-03-15 10:40:51', '', '');
INSERT INTO `train_plan_info` VALUES ('c5241d09-931e-4884-9861-59b7bd4983d1', '2015第二期员工培训', '001001', '2015', '2015-03-31', null, '0', '2015-03-29 09:48:49', '', '');

-- ----------------------------
-- Table structure for train_plan_item
-- ----------------------------
DROP TABLE IF EXISTS `train_plan_item`;
CREATE TABLE `train_plan_item` (
  `TRAIN_ITEM_ID` varchar(50) NOT NULL DEFAULT '' COMMENT '主键',
  `TRAIN_PLAN_ID` varchar(50) DEFAULT NULL COMMENT '培训计划ID',
  `ZY_DIC_ID` varchar(50) DEFAULT NULL COMMENT '专业字典ID',
  `ZY_NAME` varchar(50) DEFAULT NULL COMMENT '专业名称',
  `TRAIN_PURPOSE` text COMMENT '培训目的',
  `TRAIN_CONTENT` text COMMENT '培训内容',
  `CLASS_COUNT` varchar(50) DEFAULT NULL COMMENT '课时',
  `TEACHER` varchar(20) DEFAULT NULL COMMENT '授课人',
  `RESULT_SUBMIT` varchar(2) DEFAULT NULL COMMENT '成绩是否提交',
  `CREATE_TIME` datetime DEFAULT NULL,
  `TRAIN_PLACE` varchar(100) DEFAULT NULL COMMENT '培训地点',
  `START_DATE` date DEFAULT NULL COMMENT '开始日期',
  `END_DATE` date DEFAULT NULL COMMENT '结束日期',
  `DAY_START_TIME` time DEFAULT NULL COMMENT '每日开始时间',
  `DAY_END_TIME` time DEFAULT NULL COMMENT '每日结束时间',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `REMARK1` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训计划明细表';

-- ----------------------------
-- Records of train_plan_item
-- ----------------------------
INSERT INTO `train_plan_item` VALUES ('40030769-6c73-46ad-b475-b3d653719e96', '1', '002001', null, '电气培训', '电气培训', '21', '王老师', '0', '2015-04-04 10:26:44', '教室', '2015-03-30', '2015-04-30', null, null, '电气培训', null);
INSERT INTO `train_plan_item` VALUES ('8af0ee7a-f6c2-49ec-a6d1-796d65fb8cd1', 'c5241d09-931e-4884-9861-59b7bd4983d1', '002001', null, '??', '???', '20', '???', '0', '2015-04-16 16:33:48', '??1', '2015-04-16', '2015-04-25', null, null, '', null);

-- ----------------------------
-- Table structure for train_result
-- ----------------------------
DROP TABLE IF EXISTS `train_result`;
CREATE TABLE `train_result` (
  `TRAIN_RESULT_ID` varchar(50) NOT NULL COMMENT '主键',
  `TRAIN_EMP_ID` varchar(50) DEFAULT NULL COMMENT '学员安排ID',
  `EXAM_RESULT` float(10,6) DEFAULT NULL COMMENT '考试成绩',
  `ATTENDANCE_RESULT` float(10,6) DEFAULT NULL COMMENT '考勤成绩',
  `TOTAL_RESULT` float(10,6) DEFAULT NULL COMMENT '总成绩',
  `EXAM_TIME` datetime DEFAULT NULL COMMENT '考试时间',
  `INPUT_TIME` datetime DEFAULT NULL COMMENT '录入时间',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `REMARK1` varchar(50) DEFAULT NULL,
  `REMARK2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_RESULT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训成绩表';

-- ----------------------------
-- Records of train_result
-- ----------------------------

-- ----------------------------
-- Table structure for train_result_ratio
-- ----------------------------
DROP TABLE IF EXISTS `train_result_ratio`;
CREATE TABLE `train_result_ratio` (
  `TRAIN_RATIO_ID` varchar(50) NOT NULL COMMENT '主键',
  `TRAIN_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '培训明细ID',
  `EXAM_RATIO` float(10,3) DEFAULT NULL COMMENT '考试比列',
  `ATTENDANCE_RATIO` float(10,3) DEFAULT NULL COMMENT '考勤比例',
  `SET_TIME` datetime DEFAULT NULL COMMENT '设置时间',
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_RATIO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩比例表';

-- ----------------------------
-- Records of train_result_ratio
-- ----------------------------
INSERT INTO `train_result_ratio` VALUES ('03e995b1-2c55-488a-94f8-02f09e6c6387', '40030769-6c73-46ad-b475-b3d653719e96', '20.000', '80.000', '2015-04-04 16:30:25', null);
INSERT INTO `train_result_ratio` VALUES ('0e3e4849-f31a-49c3-8ede-d79f8cfd4fa2', 'd8e331ad-522e-48eb-837c-a463594867d5', '80.000', '20.000', '2015-04-03 01:52:22', null);

-- ----------------------------
-- Table structure for t_base_defined_url
-- ----------------------------
DROP TABLE IF EXISTS `t_base_defined_url`;
CREATE TABLE `t_base_defined_url` (
  `ID` varchar(40) NOT NULL,
  `MODULE_ID` varchar(40) DEFAULT '',
  `MODULE_NAME` varchar(100) DEFAULT '',
  `MODULE_URL` varchar(200) DEFAULT '',
  `MEMO1` varchar(100) DEFAULT '',
  `MEMO2` varchar(100) DEFAULT '',
  `INUSE` int(11) DEFAULT '0',
  `SORT_NO` int(11) DEFAULT '0',
  `MENU_CLASS` int(11) DEFAULT '0',
  `FLAG` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_defined_url
-- ----------------------------
INSERT INTO `t_base_defined_url` VALUES ('-1201746885902286187', '012', '培训成绩管理', '', '培训成绩管理', '', '1', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('-1214260860472401880', '014001', '部门管理', 'admin/tree/tree.jsp?flag=1', '', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('-3589812952091253211', '013002', '考勤信息查看', 'admin/trainPlan/trainPlanCom.jsp?flag=5', '考勤信息查看', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('-5420308376354765108', '013001', '考勤信息录入', 'admin/trainPlan/trainPlanCom.jsp?flag=4', '考勤信息录入', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('-727319462625356822', '013', '培训考勤管理', '', '培训考勤管理', '', '1', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('-7702723538805702182', '014003', '学习记录管理', 'admin/tree/tree.jsp?flag=5', '学习记录管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('-813507709232007628', '011002', '学员安排', 'admin/trainPlan/trainPlanCom.jsp?flag=1', '安排学员', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('1', '015', '系统管理', '', '用户管理', '', '1', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('1748634322657949020', '014002', '学员信息管理', 'admin/tree/tree.jsp?flag=4', '学员信息管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('2318615966281969264', '014', '学员管理', '', '学员管理', '', '1', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('3124595266865897613', '011001', '培训计划', 'admin/trainPlan/trainPlanList.jsp', '培训计划', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('4226837973598128178', '015005', '角色管理', 'admin/tree/tree.jsp?flag=3', '角色管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('4775243773543352644', '012002', '成绩修改', 'admin/trainPlan/trainPlanCom.jsp?flag=4', '成绩修改', '', '1', '0', '2', '-1');
INSERT INTO `t_base_defined_url` VALUES ('6099535427377433713', '012001', '成绩录入', 'admin/trainPlan/trainPlanCom.jsp?flag=2', '录入成绩', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('6102344488514049273', '015002', '菜单管理', 'admin/sys/menu/menu.jsp', '菜单管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('7564784445021799386', '015001', '字典管理', 'admin/sys/dic/dic.jsp', '字典管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('7992948373370953477', '015004', '用户管理', 'admin/tree/tree.jsp?flag=2', '用户管理', '', '1', '0', '2', '0');
INSERT INTO `t_base_defined_url` VALUES ('8241835661845188066', '011', '培训计划管理', '', '培训计划管理', '', '1', '0', '1', '0');
INSERT INTO `t_base_defined_url` VALUES ('9185951432046537267', '012003', '成绩查看', 'admin/trainPlan/trainPlanCom.jsp?flag=3', '成绩查看', '', '1', '0', '2', '0');

-- ----------------------------
-- Table structure for t_base_unit_info
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_info`;
CREATE TABLE `t_base_unit_info` (
  `UNIT_ID` varchar(40) NOT NULL DEFAULT '',
  `UP_UNIT_ID` varchar(40) DEFAULT '',
  `UNIT_CLASS` varchar(100) DEFAULT '',
  `UNIT_NAME` varchar(100) DEFAULT '',
  `ADDRESS` varchar(200) DEFAULT '' COMMENT '备注',
  `TELEPHONE` varchar(40) DEFAULT '',
  `CONTACT_PERSON` varchar(40) DEFAULT '',
  `EMAIL` varchar(40) DEFAULT '',
  `HEADER` varchar(40) DEFAULT '' COMMENT '简称',
  `CREATE_DATE` date DEFAULT '0000-00-00',
  PRIMARY KEY (`UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_info
-- ----------------------------
INSERT INTO `t_base_unit_info` VALUES ('001', '0', '1', '太原市第二热电厂', '啊啊啊啊啊', '6998011', '张鹏', '', '第二电厂', '2015-01-01');
INSERT INTO `t_base_unit_info` VALUES ('001001', '001', '', '发电一部', '', '', '', '', '', '2015-02-12');
INSERT INTO `t_base_unit_info` VALUES ('001001001', '001001', '', '电气1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001001002', '001001', '', '锅炉1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001001003', '001001', '', '汽机1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001002', '001', '', '发电二部', '', '', '', '', '', '2015-02-12');
INSERT INTO `t_base_unit_info` VALUES ('001002001', '001002', '', '电气1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001002002', '001002', '', '锅炉1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001002003', '001002', '', '汽机1班', '', '', '', '', '', '2015-03-15');
INSERT INTO `t_base_unit_info` VALUES ('001003', '001', '', '检修车间', '', '', '', '', '', '2015-02-12');
INSERT INTO `t_base_unit_info` VALUES ('001004', '001', '', '运输部', '材料运输', '123456', '汪峰', '', '运输部', '2015-03-30');
INSERT INTO `t_base_unit_info` VALUES ('001004001', '001004', '', '运输队1', '11', '123123', 'aa', '', '运输队1', '2015-03-30');

-- ----------------------------
-- Table structure for t_base_unit_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_role`;
CREATE TABLE `t_base_unit_role` (
  `UNIT_ID` varchar(40) DEFAULT NULL,
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `ROLE_NAME` varchar(40) DEFAULT NULL,
  `CREATE_UNIT_ID` varchar(40) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `INUSE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_role
-- ----------------------------
INSERT INTO `t_base_unit_role` VALUES ('001', '-4438309440600131024', '5645', '0', '', '1');
INSERT INTO `t_base_unit_role` VALUES ('001001', '-8387755369393512155', 'why', '0', ' ', '1');

-- ----------------------------
-- Table structure for t_base_unit_role_module
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_role_module`;
CREATE TABLE `t_base_unit_role_module` (
  `UNIT_ID` varchar(50) DEFAULT NULL,
  `ROLE_ID` varchar(50) DEFAULT NULL,
  `MODULE_ID` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_role_module
-- ----------------------------
INSERT INTO `t_base_unit_role_module` VALUES ('0', '-4438309440600131024', '011');
INSERT INTO `t_base_unit_role_module` VALUES ('0', '-4438309440600131024', '011001');
INSERT INTO `t_base_unit_role_module` VALUES ('0', '-4438309440600131024', '011002');
INSERT INTO `t_base_unit_role_module` VALUES ('001001', '-8387755369393512155', '011');
INSERT INTO `t_base_unit_role_module` VALUES ('001001', '-8387755369393512155', '011001');
INSERT INTO `t_base_unit_role_module` VALUES ('001001', '-8387755369393512155', '011002');

-- ----------------------------
-- Table structure for t_base_unit_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_user_role`;
CREATE TABLE `t_base_unit_user_role` (
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `UNIT_ID` varchar(40) DEFAULT NULL,
  `USER_ID` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_user_role
-- ----------------------------
INSERT INTO `t_base_unit_user_role` VALUES ('-8387755369393512155', '001001', '517023bc-1a33-46d9-980c-7b6bbf878fa7');
INSERT INTO `t_base_unit_user_role` VALUES ('-8387755369393512155', '001001', '60fffb75-ae8e-47d7-88b5-f27f8110f0ee');

-- ----------------------------
-- Table structure for t_base_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user_info`;
CREATE TABLE `t_base_user_info` (
  `USER_ID` varchar(40) NOT NULL DEFAULT '',
  `USER_NAME` varchar(40) DEFAULT NULL COMMENT '用户名',
  `SEX` varchar(1) DEFAULT NULL COMMENT '性别',
  `NAME` varchar(40) DEFAULT NULL COMMENT '姓名',
  `CARD_ID` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `BIRTHDAY` date DEFAULT NULL COMMENT '出生时间',
  `UNIT_ID` varchar(40) DEFAULT NULL COMMENT '部门ID',
  `PASSWORD` varchar(20) DEFAULT NULL COMMENT '密码',
  `TELEPHONE` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `DUTY` varchar(40) DEFAULT NULL COMMENT '岗位',
  `TECDUTY` varchar(40) DEFAULT NULL COMMENT '用户类型：1管理员，2学员',
  `USER_COMMENT` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `INUSE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0停用',
  `EMAIL` varchar(40) DEFAULT NULL,
  `CREATE_UNIT_ID` varchar(100) DEFAULT NULL,
  `MOBILE` varchar(200) DEFAULT NULL COMMENT '籍贯',
  `CREATE_TIME` date DEFAULT NULL,
  `LAST_LOGIN_TIME` date DEFAULT NULL COMMENT '参加工作时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_user_info
-- ----------------------------
INSERT INTO `t_base_user_info` VALUES ('', 'abc', null, null, null, null, null, 'abc', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('0ab89a5c-728e-4721-a3bd-9b49e7c121d1', 'LISI', '0', '李四', null, '2015-04-05', '001001003', '123456', '1234-1234567', '123', '2', 'headPortrait/0ab89a5c-728e-4721-a3bd-9b49e7c121d1.jpg', '0', null, '0', '山西山西山西山西山西山西陕西', '2015-04-05', '2015-04-04');
INSERT INTO `t_base_user_info` VALUES ('1', 'ROOT', '0', 'root', '142725199002021630', '2013-12-23', '0', '1', '1234567', '', '0', null, '1', null, '0', '8015', '2013-12-16', '2015-02-06');
INSERT INTO `t_base_user_info` VALUES ('33c3fb72-e1a5-46bc-b4a2-2ddc6f49a079', 'GH01', '0', '张鹏', '123123', '2015-04-12', '001001001', '123456', '123', '123', '2', '', '0', null, '0', '山西太原', '2015-04-05', '2015-03-29');
INSERT INTO `t_base_user_info` VALUES ('3b0ee83d-5201-47d8-9707-892ea82f2d2c', '22', '0', '张思', '123', '2015-03-31', '001001001', '123456', '123', '123', '2', '', '0', null, '0', '', '2015-04-05', '2015-03-29');
INSERT INTO `t_base_user_info` VALUES ('468fdf8e-9748-41cb-b05a-2a229c0baa63', 'yy', null, null, null, null, null, 'yy', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('517023bc-1a33-46d9-980c-7b6bbf878fa7', 'ZHANGSAN', '0', '??', null, null, '001001', '123456', '', null, '1', '', '1', null, '0', null, null, null);
INSERT INTO `t_base_user_info` VALUES ('5bdb145a-f9b7-48d6-861a-82c15dc3743a', 'qqq', null, null, null, null, null, '22', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('60fffb75-ae8e-47d7-88b5-f27f8110f0ee', 'XBH', '0', '???', null, null, '001001', '123456', '', null, '1', null, '1', null, '0', null, null, null);
INSERT INTO `t_base_user_info` VALUES ('6610a4a7-98da-4a19-aa5d-ffcd93ca1ce8', 'qqq', null, null, null, null, null, 'qq', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('6b896b6f-e12e-4c5e-b998-8c3f8343fd8e', 'WWW', '0', 'www', null, '2015-04-04', '001001', '123456', '', '', '2', null, '1', null, '0', '山西删词山西删词山', null, '2015-04-05');
INSERT INTO `t_base_user_info` VALUES ('7552c2eb-e9f4-4a41-b9b3-5e4e3dfe2861', 'LISAN', '0', '李三', '123', '2015-04-04', '001001003', '123456', '123', '123', '2', '', '0', null, '0', '山西删词山西删词山西删词山西删词', null, '2015-03-29');
INSERT INTO `t_base_user_info` VALUES ('78712e40-f81d-422a-b816-cdc4840202cb', 'aaa', null, null, null, null, null, '123', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('d96260ce-2fb4-4318-90a5-174d299149d2', 'QQ', '0', '王明', null, '2015-04-04', '001002001', '123456', '123', '123', '2', '', '0', null, '0', '山西删词山西删词山', null, '2015-04-04');
INSERT INTO `t_base_user_info` VALUES ('db5e292f-6f45-4f25-bf5a-41a2843f9c84', '11', '0', '张三', '1123', '2015-04-02', '001001001', '123456', '123', '123', '2', '', '0', null, '0', '', null, '2015-03-29');
INSERT INTO `t_base_user_info` VALUES ('e73c0d79-12db-4b5f-8dd2-59622b4216b6', 'sdwd', null, null, null, null, null, '1', null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('f76ea2a2-0bbc-4302-aa2a-42b1dcdc36d1', 'TT', '0', '张伟', null, '2015-04-13', '001002002', '123456', '1234578', '锅炉工', '2', null, '1', null, '0', '山西太原', null, '2015-04-13');
