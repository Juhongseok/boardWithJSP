package domain.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtil;
import domain.user.User;
import domain.user.dto.ChangeInfoReqDto;
import domain.user.dto.LoginReqDto;

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

	public String getAddress(Connection conn, String id) {
		String sql = "SELECT ADDRESS FROM USER WHERE MEMBER_ID=?";
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				return rs.getString("ADDRESS");
			
		}catch (SQLException e) {
			return null;
		}finally {
			JdbcUtil.close(rs);
		}
		return null;
	}

	public LoginReqDto changeInfo(Connection conn, ChangeInfoReqDto changeInfoReqDto) {
		String memberId = changeInfoReqDto.getId();
		String password = changeInfoReqDto.getPassword();
		String address = changeInfoReqDto.getAddress();
		
		String sql = "UPDATE USER SET PASSWORD=?, ADDRESS=? WHERE MEMBER_ID=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, password);
			pstmt.setString(2, address);
			pstmt.setString(3, memberId);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				LoginReqDto loginReqDto = new LoginReqDto(memberId, password, address);
				return loginReqDto;
			}
		}catch (SQLException e) {
			System.out.println(e);
			return null;	
		}
		return null;
	}
}
