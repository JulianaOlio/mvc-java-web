package cadastroLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest requisacao, HttpServletResponse resposta) throws ServletException, IOException {
		
		PrintWriter writer = resposta.getWriter(); 
		writer.print("Cadastro Usuário"); 
		
	}

}

