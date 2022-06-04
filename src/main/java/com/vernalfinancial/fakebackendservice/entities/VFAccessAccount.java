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
	@Embedded
	private VFRecordType recordType;
	@OneToOne
	private VFLoginCredentials loginCredentials;
	@OneToMany
	private List<VFLoginCredentials> historicalLoginCredentials;
	@OneToOne
	private VFIdentity identity;
	@OneToOne
	private VFContactInformation contactInformation;
	@OneToMany
	private List<VFContactInformation> historicalContactInformation;
	@OneToMany
	private List<VFFinancialAsset> assets;
}
