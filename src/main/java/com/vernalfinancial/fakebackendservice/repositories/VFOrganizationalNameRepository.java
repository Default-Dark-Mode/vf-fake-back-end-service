package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFOrganizationalName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing organizational names as understood
 * by Vernal Financial's system and represented
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "organization-names", path = "organization-names")
public interface VFOrganizationalNameRepository extends JpaRepository<VFOrganizationalName, Integer> {
}
