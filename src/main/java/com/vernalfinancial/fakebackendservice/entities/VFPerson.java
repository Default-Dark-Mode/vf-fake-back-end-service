package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
public class VFPerson extends VFIdentity {
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "name_record_id", nullable = false)
	private VFNameRecord nameRecord;
	@NotNull
	private LocalDate dateOfBirth;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "people_to_associated_names_join_table", joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "name_record_id", referencedColumnName = "id")})
	private List<VFNameRecord> associatedNameRecords;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "authorized_users_to_cards_join_table", joinColumns = {@JoinColumn(name = "identity_id", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false, updatable = false)})
	private List<VFFinancialCard> authorizedCards;

	/**
	 * The default constructor for the VFPerson class
	 * calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFPerson() {
		this(VFRecordType.Person, null, null, null, null, null, null, null, null, null, null);
	}


	/**
	 * The parameterized constructor for the VFPerson class
	 * is the primary constructor and will be called by any
	 * other constructor in the class.
	 *
	 * @param recordType              VFRecordType the type of the record
	 * @param id                      String the person's unique identifier
	 * @param associatedOrganizations Set<VFOrganization> associated organizations
	 * @param associatedPeople        Set<VFPerson> associated people
	 * @param cards                   Set<VFFinancialCards> the person's cards
	 * @param createdAt               LocalDateTime when the record was created
	 * @param modifiedAt              LocalDateTime when the record was modified
	 * @param nameRecord              VFNameRecord the person's name of record
	 * @param dateOfBirth             LocalDate the person's date of birth
	 * @param associatedNameRecords   Set<VFNameRecord> associated name records
	 * @param authorizedCards         Set<VFFinancialCard> the cards the person is authorized to use
	 */
	public VFPerson(VFRecordType recordType, String id, List<VFOrganization> associatedOrganizations, List<VFPerson> associatedPeople, List<VFFinancialCard> cards, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime modifiedAt, VFNameRecord nameRecord, LocalDate dateOfBirth, List<VFNameRecord> associatedNameRecords, List<VFFinancialCard> authorizedCards) {
		super(recordType, id, associatedOrganizations, associatedPeople, cards, createdAt, modifiedAt);
		this.nameRecord = nameRecord;
		this.dateOfBirth = dateOfBirth;
		this.associatedNameRecords = associatedNameRecords;
		this.authorizedCards = authorizedCards;
	}
}
