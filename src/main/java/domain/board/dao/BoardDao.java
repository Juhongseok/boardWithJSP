package domain.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import domain.board.Board;
import domain.board.dto.WriteReqDto;
import domain.user.dto.LoginReqDto;

public class BoardDao {
	
	public int insert(Connection conn, WriteReqDto writeReqDto) {
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO BOARD (TITLE, CONTENT, USER_ID) VALUES (?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeReqDto.getTitle());
			pstmt.setString(2, writeReqDto.getContent());
			pstmt.setInt(3, writeReqDto.getUserId());
			
			int result = pstmt.executeUpdate();
			
			return result;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			JdbcUtil.close(pstmt);
		}
		return -1;
	}
	
	public List<Board> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM BOARD ORDER BY ID DESC LIMIT ?, ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Board> list = new ArrayList<Board>();
			while(rs.next()) {
				list.add(convertBoard(rs));
			}
			
			return list;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Board convertBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("ID"),
				rs.getString("TITLE"),
				rs.getInt("READCOUNT"),
				rs.getString("CONTENT"),
				rs.getTimestamp("CREATEDATE"),
				rs.getInt("USER_ID"));
	}

	public static int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(*) FROM BOARD;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
				return rs.getInt(1);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return 0;
	}
	
	public Board selectById(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM BOARD WHERE ID=?; ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Board result = null;
			if(rs.next()) 
				result = convertBoard(rs);
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int increaseReadCount(Connection conn, int id) throws SQLException {		
		String sql = "UPDATE BOARD SET READCOUNT=READCOUNT+1 WHERE ID=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e);	
		}
		return -1;
	}

	public int deleteBoard(Connection conn, int boardId) {
		String sql = "DELETE FROM BOARD WHERE ID=?;";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardId);
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e);	
		}
		return -1;
	}

}
