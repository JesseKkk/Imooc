-- 测试AUTO_INCREMENT
CREATE TABLE test_auto_increment(
    id INT UNSIGNED KEY AUTO_INCREMENT,
    username VARCHAR(20)
);
INSERT test_auto_increment(username) VALUES('A');
INSERT test_auto_increment(username) VALUES('B');
INSERT test_auto_increment(username) VALUES('C');

INSERT test_auto_increment(id,username) VALUES(NULL,'A');
INSERT test_auto_increment(id,username) VALUES(DEFAULT,'A');
