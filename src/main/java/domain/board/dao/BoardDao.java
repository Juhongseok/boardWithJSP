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
}
