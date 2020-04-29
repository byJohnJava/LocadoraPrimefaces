package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.dao.FormaPagamentoDAO;

public class FormaPagamentoController {
	
	public void salvar(FormaPagamento formaPagamento) {
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		try {
			dao.salvar(formaPagamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(FormaPagamento formaPagamento) {
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		try {
			dao.excluir(formaPagamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<FormaPagamento> buscarTodos(){
		ArrayList<FormaPagamento> listaRetorno = new ArrayList<FormaPagamento>();
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		
		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	

}
