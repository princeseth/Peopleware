package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pwr_job_offer")
public class JobOffer {

	@Id
	@Column(name = "job_offer_id", columnDefinition = "bigint")
	@GeneratedValue
	private BigInteger id;

	private String name;
	private String description;
	private double lowerSalaryRange;
	private double upperSalaryRange;
	private String workingTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_degree_id")
	private AcademicDegree academicDegree;

	@OneToMany(mappedBy = "jobOfferId", fetch = FetchType.EAGER)
	private Set<JobOfferTechnicalSkill> jobTechnicalSkills = new HashSet<JobOfferTechnicalSkill>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLowerSalaryRange() {
		return lowerSalaryRange;
	}

	public void setLowerSalaryRange(double lowerSalaryRange) {
		this.lowerSalaryRange = lowerSalaryRange;
	}

	public double getUpperSalaryRange() {
		return upperSalaryRange;
	}

	public void setUpperSalaryRange(double upperSalaryRange) {
		this.upperSalaryRange = upperSalaryRange;
	}

	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}

	public Set<JobOfferTechnicalSkill> getJobTechnicalSkills() {
		return jobTechnicalSkills;
	}

	public void setJobtechnicalSkills(Set<JobOfferTechnicalSkill> jobTechnicalSkills) {
		this.jobTechnicalSkills = jobTechnicalSkills;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
