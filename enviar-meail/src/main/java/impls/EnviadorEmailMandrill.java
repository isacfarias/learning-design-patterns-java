package impls;

import java.util.Map;

import interfaces.EnviarEmail;
import model.Contato;

public class EnviadorEmailMandrill implements EnviarEmail {
	

	private Map<String, Contato> emails;
	
	public EnviadorEmailMandrill(Map<String, Contato> emails) {
		this.emails = emails;
	}
	
	public void enviar(String mensagem) {
		
		System.out.println("Iniciando o envio de email");
		
		for (String key : emails.keySet()) {
			 Contato contato = emails.get(key);
			 
			String send = new StringBuffer()
					.append("====================================================").append("\n").append("\n")
					.append("Olá ").append(contato.getNome()).append("\n").append("\n")
					.append(mensagem).append("\n").append("\n")
					.append("Na duvida, entre em contato").append("\n")
					.toString();
			
			System.out.println(send);
		}
	}

}
