package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.SaleArtwork;

/**
 * This class represents a sale artwork DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SaleArtworkDaoServices extends AbstractDaoServices<SaleArtwork> {

	/**
	 * The table name.
	 */
	public static final String TABLE_NAME = "sale_artwork";

	/**
	 * Create a sale artwork DAO services.
	 */
	public SaleArtworkDaoServices() {
		super(SaleArtwork.class);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}