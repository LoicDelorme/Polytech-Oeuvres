package fr.polytech.oeuvres.services;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import fr.polytech.oeuvres.persistence.DatabaseManager;

/**
 * This class represents an abstract DAO services.
 *
 * @author DELORME Loïc
 * @param <T>
 *            The type of the object to handle.
 * @since 1.0.0
 */
public class AbstractDaoServices<T> implements DaoServices<T> {

	/**
	 * The database manager.
	 */
	private final DatabaseManager databaseManager;

	/**
	 * The entity class.
	 */
	private final Class<T> entityClass;

	/**
	 * Create an abstract DAO services.
	 * 
	 * @param entityClass
	 *            The entity class.
	 */
	public AbstractDaoServices(Class<T> entityClass) {
		this.databaseManager = new DatabaseManager();
		this.entityClass = entityClass;
	}

	@Override
	public T get(Object id) {
		Session session = this.databaseManager.getSession();

		session.beginTransaction();
		T entity = session.find(this.entityClass, id);
		session.getTransaction().commit();

		session.close();

		return entity;
	}

	@Override
	public List<T> getAll() {
		Session session = this.databaseManager.getSession();

		session.beginTransaction();
		CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(this.entityClass);
		List<T> entities = session.createQuery(criteriaQuery.select(criteriaQuery.from(this.entityClass))).getResultList();
		session.getTransaction().commit();

		session.close();

		return entities;
	}

	@Override
	public void insert(T object) {
		Session session = this.databaseManager.getSession();

		session.beginTransaction();
		session.saveOrUpdate(object);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void update(T object) {
		Session session = this.databaseManager.getSession();

		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void delete(T object) {
		Session session = this.databaseManager.getSession();

		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();

		session.close();
	}
}