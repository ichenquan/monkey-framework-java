USE sc;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sc_application
-- ----------------------------
DROP TABLE IF EXISTS `sc_application`;
CREATE TABLE `sc_application` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `application_id` varchar(256) DEFAULT NULL COMMENT '应用程序类型识别码',
  `remark` varchar(256) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置-应用程序';

-- ----------------------------
-- Records of sc_application
-- ----------------------------
INSERT INTO `sc_application` VALUES ('1', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'test-service-provider', '测试服务提供端');

-- ----------------------------
-- Table structure for sc_application_property
-- ----------------------------
DROP TABLE IF EXISTS `sc_application_property`;
CREATE TABLE `sc_application_property` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `application_id` varchar(256) DEFAULT NULL COMMENT '应用程序ID',
  `property_id` varchar(256) DEFAULT NULL COMMENT '属性ID',
  `property_value` varchar(3200) DEFAULT NULL COMMENT '属性值',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用程序属性配置表';

-- ----------------------------
-- Records of sc_application_property
-- ----------------------------
INSERT INTO `sc_application_property` VALUES ('10000001', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'test-service-provider', 'service.bus.port', '30000', 'service端口');

-- ----------------------------
-- Table structure for sc_db_cluster
-- ----------------------------
DROP TABLE IF EXISTS `sc_db_cluster`;
CREATE TABLE `sc_db_cluster` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `cluster_id` varchar(256) DEFAULT NULL COMMENT '集群ID',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='mysql集群';

-- ----------------------------
-- Records of sc_db_cluster
-- ----------------------------
INSERT INTO `sc_db_cluster` VALUES ('1001', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-01', 'mysql集群-01');
INSERT INTO `sc_db_cluster` VALUES ('1002', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-02', 'mysql集群-02');

-- ----------------------------
-- Table structure for sc_db_node
-- ----------------------------
DROP TABLE IF EXISTS `sc_db_node`;
CREATE TABLE `sc_db_node` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `cluster_id` varchar(256) DEFAULT NULL COMMENT '集群ID',
  `node_id` varchar(256) DEFAULT NULL COMMENT '节点ID',
  `type_id` varchar(2) DEFAULT NULL COMMENT '类型标识',
  `url` varchar(256) DEFAULT NULL COMMENT 'URL',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置-应用程序';

-- ----------------------------
-- Records of sc_db_node
-- ----------------------------
INSERT INTO `sc_db_node` VALUES ('10801', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-01', 'master', 'w', 'jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');
INSERT INTO `sc_db_node` VALUES ('10802', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-01', 'slave-01', 'r', 'jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');
INSERT INTO `sc_db_node` VALUES ('10803', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-01', 'slave-02', 'r', 'jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');
INSERT INTO `sc_db_node` VALUES ('10901', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-02', 'master', 'w', 'jdbc:mysql://localhost:3306/sc?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');
INSERT INTO `sc_db_node` VALUES ('10902', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-02', 'slave-01', 'r', 'jdbc:mysql://localhost:3306/sc?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');
INSERT INTO `sc_db_node` VALUES ('10903', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'mysql-02', 'slave-02', 'r', 'jdbc:mysql://localhost:3306/sc?useUnicode=true&characterEncoding=utf-8&useSSL=false', 'root', 'snt123', '');

-- ----------------------------
-- Table structure for sc_db_path
-- ----------------------------
DROP TABLE IF EXISTS `sc_db_path`;
CREATE TABLE `sc_db_path` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `application_id` varchar(256) DEFAULT NULL COMMENT '应用程序ID',
  `cluster_id` varchar(256) DEFAULT NULL COMMENT 'mysql集群ID',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置-应用程序';

-- ----------------------------
-- Records of sc_db_path
-- ----------------------------

INSERT INTO `sc_db_path` VALUES ('10903', '2020-04-29 10:00:00', '2020-04-29 10:00:00', '1', 'test-service-provider', 'mysql-01', '');

-- ----------------------------
-- Table structure for sc_service_path
-- ----------------------------
DROP TABLE IF EXISTS `sc_service_path`;
CREATE TABLE `sc_service_path` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `service_host` varchar(256) DEFAULT NULL COMMENT '服务主机',
  `service_names` varchar(3200) DEFAULT NULL COMMENT '服务名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务路径';

-- ----------------------------
-- Table structure for sc_service_channel
-- ----------------------------
DROP TABLE IF EXISTS `sc_service_channel`;
CREATE TABLE `sc_service_channel` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '逻辑删除标志位',
  `application_id` varchar(64) DEFAULT NULL COMMENT '应用程序ID',
  `service_name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `service_host` varchar(128) DEFAULT NULL COMMENT '服务主机',
  `service_port` varchar(16) DEFAULT NULL COMMENT '服务端口',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务通道: 用于k8s环境';
