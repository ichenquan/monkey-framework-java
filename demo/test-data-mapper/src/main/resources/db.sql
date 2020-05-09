CREATE TABLE `test_city` (
  `id` bigint(18) NOT NULL COMMENT '唯一ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `flag` int(1) DEFAULT NULL COMMENT '标志',
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试城市表';