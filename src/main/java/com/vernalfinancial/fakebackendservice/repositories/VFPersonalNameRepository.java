package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFPersonalName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing personal names as understood by
 * Vernal Financial's system and represented
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "personal-names", path = "personal-names")
public interface VFPersonalNameRepository extends JpaRepository<VFPersonalName, Integer> {
}
