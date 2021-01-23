package br.com.farias.core.abstracts;

import br.com.farias.core.interfaces.NotaFiscalImpl;
import br.com.farias.impl.NotaFiscalPessoaFisica;

public class NotaFiscalPessoaFisicaCreator extends NotaFiscalCalcula {

	@Override
	protected NotaFiscalImpl impostoRestido() {
		return new NotaFiscalPessoaFisica();
	}

}
