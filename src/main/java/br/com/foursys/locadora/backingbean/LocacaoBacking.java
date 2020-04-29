package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.FuncionarioController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.controller.LocacaoFilmeController;
import br.com.foursys.locadora.util.Data;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "locacaoBacking")
@SessionScoped
public class LocacaoBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String filme;
	private String cliente;
	private String funcionario;
	private String dataLocacao;
	private Date dataDevolucao;
	private String formaPagamento;
	private Double valor;
	private String codigoLocacao;

	private ArrayList<Cliente> listaClientes;
	private ArrayList<Funcionario> listaFuncionarios;
	private ArrayList<Filme> listaFilmes;
	private ArrayList<String> listaFilmesSelecionados = null;
	private ArrayList<Locacao> listaLocacao;
	private ArrayList<LocacaoFilme> listaLocacaoFilmes;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigoLocacao() {
		return codigoLocacao;
	}

	public void setCodigoLocacao(String codigoLocacao) {
		this.codigoLocacao = codigoLocacao;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public ArrayList<String> getListaFilmesSelecionados() {
		return listaFilmesSelecionados;
	}

	public void setListaFilmesSelecionados(ArrayList<String> listaFilmesSelecionados) {
		this.listaFilmesSelecionados = listaFilmesSelecionados;
	}

	public ArrayList<Locacao> getFilmesAlugados() {
		return listaLocacao;
	}

	public void setFilmesAlugados(ArrayList<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public ArrayList<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public void setListaLocacao(ArrayList<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public ArrayList<LocacaoFilme> getListaLocacaoFilmes() {
		return listaLocacaoFilmes;
	}

	public void setListaLocacaoFilmes(ArrayList<LocacaoFilme> listaLocacaoFilmes) {
		this.listaLocacaoFilmes = listaLocacaoFilmes;
	}

	@PostConstruct
	public void init() {
		listaClientes = new ClienteController().buscarTodos();
		listaFuncionarios = new FuncionarioController().buscarTodos();
		listaFilmes = new FilmeController().buscarDisponivel();
		listaLocacao = new LocacaoController().buscarNaoDevolvido();
	}
	
	public void carregaCombos() {
		listaClientes = new ClienteController().buscarTodos();
		listaFuncionarios = new FuncionarioController().buscarTodos();
		listaFilmes = new FilmeController().buscarDisponivel();
		listaLocacao = new LocacaoController().buscarNaoDevolvido();
	}
	
	public String pegarDataAtual() {
		return Data.dataAtualFormatada;
	}

	public String salvar() {
		if (validarDados()) {
			Locacao locacao = new Locacao();

			locacao.setClienteCodigo(new Cliente(Integer.parseInt(cliente)));
			locacao.setFuncionarioCodigo(new Funcionario(Integer.parseInt(funcionario)));
			locacao.setFormaPagamentoCodigo(new FormaPagamento(Integer.parseInt(formaPagamento)));
			locacao.setDataLocacao(pegarDataAtual());
			locacao.setDataDevolucao(Data.formataData(dataDevolucao));
			locacao.setDevolvido("NAO");
			locacao.setValor(valor);

			try {
				new LocacaoController().salvar(locacao);
				for (String selecionado : listaFilmesSelecionados) {
					for (Filme filme : listaFilmes) {
						if (selecionado.equals(filme.getCodigo() + "")) {
							filme.setDisponivel("NAO");
							new FilmeController().salvar(filme);
							LocacaoFilme locacaoFilme = new LocacaoFilme();
							locacaoFilme.setFilmeCodigo(filme);
							locacaoFilme.setLocacaoCodigo(locacao);
							new LocacaoFilmeController().salvar(locacaoFilme);
						}
					}
				}
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.locacaoFeitaComSucesso);
			} catch (Exception e) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroFazerLocacao);
			}
			limparCamposLocacao();
			carregaCombos();
		}
		return "";
	}

	public void limparCamposLocacao() {
		filme = null;
		listaFilmesSelecionados = null;
		cliente = null;
		funcionario = null;
		dataLocacao = null;
		dataDevolucao = null;
		formaPagamento = null;
		valor = 0.0;
	}

	public void limparCampoDevolucao() {
		codigoLocacao = null;
	}

	public boolean validarDadosDevolucao() {
		if (Valida.verificaVazio(codigoLocacao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.selecioneLocacao);
			return false;
		}
		return true;
	}

	public boolean validarDados() {

		if (Valida.validaListaStringVazia(listaFilmesSelecionados)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.selecioneFilme);
			return false;
		}
		if (Valida.verificaVazio(cliente)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.selecioneCliente);
			return false;
		}
		if (Valida.verificaVazio(funcionario)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.selecioneFuncionario);
			return false;
		}
		if (Valida.verificaVazio(formaPagamento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.selecioneFormaPagamento);
			return false;
		}
		if (Valida.validaDataVazia(dataDevolucao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeDataDevolucao);
			return false;
		}

		return true;
	}

	public void calculaValorTotal() {
		valor = 0.0;
		for (String selecionado : listaFilmesSelecionados) {
			for (Filme filme : listaFilmes) {
				if (selecionado.equals(filme.getCodigo() + "")) {
					if (filme.getPromocao().equals("SIM")) {
						valor += filme.getValorPromocao();
					} else {
						valor += filme.getValor();
					}
				}
			}
		}
	}

	public String devolverLocacao() {
		listaLocacaoFilmes = new LocacaoFilmeController().buscarTodos();
		if (validarDadosDevolucao()) {

			Locacao locacao = new Locacao();
			locacao.setCodigo(Integer.parseInt(codigoLocacao));

			try {
				for (LocacaoFilme locacaoFilme : listaLocacaoFilmes) {
					if (locacaoFilme.getLocacaoCodigo().getCodigo() == locacao.getCodigo()) {
						locacao.setDevolvido("SIM");
						locacao.setDataDevolucao(pegarDataAtual());
						locacao.setClienteCodigo(locacaoFilme.getLocacaoCodigo().getClienteCodigo());
						locacao.setFuncionarioCodigo(locacaoFilme.getLocacaoCodigo().getFuncionarioCodigo());
						locacao.setFormaPagamentoCodigo(locacaoFilme.getLocacaoCodigo().getFormaPagamentoCodigo());
						locacao.setValor(locacaoFilme.getLocacaoCodigo().getValor());
						locacao.setDataLocacao(locacaoFilme.getLocacaoCodigo().getDataLocacao());
						Filme filme = new FilmeController().buscarPorCodigo(locacaoFilme.getFilmeCodigo().getCodigo());
						filme.setDisponivel("SIM");
						new FilmeController().salvar(filme);
						new LocacaoController().salvar(locacao);
						JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
								Mensagem.devolucaoFeitaComSucesso);
					}
				}
			} catch (Exception e) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroFazerLocacao);
			}	
			limparCampoDevolucao();
			carregaCombos();
		}
		return "";
	}

	public String sair() {
		return "index.xhtml";
	}

}
