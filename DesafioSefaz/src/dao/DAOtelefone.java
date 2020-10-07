package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Telefone;

public class DAOtelefone {

	EntityManagerFactory emf;
	EntityManager em;

	public DAOtelefone() {

		emf = Persistence.createEntityManagerFactory("hibernateSefazDesafio");
		em = emf.createEntityManager();
	}

	public void InsertTelefone(Telefone telefone) throws Exception {

		try {

			em.getTransaction().begin();
			em.persist(telefone);
			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception ex) {

			throw new Exception("Erro ao inserir o telefone.");
		}
	}

	public void UpdateTelefone(Telefone telefone) throws Exception {

		try {

			em.getTransaction().begin();
			telefone = em.merge(telefone);
			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception ex) {

			throw new Exception("Erro ao atualizar o telefone.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Telefone> SelectTelefone(Integer id_usuario) throws Exception {		
		
		try {

			return em.createQuery(" SELECT ddd, numero, tipo FROM telefone WHERE id_usuario ="+ id_usuario).getResultList();

		} catch (Exception ex) {

			throw new Exception("Erro ao listar os telefones.");
		}
	}
	
	public void RemoveTelefone(Telefone telefone) throws Exception {

		try {

			em.getTransaction().begin();
			telefone = em.merge(telefone);
			em.remove(telefone);
			em.getTransaction().commit();
			emf.close();

		} catch (Exception ex) {

			throw new Exception("Erro ao atualizar o telefone.");
		}
	}
}
