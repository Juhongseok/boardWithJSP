package domain.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtil;
import domain.user.User;

public class UserDao {
	public User selectById(Connection conn, String id) throws SQLException {
		String sql = "SELECT * FROM USER WHERE MEMBER_ID = ?;";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User(rs.getString("MEMBER_ID"),
								rs.getString("PASSWORD"),
								rs.getString("ADDRESS"),
								rs.getString("ROLE")
							);
				return user;
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
	
	public int insert(Connection conn, User user) {
		String sql = "INSERT INTO USER (MEMBER_ID, PASSWORD, ADDRESS, ROLE) VALUES(?,?,?,?);";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println(user.getMemberId() + " " + user.getPassword() + " "
					+ user.getAddress() + " " + user.getRole());
			pstmt.setString(1, user.getMemberId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getRole());
			
			int result = pstmt.executeUpdate();
			return result;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
