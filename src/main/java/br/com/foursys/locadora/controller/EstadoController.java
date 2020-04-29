package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.dao.EstadoDAO;

public class EstadoController {
	
	public void salvar(Estado estado) {
		EstadoDAO dao = new EstadoDAO();
		try {
			dao.salvar(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Estado estado) {
		EstadoDAO dao = new EstadoDAO();
		try {
			dao.excluir(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Estado> buscarTodos(){
		ArrayList<Estado> listaRetorno = new ArrayList<Estado>();
		EstadoDAO dao = new EstadoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
