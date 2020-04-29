package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.dao.GeneroDAO;

public class GeneroController {
	
	public void salvar(Genero genero) {
		GeneroDAO dao = new GeneroDAO();
		try {
			dao.salvar(genero);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Genero genero) {
		GeneroDAO dao = new GeneroDAO();
		try {
			dao.excluir(genero);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Genero> buscarTodos(){
		ArrayList<Genero> listaRetorno = new ArrayList<Genero>();
		GeneroDAO dao = new GeneroDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
