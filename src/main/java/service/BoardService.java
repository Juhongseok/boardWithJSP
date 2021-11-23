package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import db.JdbcUtil;
import domain.board.Board;
import domain.board.dao.BoardDao;
import domain.board.dto.ListReqDto;
import domain.board.dto.WriteReqDto;
import domain.user.dao.UserDao;

public class BoardService {
	BoardDao boardDao = new BoardDao();
	
	public int writeBoard(WriteReqDto writeReqDto) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		return boardDao.insert(conn, writeReqDto);
	}
	
	public void deleteBoard() {
		
	}
	
	public void modifyBoard() {
		
	}
	
	public List<ListReqDto> showBoardList(int pageNo, int size) {
		Connection conn = null;
		List<ListReqDto> result = new ArrayList<>();	
		try {
			conn = ConnectionProvider.getConnection();
			List<Board> boards = boardDao.select(conn, (pageNo-1)*size, size);
			UserDao userDao = new UserDao();
			
			for(Board board : boards) {
				String userName = userDao.getMemberId(conn, board.getUserId());
				result.add(new ListReqDto(board.getId(),
								board.getTitle(),
								userName,
								board.getReadCount(),
								pageNo,
								size)
							);
			}
			return result;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.close(conn);
		}
		return null;
	}

	public int getCountAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		return BoardDao.selectCount(conn);
	}
}
