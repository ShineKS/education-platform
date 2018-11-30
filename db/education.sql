/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/28 16:38:39                          */
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
   data_id              bigint not null comment '����id',
   attachment_id        bigint not null comment '������id',
   data_type            tinyint not null comment '1-ѧ������ 2-�ɳ�֮· 3-�ҳ�����',
   primary key (id)
);

alter table attach_relation comment '������Դ��ϵ��';

/*==============================================================*/
/* Index: data_rel_idx                                          */
/*==============================================================*/
create index data_rel_idx on attach_relation
(
   data_id,
   data_type
);

/*==============================================================*/
/* Table: attachment                                            */
/*==============================================================*/
create table attachment
(
   id                   bigint not null,
   name                 varchar(200) not null comment '�ļ�����',
   size                 bigint not null,
   location             varchar(1000) not null comment '�ļ���ַ',
   file_type            tinyint not null comment '�ļ����� 1-ͼƬ 2-��Ƶ',
   org_id               bigint not null comment '��˾id',
   create_date          datetime not null,
   is_delete            tinyint not null default 0 comment '0-δɾ�� 1-��ɾ��',
   primary key (id)
);

alter table attachment comment '������';

/*==============================================================*/
/* Table: child                                                 */
/*==============================================================*/
create table child
(
   id                   bigint not null,
   name                 varchar(15) not null,
   sex                  tinyint not null default 0 comment '0-δ֪ 1-�� 2-Ů 3-����',
   age                  tinyint,
   guarder_id           bigint,
   head_pic_id          bigint,
   binding_code         varchar(20) comment '���ڻ����󶨺��ӣ������ˢ��',
   create_date          datetime not null,
   primary key (id)
);

alter table child comment '��¼ÿһ�����ӵ�ʵ��';

/*==============================================================*/
/* Index: child_idx                                             */
/*==============================================================*/
create index child_idx on child
(
   guarder_id
);

/*==============================================================*/
/* Table: class_info                                            */
/*==============================================================*/
create table class_info
(
   id                   bigint not null,
   org_id               bigint not null,
   name                 varchar(50) not null,
   student_num          int not null,
   is_finish            bool not null default 0 comment '�Ƿ�ȫ����ҵ,�༶�Ƿ���',
   finish_date          datetime comment '�༶���ʱ��',
   course_id            bigint not null comment '��ǰ�γ�id',
   create_date          datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Index: class_idx                                             */
/*==============================================================*/
create index class_idx on class_info
(
   org_id
);

/*==============================================================*/
/* Table: course_libary                                         */
/*==============================================================*/
create table course_libary
(
   id                   bigint not null,
   org_id               bigint not null,
   name                 varchar(50) not null,
   content              varchar(1000) not null,
   create_date          datetime not null,
   is_delete            tinyint not null default 0,
   primary key (id)
);

alter table course_libary comment '�γ̿��,��¼���������пγ�';

/*==============================================================*/
/* Index: course_idx                                            */
/*==============================================================*/
create index course_idx on course_libary
(
   org_id
);

/*==============================================================*/
/* Table: grow_diary                                            */
/*==============================================================*/
create table grow_diary
(
   id                   bigint not null,
   org_id               bigint not null,
   child_id             bigint not null comment 'child��id',
   student_id           bigint not null comment 'student��id',
   course_id            bigint not null comment 'course_libary��id',
   class_id             bigint not null,
   course_name          varchar(20) not null,
   status               tinyint not null comment '0-�ɳ��� 1-�ѱ�ҵ',
   finish_date          datetime,
   create_date          datetime not null,
   primary key (id)
);

alter table grow_diary comment '�ɳ��ռ��ռǱ�';

/*==============================================================*/
/* Index: diary_idx                                             */
/*==============================================================*/
create index diary_idx on grow_diary
(
   child_id
);

/*==============================================================*/
/* Index: diary_idx1                                            */
/*==============================================================*/
create index diary_idx1 on grow_diary
(
   student_id
);

/*==============================================================*/
/* Table: grow_stage                                            */
/*==============================================================*/
create table grow_stage
(
   id                   bigint not null,
   org_id               bigint not null,
   diary_id             bigint not null comment '�ɳ��ռ�id',
   stage_score          int not null comment 'stage_score',
   stage_remark         varchar(500) not null comment '�����Ľ׶�����',
   knowledge_point      varchar(500) comment '������д��֪ʶ��',
   create_date          datetime not null,
   primary key (id)
);

alter table grow_stage comment '��¼ÿ���ɳ��ռǵĽ׶�����';

/*==============================================================*/
/* Index: stage_idx                                             */
/*==============================================================*/
create index stage_idx on grow_stage
(
   diary_id
);

/*==============================================================*/
/* Table: grow_stage_item_score                                 */
/*==============================================================*/
create table grow_stage_item_score
(
   id                   bigint not null,
   stage_id             bigint not null comment '�ɳ��׶ε�id',
   item_name            varchar(20) not null comment '����������',
   item_score           int not null comment '������÷�',
   item_type            tinyint not null comment '1-�׶α��� 2-�ҳ�����',
   primary key (id)
);

alter table grow_stage_item_score comment '�ɳ�֮·�����';

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
   status               tinyint not null default 0 comment '0-���� ',
   logo_id              bigint comment '��Ӧattach���id',
   primary key (id)
);

alter table org comment '��˾��';

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

alter table remark_template comment '�׶�����ģ��';

/*==============================================================*/
/* Index: temp_idx                                              */
/*==============================================================*/
create index temp_idx on remark_template
(
   org_id
);

/*==============================================================*/
/* Table: stage_evaluation                                      */
/*==============================================================*/
create table stage_evaluation
(
   id                   bigint not null,
   stage_id             bigint not null comment '�ɳ��׶�id',
   open_id              varchar(200) not null comment '�ҳ���openid',
   remark               varchar(500) not null,
   accept_percent       int not null comment '֪ʶ���հٷֱȣ���������',
   type                 tinyint not null comment '1-�׶����� 2-�ռ�����',
   create_date          datetime not null,
   primary key (id)
);

alter table stage_evaluation comment '�ҳ�����ÿ���ռ�ÿ���׶εĳɳ�֮·����';

/*==============================================================*/
/* Index: stage_eva_idx                                         */
/*==============================================================*/
create index stage_eva_idx on stage_evaluation
(
   stage_id
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   bigint not null,
   remark_name          varchar(20) comment '��ע����,������������ı���',
   org_id               bigint not null,
   child_id             bigint comment '���ӱ�id',
   class_id             bigint comment '��ǰ�༶id',
   note                 varchar(500),
   creater_id           bigint not null comment '������id,��sys_user',
   create_date          datetime not null,
   primary key (id)
);

alter table student comment 'ѧԱ��';

/*==============================================================*/
/* Index: stud_idx                                              */
/*==============================================================*/
create index stud_idx on student
(
   org_id,
   class_id
);

/*==============================================================*/
/* Table: weixin_user                                           */
/*==============================================================*/
create table weixin_user
(
   id                   bigint not null,
   open_id              varchar(200) not null,
   nick_name            varchar(50) not null comment '�û��ǳ�',
   gender               tinyint comment '0-δ֪ 1-���� 2-Ů��',
   city                 varchar(20),
   province             varchar(10),
   country              varchar(10),
   avatar_url           varchar(300) not null comment '���һ����ֵ����������ͷ���С���� 0��46��64��96��132 ��ֵ��ѡ��0 ���� 640x640 ��������ͷ��46 ��ʾ 46x46 ��������ͷ��ʣ����ֵ�Դ����ơ�Ĭ��132�����û�û��ͷ��ʱ����Ϊ�ա����û�����ͷ��ԭ��ͷ�� URL ��ʧЧ��',
   union_id             varchar(100) comment '����ƽ̨��ȫ��Ψһid��Ԥ���ֶ�',
   phone_number         varchar(20),
   create_date          datetime not null,
   primary key (id)
);

alter table weixin_user comment '���ڼ�¼����΢�ŷ��ʵ��û�';

/*==============================================================*/
/* Index: wx_user_idx                                           */
/*==============================================================*/
create unique index wx_user_idx on weixin_user
(
   open_id
);

