package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class VFNaturalName {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@OneToMany(mappedBy = "naturalName")
	private Set<VFPersonalName> personalNames;
	@OneToMany(mappedBy = "name")
	private Set<VFSurname> surnames;

	public VFNaturalName() {
		this(VFRecordType.NaturalName, null, null, null, null);
	}
}
