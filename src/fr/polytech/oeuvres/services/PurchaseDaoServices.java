package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.Purchase;

/**
 * This class represents a purchase DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PurchaseDaoServices extends AbstractDaoServices<Purchase> {

	/**
	 * Create a purchase DAO services.
	 */
	public PurchaseDaoServices() {
		super(Purchase.class);
	}
}