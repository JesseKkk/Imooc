CREATE DATABASE IF NOT EXISTS jdbctest CHARACTER SET 'UTF8';
USE jdbctest;
CREATE TABLE IF NOT EXISTS user(
    uid INT UNSIGNED AUTO_INCREMENT KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL
)ENGINE=INNODB CHARSET=UTF8;
INSERT user VALUES (NULL,'aaa','111','张三'),
(NULL,'bbb','222','李四'),
(NULL,'ccc','333','王五');
