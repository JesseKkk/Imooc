package com.jesse.jdbc.demo1;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import com.jesse.jdbc.utils.JDBCUtils;

public class JDBCDemo3 {

	@Test
	/**
	 *  测试JDBCUtils
	 */
	public void demo1() {
		Connection conn = null;
		Statement stmt = null;
		try {
			//获得连接
			conn = JDBCUtils.createConnection();
			//获得SQL执行执行对象
			stmt = conn.createStatement();
			//SQL语句
			String sql = "INSERT user VALUES (NULL,'eee','555','小六')";
			//执行SQL语句
			int i = stmt.executeUpdate(sql);
			if (i>0) {
				System.out.println("保存成功！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);
		}
	}
	
}
