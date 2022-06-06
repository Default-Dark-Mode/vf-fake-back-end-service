package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "name_records")
public class VFNameRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private VFRecordType recordType;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "name_records_to_personal_names_join_table",
		joinColumns = {
			@JoinColumn(name = "name_record_id", referencedColumnName = "id", nullable = false)
		},
		inverseJoinColumns = {
			@JoinColumn(name = "personal_name_id", referencedColumnName = "id", nullable = false)
		}
	)
	private Set<VFPersonalName> personalNames;
	@ManyToOne
	@JoinColumn(name = "preferred_name_id")
	private VFPersonalName preferredName;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "name_records_to_surnames_join_table",
			joinColumns = {
					@JoinColumn(name = "name_record_id", referencedColumnName = "id", nullable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "surname_id", referencedColumnName = "id", nullable = false)
			}
	)
	private Set<VFPersonalName> surnames;
	@OneToMany(mappedBy = "nameRecord")
	private Set<VFIdentificationDocumentRecord> identificationDocument;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
