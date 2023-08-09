package seguranca;

import model.Usuario;

public class Autenticar {
	
	public boolean autenticarUsuario (Usuario usuario) {
		
		String senhaBanco = "123";
		
		if (senhaBanco.equals(usuario.getSenha())) {
			return true;
			
		}else {
			return false; 
		}
		
	}

}
