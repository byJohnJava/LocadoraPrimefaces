package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.controller.CidadeController;

public class TesteCidade {
	
	public void buscarTodos() {
		for(Cidade cidade : new CidadeController().buscarTodos()) {
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstadoCodigo().getUf());
			System.out.println("");
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteCidade().buscarTodos();
	}

}
