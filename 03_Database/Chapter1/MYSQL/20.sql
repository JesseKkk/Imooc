-- 测试子查询
-- 测试由in引发的子查询

SELECT * FROM emp
WHERE depId IN (SELECT id FROM dep);

-- 创建一个user1表，id username
CREATE TABLE user1(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY,
    username VARCHAR(20)
)SELECT id,username FROM emp;

-- 将user表中的用户名写入到user1表中
INSERT user1(username) SELECT username FROM admins;

-- 去掉字段的重复值
SELECT DISTINCT(username) FROM user2;