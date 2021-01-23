package builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.ItemPedido;
import model.PedidoVenda;

public class PedidoVendaBuilder {

	
	private PedidoVenda pedido;
	
	private List<ItemPedido> itensPedido;
	
	public PedidoVendaBuilder() {
		this.pedido = new PedidoVenda();
		this.itensPedido = new ArrayList<ItemPedido>();
	}
	
	public PedidoVendaBuilder isClienteVip(String nome) {
		this.pedido.setCliente(new Cliente(nome, true));
		return this;
	}
	
	public PedidoVendaBuilder isNotClienteVip(String nome) {
		this.pedido.setCliente(new Cliente(nome, false));
		return this;
	}
	
	public PedidoVendaBuilder addItem(String itemDescricao, Integer quantidade, BigDecimal valorUnitario) {
		this.itensPedido.add(new ItemPedido(itemDescricao, quantidade, valorUnitario));
		return this;
	}
	
	
	public PedidoVenda builder() {
		this.pedido.setItensPedido(itensPedido);
		return pedido;
	}

	
}
