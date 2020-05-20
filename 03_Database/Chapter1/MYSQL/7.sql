CREATE TABLE test_primary_key(
    id INT UNSIGNED PRIMARY KEY,
    username VARCHAR(20)
);
INSERT test_primary_key(id,username) VALUES(1,'king');
INSERT test_primary_key(id,username) VALUES(1,'king123');
INSERT test_primary_key(id,username) VALUES('QUEEN');

CREATE TABLE test_primary_key3(
    id INT UNSIGNED PRIMARY KEY,
    courseId INT UNSIGNED PRIMARY KEY,
    username VARCHAR(20),
    email VARCHAR(50)
);

-- 复合主键
CREATE TABLE test_primary_key4(
    id INT UNSIGNED,
    courseId VARCHAR(20),
    username VARCHAR(20),
    email VARCHAR(50),
    PRIMARY KEY(id, courseId)
);
INSERT test_primary_key4(id, courseId,  username, email)
VALUES(1,'a','king','505733517@qq.com');

INSERT test_primary_key4(id, courseId,  username, email)
VALUES(1,'b','king','505733517@qq.com');

INSERT test_primary_key4(id, courseId,  username, email)
VALUES(1,'a','king','505733517@qq.com');

