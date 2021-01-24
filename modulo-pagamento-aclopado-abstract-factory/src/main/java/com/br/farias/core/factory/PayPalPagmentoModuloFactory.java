package com.br.farias.core.factory;

import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.ModuloPagamentoFactory;
import com.br.farias.core.interfaces.Operadora;
import com.br.farias.gestorderisco.ClearSale;
import com.br.farias.operadora.RedeCard;

public class PayPalPagmentoModuloFactory implements ModuloPagamentoFactory {

	public Operadora createOperadora() {
		return new RedeCard() ;
	}

	public GestorDeRisco createGestorRisco() {
		return new ClearSale();
	}

}
