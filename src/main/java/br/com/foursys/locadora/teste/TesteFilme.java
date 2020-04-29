package br.com.foursys.locadora.teste;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.dao.FilmeDAO;

public class TesteFilme {

	public void salvar() {

		Genero genero = new Genero(1);
		
		Filme filme = new Filme();

		filme.setNome("Madagascar");
		filme.setGeneroCodigo(genero);
		filme.setValor(10.5);
		filme.setDisponivel("NÃO");
		filme.setPromocao("NÃO");
		filme.setValorPromocao(8.25);

		FilmeDAO dao = new FilmeDAO();
		dao.salvar(filme);
		
		System.out.println("Filme inserido com sucesso!");
		System.exit(0);
	}
	
	public void buscarTodos() throws Exception {
		ArrayList<Filme> filmes = new FilmeDAO().buscarTodos();
		for (Filme filme : filmes) {
			System.out.println(filme.getNome());
		}
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		new TesteFilme().salvar();
	}

}
