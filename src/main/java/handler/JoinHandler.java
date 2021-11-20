package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dto.JoinReqDto;
import service.UserService;

public class JoinHandler implements CommandHandler{
	private static final String FORM_VIEW = "/view/joinForm.jsp";
	private UserService userService = new UserService();
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
		JoinReqDto joinDto = new JoinReqDto();
		joinDto.setId(req.getParameter("id"));
		joinDto.setPassword(req.getParameter("password"));
		joinDto.setAddress(req.getParameter("address"));
		joinDto.setRole(req.getParameter("role"));
		
		int result = userService.signUp(joinDto);
		
		if(result == 1)
			return "/index.jsp";
		return FORM_VIEW;
	}

}
