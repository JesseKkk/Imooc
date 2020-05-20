package com.jesse.jdbc.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.jesse.jdbc.utils.JDBCUtils;
import com.jesse.jdbc.utils.JDBCUtils2;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *  连接池的测试类
 * @author Jesse
 *
 */
public class DataSourceDemo1 {
	
	@Test
	/**
	 *  使用配置文件的方式
	 */
	public void demo2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 创建连接池：
			//ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//获得连接对象
			//conn = dataSource.getConnection();
			conn = JDBCUtils2.createConnection();
			//编写SQL
			String sql = "SELECT * FROM user";
			//预编译SQL
			pstmt = conn.prepareStatement(sql);
			//设置参数
			//执行SQL：
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("uid") + 
						"  " +rs.getString("username") +
						"  " + rs.getString("password") +
						"  " + rs.getString("name")
						);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils2.release(pstmt, conn, rs);
		}
	}
	
	@Test
	/**
	 * 手动设置连接池
	 */
	public void demo1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 创建连接池：
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//设置连接池的参数：
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			//dataSource.setJdbcUrl("jdbc:mysql:///jdbctest");
			dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jdbctest" +
					"?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEndocing=utf-8");
			dataSource.setUser("root");
			dataSource.setPassword("1234");
			dataSource.setMinPoolSize(20);
			dataSource.setInitialPoolSize(3);
			//获得连接对象
			conn = dataSource.getConnection();
			//编写SQL
			String sql = "SELECT * FROM user";
			//预编译SQL
			pstmt = conn.prepareStatement(sql);
			//设置参数
			//执行SQL：
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("uid") + 
						"  " +rs.getString("username") +
						"  " + rs.getString("password") +
						"  " + rs.getString("name")
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn, rs);
		}
	}
}
