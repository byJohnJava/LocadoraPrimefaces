package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.controller.GeneroController;

public class TesteGenero {
	
	public void buscarTodos() {
		for (Genero genero : new GeneroController().buscarTodos()) {
			System.out.println("Código: " + genero.getCodigo());
			System.out.println("Descrição: " + genero.getDescricao());
		}
		
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteGenero().buscarTodos();
	}

}
