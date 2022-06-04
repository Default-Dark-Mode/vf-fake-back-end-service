package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a natural person as understood
 * by the Vernal Financial systems and persisted in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "people")
public class VFPerson extends VFIdentity {
	@Embedded
	private VFRecordType recordType;
	@ManyToMany
	private List<VFNaturalName> names;
	@NotNull
	private LocalDate dateOfBirth;
	@ManyToMany
	private List<VFNaturalName> associatedNames;

	/**
	 * The default constructor for the VFPerson class
	 * calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFPerson() {
		this(null, null, null);
	}

	/**
	 * The parameterized constructor for the VFPerson
	 * class is the primary constructor and it will be
	 * called by any other constructor in the class.
	 *
	 * @param names           List<VFNaturalNames> the list of the person's names
	 * @param dateOfBirth     LocalDate the person's date of birth
	 * @param associatedNames List<VFNaturalNames> a list of names associated with the person
	 */
	public VFPerson(List<VFNaturalName> names, LocalDate dateOfBirth, List<VFNaturalName> associatedNames) {
		this.recordType = VFRecordType.Person;
		this.names = names;
		this.dateOfBirth = dateOfBirth;
		this.associatedNames = associatedNames;
	}

	@Override
	public VFRecordType getRecordType() {
		return recordType;
	}

	@Override
	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public List<VFNaturalName> getNames() {
		return names;
	}

	public void setNames(List<VFNaturalName> names) {
		this.names = names;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<VFNaturalName> getAssociatedNames() {
		return associatedNames;
	}

	public void setAssociatedNames(List<VFNaturalName> associatedNames) {
		this.associatedNames = associatedNames;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFPerson vfPerson = (VFPerson) o;
		return Objects.equals(getId(), vfPerson.getId()) && Objects.equals(getNames(), vfPerson.getNames()) && Objects.equals(getDateOfBirth(), vfPerson.getDateOfBirth()) && Objects.equals(getAssociatedNames(), vfPerson.getAssociatedNames());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNames(), getDateOfBirth(), getAssociatedNames());
	}

	@Override
	public String toString() {
		return "person{" +
				"id=" + super.getId() +
				", names=" + names +
				", date_of_birth=" + dateOfBirth +
				", associated_names=" + associatedNames +
				'}';
	}
}
