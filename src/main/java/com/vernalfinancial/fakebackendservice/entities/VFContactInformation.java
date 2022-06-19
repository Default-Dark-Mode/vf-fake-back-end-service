package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class VFContactInformation {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private VFAddress primaryAddress;
	@ManyToOne
	private VFPhone primaryNumber;
	@ManyToOne
	private VFEmail primaryEmail;

	public VFContactInformation() {
		this(VFRecordType.ContactInformation, null, null, null, null);
	}
}
