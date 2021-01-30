package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoLancamento {

	DESPESA("Despesa"),
	RECEITA("Receita");
	
	private String descricao;
}