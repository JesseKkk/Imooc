package com.jesse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jesse.dao.MessageDao;
import com.jesse.domain.Message;
import com.jesse.domain.User;
import com.jesse.utils.JDBCUtils;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void add(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "INSERT message VALUES (null, ?, ?, ?, ?)";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, message.getTitle());
			pstmt.setString(2, message.getContent());
			pstmt.setString(3, message.getCreateTime());
			pstmt.setInt(4, message.getUser().getUid());
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
	public Message find(int mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid AND mid= ?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, mid);	
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			if(rs.next()) {
				message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getString("createTime"));
				//封装信息所属的用户
				message.getUser().setUid(rs.getInt("uid"));
				message.getUser().setUsername(rs.getString("username"));	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}		
		return message;	
	}

	@Override
	public void update(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "UPDATE message SET title=?,content=? WHERE mid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, message.getTitle());
			pstmt.setString(2, message.getContent());
			pstmt.setInt(3, message.getMid());
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
	public void delete(int mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "DELETE FROM message WHERE mid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, mid);
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
	public int findCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long count = 0l;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select count(*) AS count FROM message";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			if(rs.next()) {
				count = rs.getLong("count");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}		
		return count.intValue();
	}

	@Override
	public List<Message> findByPage(int begin, int limit) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid ORDER BY m.mid DESC LIMIT ?,? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, begin);
			pstmt.setInt(2, limit);
			//5、执行
			rs = pstmt.executeQuery();
			list = new ArrayList<Message>();
			//6、结果处理
			while(rs.next()) {
				Message message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getString("createTime"));
				//封装信息所属的用户
				message.getUser().setUid(rs.getInt("uid"));
				message.getUser().setUsername(rs.getString("username"));	
				list.add(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public int findCount(User existUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long count = 0l;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select count(*) AS count FROM message WHERE uid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, existUser.getUid());			
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			if(rs.next()) {
				count = rs.getLong("count");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}		
		return count.intValue();
	}

	@Override
	public List<Message> findByPage(User existUser, int begin, int limit) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM message AS m,  user AS u  WHERE m.uid=u.uid AND m.uid=? ORDER BY m.mid DESC LIMIT ?,? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, existUser.getUid());
			pstmt.setInt(2, begin);
			pstmt.setInt(3, limit);
			//5、执行
			rs = pstmt.executeQuery();
			list = new ArrayList<Message>();
			//6、结果处理
			while(rs.next()) {
				Message message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setCreateTime(rs.getString("createTime"));
				//封装信息所属的用户
				message.getUser().setUid(rs.getInt("uid"));
				message.getUser().setUsername(rs.getString("username"));	
				list.add(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

}
