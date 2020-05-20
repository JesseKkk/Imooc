import com.jesse.sc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    private JdbcTemplate jdbcTemplate;
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
    }

    @org.junit.Test
    public void testExecute(){
        jdbcTemplate.execute("create table user1(id int, name varchar(20))");
    }

    @org.junit.Test
    public void testUpdate(){
        String sql = "INSERT INTO student(name,sex) VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"张飞","男"});
    }

    @org.junit.Test
    public void testUpdate2(){
        String sql = "UPDATE student SET sex=? WHERE id=?";
        jdbcTemplate.update(sql, "女",1);
    }

    @org.junit.Test
    public void testBatchUpdate(){
        String[] sqls={
          "INSERT INTO student(name,sex) VALUES('关羽','女')",
          "INSERT INTO student(name,sex) VALUES('刘备','男')",
          "UPDATE student SET sex='男' WHERE id=1"
        };
        jdbcTemplate.batchUpdate(sqls);
    }

    @org.junit.Test
    public void testBatchUpdate2(){
        String sql = "INSERT INTO selection(student,course) VALUES(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{1, 1001});
        list.add(new Object[]{1,1003});
        jdbcTemplate.batchUpdate(sql,list);
    }

    @org.junit.Test
    public void testQuerySimple1(){
        String sql = "SELECT count(*) FROM student";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    @org.junit.Test
    public void testQuerySimple2(){
        String sql = "SELECT name FROM student WHERE sex=?";
        List<String> names = jdbcTemplate.queryForList(sql,String.class,"男");
        System.out.println(names);
    }

    @org.junit.Test
    public void testQueryMap1(){
        String sql = "SELECT * FROM student WHERE id = ?";
        Map<String,Object> stu = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stu);
    }

    @org.junit.Test
    public void testQueryMap2(){
        String sql = "SELECT * FROM student";
        List<Map<String,Object>> stus = jdbcTemplate.queryForList(sql);
        System.out.println(stus);
    }

    @org.junit.Test
    public void testQueryEntity1(){
        String sql = "SELECT * FROM student WHERE id = ?";
        Student stu = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), 1);
        System.out.println(stu);
    }

    @org.junit.Test
    public void testQueryEntity2(){
        String sql = "SELECT * FROM student";
        List<Student> stus = jdbcTemplate.query(sql, new StudentRowMapper());
        System.out.println(stus);
    }

    private class StudentRowMapper implements RowMapper<Student>{
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
