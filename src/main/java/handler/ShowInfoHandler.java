package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dto.ChangeInfoReqDto;
import domain.user.dto.LoginReqDto;
import service.UserService;

public class ShowInfoHandler implements CommandHandler{
	private static final String FORM_VIEW = "/view/showInfo.jsp";
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		
		UserService userService = new UserService();
		ChangeInfoReqDto changeInfoReqDto = new ChangeInfoReqDto(id, password, address);
		LoginReqDto user = userService.changeInfo(changeInfoReqDto);
		HttpSession session = req.getSession();
		if(user != null) {
			session.setAttribute("user", user);
			return "/index.jsp";
		}
		return FORM_VIEW;
	}
}