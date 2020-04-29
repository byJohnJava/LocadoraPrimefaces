package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.bean.Funcionario;

public class LoginController {

	public String verificarUsuario(String login, String senha) {

		for (Funcionario funcionario : new FuncionarioController().buscarLogin(login)) {
			if (funcionario.getSenha().contentEquals(senha)) {
				return funcionario.getNome();
			}
		}
		return "";
	}

}
