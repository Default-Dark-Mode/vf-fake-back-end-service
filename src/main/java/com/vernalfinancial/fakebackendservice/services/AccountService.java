package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;

import java.util.List;

public interface AccountService {
	List<VFFinancialAsset> getAccounts();
//	List<VFAccount> getAccounts();
}
