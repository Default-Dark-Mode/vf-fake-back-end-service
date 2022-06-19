package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * This class represents a name given to an
 * individual as understood by Vernal
 * Financial's system and persisted in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "personal_names")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFPersonalName {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "name_id", nullable = false)
	private VFNaturalName naturalName;
	private Integer nameOrder;
	@ManyToMany(mappedBy = "personalNames")
	private Set<VFNameRecord> nameRecords;
	@OneToMany(mappedBy = "preferredName")
	private Set<VFNameRecord> preferredNameRecords;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public VFPersonalName() {
		this(VFRecordType.NaturalName, null, null, null, null, null, null, null);
	}
}
