package com.vernalfinancial.fakebackendservice.controllers;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialAsset;
import com.vernalfinancial.fakebackendservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;

	@GetMapping(path = "/seed")
	public ResponseEntity<Boolean> seedAccounts(@RequestParam(name = "count", required = false)Integer count){
		Boolean result = accountService.seedAccounts(count);
		ResponseEntity<Boolean> response;

		if(result){
			response = new ResponseEntity<>(result, HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<Page<VFFinancialAsset>> getAccounts(Pageable page){
		return new ResponseEntity<>(this.accountService.getAccounts(page), HttpStatus.OK);
	}
}
