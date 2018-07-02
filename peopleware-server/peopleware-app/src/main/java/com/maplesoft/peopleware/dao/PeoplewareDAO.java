package com.maplesoft.peopleware.dao;

import java.math.BigInteger;
import java.util.List;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.Company;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.exception.NoRecordFoundException;

/**
 * @author Prince seth
 *
 */
public interface PeoplewareDAO {

	/**
	 * fetch candidate details from DB
	 * 
	 * @param candidate
	 * @return return new saved candidate in response
	 */
	Candidate registerCandidate(Candidate candidate);

	/**
	 * @param candidate
	 * @return It checks for duplicate record of candidate based upon the contact#
	 * @throws DuplicateRecordFoundException
	 * @throws Exception
	 */
	boolean isRegisteredCandidate(Candidate candidate) throws DuplicateRecordFoundException, Exception;

	/**
	 * @return It fetch the list of technical skills from the DB and return it to
	 *         the Service counterpart
	 */
	List<TechnicalSkill> getTechnicalSkillList();

	/**
	 * @return It fetch the list of Academic Degrees from the DB and return it to
	 *         the Service counterpart
	 */
	List<AcademicDegree> getAcademicDegreeList();

	/**
	 * @return It fetch the list of Candidates from the DB and return it to the
	 *         Service counterpart
	 */
	List<Candidate> getAllCandidates();

	/**
	 * @return It fetch the list of Joboffers from the DB and return it to the
	 *         Service counterpart
	 */
	List<JobOffer> getAllJobOffers();

	/**
	 * @param jobOfferDetail
	 * @return It returns the qualiifed candidate for particular job offer
	 */
	List<Candidate> getQualifiedCandidates(JobOffer jobOfferDetail);

	/**
	 * @param jobOfferId
	 * @return
	 * @throws NoRecordFoundException
	 * @throws Exception
	 */
	JobOffer getJobOffer(BigInteger jobOfferId) throws NoRecordFoundException, Exception;

	/**
	 * @param jobOffer
	 * @return Persist the new job offer into the DB
	 */
	JobOffer postJobOffer(JobOffer jobOffer);

	/**
	 * @param candidateId
	 * @return
	 * @throws NoRecordFoundException
	 * @throws Exception
	 */
	Candidate getCandidate(BigInteger candidateId) throws NoRecordFoundException, Exception;

	/**
	 * @param candidateDetail
	 * @return
	 */
	List<JobOffer> getQualifiedJobs(Candidate candidateDetail);

	/**
	 * @return
	 * @throws NoRecordFoundException
	 * @throws Exception
	 */
	List<Company> getCompanyList() throws NoRecordFoundException, Exception;

}
