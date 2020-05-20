-- 测试MyISAM存储引擎
CREATE TABLE test_myisam(
    a INT UNSIGNED,
    b VARCHAR(20),
    c CHAR(32)
)ENGINE=MyISAM;

CREATE TABLE myisam_1(
    a CHAR(30),
    id INT
)ENGINE=MyISAM;

CREATE TABLE myisam_2(
    a VARCHAR(30),
    id INT
)ENGINE=MyISAM;