package fr.polytech.oeuvres.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a purchase status entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "purchase_status_lov")
public class PurchaseStatus implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "purchase_status_id")
	private int id;

	/**
	 * The label.
	 */
	@NotNull
	@Column(name = "purchase_status_label")
	private String label;

	/**
	 * Create a purchase status entity.
	 */
	public PurchaseStatus() {
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