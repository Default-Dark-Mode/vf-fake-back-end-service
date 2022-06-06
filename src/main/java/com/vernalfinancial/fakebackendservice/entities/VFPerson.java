package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a natural person as understood
 * by the Vernal Financial systems and persisted in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "people")
public class VFPerson extends VFIdentity {
	private VFRecordType recordType;
	@ManyToOne
	@JoinColumn(name = "name_record_id", nullable = false)
	private VFNameRecord nameRecord;
	@NotNull
	private LocalDate dateOfBirth;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "people_to_associated_names_join_table",
			joinColumns = {
					@JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false, updatable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "name_record_id", referencedColumnName = "id")
			})
	private List<VFNameRecord> associatedNameRecords;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "authorized_users_to_cards_join_table",
			joinColumns = {
					@JoinColumn(name = "identity_id", referencedColumnName = "id", nullable = false, updatable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false, updatable = false)
			})
	private List<VFFinancialCard> authorizedCards;

	/**
	 * The default constructor for the VFPerson class
	 * calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFPerson() {
	}
}
