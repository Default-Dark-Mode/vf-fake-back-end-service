package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFAccessAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the repository for
 * accessing VFAccessAccounts.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "access-accounts", path = "access-accounts")
public interface VFAccessAccountRepository extends JpaRepository<VFAccessAccount, Integer> {
}
