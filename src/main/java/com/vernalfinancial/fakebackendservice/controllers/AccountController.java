package com.vernalfinancial.fakebackendservice.controllers;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import com.vernalfinancial.fakebackendservice.services.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class manages the routing of traffic and
 * parameters to the appropriate function within
 * the AccountService.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RestController
@RequestMapping(path = "/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;

	/**
	 * This method seed the database with the specified
	 * or a random number of accounts, randomly made
	 * either a SavingsAccount or a CheckingAccount.
	 *
	 * @param count Integer the number of accounts to seed
	 * @return ResponseEntity<Boolean> response entity and success indicator
	 */
	@GetMapping(path = "/seed")
	public ResponseEntity<Boolean> seedAccounts(@RequestParam(name = "count", required = false) Integer count) {
		Boolean result = accountService.seedAccounts(count);
		ResponseEntity<Boolean> response;

		if (result) {
			response = new ResponseEntity<>(result, HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	/**
	 * This method receives get requests at the /accounts
	 * path and returns a page of accounts.
	 *
	 * @param page Pageable page request specifications
	 * @return ResponseEntity<Page < VFFinancialAsset>> results
	 */
	@GetMapping
	@PageableAsQueryParam
	public ResponseEntity<Page<VFFinancialAsset>> getAccounts(@Parameter(hidden = true) Pageable page) {
		return new ResponseEntity<>(this.accountService.getAccounts(page), HttpStatus.OK);
	}
}
