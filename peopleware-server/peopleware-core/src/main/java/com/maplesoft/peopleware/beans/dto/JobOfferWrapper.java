package com.maplesoft.peopleware.beans.dto;

import java.util.List;

public class JobOfferWrapper extends BaseDTO{

	private List<JobOfferDTO> jobOfferList;

	public List<JobOfferDTO> getJobOfferList() {
		return jobOfferList;
	}

	public void setJobOfferList(List<JobOfferDTO> jobOfferList) {
		this.jobOfferList = jobOfferList;
	}
}
