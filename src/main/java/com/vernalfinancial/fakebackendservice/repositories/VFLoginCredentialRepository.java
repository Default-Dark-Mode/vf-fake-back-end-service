package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFLoginCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing login credentials as
 * understood by Vernal Financial's
 * system and represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "credentials", path = "credentials")
public interface VFLoginCredentialRepository extends JpaRepository<VFLoginCredentials, Integer> {
}
