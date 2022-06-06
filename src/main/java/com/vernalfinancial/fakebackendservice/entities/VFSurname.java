package com.vernalfinancial.fakebackendservice.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "surnames")
public class VFSurname {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "name_id", nullable = false)
	private VFNaturalName name;
	@OneToMany(mappedBy = "id")
	private Set<VFSurname> surnames;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
