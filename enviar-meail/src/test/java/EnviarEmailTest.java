import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import impls.EnviadorEmailMandrill;
import model.Contato;

public class EnviarEmailTest {

	@Test
	public void test() {
		
		Map<String, Contato> map = new HashMap<>(); 
		
		map.put("andre@mail.com", new  Contato("André", "andre@mail.com"));
		map.put("josé@mail.com", new Contato("José", "josé@mail.com"));
		
		EnviadorEmailMandrill mail = new EnviadorEmailMandrill(map);
		mail.enviar("Estamos testando");
		
	}

}
