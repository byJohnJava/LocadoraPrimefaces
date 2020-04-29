package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.LocacaoController;

public class TesteLocacao {
	
	public void salvar() {
		Locacao locacao = new Locacao();
		
		locacao.setDataLocacao("16/04/2020");
		locacao.setDataDevolucao("20/04/2020");
		locacao.setValor(20.00);
		locacao.setDevolvido("NAO");
		locacao.setFormaPagamentoCodigo(new FormaPagamento(1));
		locacao.setClienteCodigo(new Cliente(1));
		locacao.setFuncionarioCodigo(new Funcionario(1));
		
		new LocacaoController().salvar(locacao);
		
		System.out.println("Locação salva com sucesso!");
		
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		new TesteLocacao().salvar();
	}

}
