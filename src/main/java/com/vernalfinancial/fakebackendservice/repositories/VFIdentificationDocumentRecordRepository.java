package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFIdentificationDocumentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing identification documents as
 * understood by Vernal Financial's system
 * and represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "ids", path = "ids")
public interface VFIdentificationDocumentRecordRepository extends JpaRepository<VFIdentificationDocumentRecord,
		String> {
}
