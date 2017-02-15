package fr.polytech.oeuvres.services;

import java.util.List;

/**
 * This interface represents a list of DAO services.
 *
 * @author DELORME Loïc
 * @param <T>
 *            The type of the object to handle.
 * @since 1.0.0
 */
public interface DaoServices<T> {

	/**
	 * Get an object according to its id.
	 * 
	 * @param id
	 *            The id.
	 * @return The corresponding object.
	 */
	public T get(Object id);

	/**
	 * Get all objects.
	 * 
	 * @return The list of objects.
	 */
	public List<T> getAll();

	/**
	 * Insert a new object.
	 * 
	 * @param object
	 *            The object to insert.
	 */
	public void insert(T object);

	/**
	 * Update an object.
	 * 
	 * @param object
	 *            The object to update.
	 */
	public void update(T object);

	/**
	 * Delete an object.
	 * 
	 * @param object
	 *            The object to delete.
	 */
	public void delete(T object);
}