package br.com.farias.core.abstracts;

import br.com.farias.core.interfaces.NotaFiscalImpl;
import br.com.farias.model.NotaFiscal;

public abstract class NotaFiscalCalcula {
	
	protected abstract NotaFiscalImpl impostoRestido() ;
	
	public void calculaImposto(NotaFiscal notaFiscal) {
		
		notaFiscal.setImposto(impostoRestido()
				               .imposto(notaFiscal.getValorTotal())
				             );
	}

}
