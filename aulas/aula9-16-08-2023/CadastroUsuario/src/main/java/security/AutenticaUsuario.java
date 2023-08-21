package security;

import java.util.List;

import model.Usuario;
import persistence.DaoUsuario;

public class AutenticaUsuario {
	
	
	
	public Usuario autencticaUsuario(Usuario usuario) {
		DaoUsuario daoUsuario = new DaoUsuario();
		
		List<Usuario> usuariosBanco = daoUsuario.buscarListaUsuario();
			
		
		for (Usuario usuarioBanco : usuariosBanco) {
			if (usuario.getUsuario().equals(usuarioBanco.getUsuario()) 
					&& usuario.getSenha().equals(usuarioBanco.getSenha())) {
				
				return usuarioBanco;
			}
			
		}
		
		return null;
		
	}
	
	
}