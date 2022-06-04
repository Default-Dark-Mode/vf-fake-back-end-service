package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private LocalDateTime modifiedAt;

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
	 * @param associatedPeople        List<VFPerson> the list of associated people
	 */
	public VFIdentity(List<VFOrganization> associatedOrganizations, List<VFPerson> associatedPeople) {
		this.recordType = VFRecordType.Identity;
		this.associatedOrganizations = associatedOrganizations;
		this.associatedPeople = associatedPeople;
		this.createdAt = LocalDateTime.now();
		this.modifiedAt = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFIdentity that = (VFIdentity) o;
		return Objects.equals(getId(), that.getId()) && getRecordType() == that.getRecordType() && Objects.equals(getAssociatedOrganizations(), that.getAssociatedOrganizations()) && Objects.equals(getAssociatedPeople(), that.getAssociatedPeople()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getModifiedAt(), that.getModifiedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getAssociatedOrganizations(), getAssociatedPeople(), getCreatedAt(), getModifiedAt());
	}

	@Override
	public String toString() {
		return "identity{" +
				"id='" + id + '\'' +
				", record_type=" + recordType +
				", associated_organizations=" + associatedOrganizations +
				", associated_people=" + associatedPeople +
				", created_at=" + createdAt +
				", modified_at=" + modifiedAt +
				'}';
	}
}
