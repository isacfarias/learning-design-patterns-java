package gestorderisco;

import java.math.BigDecimal;

import exceptions.AlertaDeRiscoException;

public class FControl {

	
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("7777")) 
			throw new AlertaDeRiscoException("Cartão suspeito.");
	}
}
