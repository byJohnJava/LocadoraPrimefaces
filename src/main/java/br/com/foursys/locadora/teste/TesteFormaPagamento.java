package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.controller.FormaPagamentoController;

public class TesteFormaPagamento {
	
	public void buscarTodos() {
		for(FormaPagamento formaPagamento : new FormaPagamentoController().buscarTodos()) {
			System.out.println("Código: " + formaPagamento.getCodigo());
			System.out.println("Descrição: " + formaPagamento.getDescricao());
		}
		
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteFormaPagamento().buscarTodos();
	}

}
