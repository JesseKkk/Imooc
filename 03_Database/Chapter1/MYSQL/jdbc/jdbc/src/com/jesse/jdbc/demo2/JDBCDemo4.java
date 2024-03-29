package com.jesse.jdbc.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.jesse.jdbc.utils.JDBCUtils;

public class JDBCDemo4 {
	
	@Test
	/**
	 *  演示JDBC的注入的漏洞
	 */
	public void demo1() {
		//boolean flag = JDBCDemo4.login2("aaa","111");//正常登录
		//boolean flag = JDBCDemo4.login2("aaa' OR '1=1 ","adfasd");//SQL注入漏洞方式一
		boolean flag = JDBCDemo4.login2("aaa' -- ","fasdfasd");//SQL注入漏洞方式二

		if(flag == true) {
			System.out.println("登陆成功！");
		}else {
			System.out.println("登录失败！");
		}
	}
	
	/**
	 * 避免SQL注入漏洞的方法
	 */
	public static boolean login2(String username,String password) {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			//获得连接
			conn = JDBCUtils.createConnection();
			//SQL语句
			String sql = "SELECT * FROM user WHERE username= ? AND password= ? ";
			//预处理SQL语句
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 执行SQL语句
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn, rs);
		}
		return flag;
	}
	
	/**
	 *  产生SQL注入漏洞的方法
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			//获得连接
			conn = JDBCUtils.createConnection();
			//获得SQL执行对象
			stmt = conn.createStatement();
			//SQL语句
			String sql = "SELECT * FROM user WHERE username='" +username +  "' AND password='" + password + "'";
			//SQL语句执行
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn, rs);
		}
		return flag;
	}
}
