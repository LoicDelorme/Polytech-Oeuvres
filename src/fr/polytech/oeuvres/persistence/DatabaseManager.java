package fr.polytech.oeuvres.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.polytech.oeuvres.entities.ArtworkState;
import fr.polytech.oeuvres.entities.Loan;
import fr.polytech.oeuvres.entities.LoanArtwork;
import fr.polytech.oeuvres.entities.Member;
import fr.polytech.oeuvres.entities.Owner;
import fr.polytech.oeuvres.entities.Purchase;
import fr.polytech.oeuvres.entities.PurchaseStatus;
import fr.polytech.oeuvres.entities.SaleArtwork;

/**
 * This class represents a database manager.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class DatabaseManager {

	/**
	 * The session factory instance.
	 */
	private static SessionFactory sessionFactory = null;

	/**
	 * Get a session.
	 * 
	 * @return The session.
	 */
	public Session getSession() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(ArtworkState.class);
			configuration.addAnnotatedClass(Loan.class);
			configuration.addAnnotatedClass(LoanArtwork.class);
			configuration.addAnnotatedClass(Member.class);
			configuration.addAnnotatedClass(Owner.class);
			configuration.addAnnotatedClass(Purchase.class);
			configuration.addAnnotatedClass(PurchaseStatus.class);
			configuration.addAnnotatedClass(SaleArtwork.class);

			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory.openSession();
	}
}