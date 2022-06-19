package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "name_records")
@Getter
@Setter
@AllArgsConstructor
public class VFNameRecord {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<VFPersonalName> personalNames;
	@JsonManagedReference
	@ManyToOne
	private VFPersonalName preferredName;
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "nameRecords")
	private Set<VFSurname> surnames;
	@OneToMany(mappedBy = "nameRecord")
	private Set<VFIdentificationDocumentRecord> identificationDocument;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public VFNameRecord() {
		this(VFRecordType.NameRecord, null, null, null, null, null, null, null);
	}
}
