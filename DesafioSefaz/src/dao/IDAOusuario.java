package dao;

import java.util.List;
import models.Usuario;

public interface IDAOusuario {
	public void InsertUsuario(Usuario usuario) throws Exception;

	public void UpdateUsuario(Usuario usuario) throws Exception;

	public List<Usuario> SelectUsuario() throws Exception;

	public void RemoveUsuario(Usuario usuario) throws Exception;

	public boolean VerificaLoginUsuario(Usuario usuario) throws Exception;
}