package handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConnectionProvider;
import domain.user.User;
import domain.user.dao.UserDao;

@WebServlet("/check.do")
public class IdCheckHandler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userName");
		UserDao userDao = new UserDao();
		PrintWriter out = resp.getWriter();
		
		
		try {
			User user = userDao.selectById(ConnectionProvider.getConnection(), id);
			if(user != null) {
				out.print("exist");
			}else {s
				out.print("not exist");
			}
				
		} catch (SQLException e) {
		}
		
	}
	
	

}
