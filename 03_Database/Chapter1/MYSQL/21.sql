CREATE TABLE cate(
    id SMALLINT UNSIGNED AUTO_INCREMENT KEY,
    cateName VARCHAR(100) NOT NULL UNIQUE,
    pId SMALLINT UNSIGNED NOT NULL DEFAULT 0
)ENGINE=INNODB;
INSERT cate(cateName,pId) VALUES('服装',0),
('数码',0),
('玩具',0);
INSERT cate(cateName,pId) VALUES('男装',1),
('女装',1),
('内衣',1);
INSERT cate(cateName,pId) VALUES('电视',2),
('冰箱',2),
('洗衣机',2);
INSERT cate(cateName,pId) VALUES('爱马仕',3),
('LV',3),
('GUCCI',3);
INSERT cate(cateName,pId) VALUES('夹克',4),
('衬衫',4),
('裤子',4);
INSERT cate(cateName,pId) VALUES('液晶电视',7),
('等离子电视',7),
('背投电视',7); 

-- 查询所有的分类信息，并且得到其父类
SELECT s.id,s.cateName AS sCateName,p.cateName AS pCateName
FROM cate AS s
LEFT JOIN cate AS p
ON s.pId=p.id;

-- 查询所有的分类信息，并且得到其子类
SELECT p.id,p.cateName AS pCateName,s.cateName AS sCateName
FROM cate AS s
RIGHT JOIN cate AS p
ON s.pId=p.id;

-- 查询所有的分类并且得到子分类的数目
SELECT p.id,p.cateName AS pCateName,COUNT(s.cateName) AS count
FROM cate AS s
RIGHT JOIN cate AS p
ON s.pId=p.id
GROUP BY p.cateName
ORDER BY id ASC;

+----+------------+-----+
| id | cateName   | pId |
+----+------------+-----+
|  1 | 服装       |   0 |
|  2 | 数码       |   0 |
|  3 | 玩具       |   0 |
|  4 | 男装       |   1 |
|  5 | 女装       |   1 |
|  6 | 内衣       |   1 |
|  7 | 电视       |   2 |
|  8 | 冰箱       |   2 |
|  9 | 洗衣机     |   2 |
| 10 | 爱马仕     |   3 |
| 11 | LV         |   3 |
| 12 | GUCCI      |   3 |
| 13 | 夹克       |   4 |
| 14 | 衬衫       |   4 |
| 15 | 裤子       |   4 |
| 16 | 液晶电视   |   7 |
| 17 | 等离子电视 |   7 |
| 18 | 背投电视   |   7 |

+----+------------+-----+
| id | cateName   | pId |
+----+------------+-----+
|  1 | 服装       |   0 |
|  2 | 数码       |   0 |
|  3 | 玩具       |   0 |
|  4 | 男装       |   1 |
|  5 | 女装       |   1 |
|  6 | 内衣       |   1 |
|  7 | 电视       |   2 |
|  8 | 冰箱       |   2 |
|  9 | 洗衣机     |   2 |
| 10 | 爱马仕     |   3 |
| 11 | LV         |   3 |
| 12 | GUCCI      |   3 |
| 13 | 夹克       |   4 |
| 14 | 衬衫       |   4 |
| 15 | 裤子       |   4 |
| 16 | 液晶电视   |   7 |
| 17 | 等离子电视 |   7 |
| 18 | 背投电视   |   7 |