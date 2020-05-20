CREATE TABLE IF NOT EXISTS catagory(
    cid INT UNSIGNED AUTO_INCREMENT KEY,
    cname VARCHAR(20),
    cdesc VARCHAR(200) 
)ENGINE=INNODB CHARSET=UTF8;

ALTER TABLE catagory RENAME category;

INSERT category VALUES (NULL,'人物画','描述人物的画'),
(NULL,'风景画','描述风景的画'),
(NULL,'动物画','描述动物的画');

INSERT user VALUES (NULL,'孔金星','1234','孔金星');

CREATE TABLE IF NOT EXISTS product(
    pid INT UNSIGNED AUTO_INCREMENT KEY,
    pname  VARCHAR(20),
    author VARCHAR(20),
    price  DOUBLE,
    description VARCHAR(1000),
    filename VARCHAR(30),
    path VARCHAR(200),
    cid INT
)

INSERT product VALUES (NULL,'蒙娜丽莎','达芬奇',4000,'意大利经典作品','mengnalisha','path',1),(NULL,'自由的塔','孔金星',5000,'中国经典作品','niubi','path',2);

Select * FROM product AS p, category AS c WHERE p.cid = c.cid;

ALTER TABLE product
ADD CONSTRAINT cid_fk_categoryCid FOREIGN KEY(cid) REFERENCES category(cid);

ALTER TABLE product CHANGE cid cid INT UNSIGNED;
ALTER TABLE product CHANGE pid pid INT UNSIGNED AUTO_INCREMENT;

INSERT category VALUES (1,'人物画','描述人物的画'),
(2,'风景画','描述风景的画');

ALTER TABLE product AUTO_INCREMENT=4;

UPDATE product SET cid=2 WHERE pid=2;

Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid AND m.uid=3 ORDER BY m.mid DESC LIMIT 0,6;