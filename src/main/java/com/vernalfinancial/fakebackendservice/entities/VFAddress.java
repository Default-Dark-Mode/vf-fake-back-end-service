package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * This class represents a physical address
 * as understood by the Vernal Financial
 * systems and persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "addresses")
public class VFAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private VFRecordType recordType;
	@Pattern(regexp = "^\\d+$")
	private Integer number;
	@Pattern(regexp = "^[a-zA-Z-\\s]+$")
	private String street;
	@Pattern(regexp = "^[a-zA-Z-\\s]+$")
	private String city;
	private String county;
	@Pattern(regexp = "^[A-Z]{2}$")
	private String state;
	@Pattern(regexp = "^[a-zA-Z]+([a-zA-Z-\\s]*)$")
	private String country;
	@Pattern(regexp = "^\\d{5}(-\\d{4})?$")
	private String postalCode;

	/**
	 * The default constructor for the VFAddress class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFAddress() {
		this(null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFAddress
	 * class is the primary constructor and will be
	 * called by any other constructor in the class.
	 *
	 * @param number     Integer the number identifier of the address
	 * @param street     String the name of the street where the address is located
	 * @param city       String the name of the city where the address is located
	 * @param county     String the name of the county where the address is located
	 * @param state      String the name of the state where the address is located
	 * @param country    String the name of the country where the address is located
	 * @param postalCode String the zip code with optional postal code for the address
	 */
	public VFAddress(Integer number, String street, String city, String county, String state, String country, String postalCode) {
		this.recordType = VFRecordType.PhysicalAddress;
		this.number = number;
		this.street = street;
		this.city = city;
		this.county = county;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFAddress vfAddress = (VFAddress) o;
		return Objects.equals(getId(), vfAddress.getId()) && getRecordType() == vfAddress.getRecordType() && Objects.equals(getNumber(), vfAddress.getNumber()) && Objects.equals(getStreet(), vfAddress.getStreet()) && Objects.equals(getCity(), vfAddress.getCity()) && Objects.equals(getCounty(), vfAddress.getCounty()) && Objects.equals(getState(), vfAddress.getState()) && Objects.equals(getCountry(), vfAddress.getCountry()) && Objects.equals(getPostalCode(), vfAddress.getPostalCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getNumber(), getStreet(), getCity(), getCounty(), getState(), getCountry(), getPostalCode());
	}

	@Override
	public String toString() {
		return "address{" +
				"id=" + id +
				", record_type=" + recordType +
				", number=" + number +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", county='" + county + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", postal_code='" + postalCode + '\'' +
				'}';
	}
}
