package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.HelloWorld;


public class DaoHelloWorld {

	public boolean salvarUsuarioBancoDados(HelloWorld ola) {

		FabricaConexao fabricaConexao = new FabricaConexao();
			
		boolean salvar = false;
		
		String comandoSqlInset = "Insert into db_frases (frase) values (?)";
		
		
		Connection conexaoRecebida =  null;
		PreparedStatement declaracaoComando = null; 
		
		
		try {
			conexaoRecebida = fabricaConexao.criarConexaoBD();
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInset);
			
			// Passa os parametros Values da query SQL
			declaracaoComando.setString(1, ola.getBuscaFrases());
			
			
			declaracaoComando.execute();
			
			
			System.out.println("A frase é: ");
			salvar = true;
			
		} catch (Exception e) {
			System.out.println("Erro ao mostrar a Frase");
			
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
		
		
		return salvar;
	}

	

	// Metodo para buscar todos os itens da tabela e transformar em List
	
	public List<HelloWorld> buscarListaFrases(){
		String comandoSqlSelect = "SELECT * FROM db_frases";
		FabricaConexao fabricaConexao = new FabricaConexao();
		List<HelloWorld> listaFrases = new ArrayList<>();
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		ResultSet resultSet = null;
		
		try {
			
		
			conexaoRecebida = fabricaConexao.criarConexaoBD();
			
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlSelect);
			resultSet = declaracaoComando.executeQuery();
			
			while (resultSet.next()) {
				HelloWorld frase = new HelloWorld();
				
				frase.setBuscaFrases(resultSet.getString("frase"));
			
			}
			
		
			
		} catch (Exception e) {
			System.out.println("Erro ao mostrar frase");
			
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
		
		
		return listaFrases;
	}
	
	}
	
	/**
	//delete from tb_usuario where nome = 'JULIANA';
	
	public boolean deletarUsuario(String nome) {
		String sql = "delete from tb_usuario where nome = ?";
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		
		
		try {
			
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexaoBD();
			
			//Prepara o comando que sera enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sql);
			
			declaracaoComando.setString(1, nome);
			//Executa a query
			declaracaoComando.execute();
			
			
			System.out.println("Frase deletada");
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar o Usuario");
			
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
		return false;
	}

	

	
	public boolean alterarUsuarioBanco(Usuario usuario) {
		
		//Inicializa a classe que cria a conexão
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		boolean salvar = false;
		
		// Comando SQL que sera usado no banco de dados
		String comandoSql = "UPDATE db_usuarios SET perfil = ?, senha = ? WHERE nome = ?";
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		try {
			
		
			conexaoRecebida = fabricaConexao.criarConexaoUsuario();
			

			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSql);
			
			// Passa os parametros Values da query SQL
			
			declaracaoComando.setString(1, usuario.getPerfil());
			declaracaoComando.setString(2, usuario.getSenha());
			declaracaoComando.setString(3, usuario.getUsuario());
			
			//Executa a query
			declaracaoComando.execute();
			
			
			System.out.println("Salvo com sucesso");
			salvar = true;
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar o Usuario");
			
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
		
		
		return salvar;
	}
	
	
	public boolean verificarUsuario(Usuario usuario) {
		
		
		
		List<Usuario> usuariosBanco = buscarListaUsuario();
		
		for (Usuario usuarioBanco : usuariosBanco) {
			if (usuario.getUsuario().equals(usuarioBanco.getUsuario())){
					 
				
				return true;
			}
			
		}
		
		
		
		return false;
	}
	
	
}

	**/