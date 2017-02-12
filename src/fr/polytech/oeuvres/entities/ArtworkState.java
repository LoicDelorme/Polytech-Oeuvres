package fr.polytech.oeuvres.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents an artwork state entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "artwork_state_lov")
public class ArtworkState implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "artwork_state_id")
	private int id;

	/**
	 * The label.
	 */
	@NotNull
	@Column(name = "artwork_state_label")
	private String label;

	/**
	 * Create an artwork state entity.
	 */
	public ArtworkState() {
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
	 * Get the label.
	 * 
	 * @return The label.
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Set the label.
	 * 
	 * @param label
	 *            The label.
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}