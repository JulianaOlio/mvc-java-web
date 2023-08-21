package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	
		private String usuario = "root";
		private String senha = "ROOT";
		
		
		private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC";
	
		public Connection criarConexaoUsuario() {
			Connection conexao = null; 
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conexao = DriverManager.getConnection(BANCO_URL_USUARIOS, usuario, senha);
				
				System.out.println("Conexão realizada!");
				
				
			}catch (Exception e) {
				System.out.println("Erro de Conexao");
				System.out.println(e.getMessage());
			}
	
		
	return conexao; 
	
	}
	
}
