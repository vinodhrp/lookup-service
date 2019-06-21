package com.spring.cloud.lookup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "IncomeType")
@Table(name = "income_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "income_id")
	private Long incomeId;
	
	@Column(name = "lookup_id",nullable=false)
	private Long lookupId;
	
	@Column(name = "income_cd",nullable=false)
	private String incomeCode;
	
	@Column(name = "income_desc",nullable=false)
	private String incomeDesc;

	public Long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getIncomeCode() {
		return incomeCode;
	}

	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
	}

	public String getIncomeDesc() {
		return incomeDesc;
	}

	public void setIncomeDesc(String incomeDesc) {
		this.incomeDesc = incomeDesc;
	}
	
	

}
