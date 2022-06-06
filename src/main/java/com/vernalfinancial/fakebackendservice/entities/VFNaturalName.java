package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 * This class maps to the representation of a
 * natural name as persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "natural_names")
public class VFNaturalName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	private VFRecordType recordType;
	@OneToMany(mappedBy = "naturalName")
	private Set<VFPersonalName> personalNames;
	@OneToMany(mappedBy = "name")
	private Set<VFSurname> surnames;

	/**
	 * The default constructor for the VFNaturalName
	 * class calls the parameterized constructor with
	 * null values for all the parameters.
	 */
	public VFNaturalName() {
		this(null, null, null);
	}

	/**
	 * The parameterized constructor for the VFNaturalName
	 * class is the primary constructor and will be called
	 * by any other constructor in the class.
	 *
	 * @param name String the natural name
	 */
	public VFNaturalName(String name, Set<VFPersonalName> personalNames, Set<VFSurname> surnames) {
		this.recordType = VFRecordType.PersonalName;
		this.personalNames = personalNames;
		this.surnames = surnames;
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
}
