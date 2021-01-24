package com.br.farias.impl.bb;

import java.util.UUID;

import com.br.farias.interfaces.Boleto;
import com.br.farias.model.NotaFiscal;

public class BBBoleto implements Boleto {
	private String BREAK_LINE = "\n";

	public void emitir(NotaFiscal notaFiscal) {
		StringBuilder nfe = new StringBuilder()
				.append(BREAK_LINE).append(BREAK_LINE)
				.append("=============================================================================").append(BREAK_LINE)
				.append("======================== Boleto Banco do Brasil =============================").append(BREAK_LINE)
				.append("=============================================================================").append(BREAK_LINE)
				.append("- Codigo barra: ").append(UUID.randomUUID()).append(BREAK_LINE)
				.append("- Razão: ").append(notaFiscal.getCleinte().getNome()).append(BREAK_LINE)
				.append("=============================================================================").append(BREAK_LINE)
				.append("- Itens:").append(BREAK_LINE);
		notaFiscal.getProdutos().forEach(produto -> {
			nfe.append(" - ").append(produto.getDescricao()).append(BREAK_LINE);
		});
		nfe
		.append("=============================================================================").append(BREAK_LINE)
		.append("- Valor ICMS.:").append(notaFiscal.getValorICMS()).append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		.append("- Valor a Pagar:").append(notaFiscal.getValorTotal()).append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		;

		System.out.println(nfe.toString());
	}

}
