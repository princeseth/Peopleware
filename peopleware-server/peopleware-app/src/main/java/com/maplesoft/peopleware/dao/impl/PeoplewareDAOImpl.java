package com.maplesoft.peopleware.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.CandidateTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.Company;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.JobOfferTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;
import com.maplesoft.peopleware.dao.PeoplewareDAO;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.exception.NoRecordFoundException;

@Repository
public class PeoplewareDAOImpl implements PeoplewareDAO {

	private static final Logger LOGGER = Logger.getLogger(PeoplewareDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Candidate registerCandidate(Candidate candidate) {
		LOGGER.info("start executing registerCandidate");
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			BigInteger candidateId = (BigInteger) session.save(candidate);

			for (CandidateTechnicalSkill je : candidate.getCandidateTechnicalSkills()) {
				CandidateTechnicalSkill cts = new CandidateTechnicalSkill();
				if (je.getRating() != null) {
					cts.setRating(je.getRating());
					cts.setTechnicalSkillId(je.getId());
					cts.setCandidateId(candidateId);

					session.save(cts);
				}
			}
			tx.commit();
			LOGGER.info("end executing registerCandidate");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return candidate;
	}

	@Override
	public boolean isRegisteredCandidate(Candidate candidate) throws DuplicateRecordFoundException, Exception {
		LOGGER.info("start executing isRegisteredCandidate");
		Session session = sessionFactory.openSession();
		try {
			// check for duplicate mobile number
			Criteria cr = session.createCriteria(Candidate.class);
			cr.add(Restrictions.eq("contact", candidate.getContact()));
			Candidate candidateGotFromDB = (Candidate) cr.uniqueResult();
			if (candidateGotFromDB != null) {
				throw new DuplicateRecordFoundException("duplicate contact number");
			}
			LOGGER.info("end executing isRegisteredCandidate");
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<AcademicDegree> getAcademicDegreeList() {
		LOGGER.info("start executing getAcademicDegreeList");
		Session session = sessionFactory.openSession();
		List<AcademicDegree> academicDegreeList = new ArrayList<AcademicDegree>();
		try {
			Criteria cr = session.createCriteria(AcademicDegree.class);
			academicDegreeList = cr.list();

			LOGGER.info("end executing getAcademicDegreeList");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return academicDegreeList;
	}

	@Override
	public List<Candidate> getAllCandidates() {
		LOGGER.info("start executing getAllCandidates");
		Session session = sessionFactory.openSession();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			Criteria cr = session.createCriteria(Candidate.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			candidateList = cr.list();

			LOGGER.info("end executing getAllCandidates");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return candidateList;
	}

	@Override
	public List<Candidate> getQualifiedCandidates(JobOffer jobOfferDetail) {
		LOGGER.info("start executing getQualifiedCandidates");
		Session session = sessionFactory.openSession();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		try {

			List<BigInteger> listOfSkills = new ArrayList<BigInteger>();
			Iterator<JobOfferTechnicalSkill> itr = jobOfferDetail.getJobTechnicalSkills().iterator();
			while (itr.hasNext()) {

				listOfSkills.add(itr.next().getTechnicalSkillId());

			}

			Criteria cr = session.createCriteria(Candidate.class, "candidate");

			cr.createAlias("candidateTechnicalSkills", "candidateTechnicalSkills");

			cr.add(Restrictions.between("candidate.minimumSalary", jobOfferDetail.getLowerSalaryRange(),
					jobOfferDetail.getUpperSalaryRange()));
			cr.add(Restrictions.in("candidateTechnicalSkills.technicalSkillId", listOfSkills));
			cr.add(Restrictions.eq("academicDegree", jobOfferDetail.getAcademicDegree()));

			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			candidateList = cr.list();

			LOGGER.info("end executing getQualifiedCandidates");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return candidateList;
	}

	@Override
	public List<JobOffer> getAllJobOffers() {
		LOGGER.info("start executing getAllJobOffers");
		Session session = sessionFactory.openSession();
		List<JobOffer> offerList = new ArrayList<JobOffer>();
		try {
			Criteria cr = session.createCriteria(JobOffer.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			offerList = cr.list();

			LOGGER.info("end executing getAllJobOffers");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return offerList;
	}

	@Override
	public List<TechnicalSkill> getTechnicalSkillList() {

		LOGGER.info("start executing getTechnicalSkillList");
		Session session = sessionFactory.openSession();
		List<TechnicalSkill> technicalSkillList = new ArrayList<TechnicalSkill>();
		try {
			Criteria cr = session.createCriteria(TechnicalSkill.class);
			technicalSkillList = cr.list();

			LOGGER.info("end executing getTechnicalSkillList");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return technicalSkillList;
	}

	@Override
	public JobOffer getJobOffer(BigInteger jobOfferId) throws NoRecordFoundException, Exception {
		LOGGER.info("start executing getJobOffer");
		Session session = sessionFactory.openSession();
		JobOffer jobOffer = null;
		try {
			jobOffer = (JobOffer) session.get(JobOffer.class, jobOfferId);
			if (jobOffer != null) {
				LOGGER.info("end executing getJobOffer");
			} else {
				throw new NoRecordFoundException("invalid JobOffer Id");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return jobOffer;
	}

	@Override
	public JobOffer postJobOffer(JobOffer jobOffer) {
		LOGGER.info("start executing postJobOffer");
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			BigInteger jobOfferId = (BigInteger) session.save(jobOffer);

			for (JobOfferTechnicalSkill je : jobOffer.getJobTechnicalSkills()) {
				JobOfferTechnicalSkill jts = new JobOfferTechnicalSkill();
				if (je.getRating() != null) {
					jts.setRating(je.getRating());
					jts.setJobOfferId(jobOfferId);
					jts.setTechnicalSkillId(je.getId());

					session.save(jts);
				}
			}
			tx.commit();
			LOGGER.info("end executing postJobOffer");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return jobOffer;
	}

	@Override
	public Candidate getCandidate(BigInteger candidateId) throws NoRecordFoundException, Exception {
		LOGGER.info("start executing getCandidate");
		Session session = sessionFactory.openSession();
		Candidate candidate = null;
		try {
			candidate = (Candidate) session.get(Candidate.class, candidateId);
			if (candidate != null) {
				LOGGER.info("end executing getCandidate");
			} else {
				throw new NoRecordFoundException("invalid candidate Id");
			}
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return candidate;
	}

	@Override
	public List<JobOffer> getQualifiedJobs(Candidate candidateDetail) {
		LOGGER.info("start executing getQualifiedJobs");
		Session session = sessionFactory.openSession();
		List<JobOffer> jobOfferList = new ArrayList<JobOffer>();
		try {
			List<BigInteger> listOfSkills = new ArrayList<BigInteger>();
			Iterator<CandidateTechnicalSkill> itr = candidateDetail.getCandidateTechnicalSkills().iterator();
			while (itr.hasNext()) {

				listOfSkills.add(itr.next().getTechnicalSkillId());

			}
			Criteria cr = session.createCriteria(JobOffer.class, "job");

			if (!("BOTH".equals(candidateDetail.getWorkingTime()))) {
				cr.add(Restrictions.eq("job.workingTime", candidateDetail.getWorkingTime()));
			}
			cr.createAlias("jobTechnicalSkills", "jobTechnicalSkills");

			cr.add(Restrictions.gt("job.upperSalaryRange", candidateDetail.getMinimumSalary()));
			cr.add(Restrictions.eq("job.academicDegree", candidateDetail.getAcademicDegree()));
			cr.add(Restrictions.in("jobTechnicalSkills.technicalSkillId", listOfSkills));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			jobOfferList = cr.list();

			LOGGER.info("end executing getQualifiedJobs");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return jobOfferList;
	}

	@Override
	public List<Company> getCompanyList() throws NoRecordFoundException, Exception {
		LOGGER.info("start executing getCompanyList");
		Session session = sessionFactory.openSession();

		List<Company> companyList = new ArrayList<Company>();
		try {
			Criteria cr = session.createCriteria(Company.class);
			companyList = cr.list();

			LOGGER.info("end executing getTechnicalSkillList");

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			session.close();
		}
		return companyList;
	}
}
