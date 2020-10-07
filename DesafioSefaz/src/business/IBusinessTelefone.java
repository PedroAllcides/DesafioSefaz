package business;

import java.util.List;
import models.Telefone;

public interface IBusinessTelefone {

	public void InsertTelefone(Telefone telefone) throws Exception;

	public void UpdateTelefone(Telefone telefone) throws Exception;

	public List<Telefone> SelectTelefone(Integer id_usuario) throws Exception;

	public void RemoveTelefone(Telefone telefone) throws Exception;
}
