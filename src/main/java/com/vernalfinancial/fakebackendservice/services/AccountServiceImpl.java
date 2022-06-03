package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFCheckingAccount;
import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import com.vernalfinancial.fakebackendservice.entities.VFSavingsAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	@Override
	public List<VFFinancialAsset> getAccounts() {
		List<VFFinancialAsset> accounts = new ArrayList<>();
		accounts.add(new VFCheckingAccount());
		accounts.add(new VFSavingsAccount());

		return accounts;
	}
}
