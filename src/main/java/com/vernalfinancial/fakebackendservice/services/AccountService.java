package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;

import java.util.List;

public interface AccountService {
	Boolean seedAccounts(Integer count);

	List<VFFinancialAsset> getAccounts();
}
