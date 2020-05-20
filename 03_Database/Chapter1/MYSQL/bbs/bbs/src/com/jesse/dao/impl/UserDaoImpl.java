package com.jesse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jesse.dao.UserDao;
import com.jesse.domain.User;
import com.jesse.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "INSERT user VALUES (null, ?, ?)";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			//5、执行
			pstmt.executeUpdate();
			//6、结果处理
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(pstmt, conn);
		}	
	}

	@Override
	public User login(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//SQL
			String sql = "SELECT * FROM user WHERE username = ? and password = ?";
			//预处理SQL
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			//执行
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User existUser = new User();
				existUser.setUid(rs.getInt("uid"));
				existUser.setUsername(rs.getString("username"));
				existUser.setPassword(rs.getString("password"));
				return existUser;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public void update(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "UPDATE user SET username=?,password=? WHERE uid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getUid());
			//5、执行
			pstmt.executeUpdate();
			//6、结果处理
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(pstmt, conn);
		}			
	}

}
