-- 创建慕课网 imooc
CREATE DATABASE IF NOT EXISTS imooc DEFAULT CHARACTER SET 'UTF8';

-- 打开imooc
USE imooc;

-- 用户表 user
CREATE TABLE IF NOT EXISTS jesse_user(
    id INT,
    username VARCHAR(20),
    password CHAR(32),
    email VARCHAR(50),
    age TINYINT,
    card CHAR(18),
    tel CHAR(11),
    salary FLOAT(8,2),
    married BOOLEAN,
    addr VARCHAR(100),
    sex ENUM('男','女','保密')
)ENGINE=INNODB CHARSET=UTF8MB4;

-- INSERT [INTO] tbl_name(id, username,...) VALUES(1, 'KING',...);
-- 向jesse_user表中插入一条记录
INSERT jesse_user(id, username, password, email, age, card, tel, salary, married, addr, sex) 
VALUES(1, 'jesse', 'jesse', '505733517@qq.com', 24, '123451234512345123','15893006022', 88888.68, 0,'北京', '男');

-- 查询表中所有记录 SELECT * FROM tbl_name;
SELECT * FROM immoc_user;

-- 向jesse_user表中插入一条记录
INSERT jesse_user(id, username, password, email, age, card, tel, salary, married, addr, sex) 
VALUES(-50, 'jesse', 'jesse', '505733517@qq.com', 127, '123451234512345123','15893006022', 2345.68, 1,'北京', '男');