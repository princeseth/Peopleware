package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pwr_candidate_technical_skill")
public class CandidateTechnicalSkill {

	@Id
	@Column(name = "can_techskill_id", columnDefinition = "bigint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "candidate_id", columnDefinition = "bigint")
	private BigInteger candidateId;

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

	public BigInteger getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(BigInteger candidateId) {
		this.candidateId = candidateId;
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