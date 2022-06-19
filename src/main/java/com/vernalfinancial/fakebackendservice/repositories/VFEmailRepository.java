package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing email addresses as
 * understood by Vernal Financial's system
 * and represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "emails", path = "emails")
public interface VFEmailRepository extends JpaRepository<VFEmail, Integer> {
}
