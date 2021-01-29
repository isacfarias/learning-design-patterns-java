package impls;

import interfaces.EnviarEmail;
import repository.ContatoXML;

public class EnviarEmailFiltro implements EnviarEmail {

	
	private ContatoXML  filtro;
	private ContatoXML  cache;
	
	
	public EnviarEmailFiltro(String contatofiltro, String... arquivos) {
		this.filtro = new ContatoXML(contatofiltro);
		this.cache = new ContatoXML(arquivos);
	}


	@Override
	public void enviar(String mensagem) {
		for (String key : filtro.getContatos().keySet()) {
			if (cache.isExists(key)) {
				System.out.println("Removendo email:"+key);
				cache.getContatos().remove(key);
			}
		}
		
		EnviadorEmailMandrill mail = new EnviadorEmailMandrill(cache.getContatos());
		mail.enviar(mensagem);
	}
	
}
