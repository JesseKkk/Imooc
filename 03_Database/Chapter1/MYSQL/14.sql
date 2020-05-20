-- 测试添加记录
CREATE DATABASE IF NOT EXISTS king DEFAULT CHARACTER SET 'UTF8';
USE king;
CREATE TABLE IF NOT EXISTS user(
    id INT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    age TINYINT UNSIGNED DEFAULT 18 COMMENT '年龄',
    email VARCHAR(50) NOT NULL DEFAULT 'imooc@qq.com' COMMENT '邮箱'
)ENGINE=INNODB CHARSET=UTF8;

-- 不指定字段名称
INSERT user VALUE(1,'king', 24, '505033517@qq.com');
INSERT user VALUES(NULL,'queen', 25,'queen@qq.com');

-- 列出指定字段的形式
INSERT user(username,email) VALUES('ROSE','rose@qq.com');

-- 一次插入3条记录
INSERT user VALUES(NULL,'a',DEFAULT,DEFAULT),
(NULL,'b',14,'b@qq.com'),
(NULL,'c',56,'b@qq.com');

-- INSERT ...SET的形式
INSERT user SET username='d', age=45,email='d@qq.com';

CREATE TABLE test(
    a VARCHAR(20)
);
INSERT test VALUES('AA'),('BB'),('CC');