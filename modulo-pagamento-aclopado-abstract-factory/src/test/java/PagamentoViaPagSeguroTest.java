import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;
import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.Operadora;
import com.br.farias.gestorderisco.FControl;
import com.br.farias.operadora.Cielo;
import com.br.farias.pagamento.Pagamento;

public class PagamentoViaPagSeguroTest {
	
	private Pagamento pagamento;
	
	@Before
	public void setUp() throws Exception {
		Operadora    operadora     = new Cielo();
		GestorDeRisco gestorDeRisco = new FControl();
		pagamento = new Pagamento(operadora, gestorDeRisco);
	}

	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test(expected=CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_cartaoInvalido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("5555.2222", new BigDecimal("2000"));
	}
	
	@Test(expected=AlertaDeRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("7777.2222", new BigDecimal("5500"));
	}
}
