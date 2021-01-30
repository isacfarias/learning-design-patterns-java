package notifier.impls;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import listener.Listener;
import model.Lancamento;
import notifier.Notifier;

public class NotificadorLancamentosVencidos implements Notifier {

	private Set<Listener> listeners;
	private List<Lancamento> lancamentos;
	
	public NotificadorLancamentosVencidos() {
		this.listeners = new HashSet<>();
	}
	
	@Override
	public void registrarListener(Listener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removerListener(Listener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void notificarListeners() {
		for (Listener listener : listeners) {
			listener.atualizar();
		}
	}

	@Override
	public void novosLancamentosVencidos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
		this.notificarListeners();
	}

	@Override
	public List<Lancamento> getLancamentosVencidos() {
		return this.lancamentos;
	}

}
