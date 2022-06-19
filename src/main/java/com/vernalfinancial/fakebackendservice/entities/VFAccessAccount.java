package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents an account granting
 * access to the Vernal Financial applications,
 * including web and mobile, as understood by
 * Vernal Financial's systems and persisted
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "access_accounts")
@Getter
@Setter
@AllArgsConstructor
public class VFAccessAccount {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@JsonIgnore
	@OneToOne
	private VFLoginCredentials loginCredentials;
	@JsonBackReference
	@OneToMany(mappedBy = "accessAccount" , fetch = FetchType.LAZY)
	private List<VFLoginCredentials> historicalLoginCredentials;
	@OneToOne
	private VFIdentity identity;
	@OneToOne
	private VFContactInformation contactInformation;
	@JsonBackReference
	@OneToMany(mappedBy = "accessAccount", fetch = FetchType.LAZY)
	private List<VFContactInformation> historicalContactInformation;
	@JsonBackReference
	@OneToMany(mappedBy = "accessAccount", fetch = FetchType.LAZY)
	private List<VFFinancialAsset> assets;
	@JsonBackReference
	@OneToMany(mappedBy = "accessAccount", fetch = FetchType.LAZY)
	private List<VFFinancialCard> cards;

	public VFAccessAccount() {
		this(VFRecordType.AccessAccount, null, null, null, null, null, null, null, null);
	}
}
