package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraServletController extends HttpServlet{

	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			response.setContentType("text/html");
			
			response.getWriter().println("<html><body><h1> Minha 1° servlet</h1></body></html>");
			
			
		}
		
}
