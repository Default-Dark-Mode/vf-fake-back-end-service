package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * This class represents a physical address
 * as understood by the Vernal Financial
 * systems and persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFAddress {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Pattern(regexp = "^\\d+$")
	private Integer number;
	@Pattern(regexp = "^[a-zA-Z-\\s]+$")
	private String street;
	@Pattern(regexp = "^[a-zA-Z-\\s]+$")
	private String city;
	private String county;
	@Pattern(regexp = "^[A-Z]{2}$")
	private String state;
	@Pattern(regexp = "^[A-Z].[a-zA-Z]+([a-zA-Z-\\s]*)$")
	private String country;
	@Pattern(regexp = "^\\d{5}(-\\d{4})?$")
	private String postalCode;

	public VFAddress() {
		this.recordType = VFRecordType.PhysicalAddress;
	}
}
