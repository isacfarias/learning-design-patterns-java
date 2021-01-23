package br.com.farias.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal {

	private String        numero;
	private Date          dataEmissao;
	private BigDecimal    imposto;
	private Cliente       cliente;
	private List<Produto> produtos; 

	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Produto produtos : produtos) {
			valorTotal = valorTotal.add(produtos.getValorUnitario().multiply(new BigDecimal(produtos.getQuantidade())));
		}
		return valorTotal;
	}
}
