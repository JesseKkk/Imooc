-- 得到版本号
SELECT VERSION(),CONNECTION_ID();

-- 得到当前所选的数据库名
SELECT DATABASE(),SCHEMA();

-- 得到当前登录的用户
SELECT USER(),CURRENT_USER(),SYSTEM_USER(),SESSION_USER();

--得到上一步插入操作产生AUTO_INCREMENT的值
SELECT LAST_INSERT_ID();

-- 得到MD5加密
SELECT MD5('king');


