package br.com.farias.model;

import br.com.farias.core.enums.PessoaTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	private String nome;
	private PessoaTipo tipo;
}
