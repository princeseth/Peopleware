package com.maplesoft.peopleware.beans.dto;

import java.util.List;

public class CandidateWrapper extends BaseDTO{

	private List<CandidateDTO> candidateList;

	public List<CandidateDTO> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<CandidateDTO> candidateList) {
		this.candidateList = candidateList;
	}
}
