package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoHelloMundo {
	
	public String buscarFrase() {
		
		String consultaBD = "SELECT * FROM  db_frases";
		ConnectionFactory fabricaConexao = new ConnectionFactory();
		
		String frase = null; 
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		ResultSet resultSet = null;
		
		try {
	
			conexaoRecebida = fabricaConexao.criarConexaoBD();
			
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(consultaBD);
			resultSet = declaracaoComando.executeQuery();
			
			while (resultSet.next()) {
				
				
				frase = resultSet.getString("frase");
								
			}
		
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar");
			
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e2) {
				System.out.println("Erro ao fechar Conexao!!");
			}
			
			
		}
		
		
		return frase;
	}
	
	
}