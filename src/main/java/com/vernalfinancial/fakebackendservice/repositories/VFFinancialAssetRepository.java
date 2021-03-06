package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface provides the interface for the
 * repository used to access all account types
 * simultaneously.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface VFFinancialAssetRepository extends JpaRepository<VFFinancialAsset, String> {
}