package handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dto.LoginReqDto;
import service.UserService;

public class LoginHandler implements CommandHandler{
	private static final String FORM_VIEW = "/view/loginForm.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println(req.getMethod());
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
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		
		try {
			UserService userService = new UserService();
			LoginReqDto user = userService.logIn(id, password);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;
		} catch (IOException e) {
			return FORM_VIEW;
		}
	}
	
	private String trim(String string) {
		return string==null ? null : string.trim();
	}
}
