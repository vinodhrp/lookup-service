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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.lookup.model.IncomeType;
import com.spring.cloud.lookup.service.IncomeTypeService;
import com.spring.cloud.lookup.util.ApiCustomMessage;

@RestController
@RequestMapping("income-type-service")
public class IncomeTypeController {
	
	Logger logger = LoggerFactory.getLogger(IncomeTypeController.class);

	@Autowired
	public IncomeTypeService incomeTypeService;

	@RequestMapping(method = RequestMethod.GET, path = "/fetchall")
	public ResponseEntity<?> getAllIncomeTypes() {
		logger.info("===========================");
		List<IncomeType> list = incomeTypeService.getAllIncomeTypes();
		if (list == null || list.size() <= 0) {
			return new ResponseEntity<ApiCustomMessage>(new ApiCustomMessage(HttpStatus.NOT_FOUND, "No Data Found...."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<IncomeType>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveExpenseType(@RequestBody IncomeType incomeType) {
		IncomeType expenseTyp = incomeTypeService.saveIncomeType(incomeType);
		return new ResponseEntity<IncomeType>(expenseTyp, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteall", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUser() {
		logger.info("Fetching & Deleting User");
		incomeTypeService.deleteAllIncomeType();
		return new ResponseEntity<ApiCustomMessage>(new ApiCustomMessage(HttpStatus.OK, "Deleted Successfully...."), HttpStatus.OK);
	}


}
