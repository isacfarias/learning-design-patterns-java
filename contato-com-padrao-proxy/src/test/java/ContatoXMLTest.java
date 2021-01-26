import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import contato.ContatosXML;
import repository.Contatos;

public class ContatoXMLTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void deveRetornarContato() {
		Contatos xml = new ContatosXML("contatos1.xml", "contatos2.xml");
		String nome = xml.buscarPor("jose@email.com");
		assertNotNull(nome);
	}

}
