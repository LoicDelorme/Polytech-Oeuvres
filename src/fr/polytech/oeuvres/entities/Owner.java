package fr.polytech.oeuvres.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents an owner entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "owner")
public class Owner implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "owner_id")
	private int id;

	/**
	 * The lastname.
	 */
	@NotNull
	@Column(name = "owner_lastname")
	private String lastname;

	/**
	 * The firstname.
	 */
	@NotNull
	@Column(name = "owner_firstname")
	private String firstname;

	/**
	 * Create an owner entity.
	 */
	public Owner() {
	}

	/**
	 * Get the id.
	 * 
	 * @return The id.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            The id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the lastname.
	 * 
	 * @return The lastname.
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * Set the lastname.
	 * 
	 * @param lastname
	 *            The lastname.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Get the firstname.
	 * 
	 * @return The firstname.
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Set the firstname.
	 * 
	 * @param firstname
	 *            The firstname.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}