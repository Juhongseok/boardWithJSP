package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import db.ConnectionProvider;
import db.JdbcUtil;
import domain.user.User;
import domain.user.dao.UserDao;
import domain.user.dto.ChangeInfoReqDto;
import domain.user.dto.JoinReqDto;
import domain.user.dto.LoginReqDto;
import service.exception.LoginException;

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
	
	public LoginReqDto logIn(String id, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			User user = userDao.selectById(conn, id);
			String address = userDao.getAddress(conn, id);
			if(user == null)
				throw new LoginException();
			
			if(!user.getPassword().equals(password))
				throw new LoginException();
			return new LoginReqDto(id, password, address);
		}catch(SQLException e) {
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void logOut() {
		
	}
	
	public void showUserInfo() {
		
	}

	public LoginReqDto changeInfo(ChangeInfoReqDto changeInfoReqDto) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return userDao.changeInfo(conn, changeInfoReqDto);
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
}
