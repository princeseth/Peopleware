package com.maplesoft.peopleware.beans.dto;

import java.util.List;

public class TechnicalSkillWrapper extends TechnicalSkillDTO {

	private List<TechnicalSkillDTO> technicalSkillList;

	public List<TechnicalSkillDTO> getTechnicalSkillList() {
		return technicalSkillList;
	}

	public void setTechnicalSkillList(List<TechnicalSkillDTO> technicalSkillList) {
		this.technicalSkillList = technicalSkillList;
	}
}
