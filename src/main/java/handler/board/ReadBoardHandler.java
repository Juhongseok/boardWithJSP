package handler.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.board.dto.ReadReqDto;
import handler.CommandHandler;
import service.BoardService;

public class ReadBoardHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boardNumber = Integer.parseInt(req.getParameter("no"));
		BoardService boardService = new BoardService();
		try {
			ReadReqDto readReqDto = boardService.getBoard(boardNumber);
			req.setAttribute("board", readReqDto);
			return "/view/readBoard.jsp";
		}catch(Exception e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
