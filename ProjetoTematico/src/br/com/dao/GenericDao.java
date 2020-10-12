package br.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.model.Pessoa;

/*
 *classe gerenerica dos metodos basicos do hibernate 
 */
public class GenericDao<T> {

	@PersistenceContext(unitName = "Projeto-Tematico")
	private final EntityManager entityManager;
	private final Class persistentClass;

	public GenericDao() {
		this.entityManager = EntityManagerUtil.getEntityManager();
		this.persistentClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected <T> void save(T entity) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		try {
			if (entity == null) {
				transaction.begin();
				getEntityManager().persist(entity);
				transaction.commit();
			} else {
				transaction.begin();
				getEntityManager().merge(entity);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	protected <T> void delete(T entity) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		try {

			transaction.begin();

			getEntityManager().remove(entity);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public <T> List<T> findAll() {
		return getEntityManager().createQuery("Select t from " + persistentClass.getSimpleName() + " t")
				.getResultList();
	}

	public Object findByName(Object nome) {

		return getEntityManager().find(persistentClass, nome);

		// return em.createQuery(" FROM " +
		// persistentClass.getName()).getSingleResult();

	}

	public Object findById(Long id) {
		return getEntityManager().find(persistentClass, id);
	}

	private void close() {
		if (getEntityManager().getEntityManagerFactory().isOpen()) {
			getEntityManager().getEntityManagerFactory().close();
		}
	}

	public Pessoa findByUser(String nome, String senha) {

		TypedQuery<Pessoa> q = getEntityManager()
				.createQuery("SELECT p FROM Pessoa p WHERE p.nome = ?1 AND p.senha = ?2", Pessoa.class);
		q.setParameter(1, nome);
		q.setParameter(2, senha);

		return q.getSingleResult();

	}

	public Pessoa findByLogin(String login, String senha) {

		TypedQuery<Pessoa> q = getEntityManager()
				.createQuery("SELECT p FROM Pessoa p WHERE p.login = ?1 AND p.senha = ?2", Pessoa.class);
		q.setParameter(1, login);
		q.setParameter(2, senha);

		return q.getSingleResult();

	}

}
