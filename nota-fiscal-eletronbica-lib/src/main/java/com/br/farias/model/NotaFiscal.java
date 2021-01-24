package com.br.farias.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal {

	private String numero;
	private Cliente cleinte;
	private List<Produto> produtos;
	private BigDecimal valorICMS;
	
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Produto produtos : produtos) {
			valorTotal = valorTotal.add(produtos.getValorUnitario().multiply(new BigDecimal(produtos.getQuantidade())));
		}
		return valorTotal;
	}
	
}
