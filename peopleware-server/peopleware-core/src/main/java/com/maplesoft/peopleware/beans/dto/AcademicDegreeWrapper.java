package com.maplesoft.peopleware.beans.dto;

import java.util.List;

public class AcademicDegreeWrapper extends BaseDTO {

		private List<AcademicDegreeDTO> academicDegreeList;

		public List<AcademicDegreeDTO> getAcademicDegreeList() {
			return academicDegreeList;
		}

		public void setAcademicDegreeList(List<AcademicDegreeDTO> academicDegreeList) {
			this.academicDegreeList = academicDegreeList;
		}
}
