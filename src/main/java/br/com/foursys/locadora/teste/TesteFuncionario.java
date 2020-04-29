package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.controller.FuncionarioController;

public class TesteFuncionario {
	
	public void salvar() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setCpf("123.456.789-00");
		funcionario.setRg("21.456.789-X");
		funcionario.setDataNascimento("14/05/2000");
		funcionario.setIdade(20);
		funcionario.setSexo("M");
		funcionario.setEnderecoCodigo(new Endereco(1));
		funcionario.setContatoCodigo(new Contato(1));
		
		funcionario.setLogin("admin");
		funcionario.setSenha("admin");

		new FuncionarioController().salvar(funcionario);

		System.out.println("Funcionario salvo com sucesso!");

		System.exit(0);
		
	}
	
	public void buscarTodos() {
		for (Funcionario funcionario : new FuncionarioController().buscarTodos()) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("RG: " + funcionario.getRg());
			System.out.println("Data de nascimento: " + funcionario.getDataNascimento());
			System.out.println("Idade: " + funcionario.getIdade());
			System.out.println("Sexo: " + funcionario.getSexo());
			System.out.println("Logradouro: " + funcionario.getEnderecoCodigo().getLogradouro());
			System.out.println("Número: " + funcionario.getEnderecoCodigo().getNumero());
			System.out.println("Complemento: " + funcionario.getEnderecoCodigo().getComplemento());
			System.out.println("Bairro: " + funcionario.getEnderecoCodigo().getBairro());
			System.out.println("Cidade: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Estado: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome()
					+ " - " + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getUf());
			System.out.println("Telefone: " + funcionario.getContatoCodigo().getTelefone());
			System.out.println("Celular: " + funcionario.getContatoCodigo().getCelular());
			System.out.println("E-mail: " + funcionario.getContatoCodigo().getEmail());
			System.out.println("Login: " + funcionario.getLogin());
			System.out.println("Senha: " + funcionario.getSenha());
		}
		
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TesteFuncionario().buscarTodos();
	}

}
