package com.vernalfinancial.fakebackendservice.repositories;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cards", path = "cards")
public interface VFFinancialCardRepository extends JpaRepository<VFFinancialCard, String> {
}
