package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFNaturalName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing a natural name as understood
 * by Vernal Financial's system and
 * represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "natural-names", path = "natural-names")
public interface VFNaturalNameRepository extends JpaRepository<VFNaturalName, Integer> {
}
