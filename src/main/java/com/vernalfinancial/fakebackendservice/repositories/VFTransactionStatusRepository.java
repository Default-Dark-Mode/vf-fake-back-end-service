package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFTransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing transaction statuses as understood
 * by Vernal Financial's system and represented
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "transaction-statuses", path = "transaction-statuses")
public interface VFTransactionStatusRepository extends JpaRepository<VFTransactionStatus, Integer> {
}
