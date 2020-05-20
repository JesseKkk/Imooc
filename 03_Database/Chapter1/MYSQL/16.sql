-- 创建数据表
CREATE DATABASE IF NOT EXISTS jesse DEFAULT CHARACTER SET 'UTF8';

-- 切换数据库
USE jesse;

-- 创建数据表
CREATE TABLE user1(
    id INT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    age TINYINT UNSIGNED NOT NULL DEFAULT 18 COMMENT '年龄',
    sex ENUM('男','女','保密') NOT NULL DEFAULT '保密' COMMENT '性别',
    addr VARCHAR(20) NOT NULL DEFAULT '北京',
    married BOOLEAN NOT NULL DEFAULT 0 COMMENT '0代表未结婚，1代表已婚',
    salary FLOAT(8,2) NOT NULL DEFAULT 0 COMMENT '薪水'
)ENGINE=INNODB CHARSET=UTF8;

-- 插入数据
INSERT user1 VALUES(1,'king',23,'男','北京',1,50000);
INSERT user1(username,age,sex,addr,married,salary) VALUES('queen',27,'女','上海',0,25000);
INSERT user1 SET username='imooc',age=31,sex='女',addr='北京',salary=40000;
INSERT user1 VALUES(NULL,'张三',38,'男','上海',0,15000),
(NULL,'张三风',38,'男','上海',0,15000),
(NULL,'张子怡',39,'女','北京',1,85000),
(NULL,'汪峰',42,'男','深圳',1,95000),
(NULL,'刘德华',58,'男','广州',0,115000),
(NULL,'吴亦凡',28,'男','北京',0,15300),
(NULL,'奶茶妹',18,'女','北京',0,75000),
(NULL,'刘嘉玲',55,'女','广州',0,15000);

-- 查询表中的记录
SELECT * FROM user1;

-- username,addr,age
SELECT username,addr,age FROM user1;

-- 查询king数据库下user1表中的所有记录
SELECT * FROM jesse.user1;

-- 查询user1表中的id 编号 username 用户名 sex 性别
SELECT id AS '编号', username AS '用户名', sex AS '性别' FROM user1;

-- 给表起别名
SELECT id,username FROM user1 AS u;

-- 测试表名.字段名
SELECT user1.id,user1.username FROM user1;

-- 测试WHERE 条件的比较运算符
-- 查询id,username,age id=5的用户
SELECT id,username,age FROM user1
WHERE id=5;

-- 添加desc字段 VARCHAR(100)
ALTER TABLE user1
ADD userDesc VARCHAR(100);

-- 更新id<=9的用户 userDesc='this is a test'
UPDATE user1 SET userDesc='this is a test'
WHERE id<=9;

-- 查询用户userDesc 为NULL的用户
SELECT id,username,age,userDesc FROM user1
WHERE userDesc=NULL;

-- IS [NOT] NULL检测NULL值
SELECT id,username,age,userDesc FROM user1
WHERE userDesc IS NULL;

-- 测试范围BETWEEN AND
-- 查询年龄在18~30之间的用户
SELECT id,username,age, sex FROM user1
WHERE age BETWEEN 18 AND 50;

-- 查询编号为1,3,5,7,9
SELECT id,username,age FROM user1
WHERE id IN(1,3,5,7,9,29,45);

SELECT id,username,age FROM user1
WHERE username IN('queen','lily','king','rose');

-- 测试逻辑运算符
-- 查询性别为男并且年龄>=20的用户
SELECT id,username,age,sex FROM user1
WHERE sex='男' AND age>=20;

-- 查询id=1 或者用户名为queen
SELECT id,username,age FROM user1
WHERE id=1 OR username='queen';

-- 要求用户名中包含三
SELECT id,username,age,sex FROM user1
WHERE username LIKE '%三%';

-- 要求用户名有三个字符组成
SELECT id,username,age,sex FROM user1
WHERE username LIKE '___';

-- 测试分组
-- 按照性别分组sex
SELECT id,username,age,sex FROM user1
GROUP BY sex;

-- 按照addr分组
SELECT username,age,sex,addr FROM user1
GROUP BY addr;

--按照性别分组，查询组中的用户名有哪些
SELECT  GROUP_CONCAT(username),age,sex,addr FROM user1
GROUP BY sex;

-- 按照性别分组，查询组中的用户名和地址有哪些
SELECT GROUP_CONCAT(username),age,sex,GROUP_CONCAT(addr) FROM user1
GROUP BY sex;

--测试COUNT()
SELECT COUNT(*) FROM user1;

SELECT COUNT(id) FROM user1;

-- 按照sex分组，得到用户名详情，并且分别求出分组中的人数
SELECT sex,GROUP_CONCAT(username) AS userDetail,COUNT(*) AS totalUsers FROM user1
GROUP BY sex;

-- 按照addr分组，得到用户名的详情，总人数，得到组中年龄的总和，年龄的最大值、最小值和平均值
SELECT addr,
GROUP_CONCAT(username) AS userDetail,
COUNT(*) AS totalUsers,
SUM(age) AS sum_age,
MAX(age) AS max_age,
MIN(age) AS min_age,
AVG(age) AS avg_age
FROM user1
GROUP BY addr;

-- 按照sex分组，统计组中总人数、用户名详情，得到薪水总和，薪水最大值、最小值、平均值
SELECT sex,
COUNT(*) AS  totalUsers,
GROUP_CONCAT(username) AS userDetail,
SUM(salary) AS sum_salary,
MAX(salary) AS max_salary,
MIN(salary) AS min_salary,
AVG(salary) AS avg_salary
FROM user1
GROUP BY sex;

SELECT GROUP_CONCAT(username) AS userdDetail,
COUNT(*) AS totalUsers
FROM user1
GROUP BY sex
WITH ROLLUP;

-- 按照字段位置进行分组
SELECT sex,
COUNT(*) AS  totalUsers,
GROUP_CONCAT(username) AS userDetail,
SUM(salary) AS sum_salary,
MAX(salary) AS max_salary,
MIN(salary) AS min_salary,
AVG(salary) AS avg_salary
FROM user1
GROUP BY 1;

-- 查询age>=30的用户并且按照sex分组
SELECT sex,GROUP_CONCAT(username) AS userDetail,
COUNT(*) AS totalUsers
FROM user1
WHERE age>=30
GROUP BY sex;

-- 按照addr分组，统计总人数
SELECT addr,GROUP_CONCAT(username) AS userDetail,
COUNT(*) AS totalUsers
FROM user1
GROUP BY addr;

-- 对于分组结果进行二次筛选，条件是组中总人数>=3
SELECT addr,GROUP_CONCAT(username) AS userDetail,
COUNT(*) AS totalUsers
FROM user1
GROUP BY addr
HAVING totalUsers>=3;

-- 测试排序
-- 按照id降序排列
SELECT id,username,age
FROM user1
ORDER BY id DESC;

-- 按照age升序
SELECT id,username,age
FROM user1
ORDER BY age ASC;

-- 按照多个字段排序
SELECT id,username,age
FROM user1
ORDER BY age ASC, id DESC;

-- 实现随机记录
SELECT id,username,age
FROM user1
ORDER BY RAND();

-- 测试LIMIT语句
-- 显示结果集中的前5条记录
SELECT id,username,age,sex
FROM user1
LIMIT 5;

SELECT id,username,age,sex
FROM user1
LIMIT 0,5;

SELECT id,username,age,sex
FROM user1
LIMIT 3,5;

UPDATE user1 SET age=age+5 LIMIT 3;
UPATE user1 SET age=age-10 ORDER BY id DESC LIMIT 3;
DELETE FROM user1 LIMIT 3;
DELETE FROM user1 ORDER BY id DESC LIMIT 3;

-- 测试完整SELECT  语句的形式
SELECT addr,
GROUP_CONCAT(username) AS usersDetail,
COUNT(*) AS totalUsers,
SUM(age) AS sum_age,
MAX(age) AS max_age,
MIN(age) AS min_age,
AVG(age) AS avg_age
FROM user1
WHERE id>=2
GROUP BY addr
HAVING totalUsers>=2
ORDER BY totalUsers
LIMIT 0,2;


