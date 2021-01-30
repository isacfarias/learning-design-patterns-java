package listener.impls;

import java.math.BigDecimal;
import java.util.List;

import listener.Listener;
import model.Pedido;
import notifiers.Notifier;

public class FaturamentoListener implements Listener {
	
	private Notifier notifier;
	
	public FaturamentoListener(Notifier notifier) {
		this.notifier = notifier;
		this.notifier.addListner(this);
	}
	
	@Override
	public void atualizar() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		List<Pedido> pedidos = this.notifier.getPedidos();
		
		System.out.println(" ");
		System.out.println("/********************** -> Faturando pedido <- ********************/");
		for (Pedido pedido : pedidos) {
			System.out.print("Item: "+pedido.getDescricao());
			System.out.print(" - Quantidade: "+pedido.getQuantidade());
			System.out.println(" - Valor: "+pedido.getValor());
			valorTotal = valorTotal.add(pedido.getValor());
		}
		System.out.println("Valor total: "+valorTotal);
		System.out.println("/*******************************************************************/");
	}

}
