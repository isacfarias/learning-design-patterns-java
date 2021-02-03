package com.br.farias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

	private Integer codigo;
	private String  nome;
	private String  telefone;
}
