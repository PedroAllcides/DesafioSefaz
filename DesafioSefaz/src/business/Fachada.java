package business;

import java.util.List;
import models.Telefone;
import models.Usuario;

public class Fachada implements IBusinessUsuario, IBusinessTelefone {

	public void InsertUsuario(Usuario u) throws Exception {
		new BusinessUsuario().InsertUsuario(u);
	}

	public void UpdateUsuario(Usuario u) throws Exception {
		new BusinessUsuario().UpdateUsuario(u);
	}

	public List<Usuario> SelectUsuario() throws Exception {
		return new BusinessUsuario().SelectUsuario();
	}

	public void RemoveUsuario(Usuario u) throws Exception {
		new BusinessUsuario().RemoveUsuario(u);
	}

	public boolean VerificaLoginUsuario(Usuario u) throws Exception {
		return new BusinessUsuario().VerificaLoginUsuario(u);
	}

	public void InsertTelefone(Telefone t) throws Exception {
		new BusinessTelefone().InsertTelefone(t);
	}

	public void UpdateTelefone(Telefone t) throws Exception {
		new BusinessTelefone().UpdateTelefone(t);
	}

	public List<Telefone> SelectTelefone(Integer id_usuario) throws Exception {
		return new BusinessTelefone().SelectTelefone(id_usuario);
	}

	public void RemoveTelefone(Telefone t) throws Exception {
		new BusinessTelefone().RemoveTelefone(t);
	}
}
