package com.br.farias.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private String descricao;
	private Integer quantidade;
	private BigDecimal valorUnitario;

}
