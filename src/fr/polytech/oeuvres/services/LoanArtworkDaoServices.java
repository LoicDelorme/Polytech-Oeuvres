package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.LoanArtwork;

/**
 * This class represents a loan artwork DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class LoanArtworkDaoServices extends AbstractDaoServices<LoanArtwork> {

	/**
	 * Create a loan artwork DAO services.
	 */
	public LoanArtworkDaoServices() {
		super(LoanArtwork.class);
	}
}