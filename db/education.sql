/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/21 20:42:21                          */
/*==============================================================*/


drop table if exists attach_relation;

drop table if exists attachment;

drop table if exists child;

drop table if exists class_info;

drop table if exists course_libary;

drop table if exists grow_diary;

drop table if exists grow_stage;

drop table if exists grow_stage_item_score;

drop table if exists guarder;

drop table if exists org;

drop table if exists remark_template;

drop table if exists stage_evaluation;

drop table if exists student;

drop table if exists weixin_user;

/*==============================================================*/
/* Table: attach_relation                                       */
/*==============================================================*/
create table attach_relation
(
   id                   bigint not null,
   data_id              bigint not null comment '数据id',
   attachment_id        bigint not null comment '附件表id',
   data_type            tinyint not null comment '1-学生资料 2-成长之路 3-家长评价',
   primary key (id)
);

alter table attach_relation comment '附件资源关系表';

/*==============================================================*/
/* Table: attachment                                            */
/*==============================================================*/
create table attachment
(
   id                   bigint not null,
   name                 varchar(200) not null comment '文件名称',
   size                 bigint not null,
   location             varchar(1000) not null comment '文件地址',
   file_type            tinyint not null comment '文件类型 1-图片 2-视频',
   org_id               bigint not null comment '公司id',
   create_date          datetime not null,
   is_delete            tinyint not null default 0 comment '0-未删除 1-已删除',
   primary key (id)
);

alter table attachment comment '附件表';

/*==============================================================*/
/* Table: child                                                 */
/*==============================================================*/
create table child
(
   id                   bigint not null,
   name                 varchar(15) not null,
   sex                  tinyint not null default 0 comment '0-未知 1-男 2-女 3-其他',
   age                  tinyint,
   guarder_id           bigint,
   head_pic_id          bigint,
   create_date          datetime not null,
   primary key (id)
);

alter table child comment '记录每一个孩子的实体';

/*==============================================================*/
/* Table: class_info                                            */
/*==============================================================*/
create table class_info
(
   id                   bigint not null,
   org_id               bigint not null,
   name                 varchar(50) not null,
   student_num          int not null,
   is_finish            bool not null default 0 comment '是否全部毕业,班级是否结课',
   finish_date          datetime comment '班级结课时间',
   course_id            bigint not null comment '当前课程id',
   create_date          datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: course_libary                                         */
/*==============================================================*/
create table course_libary
(
   id                   bigint not null,
   org_id               bigint not null,
   name                 varchar(50) not null,
   content           varchar(1000) not null,
   create_date          datetime not null,
   is_delete            tinyint not null default 0,
   primary key (id)
);

alter table course_libary comment '课程库表,记录机构的所有课程';

/*==============================================================*/
/* Table: grow_diary                                            */
/*==============================================================*/
create table grow_diary
(
   id                   bigint not null,
   org_id               bigint not null,
   child_id             bigint not null comment 'child表id',
   student_id           bigint not null comment 'student表id',
   course_id            bigint not null comment 'course_libary表id',
   class_id             bigint not null,
   course_name          varchar(20) not null,
   status               tinyint not null comment '0-成长中 1-已毕业',
   finish_date          datetime,
   create_date          datetime not null,
   primary key (id)
);

alter table grow_diary comment '成长日记日记表';

/*==============================================================*/
/* Table: grow_stage                                            */
/*==============================================================*/
create table grow_stage
(
   id                   bigint not null,
   org_id               bigint not null,
   diary_id             bigint not null comment '成长日记id',
   stage_score          int not null comment 'stage_score',
   stage_remark         varchar(500) not null comment '机构的阶段评价',
   knowledge_point      varchar(500) comment '机构填写的知识点',
   create_date          datetime not null,
   primary key (id)
);

alter table grow_stage comment '记录每个成长日记的阶段内容';

/*==============================================================*/
/* Table: grow_stage_item_score                                 */
/*==============================================================*/
create table grow_stage_item_score
(
   id                   bigint not null,
   stage_id             bigint not null comment '成长阶段的id',
   item_name            varchar(20) not null comment '报告项名称',
   item_score           int not null comment '报告项得分',
   item_type            tinyint not null comment '1-阶段报告 2-家长评价',
   primary key (id)
);

alter table grow_stage_item_score comment '成长之路报告表';

/*==============================================================*/
/* Table: guarder                                               */
/*==============================================================*/
create table guarder
(
   id                   bigint not null,
   fans_id              bigint not null,
   name                 varchar(15),
   open_id              varchar(200) not null,
   create_date          datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   bigint not null,
   name                 varchar(100) not null,
   create_date          datetime not null,
   status               tinyint not null default 0 comment '0-正常 ',
   logo_id              bigint comment '对应attach表的id',
   primary key (id)
);

alter table org comment '公司表';

/*==============================================================*/
/* Table: remark_template                                       */
/*==============================================================*/
create table remark_template
(
   id                   bigint not null,
   org_id               bigint not null,
   title                varchar(20) not null,
   content              varchar(500) not null,
   create_date          datetime not null,
   primary key (id)
);

alter table remark_template comment '阶段评价模板';

/*==============================================================*/
/* Table: stage_evaluation                                      */
/*==============================================================*/
create table stage_evaluation
(
   id                   bigint not null,
   stage_id             bigint not null comment '成长阶段id',
   open_id              varchar(200) not null comment '家长的openid',
   remark               varchar(500) not null,
   accept_percent       int not null comment '知识吸收百分比，储存整数',
   type                 tinyint not null comment '1-阶段评价 2-日记总评',
   create_date          datetime not null,
   primary key (id)
);

alter table stage_evaluation comment '家长对于每个日记每个阶段的成长之路评价';

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   bigint not null,
   remark_name          varchar(20) comment '备注名称,机构给孩子起的别名',
   org_id               bigint not null,
   child_id             bigint comment '孩子表id',
   class_id             bigint comment '当前班级id',
   note                 varchar(500),
   creater_id           bigint not null comment '创建人id,表sys_user',
   create_date          datetime not null,
   primary key (id)
);

alter table student comment '学员表';

/*==============================================================*/
/* Table: weixin_user                                           */
/*==============================================================*/
create table weixin_user
(
   id                   bigint not null,
   open_id              varchar(200) not null,
   nick_name            varchar(50) not null comment '用户昵称',
   gender               tinyint comment '0-未知 1-男性 2-女性',
   city                 varchar(20),
   province             varchar(10),
   country              varchar(10),
   avatar_url           varchar(300) not null comment '最后一个数值代表正方形头像大小（有 0、46、64、96、132 数值可选，0 代表 640x640 的正方形头像，46 表示 46x46 的正方形头像，剩余数值以此类推。默认132），用户没有头像时该项为空。若用户更换头像，原有头像 URL 将失效。',
   union_id             varchar(100) comment '开放平台的全局唯一id，预留字段',
   create_date          datetime not null,
   primary key (id)
);

alter table weixin_user comment '用于记录所有微信访问的用户';

