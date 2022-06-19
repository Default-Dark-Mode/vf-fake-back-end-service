package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository
 * for accessing financial transactions as
 * understood by Vernal Financial's system
 * and represented in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface VFFinancialTransactionRepository extends JpaRepository<VFFinancialTransaction, Integer> {
}
