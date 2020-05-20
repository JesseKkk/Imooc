package com.jesse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jesse.dao.ProductDao;
import com.jesse.domain.Category;
import com.jesse.domain.Product;
import com.jesse.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM product AS p, category AS c WHERE p.cid = c.cid ORDER BY p.pid DESC";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			list = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setAuthor(rs.getString("author"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setFilename(rs.getString("filename"));
				product.setPath(rs.getString("path"));
				//封装商品所属的分类
				product.getCategory().setCid(rs.getInt("cid"));
				product.getCategory().setCname(rs.getString("cname"));
				product.getCategory().setCdesc(rs.getString("cdesc"));
				
				list.add(product);
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
	public void save(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "INSERT product VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, product.getPname());
			pstmt.setString(2, product.getAuthor());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getFilename());
			pstmt.setString(6, product.getPath());
			pstmt.setInt(7, product.getCategory().getCid());
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
	public Product findOne(Integer pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM product AS p, category AS c WHERE p.cid = c.cid AND p.pid = ?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, pid);	
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			if(rs.next()) {
				product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setAuthor(rs.getString("author"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setFilename(rs.getString("filename"));
				product.setPath(rs.getString("path"));
				product.getCategory().setCid(rs.getInt("cid"));
				product.getCategory().setCname(rs.getString("cname"));
				product.getCategory().setCdesc(rs.getString("cdesc"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//7、释放
			JDBCUtils.release(rs, pstmt, conn);
		}		
		return product;
	}

	@Override
	public void update(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "UPDATE product SET pname=?,author=?,price=?,description=?,filename=?,path=?,cid=? WHERE pid=? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, product.getPname());
			pstmt.setString(2, product.getAuthor());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getFilename());
			pstmt.setString(6, product.getPath());
			pstmt.setObject(7, product.getCategory().getCid());
			pstmt.setInt(8, product.getPid());
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
	public void delete(Integer pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "DELETE FROM product WHERE pid=?";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, pid);
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
	public List<Product> findByCid(Integer cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM product AS p, category AS c WHERE p.cid = c.cid AND p.cid = ? ORDER BY p.pid DESC";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, cid);
			//5、执行
			rs = pstmt.executeQuery();
			//6、结果处理
			list = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setAuthor(rs.getString("author"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setFilename(rs.getString("filename"));
				product.setPath(rs.getString("path"));
				//封装商品所属的分类
				product.getCategory().setCid(rs.getInt("cid"));
				product.getCategory().setCname(rs.getString("cname"));
				product.getCategory().setCdesc(rs.getString("cdesc"));
				
				list.add(product);
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
	public void update(Connection conn, Product product) {
		PreparedStatement pstmt = null;
		try {
			//1、获得连接
			//2、编写SQL
			String sql = "UPDATE product SET pname=?,author=?,price=?,description=?,filename=?,path=?,cid=? WHERE pid=? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setString(1, product.getPname());
			pstmt.setString(2, product.getAuthor());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getFilename());
			pstmt.setString(6, product.getPath());
			pstmt.setObject(7, product.getCategory().getCid());
			pstmt.setInt(8, product.getPid());
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
			String sql = "Select count(*) AS count FROM product AS p WHERE p.cid IS NOT NULL ";
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
	public List<Product> findByPage(int begin, int limit) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			//1、获得连接
			conn = JDBCUtils.getConnection();
			//2、编写SQL
			String sql = "Select * FROM product AS p WHERE p.cid IS NOT NULL ORDER BY p.pid DESC LIMIT ?,? ";
			//3、预编译SQL
			pstmt = conn.prepareStatement(sql);
			//4、设置参数
			pstmt.setInt(1, begin);
			pstmt.setInt(2, limit);
			//5、执行
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			//6、结果处理
			while(rs.next()) {
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setAuthor(rs.getString("author"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setFilename(rs.getString("filename"));
				product.setPath(rs.getString("path"));
				list.add(product);
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
