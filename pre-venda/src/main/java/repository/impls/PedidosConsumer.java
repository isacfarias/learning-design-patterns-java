package repository.impls;

import java.util.List;

import model.Pedido;
import repository.PedidoFonte;

public class PedidosConsumer implements PedidoFonte {

	private List<Pedido> pedidos;
	
	public PedidosConsumer() {
	}
	
	@Override
	public List<Pedido> pedidos() {
		return this.pedidos;
	}

}
