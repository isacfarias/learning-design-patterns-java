package com.br.farias.model;

import com.br.farias.enuns.Sexo;
import com.br.farias.enuns.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	private String nome;
	private int idade;
	private Sexo sexo;
	private Veiculo veiculo;
}
