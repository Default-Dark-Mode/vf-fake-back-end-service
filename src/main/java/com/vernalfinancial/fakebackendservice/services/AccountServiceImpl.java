package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFCheckingAccount;
import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import com.vernalfinancial.fakebackendservice.entities.VFSavingsAccount;
import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.repositories.VFCheckingAccountRepository;
import com.vernalfinancial.fakebackendservice.repositories.VFFinancialAssetRepository;
import com.vernalfinancial.fakebackendservice.repositories.VFSavingsAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
	private final VFCheckingAccountRepository checkingAccountRepository;
	private final VFFinancialAssetRepository financialAssetRepository;
	private final VFSavingsAccountRepository savingsAccountRepository;

	/**
	 * This method is used to seed the database with either
	 * the specified number of accounts (with a random
	 * percentage being Checking and the rest being Savings
	 * Accounts.  The number of accounts to seed can be
	 * specified as an argument.
	 *
	 * @param count Integer the number of accounts to seed
	 * @return Boolean whether the seeding was successful
	 */
	@Override
	public Boolean seedAccounts(Integer count){
		Boolean isSuccessful = false;

		Random randomNumberGenerator = new Random();
		if(count == null){
			count = randomNumberGenerator.nextInt(1000);
		}

		try{
			for (int i = 1; i <= count; i++) {
				int accountType = randomNumberGenerator.nextInt(2);
				if (accountType == 0){
					VFSavingsAccount account = new VFSavingsAccount(generateUUID(), new VFBalance(false, 0, 0), false,
							LocalDateTime.now(), LocalDateTime.now(), 0, new VFBalance(false, 0, 0),
							new VFMonetaryValue(0, 0));
					this.savingsAccountRepository.save(account);
				} else {
					VFCheckingAccount account = new VFCheckingAccount(generateUUID(), new VFBalance(false, 0, 0), false,
							LocalDateTime.now(),
							LocalDateTime.now(), new VFBalance(false, 50, 0), new VFMonetaryValue(30, 0));
					this.checkingAccountRepository.save(account);
				}

				isSuccessful = true;
			}
		} catch(Exception e) {
			log.debug(e.getMessage());
		}

		return isSuccessful;
	}

	@Override
	public List<VFFinancialAsset> getAccounts() {
		return this.financialAssetRepository.findAll();
	}

	private String generateUUID(){
		String id = UUID.randomUUID().toString();

		if(financialAssetRepository.findById(id).isPresent()){
			id = generateUUID();
		}

		return id;
	}
}
