package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

public class CompanyDTO extends BaseDTO {

	private BigInteger id;
	private String name;
	private String contact;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
