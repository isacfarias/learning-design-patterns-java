import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;
import com.br.farias.core.factory.PayPalPagmentoModuloFactory;
import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.Operadora;
import com.br.farias.gestorderisco.ClearSale;
import com.br.farias.operadora.RedeCard;
import com.br.farias.pagamento.Pagamento;

public class PagamentoViaPayPalTest {
	
	private Pagamento pagamento;
	
	@Before
	public void setUp() throws Exception {
		pagamento = new Pagamento(new PayPalPagmentoModuloFactory());
	}

	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test(expected=CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_valorAcimaDoLimiteParaCartao() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("2222.2222", new BigDecimal("2000"));
	}
	
	@Test
	public void deveAutorizarVenda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		Long confirmacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
		assertNotNull(confirmacao);
	}
	
	@Test(expected=AlertaDeRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("1111.2222", new BigDecimal("5500"));
	}
}
