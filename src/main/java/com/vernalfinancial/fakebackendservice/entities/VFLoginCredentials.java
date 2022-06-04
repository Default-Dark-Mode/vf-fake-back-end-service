package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class represents a user's login
 * credentials, including username and
 * password.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
public class VFLoginCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Boolean deactivated;
	@Embedded
	private VFRecordType recordType;
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
		this(null, null);
	}

	/**
	 * The parameterized constructor for the VFLoginCredentials
	 * class is the primary constructor and will be called by
	 * any other constructors in the class.
	 *
	 * @param username        String the username to login with
	 * @param securedPassword String the user's secured password
	 */
	public VFLoginCredentials(String username, String securedPassword) {
		this.recordType = VFRecordType.LoginCredentials;
		this.deactivated = false;
		this.username = username;
		this.securedPassword = securedPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeactivated() {
		return deactivated;
	}

	public void setDeactivated(Boolean deactivated) {
		this.deactivated = deactivated;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecuredPassword() {
		return securedPassword;
	}

	public void setSecuredPassword(String securedPassword) {
		this.securedPassword = securedPassword;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFLoginCredentials that = (VFLoginCredentials) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getDeactivated(), that.getDeactivated()) && getRecordType() == that.getRecordType() && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getSecuredPassword(), that.getSecuredPassword()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getDeactivated(), getRecordType(), getUsername(), getSecuredPassword(), getCreatedAt());
	}

	@Override
	public String toString() {
		return "login_redentials{" +
				"id=" + id +
				", deactivated=" + deactivated +
				", record_type=" + recordType +
				", username='" + username + '\'' +
				", secured_password='" + securedPassword + '\'' +
				", created_at=" + createdAt +
				'}';
	}
}
