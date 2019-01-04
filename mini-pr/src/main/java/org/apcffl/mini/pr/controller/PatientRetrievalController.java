package org.apcffl.mini.pr.controller;

import java.util.Date;

import org.apcffl.mini.pr.dto.PdqResponse;
import org.apcffl.mini.pr.exception.handler.PatientRegistryExceptionHandler;
import org.apcffl.mini.pr.service.PatientRetrievalService;
import org.apcffl.mini.pr.util.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Patient Demographics Retrieval Service")
@RestController
@RequestMapping("/retrieval")
public class PatientRetrievalController implements PatientRegistryExceptionHandler {
	
	@Autowired
	PatientRetrievalService service;

	@ApiOperation(value = "Patient Data Query", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, response = PdqResponse.class)
	@RequestMapping(value = "sourceSystem/{sourceSystem}/mrn/{mrn}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PdqResponse> getPatientDemographics( @PathVariable String sourceSystem, @PathVariable String mrn) {
		
		Date startTime = new Date();
		
		PdqResponse response = service.getPatientDemographics(sourceSystem, mrn);
		ResponseEntity<PdqResponse> responseEntity = new ResponseEntity<PdqResponse>(response, HttpStatus.OK);
		
		Date endTime = new Date();
		
		LoggingUtil.logTimeDuration(startTime, endTime);
		
		return responseEntity;
	}

}
