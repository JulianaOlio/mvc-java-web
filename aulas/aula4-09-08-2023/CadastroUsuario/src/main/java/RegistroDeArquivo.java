
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroDeArquivo {
	
	public String escreverArquivo(String nome, String cpf, String email) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		
		String localArquivo = "C:\\Users\\jully\\OneDrive\\Documentos\\Portfolio\\cadastro.txt";
		String escrita = dataHoraAtual + " NOME:" +nome+ " CPF:" +cpf+ "EMAIL: " +email;

		try {
			BufferedWriter buWriter = new BufferedWriter (new FileWriter(localArquivo, true));
				buWriter.append(escrita + "\n");
				buWriter.close();
			
			System.out.println("Funcionou");
			return "Cadastro realizado"; 
			
		}catch (Exception e) {
			System.out.println("Não Funcionou");
			return "Cadastro não realizado";
		}
		
	}

}
