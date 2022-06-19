package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * This class represents a surname belonging
 * to a family as understood by Vernal
 * Financial's systems and persisted in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "surnames")
@Getter
@Setter
@AllArgsConstructor
public class VFSurname {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private VFNaturalName name;
	private Integer nameOrder;
	@ManyToMany
	private Set<VFNameRecord> nameRecords;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public VFSurname() {
		this(VFRecordType.NaturalName, null, null, null, null, null, null);
	}
}
