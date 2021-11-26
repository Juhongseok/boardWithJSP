package handler.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import service.BoardService;

public class DeleteBoardHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		BoardService boardService = new BoardService();
		int result = boardService.deleteBoard(boardId);
		PrintWriter out = resp.getWriter();
		if(result == 1)
			out.print("delete");
		else
			out.print("not delete");
		return null;
	}
}
