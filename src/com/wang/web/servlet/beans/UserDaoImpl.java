package com.wang.web.servlet.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.wang.web.servlet.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao{


	@Override
	public User getUserByUsernameAndPassword(String username, String password){

		User u = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/bigdata_0308";
//			String user = "root";
//			String pawd = "root";
//			Connection conn = DriverManager.getConnection(url,user,pawd);
			Connection conn = ConnectionUtils.getConn();
			String sql = "select username,password from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, password);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtils.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		try {
			Connection conn = ConnectionUtils.getConn();
			String sql = "select id,username,password from tbl_user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtils.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void insertUser(String username, String password) {

		try {
			Connection conn = ConnectionUtils.getConn();

			String sql = "insert into tbl_user(username,password)values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ConnectionUtils.closeConn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
