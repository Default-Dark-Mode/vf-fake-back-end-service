package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing phone numbers as
 * understood by Vernal Financial's
 * system and represented in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")
public interface VFPhoneRepository extends JpaRepository<VFPhone, Integer> {
}
