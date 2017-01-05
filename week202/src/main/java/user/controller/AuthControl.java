package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.controller.model.User;
import utils.DaoFactory;
import user.dao.UserDao;
import user.dao.UserJDBCDao;


@WebServlet("/auth")
public class AuthControl extends HttpServlet {
	
	UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		try {
			this.userDao = DaoFactory.createUserDao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get login and password
		String mail = req.getParameter("email");
		String mdp = req.getParameter("password");
		User user = new User();
		user.setMail(mail);
		user.setMotDePasse(mdp);
		
		System.out.println(mail);
		System.out.println(mdp);
		
		PrintWriter out = resp.getWriter(); 
		// check authentication of user
		if (this.userDao.checkPassword(mail, mdp)) {
			System.out.println("bravoooooooooooooooooooooo"+"\n");
			resp.sendRedirect("http://www.google.com");
			return;
		}
		else {
			//resp.sendRedirect("");
			req.setAttribute("errorMessage", "value="+mail+" inavlid");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp); 

		}
	}
	

}
