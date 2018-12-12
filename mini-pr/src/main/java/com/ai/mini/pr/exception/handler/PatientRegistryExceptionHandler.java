package com.ai.mini.pr.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ai.mini.pr.dto.PdqResponse;
import com.ai.mini.pr.exception.DataNotFoundException;
import com.ai.mini.pr.exception.ServiceException;

public interface PatientRegistryExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	default ResponseEntity<PdqResponse> handleDataNotFoundException(DataNotFoundException ex) {
		PdqResponse response = new PdqResponse();
		response.setErrors(ex.getMessage());
		return new ResponseEntity<PdqResponse>(response, HttpStatus.I_AM_A_TEAPOT);
	}

	@ExceptionHandler(ServiceException.class)
	default ResponseEntity<PdqResponse> handleServiceException(ServiceException ex) {
		PdqResponse response = new PdqResponse();
		response.setErrors(ex.getMessage());
		return new ResponseEntity<PdqResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	default ResponseEntity<PdqResponse> handleServiceException(Exception ex) {
		PdqResponse response = new PdqResponse();
		response.setErrors(ex.getMessage());
		return new ResponseEntity<PdqResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
