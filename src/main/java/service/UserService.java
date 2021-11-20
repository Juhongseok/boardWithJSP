package service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import db.JdbcUtil;
import domain.user.User;
import domain.user.dao.UserDao;
import domain.user.dto.JoinReqDto;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public int signUp(JoinReqDto joinDto) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();			
			int result = userDao.insert(conn, new User(
							joinDto.getId(),
							joinDto.getPassword(),
							joinDto.getAddress(),
							joinDto.getRole())
						);
			return result;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void signOut() {
		
	}
	
	public void logIn() {
		
	}
	
	public void logOut() {
		
	}
	
	public void changePassword() {
		
	}
	
	public void showUserInfo() {
		
	}
}
