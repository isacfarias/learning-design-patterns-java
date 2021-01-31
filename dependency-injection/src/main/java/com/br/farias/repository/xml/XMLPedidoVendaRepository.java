package com.br.farias.repository.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.br.farias.model.PedidoVenda;
import com.br.farias.repository.PedidosVendas;
import com.thoughtworks.xstream.XStream;

public class XMLPedidoVendaRepository implements PedidosVendas {

	@Override
	public void salvar(PedidoVenda pedido) {
		XStream xStream = new XStream();
		xStream.alias("pedido-venda", PedidoVenda.class);
		OutputStream out = null;
		try {
			out = new FileOutputStream(pedido.getDescricao()+".xml");
			xStream.toXML(pedido, out);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Erro ao salvar arquivo:"+e);
		}
	}

}
