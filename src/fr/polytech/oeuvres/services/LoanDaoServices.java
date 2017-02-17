package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.Loan;

/**
 * This class represents a loan DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class LoanDaoServices extends AbstractDaoServices<Loan> {

	/**
	 * Create a loan DAO services.
	 */
	public LoanDaoServices() {
		super(Loan.class);
	}
}