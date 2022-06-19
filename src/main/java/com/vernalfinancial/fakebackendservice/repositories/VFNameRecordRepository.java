package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFNameRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing name records as understood
 * by Vernal Financial's system and
 * represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "names", path = "names")
public interface VFNameRecordRepository extends JpaRepository<VFNameRecord, Integer> {
}
