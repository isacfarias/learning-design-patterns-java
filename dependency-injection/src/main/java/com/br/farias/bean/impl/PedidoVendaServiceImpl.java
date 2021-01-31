package com.br.farias.bean.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import com.br.farias.bean.CalculaImpostoService;
import com.br.farias.bean.PedidoVendaService;
import com.br.farias.model.PedidoVenda;
import com.br.farias.repository.PedidosVendas;

public class PedidoVendaServiceImpl implements PedidoVendaService {
	
	@Inject
	private PedidosVendas pedidosVendas;

	@Inject
	private CalculaImpostoService calculaImposto;

	@Override
	public void salvar(PedidoVenda pedidoVenda) {
		pedidoVenda.setData(new Date());
		
		BigDecimal impostos = calculaImposto.calcular(pedidoVenda.getValor());
		pedidoVenda.setImposto(impostos);
		
		pedidosVendas.salvar(pedidoVenda);
	}

}
