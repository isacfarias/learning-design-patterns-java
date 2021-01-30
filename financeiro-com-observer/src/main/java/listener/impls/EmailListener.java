package listener.impls;

import java.util.List;

import listener.Listener;
import model.Lancamento;
import notifier.Notifier;

public class EmailListener implements Listener {
	
	private Notifier notificador;
	
	public EmailListener(Notifier notificador) {
		this.notificador = notificador;
		this.notificador.registrarListener(this);
	}

	@Override
	public void atualizar() {
		
		List<Lancamento> lancamentosVencidos = this.notificador.getLancamentosVencidos();
		for (Lancamento lancamento : lancamentosVencidos) {
			System.out.println("Enviando e-mail para " + lancamento.getPessoa().getEmail());
		}
	}
}