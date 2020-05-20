package com.jesse.sc.dao.impl;

import com.jesse.sc.dao.StudentDao;
import com.jesse.sc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Student stu) {
        String sql = "INSERT INTO student(name,sex,born) VALUES(?,?,?)";
        jdbcTemplate.update(sql, stu.getName(), stu.getSex(), stu.getBorn());
    }

    public void update(Student stu) {
        String sql = "UPDATE student SET name=?,sex=?,born=? WHERE id=?";
        jdbcTemplate.update(sql,stu.getName(),stu.getSex(),stu.getBorn(),stu.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    public Student select(int id) {
        String sql = "SELECT * FROM student WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    public List<Student> selectAll() {
        String sql = "SELECT * FROM student WHERE id=?";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    private class StudentRowMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student stu = new Student();
            stu.setId(resultSet.getInt("id"));
            stu.setName(resultSet.getString("name"));
            stu.setSex(resultSet.getString("sex"));
            stu.setBorn(resultSet.getDate("born"));
            return stu;
        }
    }
}
