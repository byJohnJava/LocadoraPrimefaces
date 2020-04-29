package br.com.foursys.locadora.util;

public enum Rotulo {
	INFO(1,"INFO"),
	ERROR(2, "ERROR"),
	FATAL(3, "FATAL"),
	WARN(4, "WARN");
	
	private int codigo;
	private String descricao;
	
	
	private Rotulo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
}
