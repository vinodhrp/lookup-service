/*******************************************************************************
 * Copyright (c) 1994 - 2019  Vinod Inc & Co.
 * All rights reserved. 
 * This computer software is owned by Vinod Inc & Co.  
 * and is protected by german copyright laws and other laws and by international
 * treaties. This computer software is furnished by Vinod Inc & Co.,
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice.  This
 * computer software or any other copies thereof may not be provided or
 * otherwise made available to any other person.
 * -----------------------------------------------------------------------------
 * $Id: $
 * -----------------------------------------------------------------------------
 *******************************************************************************/
/**
 * @author veebee
 */
package com.spring.cloud.lookup.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.lookup.model.ExpenseType;
import com.spring.cloud.lookup.pojo.UserDetail;
import com.spring.cloud.lookup.service.ExpenseTypeService;
import com.spring.cloud.lookup.util.ApiCustomMessage;

@RestController
@RequestMapping("xpense-type-service")
public class ExpenseTypeController {

	Logger logger = LoggerFactory.getLogger(ExpenseTypeController.class);

	@Autowired
	public ExpenseTypeService expenseTypeService;
	
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/fetchausers", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetail>> listAllUsers() {
		String userURL = "http://service-user-io/user-service/fetchall";
		//ResponseEntity<List<UserDetail>> users = restTemplate.getForObject(userURL, ResponseEntity.class);

		ResponseEntity<List<UserDetail>> response = restTemplate.exchange(userURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDetail>>() {
		});

		List<UserDetail> users = response.getBody();
		for (UserDetail userDetail : users) {
			System.out.println("======================" +userDetail.getEmail());
		}
		//System.out.println(users);
		return new ResponseEntity<List<UserDetail>>(users, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/fetchall")
	public ResponseEntity<?> getAllExpenseTypes() {
		logger.info("===========================");
		List<ExpenseType> list = expenseTypeService.getAllExpenseTypes();
		if (list == null || list.size() <= 0) {
			return new ResponseEntity<ApiCustomMessage>(new ApiCustomMessage(HttpStatus.NOT_FOUND, "No Data Found...."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ExpenseType>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveExpenseType(@RequestBody ExpenseType expenseType) {
		ExpenseType expenseTyp = expenseTypeService.saveExpenseType(expenseType);
		return new ResponseEntity<ExpenseType>(expenseTyp, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/deleteall", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUser() {
		logger.info("Fetching & Deleting User");
		expenseTypeService.deleteAllExpenseType();
		return new ResponseEntity<ApiCustomMessage>(new ApiCustomMessage(HttpStatus.OK, "Deleted Successfully...."), HttpStatus.OK);
	}

}
