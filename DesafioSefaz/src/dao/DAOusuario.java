package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Usuario;

public class DAOusuario {

	private EntityManagerFactory emf;
	private EntityManager em;

	public DAOusuario() {
		emf = Persistence.createEntityManagerFactory("hibernateSefazDesafio");
		em = emf.createEntityManager();
	}

	public void InsertUsuario(Usuario usuario) throws Exception {

		try {

			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Sucesso!");

		} catch (Exception ex) {

			throw new Exception("Erro ao inserir o usuário.");
		}
	}

	public void UpdateUsuario(Usuario usuario) throws Exception {

		try {

			em.getTransaction().begin();
			usuario = em.merge(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception ex) {

			throw new Exception("Erro ao atualizar o usuário.");
		}
	}

	public List<Usuario> SelectUsuario() throws Exception {

		try {

			String q = " SELECT u FROM Usuario u ";
			TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
			return query.getResultList();

		} catch (Exception ex) {

			throw new Exception("Erro ao listar os usuários.");
		}
	}

	public void RemoveUsuario(Usuario usuario) throws Exception {

		try {

			em.getTransaction().begin();
			usuario = em.merge(usuario);
			em.remove(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception ex) {

			throw new Exception("Erro ao remover o usuário.");
		}
	}

	public boolean VerificaLoginUsuario(Usuario usuario) throws Exception {
		boolean result;
		List<Usuario> list = null;
		try {

			String q = " SELECT u FROM Usuario u WHERE Nome = :nome AND Senha = :senha ";
			TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
			query.setParameter("nome", usuario.getNome());
			query.setParameter("senha", usuario.getSenha());

			list = query.getResultList();

			if (list.size() > 0) {
				result = true;
			} else {
				result = false;
			}
			return result;

		} catch (Exception ex) {

			throw new Exception("Erro verificar login.");
		}
	}
}
