package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * This class represents a user's login
 * credentials, including username and
 * password.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "login_credentials")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFLoginCredentials {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Boolean deactivated;
	@NotNull
	private String username;
	@NotNull
	@JsonBackReference
	private String securedPassword;
	@NotNull
	private LocalDateTime createdAt;

	/**
	 * The default constructor for the VFLoginCredentials
	 * class calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFLoginCredentials() {
		this(VFRecordType.LoginCredentials, null, null, null, null, null);
	}
}
