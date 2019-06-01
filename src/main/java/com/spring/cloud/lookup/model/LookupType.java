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

@Entity(name= "LookupType")
@Table(name = "lookup_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LookupType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lookup_id")
	private Long lookupId;
	
	@Column(name = "lookup_desc",nullable=false)
	private String typeDesc;

}
