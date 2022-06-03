package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
	Boolean seedAccounts(Integer count);

	Page<VFFinancialAsset> getAccounts(Pageable page);
}
