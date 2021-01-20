package com.br.maladireta;

import javax.swing.JOptionPane;

import com.br.maladireta.contatos.MalaDireta;

public class MalaDiretaMain {

	public static void main(String[] args) {

		MalaDireta malaDireta = new MalaDireta();
		String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para o e-mail");

		boolean status = malaDireta.enviarEmail("contatos.xml", mensagem);
		System.out.println(status);

	}

}