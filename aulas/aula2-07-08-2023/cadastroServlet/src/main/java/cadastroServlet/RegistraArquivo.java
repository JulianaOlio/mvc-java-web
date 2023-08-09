package cadastroServlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistraArquivo {
	
	public String escreverNoArquivo(String nome, String cpf, String idade, String email) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		String enderecoArquivo = "C:\\Users\\jully\\Repositorio\\mvc-java-web\\aulas\\aula2-07-08-2023\\cadastroServlet\\src\\main\\webapp\\META-INF\\cadastroServlet";
		String escrita = dataHoraAtual + " NOME:" +nome+ " CPF:" +cpf+ "IDADE:" +idade+ "EMAIL: " +email;
		
		try {
			BufferedWriter buWriter = new BufferedWriter (new FileWriter(enderecoArquivo, true));
				buWriter.append(escrita + "\n");
				buWriter.close();
			
			System.out.println("Deu bom");
			return "Deu bom no cadastro"; 
			
		}catch (Exception e) {
			System.out.println("Deu ruim no cadastro");
			return "Deu ruim no cadastro";
		}
	
		
	}

}
