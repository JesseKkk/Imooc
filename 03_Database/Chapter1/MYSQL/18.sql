CREATE DATABASE IF NOT EXISTS jing DEFAULT CHARACTER SET 'UTF8';
USE jing;
CREATE TABLE IF NOT EXISTS user(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    email VARCHAR(50) NOT NULL DEFAULT '505733517@qq.com' COMMENT '邮箱',
    proName VARCHAR(10) NOT NULL DEFAULT '北京' COMMENT '北京'
)ENGINE=INNODB CHARSET=UTF8;

INSERT user(username,proName) VALUES('a','北京'),
('b','哈尔滨'),
('c','山海'),
('d','深圳'),
('e','广州'),
('f','重庆');

-- 创建省份表
CREATE TABLE IF NOT EXISTS pro(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY,
    proName VARCHAR(10) NOT NULL UNIQUE
)ENGINE=INNODB CHARSET=UTF8;
INSERT pro(proName) VALUES('北京'),
('上海'),
('深圳');

-- 创建用户表
CREATE TABLE IF NOT EXISTS user(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    email VARCHAR(50) NOT NULL DEFAULT '505733517@qq.com' COMMENT '邮箱',
    proId TINYINT UNSIGNED NOT NULL COMMENT '用户所在的省份的编号'
)ENGINE=INNODB CHARSET=UTF8;
INSERT user(username,proId) VALUES('a',1),
('b',1),
('c',1),
('d',2),
('e',3),
('f',1),
('g',1);

-- 查询user id, username provinces proName
SELECT u.id,u.username,p.proName
FROM user AS u 
JOIN pro AS p
ON u.proId=p.id;

-- 创建省份表
CREATE TABLE IF NOT EXISTS pros(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY,
    proName VARCHAR(10) NOT NULL UNIQUE
)ENGINE=INNODB CHARSET=UTF8;
INSERT pros(proName) VALUES('北京'),
('上海'),
('深圳');

-- 创建管理员
CREATE TABLE IF NOT EXISTS admins(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    email VARCHAR(50) NOT NULL DEFAULT '505733517@qq.com' COMMENT '邮箱',
    proId TINYINT UNSIGNED NOT NULL COMMENT '用户所在省份的编号'
)ENGINE=INNODB CHARSET=UTF8;
INSERT admins(username,proId) VALUES('king',1),('queen',2);

-- 创建商品分类表
CREATE TABLE IF NOT EXISTS cates(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    cateName VARCHAR(50) NOT NULL UNIQUE COMMENT '商品分类名称',
    cateDesc VARCHAR(100) NOT NULL DEFAULT '' COMMENT '商品分类的描述'
)ENGINE=INNODB CHARSET=UTF8;
INSERT cates(cateName) VALUES('母婴'),('服装'),('电子');

-- 创建商品列表
CREATE TABLE IF NOT EXISTS goods(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    productName VARCHAR(50) NOT NULL UNIQUE COMMENT '商品名称',
    price FLOAT(8,2) NOT NULL DEFAULT 0 COMMENT '价格',
    cateId TINYINT UNSIGNED NOT NULL COMMENT '商品所在的分类',
    adminId TINYINT UNSIGNED NOT NULL COMMENT '管理员编号'
)ENGINE=INNODB CHARSET=UTF8;
INSERT goods(productName,price,cateId,adminId) values('iphone9',9888,3,1), 
('adidas',388,2,2), 
('nike',888,2,2), 
('奶品',288,1,1);


-- 查询goods id productName price -- cates cateName
SELECT g.id,g.productName,g.price,c.cateName
FROM goods AS g
JOIN cates AS c
ON g.cateId=c.id;

-- 查询管理员admins id username email -- pros proName
SELECT a.id,a.username,a.email,p.proName
FROM admins AS a
JOIN pros AS p
ON a.proId=p.id; 

-- goods id productName price
-- cates cateName
-- admin username email
SELECT g.id,g.productName,g.price,c.cateName,a.username,a.email
FROM goods AS g
JOIN admins AS a
ON g.adminId=a.id
JOIN cates AS c
ON g.cateId=c.id
WHERE g.price<1000
ORDER BY g.price DESC
LIMIT 0,2;
