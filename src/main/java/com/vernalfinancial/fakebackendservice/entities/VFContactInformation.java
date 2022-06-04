package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents the contact information
 * of a natural person or organization as
 * understood by Vernal Financial's systems and
 * persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "contact_information")
public class VFContactInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private VFRecordType recordType;
	@ManyToOne
	private VFAddress primaryAddress;
	@ManyToOne
	private VFPhone primaryNumber;
	@ManyToOne
	private VFEmail primaryEmail;

	/**
	 * The default constructor for the VFContactInformation
	 * class calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFContactInformation() {
	}

	/**
	 * The parameterized constructor for the
	 * VFContactInformation class is the primary
	 * constructor and will be called by any other
	 * constructor in the class.
	 *
	 * @param primaryAddress VFAddress the primary address of the person or organization
	 * @param primaryNumber VFPhone the primary telephone number of the person or organization
	 * @param primaryEmail VFEmail the primary email address of the person or organization
	 */
	public VFContactInformation(VFAddress primaryAddress, VFPhone primaryNumber, VFEmail primaryEmail) {
		this.recordType = VFRecordType.ContactInformation;
		this.primaryAddress = primaryAddress;
		this.primaryNumber = primaryNumber;
		this.primaryEmail = primaryEmail;
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

	public VFAddress getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(VFAddress primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public VFPhone getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(VFPhone primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	public VFEmail getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(VFEmail primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFContactInformation that = (VFContactInformation) o;
		return Objects.equals(getId(), that.getId()) && getRecordType() == that.getRecordType() && Objects.equals(getPrimaryAddress(), that.getPrimaryAddress()) && Objects.equals(getPrimaryNumber(), that.getPrimaryNumber()) && Objects.equals(getPrimaryEmail(), that.getPrimaryEmail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getPrimaryAddress(), getPrimaryNumber(), getPrimaryEmail());
	}

	@Override
	public String toString() {
		return "contact_information{" +
				"id=" + id +
				", record_type=" + recordType +
				", primary_address=" + primaryAddress +
				", primary_number=" + primaryNumber +
				", primary_email=" + primaryEmail +
				'}';
	}
}
