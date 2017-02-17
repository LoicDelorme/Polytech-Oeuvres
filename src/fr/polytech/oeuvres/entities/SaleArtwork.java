package fr.polytech.oeuvres.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a sale artwork entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "sale_artwork")
public class SaleArtwork implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_artwork_id")
	private int id;

	/**
	 * The title.
	 */
	@NotNull
	@Column(name = "sale_artwork_title")
	private String title;

	/**
	 * The state.
	 */
	@ManyToOne
	@JoinColumn(name = "sale_artwork_state_id")
	private ArtworkState state;

	/**
	 * The price.
	 */
	@NotNull
	@Column(name = "sale_artwork_price")
	private double price;

	/**
	 * The owners.
	 */
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "saleArtworks")
	private List<Owner> owners = new ArrayList<Owner>();

	/**
	 * Create a sale artwork entity.
	 */
	public SaleArtwork() {
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
	 * Get the title.
	 * 
	 * @return The title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set the title.
	 * 
	 * @param title
	 *            The title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the state.
	 * 
	 * @return The state.
	 */
	public ArtworkState getState() {
		return this.state;
	}

	/**
	 * Set the state.
	 * 
	 * @param state
	 *            The state.
	 */
	public void setState(ArtworkState state) {
		this.state = state;
	}

	/**
	 * Get the price.
	 * 
	 * @return The price.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Set the price.
	 * 
	 * @param price
	 *            The price.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the owners.
	 * 
	 * @return The owners.
	 */
	public List<Owner> getOwners() {
		return this.owners;
	}

	/**
	 * Set the owners.
	 * 
	 * @param owners
	 *            The owners.
	 */
	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	/**
	 * Add an owner.
	 * 
	 * @param owner
	 *            The owner.
	 */
	public void addOwner(Owner owner) {
		this.owners.add(owner);
	}

	/**
	 * Remove an owner.
	 * 
	 * @param owner
	 *            The owner.
	 */
	public void removeOwner(Owner owner) {
		this.owners.remove(owner);
	}
}