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

@Entity(name= "SuggestionType")
@Table(name = "suggestion_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sugges_id")
	private Long suggesId;
	
	@Column(name = "lookup_id",nullable=false)
	private Long lookupId;
	
	@Column(name = "type_cd",nullable=false)
	private String typeCode;
	
	@Column(name = "type_desc",nullable=false)
	private String typeDesc;
	
	@Column(name = "usr_id",nullable=false)
	private Long userId;

	public Long getSuggesId() {
		return suggesId;
	}

	public void setSuggesId(Long suggesId) {
		this.suggesId = suggesId;
	}

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
