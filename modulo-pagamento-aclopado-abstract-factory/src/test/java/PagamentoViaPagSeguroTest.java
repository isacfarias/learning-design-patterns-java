import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;
import com.br.farias.core.pagamento.Pagamento;
import com.br.farias.impl.factory.PagSeguroPagmentoModuloFactory;

public class PagamentoViaPagSeguroTest {
	
	private Pagamento pagamento;
	
	@Before
	public void setUp() throws Exception {
		pagamento = new Pagamento(new PagSeguroPagmentoModuloFactory());
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
