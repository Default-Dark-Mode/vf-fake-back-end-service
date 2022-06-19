package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * This class maps to the representation of a
 * natural name as persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "natural_names")
@Getter
@Setter
@AllArgsConstructor
public class VFNaturalName {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "personal_names_to_natural_names_join_table",
			joinColumns = {
					@JoinColumn(name = "natural_name_id", referencedColumnName = "id", nullable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "personal_name_id", referencedColumnName = "id", nullable = false)
			}
	)
	private Set<VFPersonalName> personalNames;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "surnames_to_natural_names_join_table",
			joinColumns = {
					@JoinColumn(name = "natural_name_id", referencedColumnName = "id", nullable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "surname_id", referencedColumnName = "id", nullable = false)
			}
	)
	private Set<VFSurname> surnames;

	public VFNaturalName() {
		this(VFRecordType.NaturalName, null, null, null, null);
	}
}
