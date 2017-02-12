package fr.polytech.oeuvres.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a purchase entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "purchase")
public class Purchase implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date.
	 */
	@NotNull
	@Column(name = "purchase_date")
	private LocalDate date;

	/**
	 * The status.
	 */
	@ManyToOne
	@JoinColumn(name = "purchase_status_id")
	private PurchaseStatus status;

	/**
	 * The owner.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	/**
	 * The sale artwork.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "sale_artwork_id")
	private SaleArtwork saleArtwork;

	/**
	 * Create a purchase entity.
	 */
	public Purchase() {
	}

	/**
	 * Get the date.
	 * 
	 * @return The date.
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Set the date.
	 * 
	 * @param date
	 *            The date.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Get the status.
	 * 
	 * @return The status.
	 */
	public PurchaseStatus getStatus() {
		return this.status;
	}

	/**
	 * Set the status.
	 * 
	 * @param status
	 *            The status.
	 */
	public void setStatus(PurchaseStatus status) {
		this.status = status;
	}

	/**
	 * Get the owner.
	 * 
	 * @return The owner.
	 */
	public Owner getOwner() {
		return this.owner;
	}

	/**
	 * Set the owner.
	 * 
	 * @param owner
	 *            The owner.
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * Get the sale artwork.
	 * 
	 * @return The sale artwork.
	 */
	public SaleArtwork getSaleArtwork() {
		return this.saleArtwork;
	}

	/**
	 * Set the sale artwork.
	 * 
	 * @param saleArtwork
	 *            The sale artwork.
	 */
	public void setSaleArtwork(SaleArtwork saleArtwork) {
		this.saleArtwork = saleArtwork;
	}
}