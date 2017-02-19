package fr.polytech.oeuvres.entities.pks;

import java.io.Serializable;
import java.time.LocalDate;

import fr.polytech.oeuvres.entities.LoanArtwork;
import fr.polytech.oeuvres.entities.Member;

/**
 * This class represents a loan primary key.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class LoanPK implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date.
	 */
	private LocalDate date;

	/**
	 * The member.
	 */
	private Member member;

	/**
	 * The loan artwork.
	 */
	private LoanArtwork loanArtwork;

	/**
	 * Create a loan primary key.
	 */
	public LoanPK() {
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