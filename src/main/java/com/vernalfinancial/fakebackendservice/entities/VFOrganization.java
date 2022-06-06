package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFOrganizationType;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * This class represents an organization as
 * understood by Vernal Financial's systems
 * and as persisted in teh database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "organizations")
public class VFOrganization extends VFIdentity {
	private VFRecordType recordType;
	@ManyToMany
	private List<VFOrganizationalName> organizationalNames;
	@Embedded
	private VFOrganizationType organizationType;

	/**
	 * The default constructor for the VFOrganization
	 * class calls the parameterized constructor with
	 * null values for all the parameters.
	 */
	public VFOrganization() {
		this(null, null);
	}

	/**
	 * The parameterized constructor for the VFOrganization
	 * class it the primary constructor and will be called
	 * by any other constructor in the class.
	 *
	 * @param organizationalNames List<VFOrganizationalName> the list of the organization's names
	 * @param organizationType VFOrganizationType the type of the organization
	 */
	public VFOrganization(List<VFOrganizationalName> organizationalNames, VFOrganizationType organizationType) {
		super();
		this.recordType = VFRecordType.Organization;
		this.organizationalNames = organizationalNames;
		this.organizationType = organizationType;
	}

	public List<VFOrganizationalName> getOrganizationalNames() {
		return organizationalNames;
	}

	public void setOrganizationalNames(List<VFOrganizationalName> organizationalNames) {
		this.organizationalNames = organizationalNames;
	}

	public VFOrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(VFOrganizationType organizationType) {
		this.organizationType = organizationType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		VFOrganization that = (VFOrganization) o;
		return Objects.equals(getId(), that.getId()) && recordType == that.recordType && Objects.equals(getOrganizationalNames(), that.getOrganizationalNames()) && getOrganizationType() == that.getOrganizationType();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), recordType, getOrganizationalNames(), getOrganizationType());
	}

	@Override
	public String toString() {
		return "organization{" +
				" record_type=" + recordType +
				", organizational_names=" + organizationalNames +
				", organization_type=" + organizationType +
				'}';
	}
}