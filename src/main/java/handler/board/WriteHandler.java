package handler.board;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.board.dto.WriteReqDto;
import domain.user.dao.UserDao;
import domain.user.dto.LoginReqDto;
import handler.CommandHandler;
import service.BoardService;

public class WriteHandler implements CommandHandler{
	private static final String FORM_VIEW="/view/writeBoard.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET"))
			return processForm(req, resp);
		else if(req.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(req, resp);
		return null;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		Date now = new Date();
		LoginReqDto user = (LoginReqDto) req.getSession().getAttribute("user");
		String id = user.getId();
		UserDao userDao = new UserDao();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int userId = userDao.getPrimaryKey(id);
		
		WriteReqDto writeReqDto = new WriteReqDto(title, content, userId, userId);
		BoardService boardService = new BoardService();
		int result = boardService.writeBoard(writeReqDto);
		if(result == 1)
			return "/index.jsp";
		else
			return FORM_VIEW;
	}
}
