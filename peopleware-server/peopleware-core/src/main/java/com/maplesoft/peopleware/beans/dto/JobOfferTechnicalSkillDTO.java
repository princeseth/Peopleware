package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

public class JobOfferTechnicalSkillDTO extends BaseDTO {
	private BigInteger id;
	private Integer rating;
	private BigInteger technicalSkillId;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public BigInteger getTechnicalSkillId() {
		return technicalSkillId;
	}

	public void setTechnicalSkillId(BigInteger technicalSkillId) {
		this.technicalSkillId = technicalSkillId;
	}
}
