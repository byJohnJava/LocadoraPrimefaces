package br.com.foursys.locadora.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo")
	private Integer codigo;
	@Column(name = "data_locacao")
	private String dataLocacao;
	@Column(name = "data_devolucao")
	private String dataDevolucao;
	@Column(name = "valor")
	private double valor;
	@Column(name = "devolvido")
	private String devolvido;
	@JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private Cliente clienteCodigo;
	@JoinColumn(name = "forma_pagamento_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private FormaPagamento formaPagamentoCodigo;
	@JoinColumn(name = "funcionario_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private Funcionario funcionarioCodigo;

	public Locacao() {
	}

	public Locacao(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDevolvido() {
		return devolvido;
	}

	public void setDevolvido(String devolvido) {
		this.devolvido = devolvido;
	}

	public Cliente getClienteCodigo() {
		return clienteCodigo;
	}

	public void setClienteCodigo(Cliente clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public FormaPagamento getFormaPagamentoCodigo() {
		return formaPagamentoCodigo;
	}

	public void setFormaPagamentoCodigo(FormaPagamento formaPagamentoCodigo) {
		this.formaPagamentoCodigo = formaPagamentoCodigo;
	}

	public Funcionario getFuncionarioCodigo() {
		return funcionarioCodigo;
	}

	public void setFuncionarioCodigo(Funcionario funcionarioCodigo) {
		this.funcionarioCodigo = funcionarioCodigo;
	}

}
