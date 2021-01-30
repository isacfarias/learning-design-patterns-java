package notifiers;

import java.util.List;

import listener.Listener;
import model.Pedido;

public interface Notifier {
	
	
	public void addListner(Listener listeres);
	
	public void removeListner(Listener listeres);
	
	public void notifyListeners();
	
	public void addPedidos(List<Pedido> pedidos);
	
	public List<Pedido> getPedidos();

}
