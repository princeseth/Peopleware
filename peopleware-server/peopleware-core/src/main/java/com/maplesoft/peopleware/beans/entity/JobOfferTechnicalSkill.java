package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pwr_job_offer_technical_skill")
public class JobOfferTechnicalSkill {

	@Id
	@Column(name = "job_offer_techskill_id", columnDefinition = "bigint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "job_offer_id", columnDefinition = "bigint")
	private BigInteger jobOfferId;

	@Column(name = "technical_skill_id", columnDefinition = "bigint")
	private BigInteger technicalSkillId;

	@Column(name = "rating")
	private Integer rating;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getJobOfferId() {
		return jobOfferId;
	}

	public void setJobOfferId(BigInteger jobOfferId) {
		this.jobOfferId = jobOfferId;
	}

	public BigInteger getTechnicalSkillId() {
		return technicalSkillId;
	}

	public void setTechnicalSkillId(BigInteger technicalSkillId) {
		this.technicalSkillId = technicalSkillId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
