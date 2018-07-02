package com.maplesoft.peopleware.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplesoft.peopleware.beans.dto.AcademicDegreeDTO;
import com.maplesoft.peopleware.beans.dto.AcademicDegreeWrapper;
import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.CandidateWrapper;
import com.maplesoft.peopleware.beans.dto.CompanyDTO;
import com.maplesoft.peopleware.beans.dto.CompanyWrapper;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferWrapper;
import com.maplesoft.peopleware.beans.dto.TechnicalSkillDTO;
import com.maplesoft.peopleware.beans.dto.TechnicalSkillWrapper;
import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.CandidateTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.Company;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.JobOfferTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;
import com.maplesoft.peopleware.dao.PeoplewareDAO;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.response.BaseResponse;
import com.maplesoft.peopleware.service.PeoplewareService;
import com.maplesoft.peopleware.util.PeoplewareConstants;
import com.maplesoft.peopleware.util.SortMap;

/**
 * @author Prince Seth
 * 
 *         The implementation of Service methods which includes the business
 *         logic to serve the cotroller request by fetching details from DAO
 *         layer of the application.
 */
@Service
public class PeoplewareServiceImpl implements PeoplewareService {

	private static final Logger LOGGER = Logger.getLogger(PeoplewareServiceImpl.class);

	@Autowired
	private PeoplewareDAO peoplewareDAO;

	@Override
	public BaseResponse registerCandidate(CandidateDTO candidateDTO) {
		LOGGER.info("start executing registerCandidate");
		ModelMapper mp = new ModelMapper();
		BaseResponse response = new BaseResponse();

		Candidate candidate = null;
		try {
			if (peoplewareDAO.isRegisteredCandidate(mp.map(candidateDTO, Candidate.class))) {
				response.setMessage("Candidate Already Exist");
				response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
				return response;
			}

			candidate = peoplewareDAO.registerCandidate(mp.map(candidateDTO, Candidate.class));
			response.setBaseDTO(mp.map(candidate, CandidateDTO.class));

			response.setMessage("Registered Candidate Successfully");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (DuplicateRecordFoundException e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setMessage("unabe to register candidate");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing registerCandidate");
		return response;
	}

	@Override
	public BaseResponse getAcademicDegreeList() {
		LOGGER.info("start executing getAcademicDegreeList");
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		AcademicDegreeWrapper awp = new AcademicDegreeWrapper();

		try {
			List<AcademicDegree> academicDegreeList = peoplewareDAO.getAcademicDegreeList();
			List<AcademicDegreeDTO> tempList = new ArrayList<AcademicDegreeDTO>();

			Iterator<AcademicDegree> itr = academicDegreeList.iterator();
			while (itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), AcademicDegreeDTO.class));
			}

			awp.setAcademicDegreeList(tempList);
			response.setBaseDTO(awp);
			response.setMessage("Fetch initial form data getAcademicDegreeList");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		return response;
	}

	@Override
	public BaseResponse getAllCandidates() {
		BaseResponse response = new BaseResponse();
		CandidateWrapper cwp = new CandidateWrapper();
		ModelMapper mapper = new ModelMapper();

		try {
			List<Candidate> candidateList = peoplewareDAO.getAllCandidates();
			List<CandidateDTO> tempList = new ArrayList<CandidateDTO>();

			Iterator<Candidate> itr = candidateList.iterator();

			while (itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), CandidateDTO.class));
			}

			cwp.setCandidateList(tempList);
			response.setBaseDTO(cwp);
			response.setMessage("List of Candidate");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}

		return response;
	}

	@Override
	public BaseResponse getAllOffers() {
		BaseResponse response = new BaseResponse();
		JobOfferWrapper jwp = new JobOfferWrapper();
		ModelMapper mapper = new ModelMapper();

		try {
			List<JobOffer> offerList = peoplewareDAO.getAllJobOffers();
			List<JobOfferDTO> tempList = new ArrayList<JobOfferDTO>();

			Iterator<JobOffer> itr = offerList.iterator();

			while (itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), JobOfferDTO.class));
			}

			jwp.setJobOfferList(tempList);
			response.setBaseDTO(jwp);
			response.setMessage("List of Job offers");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}

		return response;
	}

	@Override
	public BaseResponse getTechnicalSkillList() {
		LOGGER.info("start executing getTechnicalSkillList");
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		TechnicalSkillWrapper twp = new TechnicalSkillWrapper();

		try {
			List<TechnicalSkill> technicalSkillList = peoplewareDAO.getTechnicalSkillList();
			List<TechnicalSkillDTO> tempList = new ArrayList<TechnicalSkillDTO>();

			Iterator<TechnicalSkill> itr = technicalSkillList.iterator();
			while (itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), TechnicalSkillDTO.class));
			}

			twp.setTechnicalSkillList(tempList);
			response.setBaseDTO(twp);
			response.setMessage("Fetch initial form data");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing getTechnicalSkillList");
		return response;
	}

	@Override
	public BaseResponse getQualifiedCandidates(BigInteger jobOfferId) {
		LOGGER.info("start executing qualifiedCandidates");
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		CandidateWrapper cwp = new CandidateWrapper();
		List<CandidateDTO> finalList = new ArrayList<CandidateDTO>();

		try {

			JobOffer jobOfferDetail = peoplewareDAO.getJobOffer(jobOfferId);
			List<Candidate> candidateList = peoplewareDAO.getQualifiedCandidates(jobOfferDetail);

			Map<Candidate, Integer> candidateMap = new HashMap<Candidate, Integer>();
			Map<Candidate, Integer> sortedMap = null;

			Map<BigInteger, Integer> jobOfferSkillsMap = new HashMap<BigInteger, Integer>();
			for (JobOfferTechnicalSkill jobOfferSkills : jobOfferDetail.getJobTechnicalSkills()) {
				jobOfferSkillsMap.put(jobOfferSkills.getTechnicalSkillId(), jobOfferSkills.getRating());
			}

			for (Candidate candidate : candidateList) {
				int score = 0;

				for (CandidateTechnicalSkill it : candidate.getCandidateTechnicalSkills()) {
					if (jobOfferSkillsMap.containsKey(it.getTechnicalSkillId())) {
						score += it.getRating();
					}
				}
				candidateMap.put(candidate, score);
			}

			sortedMap = SortMap.sortByValues(candidateMap);

			for (Map.Entry<Candidate, Integer> entry : sortedMap.entrySet()) {
				finalList.add(mapper.map(entry.getKey(), CandidateDTO.class));
			}

			cwp.setCandidateList(finalList);
			response.setBaseDTO(cwp);
			response.setMessage("Qualified Candidates for Job Offer");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing getTechnicalSkillList");
		return response;
	}

	@Override
	public BaseResponse getCandidateJobOffers(BigInteger candidateId) {
		LOGGER.info("start executing candidateJobOffers");
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		JobOfferWrapper jwp = new JobOfferWrapper();
		List<JobOfferDTO> finalList = new ArrayList<JobOfferDTO>();

		try {

			Candidate candidateDetail = peoplewareDAO.getCandidate(candidateId);
			List<JobOffer> jobOfferList = peoplewareDAO.getQualifiedJobs(candidateDetail);

			Iterator<JobOffer> itr = jobOfferList.iterator();
			while (itr.hasNext()) {
				finalList.add(mapper.map(itr.next(), JobOfferDTO.class));
			}

			jwp.setJobOfferList(finalList);
			response.setBaseDTO(jwp);
			response.setMessage("Qualified Jobs for Candidate");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing candidateJobOffers");
		return response;
	}

	@Override
	public BaseResponse postJobOffer(JobOfferDTO jobOfferDTO) {
		LOGGER.info("start executing postJobOffer");
		ModelMapper mp = new ModelMapper();
		BaseResponse response = new BaseResponse();

		JobOffer jobOffer = null;
		try {

			jobOffer = peoplewareDAO.postJobOffer(mp.map(jobOfferDTO, JobOffer.class));
			response.setBaseDTO(mp.map(jobOffer, JobOfferDTO.class));

			response.setMessage("Job Posted successfully");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing postJobOffer");
		return response;
	}

	@Override
	public BaseResponse getCompanyList() {
		LOGGER.info("start executing getCompanyList");
		ModelMapper mapper = new ModelMapper();
		BaseResponse response = new BaseResponse();
		CompanyWrapper cwp = new CompanyWrapper();

		try {
			List<Company> companyList = peoplewareDAO.getCompanyList();
			List<CompanyDTO> tempList = new ArrayList<CompanyDTO>();

			Iterator<Company> itr = companyList.iterator();
			while (itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), CompanyDTO.class));
			}

			cwp.setCompanyList(tempList);
			response.setBaseDTO(cwp);
			response.setMessage("Fetch initial form data");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);

		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing getCompanyList");
		return response;
	}
}
