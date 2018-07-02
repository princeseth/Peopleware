package com.maplesoft.peopleware.response;

import java.io.Serializable;

import com.maplesoft.peopleware.beans.dto.BaseDTO;

public class BaseResponse implements Serializable {

	private String status;
	private String errorMessage;
	private String message;
	private BaseDTO baseDTO;

	public BaseDTO getBaseDTO() {
		return baseDTO;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public void setBaseDTO(BaseDTO baseDTO) {
		this.baseDTO = baseDTO;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
