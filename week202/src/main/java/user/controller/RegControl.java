package user.controller;


import java.io.IOException;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.controller.model.User;
import utils.DaoFactory;
import user.dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/signin")
public class RegControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

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
		          
		String f = req.getParameter("firstname");  
		String l = req.getParameter("lastname");  
		String e = req.getParameter("email");  
		String p = req.getParameter("password");
		

		User u = new User();
		u.setMail(e);
		u.setPrenom(f);
		u.setNom(l);
		u.setMotDePasse(p);
		
		System.out.println("first = " + f);
		System.out.println("last = " + l);
		System.out.println("email = " + e);
		System.out.println("pwd = " + p);
		          
		try {
			//connexion a la base de donnees 
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/you/apache-maven-3.3.9/week202/data.db");  
			
			PreparedStatement st = con.prepareStatement("select * from user where email=?");
		    st.setString(1, e);
			ResultSet rs = st.executeQuery();
			if (rs.next()) { // email present dans la base de donnees
				req.setAttribute("errorMessage", "signin refuses existing user");
                RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
                rd.forward(req, resp);
			}
			
	
			if ( f != null && l != null && e != null && p != null && f != "" && l != "" && e != "" && p != "")  {
				this.userDao.create(u);
				System.out.println("You are successfully registered...");
				resp.sendRedirect("http://www.google.com");
			}
			else {
				
				req.setAttribute("errorMessage", "fields are missing");
                RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
                rd.forward(req, resp);
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		}  
		          

	}

}

