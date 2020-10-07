package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import business.Fachada;
import models.Usuario;

@Named(value = "beanLogin")
@RequestScoped
public class BeanLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	public BeanLogin() {

	}

	// Atributos

	private Usuario usuario = new Usuario();
	Fachada fachada = new Fachada();
	private String mensagem;

	// Metodos

	public String VerificaLoginUsuario() throws Exception {
		try {
			if (fachada.VerificaLoginUsuario(this.usuario)) {
				return "listarTelefone";
			}
			
			return null;
		} catch (Exception ex) {
			mensagem = "" + ex;
			return null;
		}
	}

	// Getters e Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
