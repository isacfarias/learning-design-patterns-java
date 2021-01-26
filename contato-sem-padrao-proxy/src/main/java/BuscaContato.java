import contato.ContatosXML;
import repository.Contatos;

public class BuscaContato {

	public static void main(String[] args) {
		Contatos contato = new  ContatosXML("contatos1.xml", "contatos2.xml");
		String nome = contato.buscarPor("joao@email.com");
		System.out.println(nome);
	}
	
}
