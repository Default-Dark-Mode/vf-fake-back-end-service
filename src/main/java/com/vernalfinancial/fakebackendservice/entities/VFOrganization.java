package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFOrganizationType;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represents an organization as
 * understood by Vernal Financial's systems
 * and as persisted in teh database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "organizations")
@Getter
@Setter
public class VFOrganization extends VFIdentity {
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "identitiy_to_organization_join_table",
			joinColumns = {
					@JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "identity_id", referencedColumnName = "id", nullable = false)
			}
	)
	private List<VFOrganizationalName> organizationalNames;
	@Enumerated(value = EnumType.STRING)
	private VFOrganizationType organizationType;

	/**
	 * The default constructor for the VFOrganization
	 * class calls the parameterized constructor with
	 * null values for all the parameters.
	 */
	public VFOrganization() {
		this(VFRecordType.Organization, null, null, null, null, null, null, null, null);
	}

	public VFOrganization(VFRecordType recordType, String id, List<VFOrganization> associatedOrganizations, List<VFPerson> associatedPeople, List<VFFinancialCard> cards, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime modifiedAt, List<VFOrganizationalName> organizationalNames, VFOrganizationType organizationType) {
		super(recordType, id, associatedOrganizations, associatedPeople, cards, createdAt, modifiedAt);
		this.organizationalNames = organizationalNames;
		this.organizationType = organizationType;
	}
}