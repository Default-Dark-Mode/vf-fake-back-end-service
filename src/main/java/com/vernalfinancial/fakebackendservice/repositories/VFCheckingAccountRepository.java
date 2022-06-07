package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFCheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * This interface provides the interface for
 * the checking account repository.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "checking_accounts", path = "checking_accounts")
public interface VFCheckingAccountRepository extends JpaRepository<VFCheckingAccount, String> {
}
