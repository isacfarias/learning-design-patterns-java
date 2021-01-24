package com.br.farias.impl.factory;

import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.ModuloPagamentoFactory;
import com.br.farias.core.interfaces.Operadora;
import com.br.farias.impl.gestorderisco.FControl;
import com.br.farias.impl.operadora.Cielo;

public class PagSeguroPagmentoModuloFactory implements ModuloPagamentoFactory {

	public Operadora createOperadora() {
		return new Cielo() ;
	}

	public GestorDeRisco createGestorRisco() {
		return new FControl();
	}
}
