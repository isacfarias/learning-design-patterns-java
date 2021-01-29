import org.junit.Test;

import impls.EnviarEmailFiltro;

public class EmailFiltroTest {

	@Test
	public void test() {

		String filtro = "nao_enviar_email.xml"; 

		EnviarEmailFiltro mail = new EnviarEmailFiltro(filtro, "contatos1.xml", "contatos2.xml");
		mail.enviar("Teste envio de mensagem");
	}

}
