package main;

import business.Fachada;
import models.Usuario;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("hibernateSefazDesafio");

		Fachada f = new Fachada();
		Usuario u = new Usuario();
		//u.setId((long) 1);
		u.setNome("Jefferson");
		u.setEmail("pedro@gmail");
		u.setSenha("456798");

		try {

			/*
			 * EntityManager em = emf.createEntityManager();
			 * 
			 * EntityTransaction et = em.getTransaction(); et.begin(); em.persist(u);
			 * et.commit(); em.close(); emf.close();
			 */

			f.InsertUsuario(u);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
