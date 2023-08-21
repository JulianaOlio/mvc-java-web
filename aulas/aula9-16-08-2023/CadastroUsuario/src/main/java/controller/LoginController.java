package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import security.AutenticaUsuario;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/loginController.jsp").forward(request, response);
	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioTentandoAutenticar = new Usuario();
		
		Usuario usuarioAutenticado = new Usuario();
		
		AutenticaUsuario autenticar = new AutenticaUsuario();
		
		// busca o elemento userName na requisição
		usuarioTentandoAutenticar.setUsuario(request.getParameter("username"));
		// busca o elemento  na requisição
		usuarioTentandoAutenticar.setSenha(request.getParameter("password"));
		
		usuarioAutenticado = autenticar.autencticaUsuario(usuarioTentandoAutenticar);
		
		//Separa uma sessao para o sistema no servidor
		HttpSession sessao = request.getSession();
		
		// Verificar se o usuario foi atenticado 
		if( usuarioAutenticado != null) {
			sessao.setAttribute("UsuarioSessao", usuarioAutenticado);
			
			// Direciona para a pagina /menuAdm
			response.sendRedirect(request.getContextPath()+ "/menuAdm");
			
			// Direciona Caso o login esteja errado
		}else {
			response.sendRedirect(request.getContextPath()+ "/erroLogin");
		}

	}
}
