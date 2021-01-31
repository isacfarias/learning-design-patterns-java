package com.br.farias.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoVenda {

	private String descricao;
	private BigDecimal valor;
	private BigDecimal imposto;
	private Date data;
}
