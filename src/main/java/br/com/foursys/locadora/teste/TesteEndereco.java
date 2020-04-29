package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.controller.EnderecoController;

public class TesteEndereco {
	
	public void salvar() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Avenida Esmeralda");
		endereco.setNumero(123);
		endereco.setComplemento(null);
		endereco.setBairro("Mutinga");
		endereco.setCep("06286-000");
		endereco.setCidadeCodigo(new Cidade(1));
		
		new EnderecoController().salvar(endereco);
		
		System.out.println("Endereco salvo com sucesso!");
		
		System.exit(0);
	}
	
	public void buscarTodos() {
		for(Endereco endereco : new EnderecoController().buscarTodos()) {
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Número: " + endereco.getNumero());
			System.out.println("Complemento: " + endereco.getComplemento());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Cidade: " + endereco.getCidadeCodigo().getNome());
			System.out.println("Estado: " + endereco.getCidadeCodigo().getEstadoCodigo().getUf());
		}
	}
	
	public static void main(String[] args) {
		new TesteEndereco().buscarTodos();
	}

}
