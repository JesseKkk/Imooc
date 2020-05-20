-- 创建慕课网 imooc
CREATE DATABASE IF NOT EXISTS imooc DEFAULT CHARACTER SET 'UTF8';

-- 打开imooc
USE imooc;

-- 用户表 user
CREATE TABLE IF NOT EXISTS user(
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
