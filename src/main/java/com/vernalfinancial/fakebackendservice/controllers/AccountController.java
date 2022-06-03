package com.vernalfinancial.fakebackendservice.controllers;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import com.vernalfinancial.fakebackendservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;

	@GetMapping
	public ResponseEntity<List<VFFinancialAsset>> getAccounts(){
		return new ResponseEntity<>(this.accountService.getAccounts(), HttpStatus.OK);
	}
}
