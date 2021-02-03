package com.br.farias.model;

import java.time.YearMonth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoCredito {

	private String numero;
	private String nome;
	private YearMonth vencimento;
	private int codigoSeguranca;
}