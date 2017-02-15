package fr.polytech.oeuvres.services;

import fr.polytech.oeuvres.entities.Member;

/**
 * This class represents a member DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class MemberDaoServices extends AbstractDaoServices<Member> {

	/**
	 * The table name.
	 */
	public static final String TABLE_NAME = "member";

	/**
	 * Create a member DAO services.
	 */
	public MemberDaoServices() {
		super(Member.class);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}