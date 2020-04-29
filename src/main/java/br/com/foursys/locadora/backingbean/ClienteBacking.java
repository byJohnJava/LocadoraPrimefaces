package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.controller.CidadeController;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
import br.com.foursys.locadora.controller.EstadoController;
import br.com.foursys.locadora.util.Data;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "clienteBacking")
@SessionScoped
public class ClienteBacking implements Serializable {
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
	

	private Cliente clienteUpdate;

	private boolean alterar = false;

	private boolean skip;

	private String pesquisaNome = "";

	private ArrayList<Cliente> listaClientes;
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

	public Cliente getClienteUpdate() {
		return clienteUpdate;
	}

	public void setClienteUpdate(Cliente clienteUpdate) {
		this.clienteUpdate = clienteUpdate;
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

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
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

	public ArrayList<Cliente> preencherTabela() {
		return new ClienteController().buscarTodos();
	}

	public String salvar() {
		if (alterar) {
			if (validarAlterar()) {
				alterar = false;
				new EnderecoController().salvar(clienteUpdate.getEnderecoCodigo());
				new ContatoController().salvar(clienteUpdate.getContatoCodigo());
				new ClienteController().salvar(clienteUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.clienteAlteradoComSucesso);
				clienteUpdate = null;
				return "consultarCliente";
			}
		} else {
			if (validarIncluir()) {

				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Contato contato = new Contato();

				cliente.setCpf(cpf);
				cliente.setRg(rg);
				cliente.setNome(nome);
				cliente.setDataNascimento(Data.formataData(dataNascimento));
				cliente.setIdade(Integer.parseInt(idade));
				cliente.setSexo(sexo);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				contato.setTelefone(telefone);
				contato.setCelular(celular);
				contato.setEmail(email);
				cliente.setContatoCodigo(contato);
				cliente.setEnderecoCodigo(endereco);

				try {
					new EnderecoController().salvar(endereco);
					new ContatoController().salvar(contato);
					new ClienteController().salvar(cliente);
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
							Mensagem.clienteSalvoComSucesso);
					limparDados();
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroSalvarCliente);
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

		return true;
	}


	public boolean validarAlterar() {
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getLogradouro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEndereco);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getNumero() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getBairro())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getCep())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getCidadeCodigo() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getContatoCodigo().getTelefone())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeTelefone);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getContatoCodigo().getCelular())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCelular);
			return false;
		}
		if (Valida.verificaVazio(clienteUpdate.getContatoCodigo().getEmail())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEmail);
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
	}

	public void pesquisar() {
		listaClientes = pesquisarCliente();
	}

	public ArrayList<Cliente> pesquisarCliente() {
		return new ClienteController().buscarNome(pesquisaNome);
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
		return "alterarCliente";
	}

	public String excluir() {
		new ClienteController().excluir(clienteUpdate);
		new EnderecoController().excluir(clienteUpdate.getEnderecoCodigo());
		new ContatoController().excluir(clienteUpdate.getContatoCodigo());
		
		listaClientes = new ClienteController().buscarTodos();
		for (Cliente clientes : listaClientes) {
			if (clientes.getCodigo().equals(clienteUpdate.getCodigo())) {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroExcluirCliente);
				return "";
			} 
		}
		
		JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.clienteExcluidoComSucesso);
		return "";
	}

}
