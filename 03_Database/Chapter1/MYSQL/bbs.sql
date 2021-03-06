-- 创建bbs数据库
CREATE DATABASE IF NOT EXISTS bbs DEFAULT CHARACTER SET 'UTF8';
-- 切换到数据库
USE bbs;
--创建user表
CREATE TABLE IF NOT EXISTS user(
    uid INT UNSIGNED AUTO_INCREMENT KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(16) NOT NULL
)ENGINE=INNODB CHARSET=UTF8;
-- 创建message表
CREATE TABLE IF NOT EXISTS message(
    mid INT UNSIGNED AUTO_INCREMENT KEY,
    title VARCHAR(50),
    content VARCHAR(1000),
    creatTime VARCHAR(20),
    uid INT UNSIGNED
)ENGINE=INNODB CHARSET=UTF8;
-- message表增加外键
ALTER TABLE message
ADD CONSTRAINT uid_fk_userUid FOREIGN KEY(uid) REFERENCES user(uid);