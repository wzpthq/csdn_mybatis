create table user1 (
    id int not null auto_increment comment '主键ID',
    name varchar(128) not null default '' comment '名称',
    created_at varchar(10) not null default '' comment '创建时间',
    updated_at varchar(10) not null default '' comment '更新时间',
    primary key(`id`)
) ENGINE=INNODB charset=utf8 comment '用户表 - 测试typeHandler';