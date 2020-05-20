package com.jesse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jesse.dao.CategoryDao;
import com.jesse.domain.Category;
import com.jesse.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Category> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM category ORDER BY cid DESC";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			list = new ArrayList<Category>();
			while(rs.next()) {
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				category.setCdesc(rs.getString("cdesc"));
				list.add(category);
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
	public void save(Category category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "INSERT category VALUES (null,?,?)";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, category.getCname());
			pstmt.setString(2, category.getCdesc());
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
	public Category findOne(Integer cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Category category = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM category  WHERE cid= ?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, cid);	
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			if(rs.next()) {
				category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				category.setCdesc(rs.getString("cdesc"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}		
		return category;
	}

	@Override
	public void update(Category category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "UPDATE category SET cname=?,cdesc=? WHERE cid=? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, category.getCname());
			pstmt.setString(2, category.getCdesc());
			pstmt.setInt(3, category.getCid());
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
	public void delete(Integer cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "DELETE FROM category WHERE cid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, cid);
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
	public void delete(Connection conn, Integer cid) {
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			//2、编写SQL
			String sql = "DELETE FROM category WHERE cid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, cid);
			//5、执行
			pstmt.executeUpdate();
			//6、结果处理
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}	

}
