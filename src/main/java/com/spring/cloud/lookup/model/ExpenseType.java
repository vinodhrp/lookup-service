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

@Entity(name= "ExpenseType")
@Table(name = "xpense_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "xp_id")
	private Long xpId;
	
	@Column(name = "lookup_id",nullable=false)
	private Long lookupId;
	
	@Column(name = "xp_cd",nullable=false)
	private String xpCode;
	
	@Column(name = "xp_desc",nullable=false)
	private String xpDesc;
	
	

}
