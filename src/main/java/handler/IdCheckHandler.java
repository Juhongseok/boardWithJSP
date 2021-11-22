package handler;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConnectionProvider;
import domain.user.User;
import domain.user.dao.UserDao;

public class IdCheckHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("userName");
		UserDao userDao = new UserDao();
		PrintWriter out = resp.getWriter();
		
		
		try {
			User user = userDao.selectById(ConnectionProvider.getConnection(), id);
			if(user != null) {
				out.print("exist");
			}else {
				out.print("not exist");
			}
				
		} catch (SQLException e) {
		}
		return null;
	}
}
