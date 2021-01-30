package notifier;

import java.util.List;

import listener.Listener;
import model.Lancamento;

public interface Notifier {

	public void registrarListener(Listener listener);
	
	public void removerListener(Listener listener);
	
	public void notificarListeners();
	
	public void novosLancamentosVencidos(List<Lancamento> lancamentos);
	
	public List<Lancamento> getLancamentosVencidos();
}
