package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.GeneroController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "filmeBacking")
@SessionScoped
public class FilmeBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String valor;
	private String disponivel;
	private String promocao;
	private String valorPromocao;
	private String genero;

	private Filme filmeUpdate;

	private boolean alterar = false;

	private String pesquisaNome = "";

	private ArrayList<Filme> listaFilmes;
	private ArrayList<Filme> listaFilmesDisponiveis;

	private ArrayList<Genero> listaGenero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Filme getFilmeUpdate() {
		return filmeUpdate;
	}

	public void setFilmeUpdate(Filme filmeUpdate) {
		this.filmeUpdate = filmeUpdate;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public ArrayList<Filme> getListaFilmesDisponiveis() {
		return listaFilmesDisponiveis;
	}

	public void setListaFilmesDisponiveis(ArrayList<Filme> listaFilmesDisponiveis) {
		this.listaFilmesDisponiveis = listaFilmesDisponiveis;
	}

	public ArrayList<Genero> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(ArrayList<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}

	public String salvar() {
		if (alterar) {
			if (validarAlterar()) {
				alterar = false;
				new FilmeController().salvar(filmeUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeAlteradoComSucesso);
				filmeUpdate = null;
				return "consultarFilme";
			}
		} else {

			if (validarIncluir()) {
				Filme filme = new Filme();
				FilmeController controller = new FilmeController();

				filme.setNome(nome);
				filme.setGeneroCodigo(new Genero(Integer.parseInt(genero)));
				filme.setDisponivel(disponivel);
				filme.setValor(Double.parseDouble(valor));
				filme.setPromocao(promocao);
				filme.setValorPromocao(Double.parseDouble(valorPromocao));

				try {
					controller.salvar(filme);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeSalvoComSucesso);
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroSalvarFilme);
				}

				limparCampos();
			}
		}
		return "";
	}

	public void limparCampos() {
		nome = null;
		genero = null;
		disponivel = null;
		valor = null;
		promocao = null;
		valorPromocao = null;
	}

	public boolean validarIncluir() {
		if (Valida.verificaVazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}
		if (Valida.verificaVazio(genero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeGenero);
			return false;
		}
		if (Valida.verificaVazio(disponivel)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.verificaVazio(valor)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeValor);
			return false;
		}
		if (Valida.verificaVazio(promocao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		}
		if (promocao.equals("NAO")) {
			valorPromocao = "0.0";
		} else if (promocao.equals("SIM")) {
			if (Valida.verificaVazio(valorPromocao)) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
						Mensagem.informeValorPromocao);
				return false;
			}
		}

		return true;
	}
	
	public boolean validarAlterar() {
		if (Valida.verificaVazio(filmeUpdate.getDisponivel())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.verificaVazio(filmeUpdate.getValor() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeValor);
			return false;
		}
		if (Valida.verificaVazio(filmeUpdate.getPromocao())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		}
		if (filmeUpdate.getPromocao().equals("NAO")) {
			valorPromocao = "0.0";
		} else if (filmeUpdate.getPromocao().equals("SIM")) {
			if (Valida.verificaVazio(filmeUpdate.getPromocao())) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
						Mensagem.informeValorPromocao);
				return false;
			}
		}

		return true;
	}

	@PostConstruct
	public void init() {
		listaGenero = new GeneroController().buscarTodos();
	}

	public ArrayList<Filme> preencherTabela() {
		return new FilmeController().buscarTodos();
	}

	public void pesquisar() {
		listaFilmes = pesquisarFilme();
	}

	public ArrayList<Filme> pesquisarFilme() {
		return new FilmeController().buscarNome(pesquisaNome);
	}

	public String sair() {
		return "index";
	}

	public String alterar() {
		alterar = true;
		return "alterarFilme";
	}

	public String excluir() {
		new FilmeController().excluir(filmeUpdate);

		listaFilmes = new FilmeController().buscarTodos();
		for (Filme filmes : listaFilmes) {
			if (filmes.getCodigo().equals(filmeUpdate.getCodigo())) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroExcluirFilme);
				return "";
			} 
		}
		JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeExcluidoComSucesso);
		return "";
	}
}
