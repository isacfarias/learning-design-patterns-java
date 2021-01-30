package listener.impls;

import java.util.List;

import listener.Listener;
import model.Pedido;
import notifiers.Notifier;

public class DepositoListener implements Listener {
	
	private Notifier notifier;

	public DepositoListener(Notifier notifier) {
		this.notifier = notifier;
		this.notifier.addListner(this);
	}

	@Override
	public void atualizar() {
		List<Pedido> pedidos = this.notifier.getPedidos();
		System.out.println("/********************** -> Imprimindo romaneio <- ********************/");
		for (Pedido pedido : pedidos) {
			System.out.print("Item: "+pedido.getDescricao());
			System.out.println(" - Quantidade: "+pedido.getQuantidade());
		}
		System.out.println("/*************************************************------------------**/");
	}

}
