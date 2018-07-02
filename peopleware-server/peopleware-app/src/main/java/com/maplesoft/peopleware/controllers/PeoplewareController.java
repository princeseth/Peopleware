package com.maplesoft.peopleware.controllers;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.response.BaseResponse;
import com.maplesoft.peopleware.service.PeoplewareService;

/**
 * @author Prince Seth
 *
 *         Controller - Entry point for all request (POST|GET).
 */
@Controller
public class PeoplewareController {

	private static final Logger LOGGER = Logger.getLogger(PeoplewareController.class);

	@Autowired
	private PeoplewareService peoplewareService;

	/**
	 * POST Request
	 * 
	 * @param candidateDTO
	 *            Request body of format CandidateDTO will be accpeted to register
	 *            Candidate.
	 * @return Base Response will be returned which includes registered candidate of
	 *         the format CandidateDTO.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse registerCandidate(@RequestBody CandidateDTO candidateDTO) {
		LOGGER.info("inside registerCandidate");
		return peoplewareService.registerCandidate(candidateDTO);
	}

	/**
	 * GET Request
	 * 
	 * @return Base Response will be returned of format AcademicDegreeWrapper which
	 *         includes the list of AcademicDegreeDTO (AcademicDegrees) from DB.
	 */
	@RequestMapping(value = "/getAcademicDegreeList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getAcademicDegreeList() {
		LOGGER.info("inside registerForm");
		return peoplewareService.getAcademicDegreeList();
	}

	/**
	 * GET Request
	 * 
	 * @return Base Response will be returned of format TechnicalSkillWrapper which
	 *         includes the list of TechnicalSkillDTO (TechnicalSkills) from DB.
	 */
	@RequestMapping(value = "/getTechnicalSkillList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getTechnicalSkillList() {
		LOGGER.info("inside getTechnicalSkillList");
		return peoplewareService.getTechnicalSkillList();
	}

	/**
	 * GET Request
	 * 
	 * @return Base Response will be returned of format CandidateWrapper which
	 *         includes the list of CandidateDTO (Candidates) from DB.
	 */
	@RequestMapping(value = "/listAllCandidates", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse listAllCandidates() {
		LOGGER.info("inside listAllCandidates");
		return peoplewareService.getAllCandidates();
	}

	/**
	 * GET Request
	 * 
	 * @return Base Response will be returned of format CompanyWrapper which
	 *         includes the list of CompanyDTO (Companies) from DB.
	 */
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getCompanyList() {
		LOGGER.info("inside getCompanyList");
		return peoplewareService.getCompanyList();
	}

	/**
	 * GET Request
	 * 
	 * @return Base Response will be returned of format JobOfferWrapper which
	 *         includes the list of JobOfferDTO (JobOffers) from DB.
	 */
	@RequestMapping(value = "/listAlloffers", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse listAlloffers() {
		LOGGER.info("inside listAlloffers");
		return peoplewareService.getAllOffers();
	}

	/**
	 * POST Request
	 * 
	 * @param jobOfferDTO
	 *            Request body of format JobOfferDTO will be accpeted to post
	 *            Companies JobOffer
	 * @return Base Response will be returned which includes JobOffer which get
	 *         registered of the format JobOfferDTO.
	 */
	@RequestMapping(value = "/postJobOffer", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse postJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
		LOGGER.info("inside postJobOffer");
		return peoplewareService.postJobOffer(jobOfferDTO);
	}

	/**
	 * GET Request
	 * 
	 * @param jobOfferId
	 *            Request Paramater of type BigInteger (i.e. jobOfferId) will be
	 *            accpeted to fetch qualified candidates for particular JobOffer
	 * @return
	 */
	@RequestMapping(value = "/qualifiedCandidates", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse qualifiedCandidates(@RequestParam("jobOfferId") BigInteger jobOfferId) {
		LOGGER.info("inside qualifiedCandidates");
		return peoplewareService.getQualifiedCandidates(jobOfferId);
	}

	/**
	 * GET Request
	 * 
	 * @param candidateId
	 *            Request Paramater of type BigInteger (i.e. candidateId) will be
	 *            accpeted to fetch qualified JobOffers for particular Candidate
	 * @return
	 */
	@RequestMapping(value = "/candidateJobOffers", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse candidateJobOffers(@RequestParam("candidateId") BigInteger candidateId) {
		LOGGER.info("inside candidateJobOffers");
		return peoplewareService.getCandidateJobOffers(candidateId);
	}

}
