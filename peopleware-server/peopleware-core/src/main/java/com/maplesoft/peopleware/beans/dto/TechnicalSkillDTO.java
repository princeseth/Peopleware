package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

public class TechnicalSkillDTO extends BaseDTO {
	private BigInteger id;
	private String name;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
