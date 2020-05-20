package com.jesse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jesse.dao.UserDao;
import com.jesse.domain.User;
import com.jesse.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//SQL
			String sql = "SELECT * FROM user where username = ? and password = ?";
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

}
