package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing contact information as understood
 * by Vernal Financial's system and represented
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface VFContactInformationRepository extends JpaRepository<VFContactInformation, Integer> {
}
