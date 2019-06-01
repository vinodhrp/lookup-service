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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.lookup.model.LookupType;
import com.spring.cloud.lookup.service.LookupTypeService;
import com.spring.cloud.lookup.util.ApiCustomMessage;

@RestController
@RequestMapping("lookup-type-service")
public class LookupTypeController {
	
	@Autowired
	private LookupTypeService lookupTypeService;
	
	@RequestMapping(method=RequestMethod.POST, value="/savelookuptype")
	public ResponseEntity<?> saveLookupType(@RequestBody LookupType lookupType){
		if(lookupType == null) {
			return new ResponseEntity<ApiCustomMessage>(new ApiCustomMessage(),HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<LookupType>(lookupTypeService.saveLookupType(lookupType),HttpStatus.ACCEPTED);
	}

}
