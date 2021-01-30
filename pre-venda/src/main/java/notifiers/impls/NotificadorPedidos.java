package notifiers.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import listener.Listener;
import model.Pedido;
import notifiers.Notifier;

public class NotificadorPedidos implements Notifier {
	
	private Set<Listener> listeners;
	private List<Pedido> pedidos;
	
	public NotificadorPedidos() {
		this.listeners = new HashSet<>();
		this.pedidos = new ArrayList<Pedido>();
	}

	@Override
	public void addListner(Listener listeres) {
		this.listeners.add(listeres);
	}

	@Override
	public void removeListner(Listener listeres) {
		this.listeners.remove(listeres);
	}

	@Override
	public void notifyListeners() {
		for (Listener listener : listeners) {
			listener.atualizar();
		}
	}

	@Override
	public void addPedidos(List<Pedido> pedidos) {
		this.pedidos.addAll(pedidos);
		notifyListeners();
	}

	@Override
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

}
