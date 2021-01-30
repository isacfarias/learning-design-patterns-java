package listener.impls;

import java.util.List;

import listener.Listener;
import model.Lancamento;
import notifier.Notifier;

public class SMSListener implements Listener {

	private Notifier notificador;
	
	public SMSListener(Notifier notificador) {
		this.notificador = notificador;
		this.notificador.registrarListener(this);
	}

	@Override
	public void atualizar() {
		
		List<Lancamento> lancamentosVencidos = this.notificador.getLancamentosVencidos();
		
		for (Lancamento lancamento : lancamentosVencidos) {
			System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
		}
	}

}