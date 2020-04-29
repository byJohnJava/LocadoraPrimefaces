package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;

public class ClienteController {
	
	public void salvar(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.excluir(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> buscarTodos(){
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Cliente> buscarNome(String nome) {
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	

}
