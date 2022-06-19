package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represents the identity of an individual
 * or organization as understood by Vernal Financial
 * and its systems.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "identities")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@Builder
public abstract class VFIdentity {
	private final VFRecordType recordType;
	@Id
	private String id;
	@ManyToMany
	private List<VFOrganization> associatedOrganizations;
	@ManyToMany
	private List<VFPerson> associatedPeople;
	@OneToMany
	private List<VFFinancialCard> cards;
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private LocalDateTime modifiedAt;

	/**
	 * The default constructor for the VFIdentity class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFIdentity() {
		this(VFRecordType.Identity, null, null, null, null, null, null);
	}
}
