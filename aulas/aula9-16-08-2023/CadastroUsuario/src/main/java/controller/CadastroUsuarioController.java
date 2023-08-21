package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import persistence.DaoUsuario;



public class CadastroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	DaoUsuario daoUsuario = new DaoUsuario();
					 		 	
			HttpSession sessao = request.getSession();
			
			Usuario usuarioLogado = (Usuario) sessao.getAttribute("UsuarioSessao");
			
			if(usuarioLogado== null) {
				response.sendRedirect(request.getContextPath() + "/login");
			}else {
				
			
				if(usuarioLogado.getPerfil().equals("ADM")) {
		 
					request.getRequestDispatcher("WEB-INF/cadastroUsuarioController.jsp").forward(request,response);
				}
			}
	  }
				
				 /**
				 if(acao != null && acao.equals("delete") ) {
					  nomeUsuario = request.getParameter("usuario");
					 daoUsuario.deletarUsuario(nomeUsuario);
					 response.sendRedirect(request.getContextPath() + "/cadastroUsuario");
					 
				 }
				 
				 if(acao != null && acao.equals("edit") ) {
					  nomeUsuario = request.getParameter("usuario");
					  botaoFormulario = "Alterar";
					 					 
				 }
				 
				**/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		Usuario usuario = new Usuario();
		DaoUsuario daoUsuario = new DaoUsuario();
		
			usuario.setUsuario(request.getParameter("usuario"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setPerfil(request.getParameter("perfil"));
	
			if (daoUsuario.verificarUsuario(usuario)) {
				daoUsuario.alterarUsuarioBanco(usuario);
			}else {
				daoUsuario.salvarUsuarioBancoDados(usuario);
			}
		
		
			request.getRequestDispatcher("WEB-INF/cadastroUsuarioController.jsp").forward(request,response);
	
	
	}
	
}