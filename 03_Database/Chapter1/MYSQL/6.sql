CREATE TABLE test_str(
    a CHAR(5),
    b VARCHAR(5)
);
INSERT test_str(a,b) VALUES('','');
INSERT test_str(a,b) VALUES('a','a');
INSERT test_str(a,b) VALUES('ab','ab');
INSERT test_str(a,b) VALUES('abc','abc');
INSERT test_str(a,b) VALUES('abcd','abcd');
INSERT test_str(a,b) VALUES('abcde','abcde');
INSERT test_str(a,b) VALUES('abcdef','abcdef');
INSERT test_str(a,b) VALUES(' 123 ',' 123 ');

SELECT CONCAT('*', a, '*'),CONCAT('*',b,'*') FROM test_str;

-- 测试TEXT不能有默认值
CREATE TABLE test_str1(
    cntent TEXT DEFAULT 'THIS IS A TEST'
);

-- 测试ENUM
CREATE TABLE test_enum(
    sex ENUM('男','女','保密')
);
INSERT test_enum(sex) VALUES('男');
INSERT test_enum(sex) VALUES('男1');
INSERT test_enum(sex) VALUES(NULL);
INSERT test_enum(sex) VALUES(1);


-- 测试SET
CREATE TABLE test_set(
    a SET('A','B','C','D','E','F')
);
INSERT test_set(a) VALUES('A');
INSERT test_set(a) VALUES('C');
INSERT test_set(a) VALUES('C,D,F');
INSERT test_set(a) VALUES('C,F,A');


-- 测试TIME类型
CREATE TABLE test_time(
    a TIME
);
INSERT test_time(a) VALUES('12:23:45');
INSERT test_time(a) VALUES('2 12:23:45');
INSERT test_time(a) VALUES('12:23');
INSERT test_time(a) VALUES('121212');
INSERT test_time(a) VALUES(NOW());
INSERT test_time(a) VALUES(CURRENT_TIME);

-- 测试DATE类型 YYYY-MM-DD YYYYMMDD
CREATE TABLE test_date(
    a DATE
);
INSERT test_date(a) VALUES('2017-03-04');
INSERT test_date(a) VALUES('2017-2-14');
INSERT test_date(a) VALUES('4007-03-04');
INSERT test_date(a) VALUES('20170304');
INSERT test_date(a) VALUES('2017@03@04');
INSERT test_date(a) VALUES('2017.03.04');

-- YY-MM-DD YYMMDD
-- 70~99 转换为1970-1999 00~69 2000-2069
INSERT test_date(a) VALUES('780902');
INSERT test_date(a) VALUES('650902');
INSERT test_date(a) VALUES(NOW());
INSERT test_date(a) VALUES(CURRENT_TIME);

-- 测试DATETIME
CREATE TABLE test_datetime(
    a DATETIME
);
INSERT test_datetime(a) VALUES('1004-09-12 12:34:56');
INSERT test_datetime(a) VALUES('720305121212');
INSERT test_datetime(a) VALUES(NOW());
INSERT test_datetime(a) VALUES(CURRENT_TIME);

-- 测试TIMESTAMP
CREATE TABLE test_timestamp(
    a TIMESTAMP
);
INSERT test_timestamp(a) VALUES('1978-10-23 12:12:12');

-- 插入CURRENT_TIMESTAMP
INSERT test_timestamp VALUES(CURRENT_TIMESTAMP);


-- 测试YEAR
CREATE TABLE test_year(
    a YEAR
);
INSERT test_year(a) VALUES(1901);
INSERT test_year(a) VALUES(2156);
INSERT test_year(a) VALUES(20);
INSERT test_year(a) VALUES(0);
INSERT test_year(a) VALUES('0');

-- 00~69 2000~2069 70~99 1970~1999
-- 0 插入的结果是0000
-- '0' 插入的结果是2000