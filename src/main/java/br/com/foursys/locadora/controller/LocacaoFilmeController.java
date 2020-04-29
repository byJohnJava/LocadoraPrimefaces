package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.dao.LocacaoFilmeDAO;

public class LocacaoFilmeController {
	
	public void salvar(LocacaoFilme locacaoFilme) {
		LocacaoFilmeDAO dao = new LocacaoFilmeDAO();
		try {
			dao.salvar(locacaoFilme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(LocacaoFilme locacaoFilme) {
		LocacaoFilmeDAO dao = new LocacaoFilmeDAO();
		try {
			dao.excluir(locacaoFilme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<LocacaoFilme> buscarTodos(){
		ArrayList<LocacaoFilme> listaRetorno = new ArrayList<LocacaoFilme>();
		LocacaoFilmeDAO dao = new LocacaoFilmeDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<LocacaoFilme> buscarNome(String nome) {
		ArrayList<LocacaoFilme> listaRetorno = new ArrayList<LocacaoFilme>();
		LocacaoFilmeDAO dao = new LocacaoFilmeDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
