import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import exceptions.AlertaDeRiscoException;
import exceptions.CapturaNaoAutorizadaException;
import gestorderisco.FControl;
import operadora.Cielo;
import pagamento.PagamentoPagSeguro;

public class PagamentoViaPagSeguroTest {
	
	private PagamentoPagSeguro pagamento;
	
	@Before
	public void setUp() throws Exception {
		Cielo    operadora     = new Cielo();
		FControl gestorDeRisco = new FControl();
		pagamento = new PagamentoPagSeguro(operadora, gestorDeRisco);
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
