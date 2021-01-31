package com.br.farias.bean.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.br.farias.bean.CalculaImpostoService;
import com.br.farias.bean.PedidoVendaService;
import com.br.farias.model.PedidoVenda;
import com.br.farias.repository.PedidosVendas;
import com.br.farias.repository.xml.XMLPedidoVendaRepository;

public class PedidoVendaServiceImpl implements PedidoVendaService {
	
	private PedidosVendas pedidosVendas;

	private CalculaImpostoService calculaImposto;
	
	public PedidoVendaServiceImpl() {
		this.pedidosVendas = new XMLPedidoVendaRepository();
		this.calculaImposto = new CalculaImpostoImpl();
	}
	
	@Override
	public void salvar(PedidoVenda pedidoVenda) {
		pedidoVenda.setData(new Date());
		
		BigDecimal impostos = calculaImposto.calcular(pedidoVenda.getValor());
		pedidoVenda.setImposto(impostos);
		
		pedidosVendas.salvar(pedidoVenda);
	}

}
