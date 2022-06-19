package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing surnames as understood by
 * Vernal Financial's system and
 * represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "surnames", path = "surnames")
public interface VFSurnameRepository extends JpaRepository<VFSurname, Integer> {
}
