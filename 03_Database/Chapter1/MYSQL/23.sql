-- 测试字符串函数
-- CHAR_LENGTH(): 得到字符串的字符数
SELECT CHAR_LENGTH('abc');

-- LENGTH(): 返回字符串的字节长度
SELECT LENGTH('abc');
SELECT LENGTH('你好啊');

-- CONCAT(s1,s2,...):将字符串合并成一个字符串
SELECT CONCAT('a','b','c');

-- 如果字符串中包含NULL，返回拼接结果是NULL
SELECT CONCAT('a','b','c',null);


-- CONCAT_WS(x,s1,s2,s3...): 已指定分隔符拼接字符串
SELECT CONCAT_WS('-','a','b','c');

-- 将字符串转换成大写或者小写 UPPER()|UCASE() LOWER()|LCASE()
SELECT UPPER('hello king'),UCASE('hello imooc'),
LOWER('HELLO ADMIN'),LCASE('HELLO EVERYBODY');

-- 字符串的反转REVERSE()
SELECT REVERSE('abc');

--LEFT()|RIGHT(): 返回字符串的前几个字符或者或后几个字符
SELECT LEFT('hello',2),RIGHT('hello',2);

-- LPAD()|RPAD(): 用字符串填充到指定长度
SELECT LPAD('abc',10,'?');
SELECT RPAD('abc',10,'!');

-- 去掉字符串两端的空格TRIM()|LTRIM()|RTRIM()
SELECT CONCAT('*',TRIM(' abc '),'*'),CONCAT('*',LTRIM(' abc '),'*'),CONCAT('*',RTRIM(' abc '),'*');

-- REPEART(s): 重复指定的次数
SELECT REPEAT('hello',3);

-- REPLACE(): 替换字符串
SELECT  REPLACE('hello king','king','queen');

-- 截取字符串SUBSTRING
SELECT SUBSTRING('abcdef',1,3);

-- 比较字符串
SELECT STRCMP('a','b');