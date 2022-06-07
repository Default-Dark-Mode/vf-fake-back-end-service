package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFSavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * This interface provides the interface for the
 * repository that allows access to savings
 * accounts.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "savings_accounts", path = "savings_accounts")
public interface VFSavingsAccountRepository extends JpaRepository<VFSavingsAccount, String> {
}