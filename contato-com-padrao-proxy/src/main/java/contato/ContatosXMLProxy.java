package contato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import repository.Contatos;

public class ContatosXMLProxy implements Contatos {

	private ContatosXML contatoXml;
	private List<String> nomeArquivos;
	
	public ContatosXMLProxy(String...nomeArquivos) {
		this.nomeArquivos = new ArrayList<>(Arrays.asList(nomeArquivos));
	}
	
	@Override
	public String buscarPor(String email) {
		String nome = null;
		Random random = new Random();
		
		int quantidadeArquivos = this.nomeArquivos.size(); 
		for (int i = 0; i < quantidadeArquivos; i++) {
			int indiceParaPesquisar = random.nextInt(nomeArquivos.size());
		
			String nomeArquivo = nomeArquivos.remove(indiceParaPesquisar);
			this.contatoXml    = new ContatosXML(nomeArquivo);
			nome = this.contatoXml.buscarPor(email);
			if (nome != null) break;
		}
		
		return nome;
	}
}
