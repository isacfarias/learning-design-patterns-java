package com.br.farias.impl.nfe;

import java.math.BigDecimal;

import com.br.farias.interfaces.NotaFiscalEletronica;
import com.br.farias.model.NotaFiscal;

public class RioDeJaneiroNfe implements NotaFiscalEletronica {

	private String BREAK_LINE = "\n";
	private BigDecimal ALI_ICMS_INT = new BigDecimal("0.18");//18%
	
	public void gerarNfe(NotaFiscal notaFiscal) {
		notaFiscal.setNumero((Math.round(Math.random() * 1000))+"");
		calculaICMS(notaFiscal);
		
		StringBuilder nfe = new StringBuilder()
		.append("=============================================================================").append(BREAK_LINE)
		.append("====================== Nota Fiscal Eletronica - RJ ==========================").append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)		
		.append("Numero: ").append(notaFiscal.getNumero()).append(BREAK_LINE)
		.append("Razão: ").append(notaFiscal.getCleinte().getNome()).append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		.append("Itens:").append(BREAK_LINE)
		.append("Descrição").append(" | ").append(" Quant.").append(" | ").append(" Vlr Unit. ").append(" | ").append(" Vlr total ") .append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		;
		notaFiscal.getProdutos().forEach(produto -> {
			nfe.append(produto.getDescricao()).append("           | ")
			.append(produto.getQuantidade()).append("            | ")
			.append(produto.getValorUnitario() ).append("          | ")
			.append(produto.getValorUnitario().multiply(new BigDecimal(produto.getQuantidade())))
			.append(BREAK_LINE);
		});
		nfe
		.append("=============================================================================").append(BREAK_LINE)
		.append("ICMS.:").append(notaFiscal.getValorICMS()).append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		.append("Valor total.:").append(notaFiscal.getValorTotal()).append(BREAK_LINE)
		.append("=============================================================================").append(BREAK_LINE)
		;
		System.out.println(nfe.toString());
	}

	private void calculaICMS(NotaFiscal notaFiscal) {
		notaFiscal.setValorICMS(notaFiscal.getValorTotal().multiply(ALI_ICMS_INT));
	}

}
