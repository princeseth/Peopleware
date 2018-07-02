package com.maplesoft.peopleware.beans.dto;

import java.util.List;

public class CompanyWrapper extends BaseDTO {
	private List<CompanyDTO> companyList;

	public List<CompanyDTO> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyDTO> companyList) {
		this.companyList = companyList;
	}

	
}
