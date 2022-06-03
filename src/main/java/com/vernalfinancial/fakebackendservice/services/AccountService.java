package com.vernalfinancial.fakebackendservice.services;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class provides the interface for the
 * AccountService.
 *
 * @author Matthew.Crowell1@gmail.com
 */
public interface AccountService {
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
	Boolean seedAccounts(Integer count);

	/**
	 * This method retrieves all accounts matching the
	 * parameters provided by the user via the Pageable
	 * parameter.
	 *
	 * @param page Pageable representing the page specification
	 * @return the requested page of accounts
	 */
	Page<VFFinancialAsset> getAccounts(Pageable page);
}
