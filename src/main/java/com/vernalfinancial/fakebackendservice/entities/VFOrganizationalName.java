package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * This class represents the name of an organization,
 * whether corporate, governmental, religious, or
 * otherwise, as persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "organizational_names")
public class VFOrganizationalName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	private VFRecordType recordType;

	/**
	 * The default constructor for the VFOrganizationalName
	 * class calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFOrganizationalName() {
		this(null);
	}

	/**
	 * The parameterized constructor for the VFOrganizationalName
	 * class is the primary constructor and will be called by any
	 * other constructor in the class.
	 *
	 * @param name String the organization's name
	 */
	public VFOrganizationalName(String name) {
		this.recordType = VFRecordType.OrganizationalName;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFOrganizationalName that = (VFOrganizationalName) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && getRecordType() == that.getRecordType();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getRecordType());
	}

	@Override
	public String toString() {
		return "organizational_name{" +
				"id=" + id +
				", name='" + name + '\'' +
				", record_type=" + recordType +
				'}';
	}
}
