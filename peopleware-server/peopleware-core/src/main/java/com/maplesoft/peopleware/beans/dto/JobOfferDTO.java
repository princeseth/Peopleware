package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;
import java.util.Set;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Company;

public class JobOfferDTO extends BaseDTO {

	private BigInteger id;
	private String name;
	private String description;
	private double lowerSalaryRange;
	private double upperSalaryRange;
	private String workingTime;
	private AcademicDegree academicDegree;
	private Set<JobOfferTechnicalSkillDTO> jobTechnicalSkills;
	private Company company;

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

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Set<JobOfferTechnicalSkillDTO> getJobTechnicalSkills() {
		return jobTechnicalSkills;
	}

	public void setJobTechnicalSkills(Set<JobOfferTechnicalSkillDTO> jobTechnicalSkills) {
		this.jobTechnicalSkills = jobTechnicalSkills;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
