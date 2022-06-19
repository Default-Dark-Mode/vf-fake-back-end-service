package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * This class represents an email address as
 * understood by Vernal Financial's systems
 * and persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "emails")
@Getter
@Setter
@AllArgsConstructor
public class VFEmail {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Boolean verified;
	@NotNull
	private String account;
	@NotNull
	private String domain;
	@NotNull
	private String topLevelDomain;
	@NotNull
	private LocalDateTime createdAt;

	/**
	 * The default constructor for the VFEmail class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFEmail() {
		this(VFRecordType.EmailAddress, null, null, null, null, null, null);
	}

	/**
	 * The single parameter constructor of the VFEmail
	 * class calls the parameterized constructor with
	 * null values and then initializes the email
	 * address fields by extracting each field from
	 * the single String parameter.
	 *
	 * @param emailAddress String the email address
	 */
	public VFEmail(String emailAddress) {
		this(VFRecordType.EmailAddress, null, null, null, null, null, null);
		this.account = emailAddress.split("@", 2)[0];
		this.domain = emailAddress.split("@", 2)[1].split("\\.", 2)[0];
		this.topLevelDomain = emailAddress.split("@", 2)[1].split("\\.", 2)[1];
	}
}
