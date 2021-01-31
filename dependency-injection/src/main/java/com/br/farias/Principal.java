package com.br.farias;

import java.math.BigDecimal;
import java.util.Date;

import com.br.farias.bean.PedidoVendaService;
import com.br.farias.bean.impl.PedidoVendaServiceImpl;
import com.br.farias.model.PedidoVenda;
import com.br.farias.util.weld.WeldContext;

public class Principal {

	public static void main(String[] args) {
		PedidoVendaService pedidoVendaService = WeldContext.INSTANCE.getBean(PedidoVendaServiceImpl.class);
		PedidoVenda pedido = new PedidoVenda("sabonete", new BigDecimal("3.0"), new BigDecimal("0.05"), new Date());
		pedidoVendaService.salvar(pedido);

	}
}
