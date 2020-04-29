package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.foursys.locadora.controller.LoginController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;

@ManagedBean(name = "loginBacking")
@SessionScoped
public class LoginBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private String usuario;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void efetuarLogin() {
		try {
			usuario = new LoginController().verificarUsuario(login, senha);
			if (!usuario.equals("")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} else {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.problemasNoLogin, Mensagem.credenciaisInvalidas);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
