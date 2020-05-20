CREATE TABLE IF NOT EXISTS new_cate(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    cateName VARCHAR(50) NOT NULL UNIQUE COMMENT '分类名称',
    cateDesc VARCHAR(100) NOT NULL DEFAULT '' COMMENT '分类描述'
)ENGINE=INNODB CHARSET=UTF8;
INSERT new_cate(cateName) VALUES('国内新闻'),
('国际新闻'),
('娱乐新闻'),
('体育新闻');

CREATE TABLE IF NOT EXISTS news(
    id TINYINT UNSIGNED  AUTO_INCREMENT KEY COMMENT '编号',
    title VARCHAR(100) NOT NULL UNIQUE COMMENT '新闻标题',
    content VARCHAR(1000) NOT NULL COMMENT '新闻内容',
    cateId TINYINT NOT NULL COMMENT '新闻所属分类编号'
)ENGINE=INNODB CHARSET=UTF8;
INSERT news(title,content,cateId) VALUES('a1','aaaa1',1),
('a2','aaaa2',1),
('a3','aaaa3',4),
('a4','aaaa4',2),
('a5','aaaa5',3);

-- news id title content
-- new_cate cateName

SELECT n.id,n.title,n.content,c.cateName
FROM news AS n
JOIN new_cate AS c
ON n.cateId=c.id;


CREATE TABLE IF NOT EXISTS new_cate(
    id TINYINT UNSIGNED AUTO_INCREMENT KEY COMMENT '编号',
    cateName VARCHAR(50) NOT NULL UNIQUE COMMENT '分类名称',
    cateDesc VARCHAR(100) NOT NULL DEFAULT '' COMMENT '分类描述'
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS news(
    id TINYINT UNSIGNED  AUTO_INCREMENT KEY COMMENT '编号',
    title VARCHAR(100) NOT NULL UNIQUE COMMENT '新闻标题',
    content VARCHAR(1000) NOT NULL COMMENT '新闻内容',
    cateId TINYINT UNSIGNED NOT NULL COMMENT '新闻所属分类编号',
    CONSTRAINT cateId_fk_newCate FOREIGN KEY(cateId) REFERENCES new_cate(id)
)ENGINE=INNODB CHARSET=UTF8;

-- 测试非法记录
INSERT news(title,content,cateId) VALUES('b1','bbbbb1',8);

-- 测试删除父表中的记录和删除父表
DELETE FROM new_cate WHERE id=1;

UPDATE new_cate SET id=10 WHERE id=1;

INSERT new_cate(cateName) VALUES('教育新闻');

-- 将教育新闻改为新闻
UPDATE new_cate SET cateName='教育' WHERE id=5;
UPDATE new_cate SET id=50 WHERE cateName='教育';

-- 删除外键
ALTER TABLE news
DROP FOREIGN KEY cateId_fk_newCate;

-- 增加外键
ALTER TABLE news
ADD CONSTRAINT cateId_fk_newCate FOREIGN KEY(cateId) REFERENCES new_cate(id);

-- 指定级联操作 DELETE CASCADE UPDATE CASCADE
ALTER TABLE news
ADD FOREIGN KEY(cateId) REFERENCES new_cate(id)
ON DELETE CASCADE ON UPDATE CASCADE;