package com.br.farias.service;

import com.br.farias.service.impl.Normal;
import com.br.farias.service.impl.Sedex;

public enum TipoFrete {
	NORMAL {
		@Override
		public Frete obterFrete() {
			return new Normal();
		}
	},
	SEDEX {
		@Override
		public Frete obterFrete() {
			return new Sedex();
		}
	};	
	
	public abstract Frete obterFrete();
}