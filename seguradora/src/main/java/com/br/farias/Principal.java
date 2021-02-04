package com.br.farias;

import java.util.Scanner;

import com.br.farias.enuns.Sexo;
import com.br.farias.enuns.Veiculo;
import com.br.farias.model.Cliente;
import com.br.farias.service.PropostaSeguro;

public class Principal {


	public static void main(String[] args) {

		try (Scanner entrada = new Scanner(System.in)) {
			
			System.out.print("Informe o nome: ");
			String nome = entrada.nextLine();
			
			System.out.print("Informe a idade: ");
			int idade = entrada.nextInt();
			
			System.out.print("Informe o sexo ( 1 ) - Masculino, ( 2 ) - Feminino: ");
			int sexo = entrada.nextInt();
			Sexo sexoEnum = Sexo.values()[sexo - 1];
			
			Cliente cliente = new Cliente(nome, idade, sexoEnum, null);

			int count = 0;
			while (count <= 2 ) {

				System.out.print("Informe o tipo de veiculo  ( 1 ) - moto, ( 2 ) - carro: ");
				int veiculo = entrada.nextInt();
				Veiculo veiculoEnum = Veiculo.values()[veiculo - 1];
				cliente.setVeiculo(veiculoEnum);
				
				System.out.print("Informe o valor do veiculo: ");
				double valor = entrada.nextDouble();
				
				PropostaSeguro proposta = new PropostaSeguro(veiculoEnum.obterVeiculo());
				proposta.calcular(cliente, valor);
				System.out.println(proposta.gerar());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
