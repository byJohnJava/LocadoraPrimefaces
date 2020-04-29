package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.LocacaoFilmeController;

public class TesteLocacaoFilme {

	public void salvar() {
		LocacaoFilme locacaoFilme1 = new LocacaoFilme();

		locacaoFilme1.setFilmeCodigo(new Filme(1));
		locacaoFilme1.setLocacaoCodigo(new Locacao(1));

		LocacaoFilme locacaoFilme2 = new LocacaoFilme();

		locacaoFilme2.setFilmeCodigo(new Filme(2));
		locacaoFilme2.setLocacaoCodigo(new Locacao(1));

		LocacaoFilme locacaoFilme3 = new LocacaoFilme();

		locacaoFilme3.setFilmeCodigo(new Filme(3));
		locacaoFilme3.setLocacaoCodigo(new Locacao(1));

		new LocacaoFilmeController().salvar(locacaoFilme1);
		new LocacaoFilmeController().salvar(locacaoFilme2);
		new LocacaoFilmeController().salvar(locacaoFilme3);

		System.out.println("Itens de locação salvos com sucesso!");

		System.exit(0);

	}

	public void buscarTodos() {
		for (LocacaoFilme filme : new LocacaoFilmeController().buscarTodos()) {
			System.out.println("Código da locação: " + filme.getLocacaoCodigo().getCodigo());
			System.out.println("Nome do filme: " + filme.getFilmeCodigo().getNome());
			System.out.println("Gênero do filme: " + filme.getFilmeCodigo().getGeneroCodigo().getDescricao());
			System.out.println("Nome do Cliente: " + filme.getLocacaoCodigo().getClienteCodigo().getNome());
			System.out.println("Data de locação: " + filme.getLocacaoCodigo().getDataLocacao());
			System.out.println("Cidade do cliente: "
					+ filme.getLocacaoCodigo().getClienteCodigo().getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Telefone do cliente: "
					+ filme.getLocacaoCodigo().getClienteCodigo().getContatoCodigo().getTelefone());
			System.out.println("Celular do cliente: "
					+ filme.getLocacaoCodigo().getClienteCodigo().getContatoCodigo().getCelular());
			System.out.println("Funcionário: " + filme.getLocacaoCodigo().getFuncionarioCodigo().getNome());
			System.out.println("Forma de pagamento: " + filme.getLocacaoCodigo().getFormaPagamentoCodigo().getDescricao());
			System.out.println("");
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteLocacaoFilme().salvar();
	}

}
