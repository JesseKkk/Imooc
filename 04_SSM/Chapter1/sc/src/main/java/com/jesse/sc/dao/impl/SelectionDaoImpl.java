package com.jesse.sc.dao.impl;

import com.jesse.sc.dao.SelectionDao;
import com.jesse.sc.entity.Selection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class SelectionDaoImpl implements SelectionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<Selection> seles) {
        String sql = "INSERT INTO selection VALUES(?,?,?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        for (Selection sel : seles) {
            Object[] args = new Object[4];
            args[0] = sel.getSid();
            args[1] = sel.getCid();
            args[2] = sel.getSelTime();
            args[3] = sel.getScore();
            list.add(args);
        }
        jdbcTemplate.batchUpdate(sql, list);
    }

    public void delete(int sid, int cid) {
        String sql = "DELETE FROM selection WHERE student=? AND course=?";
        jdbcTemplate.update(sql,sid,cid);
    }

    public List<Map<String, Object>> selectByStudent(int sid) {
        String sql = "SELECT se.*,stu.name sname,cou.name cname FROM selection se " +
                "LEFT JOIN student stu ON se.student=stu.id " +
                "LEFT JOIN course cou ON se.course=cou.id" +
                "WHERE student=?";
        return jdbcTemplate.queryForList(sql,sid);
    }

    public List<Map<String, Object>> selectByCourse(int cid) {
        String sql = "SELECT se.*,stu.name sname,cou.name cname FROM selection se " +
                "LEFT JOIN student stu ON se.student=stu.id " +
                "LEFT JOIN course cou ON se.course=cou.id" +
                "WHERE student=?";
        return jdbcTemplate.queryForList(sql,cid);
    }
}
