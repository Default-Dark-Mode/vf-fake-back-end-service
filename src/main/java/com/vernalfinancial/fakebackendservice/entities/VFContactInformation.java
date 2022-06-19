package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
@Getter
@Setter
@AllArgsConstructor
public class VFContactInformation {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonManagedReference
	@ManyToOne
	private VFAddress primaryAddress;
	@JsonManagedReference
	@ManyToOne
	private VFPhone primaryNumber;
	@JsonManagedReference
	@ManyToOne
	private VFEmail primaryEmail;
	@JsonManagedReference
	@ManyToOne
	private VFAccessAccount accessAccount;

	public VFContactInformation() {
		this(VFRecordType.ContactInformation, null, null, null, null, null);
	}
}
