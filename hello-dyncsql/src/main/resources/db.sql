create table user(
    `id` int not null auto_increment,
    `name` varchar(255) not null default '' comment '姓名',
    `created_at` datetime not null default '1970-01-01' comment '创建时间',
    `updated_at` datetime not null default '1970-01-01' comment '更新时间',
    primary key(`id`)
)ENGINE INNODB charset=utf8 COMMENT '用户表';


