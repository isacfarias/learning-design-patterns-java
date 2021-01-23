package br.com.farias.core.abstracts;

import br.com.farias.core.interfaces.NotaFiscalImpl;
import br.com.farias.impl.NotaFiscalPessoaJuridica;

public class NotaFiscalPessoaJuridicaCreator extends NotaFiscalCalcula {

	@Override
	protected NotaFiscalImpl impostoRestido() {
		return new NotaFiscalPessoaJuridica();
	}

}
