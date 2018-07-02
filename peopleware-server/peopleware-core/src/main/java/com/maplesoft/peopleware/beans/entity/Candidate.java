package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pwr_candidate")
public class Candidate {

	@Id
	@Column(name = "candidate_id", columnDefinition = "bigint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String contact;
	@Column(name = "minimum_salary")
	private double minimumSalary;
	@Column(name = "working_time")
	private String workingTime;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_degree_id")
	private AcademicDegree academicDegree;

	@OneToMany(mappedBy = "candidateId", fetch = FetchType.EAGER)
	private Set<CandidateTechnicalSkill> candidateTechnicalSkills = new HashSet<CandidateTechnicalSkill>();

	public Candidate() {
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

	public boolean isRegisteredCandidate(Candidate candidate) {

		return false;
	}

	public Set<CandidateTechnicalSkill> getCandidateTechnicalSkills() {
		return candidateTechnicalSkills;
	}

	public void setCandidateTechnicalSkills(Set<CandidateTechnicalSkill> candidateTechnicalSkills) {
		this.candidateTechnicalSkills = candidateTechnicalSkills;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contact=" + contact + ", minimumSalary=" + minimumSalary + ", workingTime=" + workingTime
				+ ", academicDegree=" + academicDegree + ", candidateTechnicalSkills=" + candidateTechnicalSkills + "]";
	}

}
