package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

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
public class VFEmail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private VFRecordType recordType;
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
		this(null, null, null);
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
	public VFEmail(String emailAddress){
		this(null, null, null);
		this.account = emailAddress.split("@", 2)[0];
		this.domain = emailAddress.split("@", 2)[1].split("\\.", 2)[0];
		this.topLevelDomain = emailAddress.split("@", 2)[1].split("\\.", 2)[1];
	}

	/**
	 * The parameterized constructor for the VFEmail class
	 * is the primary constructor and will be called by
	 * any other constructor in the class.
	 *
	 * @param account String the account name of the email account
	 * @param domain String the domain name of the email account
	 * @param topLevelDomain String the top level domain of the email account
	 */
	public VFEmail(String account, String domain, String topLevelDomain) {
		this.recordType = VFRecordType.EmailAddress;
		this.verified = false;
		this.account = account;
		this.domain = domain;
		this.topLevelDomain = topLevelDomain;
		this.createdAt = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(String topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
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
		VFEmail vfEmail = (VFEmail) o;
		return Objects.equals(getId(), vfEmail.getId()) && getRecordType() == vfEmail.getRecordType() && Objects.equals(getVerified(), vfEmail.getVerified()) && Objects.equals(getAccount(), vfEmail.getAccount()) && Objects.equals(getDomain(), vfEmail.getDomain()) && Objects.equals(getTopLevelDomain(), vfEmail.getTopLevelDomain()) && Objects.equals(getCreatedAt(), vfEmail.getCreatedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getVerified(), getAccount(), getDomain(), getTopLevelDomain(), getCreatedAt());
	}

	@Override
	public String toString() {
		return "email{" +
				"id=" + id +
				", record_type=" + recordType +
				", verified=" + verified +
				", account='" + account + '\'' +
				", domain='" + domain + '\'' +
				", top_level_domain='" + topLevelDomain + '\'' +
				", created_at=" + createdAt +
				'}';
	}
}
