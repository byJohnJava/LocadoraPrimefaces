package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.dao.FuncionarioDAO;

public class FuncionarioController {
	
	public void salvar(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.salvar(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.excluir(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Funcionario> buscarTodos(){
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Funcionario> buscarNome(String nome) {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();
		
		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Funcionario> buscarLogin(String login) {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();
		
		try {
			listaRetorno = dao.buscarLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	

}
