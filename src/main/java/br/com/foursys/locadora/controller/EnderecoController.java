package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.dao.EnderecoDAO;

public class EnderecoController {
	
	public void salvar(Endereco endereco) {
		EnderecoDAO dao = new EnderecoDAO();
		try {
			dao.salvar(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Endereco endereco) {
		EnderecoDAO dao = new EnderecoDAO();
		try {
			dao.excluir(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Endereco> buscarTodos(){
		ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
		EnderecoDAO dao = new EnderecoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Endereco> buscarNome(String nome) {
		ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
		EnderecoDAO dao = new EnderecoDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
