package fr.polytech.oeuvres.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a loan entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "loan")
public class Loan implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date.
	 */
	@NotNull
	@Column(name = "loan_date")
	private LocalDate date;

	/**
	 * The duration.
	 */
	@NotNull
	@Column(name = "loan_duration")
	private int duration;

	/**
	 * The member.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	/**
	 * The loan artwork.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "loan_artwork_id")
	private LoanArtwork loanArtwork;

	/**
	 * Create a loan entity.
	 */
	public Loan() {
	}

	/**
	 * Get the date.
	 * 
	 * @return The date.
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Set the date.
	 * 
	 * @param date
	 *            The date.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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

	/**
	 * Get the member.
	 * 
	 * @return The member.
	 */
	public Member getMember() {
		return this.member;
	}

	/**
	 * Set the member.
	 * 
	 * @param member
	 *            The member.
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Get the loan artwork.
	 * 
	 * @return The loan artwork.
	 */
	public LoanArtwork getLoanArtwork() {
		return this.loanArtwork;
	}

	/**
	 * Set the loan artwork.
	 * 
	 * @param loanArtwork
	 *            The loan artwork.
	 */
	public void setLoanArtwork(LoanArtwork loanArtwork) {
		this.loanArtwork = loanArtwork;
	}
}