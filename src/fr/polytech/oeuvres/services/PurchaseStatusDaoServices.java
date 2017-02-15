package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.PurchaseStatus;

/**
 * This class represents a purchase status DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class PurchaseStatusDaoServices extends AbstractDaoServices<PurchaseStatus> {

	/**
	 * The table name.
	 */
	public static final String TABLE_NAME = "purchase_status_lov";

	/**
	 * Create a purchase status DAO services.
	 */
	public PurchaseStatusDaoServices() {
		super(PurchaseStatus.class);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}