package com.vernalfinancial.fakebackendservice.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "name_records")
public class VFNameRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	@ManyToOne
	@JoinColumn(name = "surname_id", nullable = false)
	private VFSurname surname;
	@OneToMany(mappedBy = "nameRecord")
	private Set<VFIdentificationDocumentRecord> identificationDocument;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
