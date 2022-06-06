package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

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
public class VFAccessAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private VFRecordType recordType;
	@OneToOne
	private VFLoginCredentials loginCredentials;
	@OneToMany(fetch = FetchType.LAZY)
	private List<VFLoginCredentials> historicalLoginCredentials;
	@OneToOne
	private VFIdentity identity;
	@OneToOne
	private VFContactInformation contactInformation;
	@OneToMany(fetch = FetchType.LAZY)
	private List<VFContactInformation> historicalContactInformation;
	@OneToMany(fetch = FetchType.LAZY)
	private List<VFFinancialAsset> assets;
	@OneToMany(fetch = FetchType.LAZY)
	private List<VFFinancialCard> cards;
}
