package business;

import java.util.List;

import dao.DAOtelefone;
import dao.IDAOtelefone;
import models.Telefone;

public class BusinessTelefone implements IDAOtelefone {

	private final DAOtelefone daoTelefone = new DAOtelefone();

	public boolean ValidarDadosBasicos(Telefone telefone) throws Exception {

		if (telefone == null) {
			throw new Exception("Erro! Favor informar um telefone.");
		}

		if ((telefone.getDdd() == null) || (telefone.getDdd().trim().isEmpty() == true)
				|| (telefone.getDdd().isEmpty() == true)) {

			throw new Exception("Erro! Campo vazio. Favor informar o ddd do telefone.");
		}

		if ((telefone.getDdd().trim().length() != 2)) {
			throw new Exception("Erro! Número de caracteres incompatível. O ddd deve conter 2 caracteres.");
		}

		if ((telefone.getNumero() == null) || (telefone.getNumero().trim().isEmpty() == true)
				|| (telefone.getNumero().isEmpty() == true)) {

			throw new Exception("Erro! Campo vazio. Favor informar o numero do telefone.");
		}

		if ((telefone.getNumero().trim().length() < 8 || telefone.getNumero().trim().length() > 9)) {
			throw new Exception(
					"Erro! Número de caracteres incompatível. O número deve conterno mínimo 8 e no máximo 9 caracteres.");
		}
		return true;
	}

	public void InsertTelefone(Telefone telefone) throws Exception {
		try {
			if (ValidarDadosBasicos(telefone)) {
				daoTelefone.InsertTelefone(telefone);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void UpdateTelefone(Telefone telefone) throws Exception {
		try {
			if (ValidarDadosBasicos(telefone)) {
				daoTelefone.UpdateTelefone(telefone);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	public List<Telefone> SelectTelefone(Integer id_usuario) throws Exception {
		try {
			return daoTelefone.SelectTelefone(id_usuario);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void RemoveTelefone(Telefone telefone) throws Exception {
		try {
			daoTelefone.RemoveTelefone(telefone);

		} catch (Exception ex) {
			throw ex;
		}
	}
}