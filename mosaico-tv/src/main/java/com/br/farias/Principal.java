package com.br.farias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.br.farias.bean.FilmeService;
import com.br.farias.bean.impl.FilmeServiceImpl;
import com.br.farias.enums.Tipo;
import com.br.farias.model.Filme;
import com.br.farias.util.weld.WeldContext;

public class Principal {

	public static void main(String[] args) throws ParseException {
		FilmeService filmeService = WeldContext.INSTANCE.getBean(FilmeServiceImpl.class);
		
		String nome = JOptionPane.showInputDialog("Informe o nome do fime");
		String dateStr = JOptionPane.showInputDialog("Informe a data de lançamento do fime");
		
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
		
		Filme filme = new Filme(nome, date, Tipo.ANTIGO);
		 
		filmeService.salvar(filme);

	}
}
