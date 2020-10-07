package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import business.Fachada;
import models.Usuario;

@Named(value = "beanUsuario")
@RequestScoped
public class BeanUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public BeanUsuario() {

	}

	// Atributos

	private Usuario usuario = new Usuario();
	private List<Usuario> list;
	Fachada fachada = new Fachada();

	// Metodos

	public void addMessage(String msg) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public String InsertUsuario() throws Exception {
		try {
			fachada.InsertUsuario(this.usuario);
			addMessage("Usuário cadastrado com sucesso!");
			return "home";
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void SelectUsuario() throws Exception {
		try {			
			 list = fachada.SelectUsuario();	
			 addMessage("Usuário listado com sucesso!");
			 
		} catch (Exception ex) {
			ex.printStackTrace();			
		}
	}

	// Getters e Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}	
}
