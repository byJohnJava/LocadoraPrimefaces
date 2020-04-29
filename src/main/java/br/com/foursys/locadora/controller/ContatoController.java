package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.dao.ContatoDAO;

public class ContatoController {
	
	public void salvar(Contato contato) {
		ContatoDAO dao = new ContatoDAO();
		try {
			dao.salvar(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Contato contato) {
		ContatoDAO dao = new ContatoDAO();
		try {
			dao.excluir(contato);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public ArrayList<Contato> buscarTodos(){
		ArrayList<Contato> listaRetorno = new ArrayList<Contato>();
		ContatoDAO dao = new ContatoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
