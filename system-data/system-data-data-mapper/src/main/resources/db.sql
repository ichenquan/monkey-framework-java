-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists so_dept;
create table so_dept (
  id                bigint(20)      not null auto_increment    comment '部门id',
  parent_id         bigint(20)      default 0                  comment '父部门id',
  ancestors         varchar(50)     default ''                 comment '祖级列表',
  dept_name         varchar(30)     default ''                 comment '部门名称',
  order_num         int(4)          default 0                  comment '显示顺序',
  leader            varchar(20)     default null               comment '负责人',
  phone             varchar(11)     default null               comment '联系电话',
  email             varchar(50)     default null               comment '邮箱',
  status            char(1)         default '0'                comment '部门状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (id)
) engine=innodb auto_increment=200 comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into so_dept values(100,  0,   '0',          '若依科技',   0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11-33-00', 'ry', '2018-03-16 11-33-00');
insert into so_dept values(101,  100, '0,100',      '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11-33-00', 'ry', '2018-03-16 11-33-00');
insert into so_dept values(102,  100, '0,100',      '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11-33-00', 'ry', '2018-03-16 11-33-00');


-- ----------------------------
-- 1、字典类型表
-- ----------------------------

drop table if exists sd_dict_type;
create table sd_dict_type
(
  id               bigint(20)      not null auto_increment    comment '字典主键',
  dict_name        varchar(100)    default ''                 comment '字典名称',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  owned_dept_id    bigint(20)      not null                   comment '拥有者的（父）机构标识',
  `status`         char(1)         default '0'                comment '状态（0正常 1停用）',
  remark           varchar(500)    default null               comment '备注',
  create_user_id   bigint(20)      default null               comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_user_id   bigint(20)      default null               comment '更新者',
  update_time      datetime                                   comment '更新时间',
  flag             char(1)         default '0'                comment '标志（0-正常，1-已删除，2-只读）',
  primary key (id),
  unique (dict_type, owned_dept_id)
) engine=innodb auto_increment=100 comment = '字典类型表';

insert into sd_dict_type values(1,  '用户性别', 'sys_user_sex', 100,   '0', '用户性别列表', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', '0');
insert into sd_dict_type values(11, '用户性别', 'sys_user_sex', 101,   '0', '用户性别列表', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', '0');

-- ----------------------------
-- 2、字典数据表
-- ----------------------------
drop table if exists sd_dict_data;
create table sd_dict_data
(
  dict_code        bigint(20)      not null auto_increment    comment '字典编码',
  dict_sort        int(4)          default 0                  comment '字典排序',
  dict_label       varchar(100)    default ''                 comment '字典标签',
  dict_value       varchar(100)    default ''                 comment '字典键值',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  owned_dept_id    bigint(20)      not null                   comment '拥有者的（父）机构标识',
  css_class        varchar(100)    default null               comment '样式属性（其他样式扩展）',
  list_class       varchar(100)    default null               comment '表格回显样式',
  is_default       char(1)         default 'N'                comment '是否默认（Y是 N否）',
  `status`         char(1)         default '0'                comment '状态（0正常 1停用）',
  remark           varchar(500)    default null               comment '备注',
  create_user_id   bigint(20)      default null               comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_user_id   bigint(20)      default null               comment '更新者',
  update_time      datetime                                   comment '更新时间',
  flag             char(1)         default '0'                comment '标志（0-正常，1-已删除，2-只读）',
  primary key (dict_code),
  unique (owned_dept_id, dict_type, dict_code)
) engine=innodb auto_increment=100 comment = '字典数据表';

insert into sd_dict_data values(1,  1,  '男',   '0',   'sys_user_sex', 100, '',   '','Y', '0', '性别男', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', 0);
insert into sd_dict_data values(2,  2,  '女',   '1',   'sys_user_sex', 100, '',   '','N', '0', '性别女', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', 0);
insert into sd_dict_data values(3,  3,  '未知', '2',   'sys_user_sex', 100, '',   '','N', '0', '性别未知', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', 0);
insert into sd_dict_data values(34,  1,  '男',   '0',   'sys_user_sex', 101, '',   '','Y', '0', '性别男', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', 0);
insert into sd_dict_data values(35,  2,  '女',   '1',   'sys_user_sex', 101, '',   '','N', '0', '性别女', 01, '2020-04-27 11-33-00', 02, '2020-04-27 11-33-00', 0);

-- ----------------------------
-- 3、数据源表
-- ----------------------------
DROP TABLE IF EXISTS `sd_data_source`;
CREATE TABLE `sd_data_source`  (
  `id` bigint(20) NOT NULL auto_increment COMMENT '数据源主键',
  `data_source_code` varchar(100) NOT NULL COMMENT '数据源编码',
  `data_source_url` varchar(255) NOT NULL COMMENT '数据源连接串',
  `data_source_user` varchar(100) NOT NULL COMMENT '数据源用户',
  `data_source_pwd` varchar(100) NOT NULL COMMENT '数据源密码',
  `jdbc_driver_type` varchar(100) NOT NULL DEFAULT '0' COMMENT 'Jdbc驱动包名',
  `tenant_id` varchar(50) NOT NULL COMMENT '租户标识',
  `tenant_type` char(1) NULL DEFAULT '0' COMMENT '租户类型（0-database，1-schema，2-discriminator）',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `flag` char(1) NULL DEFAULT '0' COMMENT '标志（0-正常，1-已删除，2-只读）',
  PRIMARY KEY (`id`)
) ENGINE=innodb auto_increment=100 COMMENT ='数据源表';

INSERT INTO `sd_data_source` VALUES (1, 'snt-test-ds', 'jdbc:mysql://localhost:3306/ry-vue?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8', 'root', 'snt123', 'com.mysql.jdbc.Driver', 'snt-test', '0', 1, '2020-04-27 11:41:25', 2, '2020-04-27 11:41:31', '0');
-- insert into ss_menu values('116',  '数据源', '1',   '10', 'dataSource',     'system/dataSource/index',      1, 'C', '0', '0', 'system:dataSource:list',      'message',       01, '2018-03-16 11-33-00', 02, '2020-04-30 13-30-00', '数据源菜单');

-- ----------------------------
-- 数据设计(生成)器-数据表
-- ----------------------------
drop table if exists sd_designer_table;
create table sd_designer_table (
  id                bigint(20)      not null auto_increment    comment '编号',
  name              varchar(200)    default ''                 comment '表名称',
  comment           varchar(500)    default ''                 comment '表描述',
--  class_name        varchar(100)    default ''                 comment '实体类名称',
  tpl_category      varchar(200)    default 'crud'             comment '使用的模板（crud单表操作 tree树表操作）',
--  package_name      varchar(100)                               comment '生成包路径',
--  module_name       varchar(30)                                comment '生成模块名',
--  business_name     varchar(30)                                comment '生成业务名',
--  function_name     varchar(50)                                comment '生成功能名',
--  function_author   varchar(50)                                comment '生成功能作者',
  options           varchar(1000)                              comment '其它生成选项',
  `create_user_id`  bigint(20)      NOT NULL                   COMMENT '创建者',
  create_time 	    datetime                                   comment '创建时间',
  `update_user_id`  bigint(20)      NULL DEFAULT NULL          COMMENT '更新者',
  update_time       datetime                                   comment '更新时间',
  `flag`            char(1)         NULL DEFAULT '0'           COMMENT '标志（0-正常，1-已删除，2-只读）',
  remark            varchar(500)    default null               comment '备注',
  primary key (id)
) engine=innodb auto_increment=100 comment = '数据设计(生成)器-数据表';

-- insert into sd_designer_table values(1, 'test_table', 'test', 'crud', null, 01, '2020-04-27 16:20:00', 02, '2020-04-27 16:20:00', 0, 'test');
-- ----------------------------
-- 数据设计(生成)器-数据列
-- ----------------------------
drop table if exists sd_designer_column;
create table sd_designer_column (
  id                bigint(20)      not null auto_increment    comment '编号',
  table_id          varchar(64)                                comment '归属表编号',
  name              varchar(200)                               comment '列名称',
  comment           varchar(500)                               comment '列描述',
  type              varchar(100)                               comment '列类型',
--  java_type         varchar(500)                               comment 'JAVA类型',
--  java_field        varchar(200)                               comment 'JAVA字段名',
  is_pk             char(1)                                    comment '是否主键（1是）',
  is_increment      char(1)                                    comment '是否自增（1是）',
  is_required       char(1)                                    comment '是否必填（1是）',
  is_insert         char(1)                                    comment '是否为插入字段（1是）',
  is_edit           char(1)                                    comment '是否编辑字段（1是）',
  is_list           char(1)                                    comment '是否列表字段（1是）',
  is_query          char(1)                                    comment '是否查询字段（1是）',
--  query_type        varchar(200)    default 'EQ'               comment '查询方式（等于、不等于、大于、小于、范围）',
--  html_type         varchar(200)                               comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
--  dict_type         varchar(200)    default ''                 comment '字典类型',
  sort              int                                        comment '排序',
  `create_user_id`  bigint(20)      NOT NULL                   COMMENT '创建者',
  create_time 	    datetime                                   comment '创建时间',
  `update_user_id`  bigint(20)      NULL DEFAULT NULL          COMMENT '更新者',
  update_time       datetime                                   comment '更新时间',
  `flag`            char(1)         NULL DEFAULT '0'           COMMENT '标志（0-正常，1-已删除，2-只读）',
  primary key (id)
) engine=innodb auto_increment=100 comment = '数据设计(生成)器-数据列';

-- insert into sd_designer_column values(1, 1, 'test_column', 'test', 'varchar(20)', 0,0,0,0,0,0,0,1,01,'2020-04-27 16:20:00',02,'2020-04-27 16:20:00',0);