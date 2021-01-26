import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import contato.ContatosXML;
import contato.ContatosXMLProxy;
import repository.Contatos;

public class ContatoXMLProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void deveRetornarContato() {
		Contatos xml = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
		String nome = xml.buscarPor("jose@email.com");
		assertEquals("José Santos", nome);
	}

}
