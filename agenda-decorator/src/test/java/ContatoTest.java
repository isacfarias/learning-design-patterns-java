import static org.junit.Assert.*;

import org.junit.Test;

import com.br.farias.model.Contato;
import com.br.farias.repository.AgendaDAO;
import com.br.farias.repository.impl.CacheAgendaDAO;
import com.br.farias.repository.impl.XMLAgendaDAO;

public class ContatoTest {

	@Test
	public void test() {
		Contato contato = new Contato(2, "Andre G. Silva", "00990088333");
		AgendaDAO agenda = new CacheAgendaDAO(new XMLAgendaDAO());
		agenda.inserir(contato);
		
		Contato temp = agenda.buscar(2);
		
		assertTrue("Retornou o valor", temp.getCodigo().equals(contato.getCodigo()));
		
	}

}
