package com.maplesoft.peopleware.service;

import java.math.BigInteger;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.response.BaseResponse;

/**
 * @author Prince Seth
 * 
 *         Service Interface - includes method to serve the controller request
 */
public interface PeoplewareService {

	/**
	 * @param candidateDTO
	 *            This method pass the candidateDTO parameter of type CandidateDTO
	 *            to DAO layer by mapping into Candidate class and receives the
	 *            saved Candidate detail in response.
	 * @return Serve the controller with reponse of type Base Response (includes
	 *         CandidateDTO )
	 */
	BaseResponse registerCandidate(CandidateDTO candidateDTO);

	/**
	 * Fetch the List of Technical Skills from the DAO layer
	 * 
	 * @return Serve the controller with TechnicalSkill Wrapper of type Base
	 *         Response (includes List of TechnicalSkillDTO )
	 */
	BaseResponse getTechnicalSkillList();

	/**
	 * Fetch the List of Academic Degree from the DAO layer
	 * 
	 * @return Serve the controller with AcademicDegree Wrapper of type Base
	 *         Response (includes List of AcademicDegreeDTO )
	 */
	BaseResponse getAcademicDegreeList();

	/**
	 * Fetch the List of Candidates from the DAO layer
	 * 
	 * @return Serve the controller with Candidate Wrapper of type Base Response
	 *         (includes List of Candidates)
	 */
	BaseResponse getAllCandidates();

	/**
	 * Fetch the List of Job Offers from the DAO layer
	 * 
	 * @return Serve the controller with Job Offer Wrapper of type Base Response
	 *         (includes List of JobOffers )
	 */
	BaseResponse getAllOffers();

	/**
	 * @param jobOfferId
	 *            This method pass the jobOfferId of type BigInteger to the DAO
	 *            layer to fetch the number of qualified candidates for particular
	 *            JobOfferId
	 * @return Serve the controller with Sorted List of Candidates those are
	 *         qualified for the JobOffer based on the technical requirements
	 */
	BaseResponse getQualifiedCandidates(BigInteger jobOfferId);

	/**
	 * @param candidateId
	 *            This method pass the candidateId of type BigInteger to the DAO
	 *            layer to fetch the number of qualified Job Offers for particular
	 *            Candidate
	 * @return Serve the controller with List of Job Offers which are closely
	 *         matched by the candidate requirements and technical skills.
	 * 
	 */
	BaseResponse getCandidateJobOffers(BigInteger candidateId);

	/**
	 * @param jobOfferDTO
	 *            This method pass the jobOfferDTO of type JobOfferDTO to the DAO
	 *            layer to save the Job Offer of particular company and their
	 *            technical requirements
	 * @return
	 */
	BaseResponse postJobOffer(JobOfferDTO jobOfferDTO);

	/**
	 * Fetch the List of Companies from the DAO layer
	 * 
	 * @return Serve the controller with Job Offer Wrapper of type Base Response
	 *         (includes List of Companies )
	 */
	BaseResponse getCompanyList();
}
