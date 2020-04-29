package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;

public class FilmeController {
		
	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.excluir(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Filme> buscarTodos(){
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Filme> buscarNome(String nome) {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public Filme buscarPorCodigo(int codigo) {
		Filme filme = new Filme();
		try {
			filme = new FilmeDAO().buscarPorCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filme;
	}
	
	
	public ArrayList<Filme> buscarDisponivel() {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		
		try {
			listaRetorno = dao.buscarDisponivel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

}
