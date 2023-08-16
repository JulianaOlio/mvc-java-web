package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class FabricaConexao {
	
	private String usuario = "root";
	private String senha = "root";
	
	
	// url do banco de dados
	private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC";

	// metodo que cria a conexao com o DB
	public Connection criarConexaoBancoUsuario() {
		Connection conexao = null; 
		
		try {
			// Classe do drive do banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Cria o objeto de conexão
			conexao = DriverManager.getConnection(BANCO_URL_USUARIOS,usuario, senha);
			
			System.out.println("Conexão Realizada");
			
		} catch (Exception e) {
			
			System.out.println("Conexão Não Realizada. Erro na Conexão");
			System.out.println(e.getMessage());
				
		}
		return conexao; 
		
	}
}
