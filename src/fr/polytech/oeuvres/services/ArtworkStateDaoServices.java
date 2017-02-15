package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.ArtworkState;

/**
 * This class represents an artwork state DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class ArtworkStateDaoServices extends AbstractDaoServices<ArtworkState> {

	/**
	 * The table name.
	 */
	public static final String TABLE_NAME = "artwork_state_lov";

	/**
	 * Create an artwork state DAO services.
	 */
	public ArtworkStateDaoServices() {
		super(ArtworkState.class);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}