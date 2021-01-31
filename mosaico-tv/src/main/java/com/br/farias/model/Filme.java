package com.br.farias.model;

import java.util.Date;

import com.br.farias.enums.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

	private String descricao;
	private Date data;
	private Tipo tipo;
}
