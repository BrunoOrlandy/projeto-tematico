package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
 *Gera a conexao a partir do Persistence.XML 
 */
public class EntityManagerUtil {
	private static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Projeto-Tematico");
		}
		return emf.createEntityManager();
	}

	public static void criaTabelas() {
		emf = Persistence.createEntityManagerFactory("Projeto-Tematico");

		EntityManager em = emf.createEntityManager();

		emf.close();
		em.close();
	}
}
