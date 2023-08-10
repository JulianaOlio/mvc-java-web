import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 response.getWriter().println("<!DOCTYPE html>\r\n"
			 		+ "<html>\r\n"
			 		+ "	<meta charset=\"UTF-8\">\r\n"
			 		+ "	<title> Tela de Login</title>\r\n"
			 		+ "	<style>\r\n"
			 		+ "		body{\r\n"
			 		+ "			font-family: Arial, sans-serif;\r\n"
			 		+ "            		background-color: #f4f4f4;\r\n"
			 		+ "            		margin: 0;\r\n"
			 		+ "            		padding: 0;\r\n"
			 		+ "            		display: flex;\r\n"
			 		+ "            		justify-content: center;\r\n"
			 		+ "            		align-items: center;\r\n"
			 		+ "            		min-height: 100vh;\r\n"
			 		+ "        	}\r\n"
			 		+ "		\r\n"
			 		+ "		 .login-container {\r\n"
			 		+ "            		background-color: #fff;\r\n"
			 		+ "            		padding: 20px;\r\n"
			 		+ "            		border-radius: 5px;\r\n"
			 		+ "            		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n"
			 		+ "            		wi\r\n"
			 		+ "		}\r\n"
			 		+ "	\r\n"
			 		+ "	<\\style>\r\n"
			 		+ "<body>\r\n"
			 		+ "\r\n"
			 		+ "	<div class=\"login-container\">\r\n"
			 		+ "	<h2>Tela de Login </h2>\r\n"
			 		+ "	<form>\r\n"
			 		+ "		<div class=\"form-group\">\r\n"
			 		+ "			<label form=\"username\">	Usuario:</label>\r\n"
			 		+ "			<input type=\"text\" id=\"username\" name=\"username\" requerid\">\r\n"
			 		+ "		</div>\r\n"
			 		+ "\r\n"
			 		+ "		<div class=\"lform-group\">\r\n"
			 		+ "			<label form=\"password\">	Senha:</label>\r\n"
			 		+ "			<input type=\"password\" id=\"password\" name=\"password\" requerid\">\r\n"
			 		+ "		</div>\r\n"
			 		+ "		\r\n"
			 		+ "		<button type=\"submit\"> Entrar </button\r\n"
			 		+ "	</form>\r\n"
			 		+ "</body>\r\n"
			 		+ "\r\n"
			 		+ "</html>"); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Autenticar autenticar = new Autenticar();
		Usuario usuario = new Usuario(); // inicializo usuario 
		Usuario usuarioAutenticado = new Usuario();//inicializo usuario autenticado 
				
			usuario.setUsuario(request.getParameter("username"));
			usuario.setUsuario(request.getParameter("password"));
		    
		   
			if (autenticar.autenticarUsuario(usuario) != null) {
				usuarioAutenticado = autenticar.autenticarUsuario(usuario);
				
				if(usuarioAutenticado.getPerfil().equals("COMUM")) {
					response.sendRedirect(request.getContextPath() + "/menuCadastro");
				}
				
				if(usuarioAutenticado.getPerfil().equals("ADM")) {
					response.sendRedirect(request.getContextPath() + "/menuAdm");
				}
	
			}else {
				response.sendRedirect(request.getContextPath() + "/erroLogin");
			}

	}
}
	
