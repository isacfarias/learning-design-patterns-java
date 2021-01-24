package pagamento;

import java.math.BigDecimal;

import exceptions.AlertaDeRiscoException;
import exceptions.CapturaNaoAutorizadaException;
import gestorderisco.FControl;
import operadora.Cielo;

public class PagamentoPagSeguro {
	
	private Cielo operadora;
	private FControl gestorDeRisco;
		
	public PagamentoPagSeguro(Cielo operadora, FControl gestorDeRisco) {
		this.operadora = operadora;
		this.gestorDeRisco = gestorDeRisco;
	}
	
	public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		this.operadora.capturar(cartao, valor);
		this.gestorDeRisco.avaliarRisco(cartao, valor);
		return this.operadora.confirmar();
	}
	
}
