package business;

import java.util.List;
import dao.DAOusuario;
import dao.IDAOusuario;
import models.Usuario;

public class BusinessUsuario implements IDAOusuario {

	private final DAOusuario daoUsuario = new DAOusuario();

	public boolean ValidarDadosBasicos(Usuario usuario) throws Exception {

		if (usuario == null) {
			throw new Exception("Erro! Favor informar um usuário.");
		}

		if ((usuario.getNome() == null) || (usuario.getNome().equals(""))) {

			throw new Exception("Erro! Campo vazio. Favor informar o nome do usuário.");
		}

		if ((usuario.getNome().trim().length() > 50)) {
			throw new Exception(
					"Erro! Número de caracteres incompatível. O nome deve conterno no máximo 50 caracteres.");
		}

		if ((usuario.getEmail() == null) || (usuario.getEmail().trim().isEmpty() == true)
				|| (usuario.getEmail().isEmpty() == true)) {

			throw new Exception("Erro! Campo vazio. Favor informar o e-mail do usuário.");
		}

		if ((usuario.getEmail().trim().length() > 30)) {
			throw new Exception(
					"Erro! Número de caracteres incompatível. O e-mail deve conterno no máximo 30 caracteres.");
		}

		if ((usuario.getSenha() == null) || (usuario.getSenha().trim().isEmpty() == true)
				|| (usuario.getSenha().isEmpty() == true)) {

			throw new Exception("Erro! Campo vazio. Favor informar a senha do usuário.");
		}

		if ((usuario.getEmail().trim().length() < 6 || usuario.getEmail().trim().length() > 25)) {
			throw new Exception(
					"Erro! Número de caracteres incompatível. A senha deve conterno no mínimo 6 e no máximo 25 caracteres.");
		}
		return true;
	}

	public void InsertUsuario(Usuario usuario) throws Exception {
		try {
			if (ValidarDadosBasicos(usuario)) {
				daoUsuario.InsertUsuario(usuario);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void UpdateUsuario(Usuario usuario) throws Exception {
		try {
			if (ValidarDadosBasicos(usuario)) {
				daoUsuario.UpdateUsuario(usuario);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	public List<Usuario> SelectUsuario() throws Exception {
		try {
			return daoUsuario.SelectUsuario();

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void RemoveUsuario(Usuario usuario) throws Exception {
		try {
			daoUsuario.RemoveUsuario(usuario);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public boolean VerificaLoginUsuario(Usuario usuario) throws Exception {
		try {
			return daoUsuario.VerificaLoginUsuario(usuario);

		} catch (Exception ex) {
			throw ex;
		}
	}
}
