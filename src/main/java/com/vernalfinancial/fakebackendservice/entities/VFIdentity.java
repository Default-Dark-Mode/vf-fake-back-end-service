package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * This class represents the identity of an individual
 * or organization as understood by Vernal Financial
 * and its systems.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "identities")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VFIdentity {
	@Id
	private String id;
	@Embedded
	private VFRecordType recordType;
	@ManyToMany
	private List<VFOrganization> associatedOrganizations;
	@ManyToMany
	private List<VFPerson> associatedPeople;

	/**
	 * The default constructor for the VFIdentity class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFIdentity() {
		this(null, null);
	}

	/**
	 * The parameterized constructor for the VFIdentity
	 * class is the primary constructor and it will be
	 * called by any other constructor in the class.
	 *
	 * @param associatedOrganizations List<VFOrganization> the list of associated organizations
	 * @param associatedPeople List<VFPerson> the list of associated people
	 */
	public VFIdentity(List<VFOrganization> associatedOrganizations, List<VFPerson> associatedPeople) {
		this.recordType = VFRecordType.Identity;
		this.associatedOrganizations = associatedOrganizations;
		this.associatedPeople = associatedPeople;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<VFOrganization> getAssociatedOrganizations() {
		return associatedOrganizations;
	}

	public void setAssociatedOrganizations(List<VFOrganization> associatedOrganizations) {
		this.associatedOrganizations = associatedOrganizations;
	}

	public List<VFPerson> getAssociatedPeople() {
		return associatedPeople;
	}

	public void setAssociatedPeople(List<VFPerson> associatedPeople) {
		this.associatedPeople = associatedPeople;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFIdentity that = (VFIdentity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getAssociatedOrganizations(), that.getAssociatedOrganizations()) && Objects.equals(getAssociatedPeople(), that.getAssociatedPeople());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getAssociatedOrganizations(), getAssociatedPeople());
	}

	@Override
	public String toString() {
		return "identity{" +
				"id=" + id +
				", associated_organizations=" + associatedOrganizations +
				", associated_people=" + associatedPeople +
				'}';
	}
}
