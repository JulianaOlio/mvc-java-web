package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class DaoUsuario {
	
	public boolean salvarUsuarioBanco(Usuario usuario) {
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		boolean salvar = false;
		
		// comando SQL que sera usado no Banco de Dados
		String comandoSqlInsert = "insert int db_usuarios (usuario, perfil, senha) value (?, ?, ?)";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null; 
		
		try {
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexaoBancoUsuario();
			
			//Prepara o comando que será enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);
			
			// Passa os parametros Values da query SQL
			declaracaoComando.setString(1, usuario.getUsuario().toUpperCase());
			declaracaoComando.setString(2, usuario.getPerfil().toUpperCase());
			declaracaoComando.setString(3, usuario.getSenha().toUpperCase());
		
			//Executa a query
			declaracaoComando.execute();
			
			System.out.println("Salvo com sucesso!");
			salvar = true;
			
		}catch(Exception e) {
			System.out.println("Erro ao Salvar Usuario!");
						
		}finally {
			/* 
			 verifica se a conexao e declaração de comando estão vazios
				caso tenham informações, serão fechadas pelos comandos abaixo
			*/
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
			}catch (Exception e2) {
				System.out.println("Erro ao fechar conexao!!");
				
			}
		}
		
		return salvar;
	}
		
		// Metodo para buscar todos os itens da tabela e transformar em List
		public List<Usuario> buscarListaUsuario(){
			String comandoSqlSelect = "Select * FROM db_usuarios";
			FabricaConexao fabricaConexao = new FabricaConexao();
			List<Usuario> usuarios = new ArrayList<>();
			
			Connection conexaoRecebida = null;
			PreparedStatement declaracaoComando = null;
			ResultSet resultSet = null; 
		
			try {
				
				// armazena conexao 
				conexaoRecebida = fabricaConexao.criarConexaoBancoUsuario();
				
				declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlSelect);
				resultSet = declaracaoComando.executeQuery();
				
				while(resultSet.next()){
					Usuario usuario = new Usuario();
					
					usuario.setUsuario(resultSet.getString("usuario"));
					usuario.setPerfil(resultSet.getString("perfil"));
					usuario.setSenha(resultSet.getString("senha"));
					usuarios.add(usuario);
				}
				
			}catch (Exception e) {
				System.out.println("Erro ao Salvar o Usuario");
			
			}finally {
				try {
					if(conexaoRecebida != null) {
						conexaoRecebida.close();
					}
					if (declaracaoComando != null) {
						declaracaoComando.close();
					}
					
				}catch (Exception e2) {
					System.out.println("Erro ao fechar a conexão!");
				}
			}
			
			return usuarios; 
		
	}
	
		//delete from tb_usuario where nome = 'JULIANA';	

		
		public boolean deletarUsuario(String usuario) {
			String sql = "delete from db_usuarios where usuario = ?";
				
				
			FabricaConexao fabricaConexao = new FabricaConexao();
				
			Connection conexaoRecebida = null;
			PreparedStatement declaracaoComando = null; 
				
			try {
					
				//armazena a conexao 
				conexaoRecebida = fabricaConexao.criarConexaoBancoUsuario();
					
				// prepara o comando que sera enviado para o banco
				declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sql);
										
				declaracaoComando.setString(1, usuario);
				
				// executa a query 
				declaracaoComando.execute();
					
				System.out.println("Deletado com sucesso");
				return true;
				
			}catch (Exception e) {
				System.out.println("Erro ao deletar o usuario");
					
			} finally {
					
				try {
					if(conexaoRecebida != null) {
							conexaoRecebida.close();
					}
						if(declaracaoComando != null) {
							declaracaoComando.close();
						
						}
						
					}catch (Exception e2) {
						System.out.println("Erro ao fechar conexao");
					
					}
				}
				return false; 
			}
		
		

			public boolean atualizarUsuario(Usuario usuario) {
				
				boolean salvar = false;
				
				String sql = "UPDATE db_usuarios SET perfil = ? , senha = ? WHERE usuario = ? ";
				
				FabricaConexao fabricaConexao = new FabricaConexao();
				
				Connection conexaoRecebida = null;
				PreparedStatement declaracaoComando = null; 
				
				try {
					
				 //armazena a conexao 
					conexaoRecebida = fabricaConexao.criarConexaoBancoUsuario();
					
				 // prepara o comando que sera enviado para o banco
					declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sql);
										
					declaracaoComando.setString(1, usuario.getUsuario());
					declaracaoComando.setString(1, usuario.getPerfil());
					declaracaoComando.setString(1, usuario.getSenha());
				
				// executa a query 
					declaracaoComando.execute();
					
					System.out.println("Atualizado com sucesso");
					return true;
				
				}catch (Exception e) {
					System.out.println("Erro ao alterar o usuario");
					
				} finally {
					
					try {
						if(conexaoRecebida != null) {
							conexaoRecebida.close();
						}
						if(declaracaoComando != null) {
							declaracaoComando.close();
						
						}
						
					}catch (Exception e2) {
						System.out.println("Erro ao fechar conexao");
					
					}
				}
				return salvar; 
			}
			
			public boolean verificarUsuario (Usuario usuario) {
				
				List <Usuario> usuariosBanco = buscarListaUsuario();
				
				for (Usuario usuarioBanco : usuariosBanco) {
					if (usuario.getUsuario().equals(usuarioBanco.getUsuario())) {
						
						return true; 
					}
					
				
			}
				return false;
				
				
			}
			
			
				
	}
			

