package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;
import java.util.Set;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;

public class CandidateDTO extends BaseDTO {

	private BigInteger id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private double minimumSalary;
	private String workingTime;
	private Set<CandidateTechnicalSkillDTO> candidateTechnicalSkills;
	private AcademicDegree academicDegree;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getMinimumSalary() {
		return minimumSalary;
	}

	public void setMinimumSalary(double minimumSalary) {
		this.minimumSalary = minimumSalary;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public Set<CandidateTechnicalSkillDTO> getCandidateTechnicalSkills() {
		return candidateTechnicalSkills;
	}

	public void setCandidateTechnicalSkills(Set<CandidateTechnicalSkillDTO> candidateTechnicalSkills) {
		this.candidateTechnicalSkills = candidateTechnicalSkills;
	}

	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}

}
