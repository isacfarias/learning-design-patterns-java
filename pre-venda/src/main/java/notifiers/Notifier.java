package notifiers;

import listener.Listener;

public interface Notifier {
	
	
	public void addListner(Listener listeres);
	
	public void removeListner(Listener listeres);
	
	public void notifyListeners();
	
	public void addPedidos();
	
	public void getPedidos();

}
