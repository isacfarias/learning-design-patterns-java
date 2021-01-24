package operadora;

import java.math.BigDecimal;

import exceptions.CapturaNaoAutorizadaException;

public class Cielo {
	
	private Long codigoConfirmacao = -1L;
	
	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
		if (cartao.startsWith("5555"))
			throw new CapturaNaoAutorizadaException("Numero de cartão não autorizado");
		this.codigoConfirmacao = (long) Math.random() * 1000;
	}
	
	public Long confirmar() {
		System.out.println("Fazendo debito na conta do cliente via Cielo");
		return this.codigoConfirmacao;
	}

}
