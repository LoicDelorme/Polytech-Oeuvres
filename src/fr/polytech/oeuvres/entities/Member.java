package fr.polytech.oeuvres.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class represents a member entity.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private int id;

	/**
	 * The lastname.
	 */
	@NotNull
	@Column(name = "member_lastname")
	private String lastname;

	/**
	 * The firstname.
	 */
	@NotNull
	@Column(name = "member_firstname")
	private String firstname;

	/**
	 * The address.
	 */
	@NotNull
	@Column(name = "member_address")
	private String address;

	/**
	 * The zipcode.
	 */
	@NotNull
	@Column(name = "member_zipcode")
	private String zipcode;

	/**
	 * The city.
	 */
	@NotNull
	@Column(name = "member_city")
	private String city;

	/**
	 * The loan artworks.
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<LoanArtwork> loanArtworks = new ArrayList<LoanArtwork>();

	/**
	 * Create a member entity.
	 */
	public Member() {
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
	 * Get the lastname.
	 * 
	 * @return The lastname.
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * Set the lastname.
	 * 
	 * @param lastname
	 *            The lastname.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Get the firstname.
	 * 
	 * @return The firstname.
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Set the firstname.
	 * 
	 * @param firstname
	 *            The firstname.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Get the address.
	 * 
	 * @return The address.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Set the address.
	 * 
	 * @param address
	 *            The address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the zipcode.
	 * 
	 * @return The zipcode.
	 */
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 * Set the zipcode.
	 * 
	 * @param zipcode
	 *            The zipcode.
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Get the city.
	 * 
	 * @return The city.
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Set the city.
	 * 
	 * @param city
	 *            The city.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the loan artworks.
	 * 
	 * @return The loan artworks.
	 */
	public List<LoanArtwork> getLoanArtworks() {
		return this.loanArtworks;
	}

	/**
	 * Set the loan artworks.
	 * 
	 * @param loanArtworks
	 *            The loan artworks.
	 */
	public void setLoanArtworks(List<LoanArtwork> loanArtworks) {
		this.loanArtworks = loanArtworks;
	}

	/**
	 * Add a loan artwork.
	 * 
	 * @param loanArtwork
	 *            The loan artwork.
	 */
	public void addLoanArtwork(LoanArtwork loanArtwork) {
		this.loanArtworks.add(loanArtwork);
	}

	/**
	 * Remove a loan artwork.
	 * 
	 * @param loanArtwork
	 *            The loan artwork.
	 */
	public void removeLoanArtwork(LoanArtwork loanArtwork) {
		this.loanArtworks.add(loanArtwork);
	}
}