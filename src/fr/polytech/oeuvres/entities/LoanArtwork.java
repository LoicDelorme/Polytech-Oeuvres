package fr.polytech.oeuvres.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a loan artwork entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "loan_artwork")
public class LoanArtwork implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "loan_artwork_id")
	private int id;

	/**
	 * The title.
	 */
	@NotNull
	@Column(name = "loan_artwork_title")
	private String title;

	/**
	 * The duration.
	 */
	@NotNull
	@Column(name = "loan_artwork_duration")
	private int duration;

	/**
	 * Create a loan artwork entity.
	 */
	public LoanArtwork() {
	}

	/**
	 * Get the id.
	 * 
	 * @return The id.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            The id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the title.
	 * 
	 * @return The title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set the title.
	 * 
	 * @param title
	 *            The title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the duration.
	 * 
	 * @return The duration.
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Set the duration.
	 * 
	 * @param duration
	 *            The duration.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}