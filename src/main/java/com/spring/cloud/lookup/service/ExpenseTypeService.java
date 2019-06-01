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
package com.spring.cloud.lookup.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.lookup.config.HibernateSession;
import com.spring.cloud.lookup.model.ExpenseType;

@Service
@Transactional
public class ExpenseTypeService {

	@Autowired
	HibernateSession hibernateSession;

	public List<ExpenseType> getAllExpenseTypes() {
		Session session = hibernateSession.hibernateSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ExpenseType> expenseQuery = criteriaBuilder.createQuery(ExpenseType.class);
		Root<ExpenseType> rootExp = expenseQuery.from(ExpenseType.class);
		expenseQuery.select(rootExp);
		Query<ExpenseType> qryList = session.createQuery(expenseQuery);
		return qryList.getResultList();
	}
	
	public ExpenseType saveExpenseType(ExpenseType expenseType) {
		Session session = hibernateSession.hibernateSession();
		session.saveOrUpdate(expenseType);
		return expenseType;
	}
	
	
	public void deleteAllExpenseType() {
		Session session = hibernateSession.hibernateSession();
		List<ExpenseType> delList = getAllExpenseTypes();
		for (ExpenseType expenseType : delList) {
			session.delete(expenseType);
		}
		
	}
	

}
