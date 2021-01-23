package br.com.farias.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	private String nome;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	
}
