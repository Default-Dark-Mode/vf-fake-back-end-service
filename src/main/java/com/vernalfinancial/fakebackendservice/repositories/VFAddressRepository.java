package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing addresses as understood by
 * Vernal Financial's system and represented
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses")
public interface VFAddressRepository extends JpaRepository<VFAddress, Integer> {
}
