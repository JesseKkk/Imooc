-- 测试非空
CREATE TABLE test_not_null(
    a  VARCHAR(20),
    B VARCHAR(20) NOT NULL
);
INSERT test_not_null(a,b) VALUES('','');
INSERT test_not_null(a,b) VALUES(NULL,NULL);

-- 测试默认值
CREATE TABLE test_default(
    id INT UNSIGNED AUTO_INCREMENT KEY,
    username VARCHAR(20) NOT NULL,
    age TINYINT UNSIGNED DEFAULT 18,
    email VARCHAR(50) NOT NULL DEFAULT '505755517@qq.com'
);
INSERT test_default(username) VALUES('A');
INSERT test_default(username,age,email) VALUES('B',30,'immoc@qq.com');
INSERT test_default(username,age,email) VALUES('C',NULL,'immoc@qq.com');
INSERT test_default(username,age,email) VALUES('D',NULL,NULL);
INSERT test_default(username,age,email) VALUES('E',26,DEFAULT);

CREATE TABLE test_defalut1(
    id INT UNSIGNED AUTO_INCREMENT KEY,
    sex ENUM('a','b','c') NOT NULL DEFAULT 'a'
);

-- 测试UNIQUE KEY
CREATE TABLE test_unique(
    id INT UNSIGNED AUTO_INCREMENT KEY,
    username VARCHAR(20) NOT NULL UNIQUE KEY,
    email VARCHAR(50) UNIQUE,
    card CHAR(18) UNIQUE
);
INSERT test_unique(username,email,card) VALUES('A','A@QQ.COM','1');
INSERT test_unique(username,email,card) VALUES('B','A@QQ.COM','12');
INSERT test_unique(username,email,card) VALUES('C',NULL,NULL);
