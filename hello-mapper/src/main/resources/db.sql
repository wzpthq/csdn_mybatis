create table user(
    `id` int not null auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`)
)ENGINE INNODB charset=utf8 COMMENT '用户表';

create table teacher (
    `id` int not null  auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`)
)ENGINE INNODB charset=utf8 COMMENT '教师表';

create table student (
    `id` int not null auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `tid` int not null default 0 comment '教师ID',
    `teacher_name` varchar(255) not null default '' comment '教师名称',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`)
)ENGINE INNODB charset=utf8 COMMENT '学生表';

create table husband (
    `id` int not null auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `wife_id` int not null default 0 comment '妻子ID',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`),
    UNIQUE KEY `uk_wife_id` (`wife_id`)
)ENGINE INNODB charset=utf8 COMMENT '丈夫表';


create table wife (
    `id` int not null auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`)
)ENGINE INNODB charset=utf8 COMMENT '妻子表';


