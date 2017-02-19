package fr.polytech.oeuvres.entities.pks;

import java.io.Serializable;

import fr.polytech.oeuvres.entities.Owner;
import fr.polytech.oeuvres.entities.PurchaseStatus;
import fr.polytech.oeuvres.entities.SaleArtwork;

/**
 * This class represents a purchase primary key.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PurchasePK implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The status.
	 */
	private PurchaseStatus status;

	/**
	 * The owner.
	 */
	private Owner owner;

	/**
	 * The sale artwork.
	 */
	private SaleArtwork saleArtwork;

	/**
	 * Create a purchase primary key.
	 */
	public PurchasePK() {
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