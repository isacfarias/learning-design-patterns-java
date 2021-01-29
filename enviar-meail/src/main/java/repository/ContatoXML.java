package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import interfaces.ContatoFiltro;
import model.Contato;


public class ContatoXML implements ContatoFiltro {


	private Map<String, Contato> contatos  = new HashMap<>();

	public ContatoXML(String... arquivos) {
		XStream xstream = new XStream();
		xstream.alias("contatos", List.class);
		xstream.alias("contato", Contato.class);

		for (String nomeArquivo : arquivos) {
			System.out.println("Carregando arquivo: " + nomeArquivo);
			List<Contato> contatosCarregados = (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + nomeArquivo));
			for (Contato contato : contatosCarregados) {
				contatos.put(contato.getEmail(), contato);
			}
		}
	}
	

	public Map<String, Contato> getContatos() {
		return contatos;
	}


	@Override
	public boolean isExists(String mail) {
		 return this.contatos.containsKey(mail);
	}

}
