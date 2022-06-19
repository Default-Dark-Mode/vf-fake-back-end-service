package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * This class represents a telephone number as
 * understood by Vernal Financial's systems and
 * as persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "phone_numbers")
@Getter
@Setter
@AllArgsConstructor
public class VFPhone {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Boolean mobile;
	@Pattern(regexp = "^\\d{1,4}$")
	private String countryCode;
	@Pattern(regexp = "^\\d{3}$")
	private String areaCode;
	@Pattern(regexp = "^\\d{3}$")
	private String prefix;
	@Pattern(regexp = "^\\d{4}$")
	private String line;
	@Pattern(regexp = "^\\d{0,5}$")
	private String extension;

	public VFPhone() {
		this(VFRecordType.PhoneNumber, null, null, null, null, null, null, null);
	}
}
