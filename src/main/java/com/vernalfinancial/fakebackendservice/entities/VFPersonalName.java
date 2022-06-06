package com.vernalfinancial.fakebackendservice.entities;

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
@Entity
@Table(name = "personal_names")
public class VFPersonalName {
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
}
