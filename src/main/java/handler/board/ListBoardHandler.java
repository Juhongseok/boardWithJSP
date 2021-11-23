package handler.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.board.dto.ListPageReqDto;
import domain.board.dto.ListReqDto;
import handler.CommandHandler;
import service.BoardService;

public class ListBoardHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNumber = req.getParameter("pageNo");
		int pageNo = 1;
		int size = 10;
		if(pageNumber!=null)
			pageNo = Integer.parseInt(pageNumber);
		
		BoardService boardService = new BoardService();
		List<ListReqDto> list =  boardService.showBoardList(pageNo, size);
		int total = boardService.getCountAll();
		
		ListPageReqDto result = new ListPageReqDto(total, pageNo, list, size);
		req.setAttribute("result", result);
		return "/view/listBoard.jsp";
	}
}
