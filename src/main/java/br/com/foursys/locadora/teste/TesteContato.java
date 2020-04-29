package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.controller.ContatoController;

public class TesteContato {

	public void salvar() {
		Contato contato = new Contato();
		contato.setCelular("(11) 94761-4880");
		contato.setTelefone("(11) 3603-7291");
		contato.setEmail("joao@foursys.com.br");

		new ContatoController().salvar(contato);

		System.out.println("Contato inserido com sucesso");

		System.exit(0);
	}

	public void buscarTodos() {
		for (Contato contato : new ContatoController().buscarTodos()) {
			System.out.println("Código: " + contato.getCodigo());
			System.out.println("Celular: " + contato.getCelular());
			System.out.println("Telefone: " + contato.getTelefone());
			System.out.println("E-mail: " + contato.getEmail());
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteContato().buscarTodos();
	}

}
