package com.vernalfinancial.fakebackendservice.controllers;

import com.vernalfinancial.fakebackendservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class manages the routing of traffic and
 * parameters to the appropriate function within
 * the AccountService.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@RestController
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
	@GetMapping(path = "/generator/accounts")
	@ResponseBody
	public ResponseEntity<Boolean> seedAccounts(@RequestParam(name = "count", required = false) Integer count) {
		Boolean result = accountService.seedAccounts(count);
		HttpStatus status;

		if (result) {
			status = HttpStatus.CREATED;
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(result, status);
	}

}
