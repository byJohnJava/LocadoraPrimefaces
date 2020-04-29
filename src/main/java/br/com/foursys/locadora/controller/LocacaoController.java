package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.LocacaoDAO;

public class LocacaoController {
	
	public void salvar(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.salvar(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.excluir(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Locacao> buscarTodos(){
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Locacao> buscarNome(String nome) {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Locacao> buscarNaoDevolvido(){
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();
		
		try {
			listaRetorno = dao.buscarNaoDevolvido();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
