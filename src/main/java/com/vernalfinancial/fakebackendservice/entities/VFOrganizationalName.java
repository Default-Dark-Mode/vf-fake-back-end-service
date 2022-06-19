package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Getter
@Setter
@AllArgsConstructor
public class VFOrganizationalName {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;

	/**
	 * The default constructor for the VFOrganizationalName
	 * class calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFOrganizationalName() {
		this(VFRecordType.OrganizationalName, null, null);
	}
}
