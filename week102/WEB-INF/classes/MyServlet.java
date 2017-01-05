import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
@WebServlet("/bonjour")
public class MyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("prenom");
		String lastname  = req.getParameter("nom");

		Writer out = resp.getWriter();

		out.write("<p>Bonjour <b>" + firstname + " " + lastname + "</b> !</p>");
	}



	/* public  void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException  {
	
		//response.setContentType("text/html") ;
		
		//PrintWriter out = response.getWriter() ;
		//out.println("<html>") ;
		//out.println("<head>") ;
		//out.println("<title>Bonjour le monde !</title>") ;
		//out.println("</head>") ;
		//out.println("<body>") ;
		//out.println("<h1>Bonjour le monde !</h1>") ;
		//out.println("</body>") ;
		//out.println("</html>") ;



		String firstname = request.getParameter("prenom");
		String lastname  = request.getParameter("nom");

		Writer out = response.getWriter();

		out.write("<p>Bonjour <b>" + firstname + " " + lastname + "</b> !</p>");   
		//out.write(""+request.getParameter("prenom")+request.getParameter("name"));
		//out.write(""+request.getQueryString());
	}

	 public  void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException  {
	
		doGet(request, response) ;
	}
*/
}