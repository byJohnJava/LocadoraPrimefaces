package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.controller.CidadeController;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
import br.com.foursys.locadora.controller.EstadoController;
import br.com.foursys.locadora.controller.FuncionarioController;
import br.com.foursys.locadora.util.Data;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "funcionarioBacking")
@SessionScoped
public class FuncionarioBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private String idade;
	private String sexo;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String celular;
	private String telefone;
	private String email;
	private String login;
	private String senha;

	private Funcionario funcionarioUpdate;

	private boolean alterar = false;

	private boolean skip;

	private String pesquisaNome = "";

	private ArrayList<Funcionario> listaFuncionarios;
	private ArrayList<Estado> listaEstados;
	private ArrayList<Cidade> listaCidades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionarioUpdate() {
		return funcionarioUpdate;
	}

	public void setFuncionarioUpdate(Funcionario funcionarioUpdate) {
		this.funcionarioUpdate = funcionarioUpdate;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public ArrayList<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(ArrayList<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public ArrayList<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(ArrayList<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	@PostConstruct
	public void init() {
		listaCidades = new CidadeController().buscarTodos();
		listaEstados = new EstadoController().buscarTodos();
	}

	public ArrayList<Funcionario> preencherTabela() {
		return new FuncionarioController().buscarTodos();
	}

	public String salvar() {
		if (alterar) {
			if (validarAlterar()) {
				alterar = false;
				new EnderecoController().salvar(funcionarioUpdate.getEnderecoCodigo());
				new ContatoController().salvar(funcionarioUpdate.getContatoCodigo());
				new FuncionarioController().salvar(funcionarioUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.funcionarioAlteradoComSucesso);
				funcionarioUpdate = null;
				return "consultarFuncionario";
			}
		} else {
			if (validarIncluir()) {

				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				Contato contato = new Contato();

				funcionario.setCpf(cpf);
				funcionario.setRg(rg);
				funcionario.setNome(nome);
				funcionario.setDataNascimento(Data.formataData(dataNascimento));
				funcionario.setIdade(Integer.parseInt(idade));
				funcionario.setSexo(sexo);
				funcionario.setLogin(login);
				funcionario.setSenha(senha);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				contato.setTelefone(telefone);
				contato.setCelular(celular);
				contato.setEmail(email);
				funcionario.setContatoCodigo(contato);
				funcionario.setEnderecoCodigo(endereco);

				try {
					new EnderecoController().salvar(endereco);
					new ContatoController().salvar(contato);
					new FuncionarioController().salvar(funcionario);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
							Mensagem.funcionarioSalvoComSucesso);
					limparDados();
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroSalvarFuncionario);
				}
			}
		}

		return "";
	}

	
	public boolean validarIncluir() {
		if (Valida.verificaVazio(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCpf);
			return false;
		}
		if (!Valida.validaCpf(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.informacaoInvalida, Mensagem.cpfInvalido);
			return false;
		}

		if (Valida.verificaVazio(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRg);
			return false;
		}

		if (!Valida.validaRg(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.informacaoInvalida, Mensagem.rgInvalido);
			return false;
		}

		if (Valida.verificaVazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}

		if (Valida.validaDataVazia(dataNascimento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informedataNascimento);
			return false;
		}
		
		if (!Valida.validaDataMaiorQueHoje(dataNascimento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.informacaoInvalida,
					Mensagem.dataNascimentoInvalida);
			return false;
		}

		if (Valida.verificaVazio(idade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeIdade);
			return false;
		}
		if (Valida.verificaVazio(sexo)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSexo);
			return false;
		}

		if (Valida.verificaVazio(logradouro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEndereco);
			return false;
		}
		if (Valida.verificaVazio(numero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.verificaVazio(bairro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.verificaVazio(cep)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.verificaVazio(cidade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.verificaVazio(estado)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.verificaVazio(telefone)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeTelefone);
			return false;
		}
		if (Valida.verificaVazio(celular)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCelular);
			return false;
		}
		if (Valida.verificaVazio(email)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEmail);
			return false;
		}
		if (Valida.verificaVazio(login)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogin);
			return false;
		}
		if (Valida.verificaVazio(senha)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSenha);
			return false;
		}

		return true;
	}


	public boolean validarAlterar() {
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getLogradouro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEndereco);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getNumero() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getBairro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getCep())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getCidadeCodigo() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getContatoCodigo().getTelefone())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeTelefone);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getContatoCodigo().getCelular())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCelular);
			return false;
		}
		if (Valida.verificaVazio(funcionarioUpdate.getContatoCodigo().getEmail())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEmail);
			return false;
		}
		if (Valida.verificaVazio(senha)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSenha);
			return false;
		}

		return true;
	}

	public void limparDados() {
		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		idade = null;
		sexo = null;
		logradouro = null;
		numero = null;
		cep = null;
		complemento = null;
		bairro = null;
		cidade = null;
		estado = null;
		celular = null;
		telefone = null;
		email = null;
		login = null;
		senha = null;
	}

	public void pesquisar() {
		listaFuncionarios = pesquisarFuncionario();
	}

	public ArrayList<Funcionario> pesquisarFuncionario() {
		return new FuncionarioController().buscarNome(pesquisaNome);
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public String alterar() {
		alterar = true;
		return "alterarFuncionario";
	}

	public String excluir() {
		new FuncionarioController().excluir(funcionarioUpdate);
		new EnderecoController().excluir(funcionarioUpdate.getEnderecoCodigo());
		new ContatoController().excluir(funcionarioUpdate.getContatoCodigo());
		
		listaFuncionarios = new FuncionarioController().buscarTodos();
		for (Funcionario funcionarios : listaFuncionarios) {
			if (funcionarios.getCodigo().equals(funcionarioUpdate.getCodigo())) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroExcluirFuncionario);
				return "";
			} 
		}
		
		JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.funcionarioExcluidoComSucesso);
		return "";
	}

}
