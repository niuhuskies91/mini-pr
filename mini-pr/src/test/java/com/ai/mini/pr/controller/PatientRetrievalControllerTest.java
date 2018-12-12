package com.ai.mini.pr.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize; 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.dto.PatientRecord;
import com.ai.mini.pr.dto.PdqResponse;
import com.ai.mini.pr.exception.DataNotFoundException;
import com.ai.mini.pr.exception.ServiceException;
import com.ai.mini.pr.service.PatientRetrievalService;

// https://dzone.com/articles/spring-boot-rest-api-unit-testing-with-junits

@RunWith(SpringRunner.class)
@WebMvcTest(value = PatientRetrievalController.class)
public class PatientRetrievalControllerTest {
	
	private static final String REST_URL = "/retrieval";
	private static final String PARAM_NAME_SOURCE = "sourceSystem";
	private static final String PARAM_NAME_MRN = "mrn";
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientRetrievalService service;
	
	@Test
	public void testDataNotFound() throws Exception {
		
		// build the mock service response

		when(service.getPatientDemographics(
				anyString(), 
				anyString()))
		.thenThrow(new DataNotFoundException("error1"));

		// perform the mock REST call
		
		mockMvc.perform(
				get(REST_URL)
				.param(PARAM_NAME_SOURCE, MiniPrTest.SOURCE_SYSTEM_1)
				.param(PARAM_NAME_MRN, MiniPrTest.MRN_SYS1_1)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void testServiceException() throws Exception {
		
		// build the mock service response

		when(service.getPatientDemographics(
				anyString(), 
				anyString()))
		.thenThrow(new ServiceException("error1"));

		// perform the mock REST call
		
		mockMvc.perform(
				get(REST_URL)
				.param(PARAM_NAME_SOURCE, MiniPrTest.SOURCE_SYSTEM_1)
				.param(PARAM_NAME_MRN, MiniPrTest.MRN_SYS1_1)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isInternalServerError());
	}

	@Test
	public void testSuccessfulRetrieval() throws Exception {
		
		// build the mock service response
		
		PdqResponse mockResponse = new PdqResponse();
		PatientRecord mockRecord = MiniPrTest.buildPatientRecord();
		mockResponse.setPatient(mockRecord);
		
		when(service.getPatientDemographics(
				anyString(), 
				anyString()))
		.thenReturn(mockResponse);

		// perform the mock REST call
		
		mockMvc.perform(
				get(REST_URL)
				.param(PARAM_NAME_SOURCE, MiniPrTest.SOURCE_SYSTEM_1)
				.param(PARAM_NAME_MRN, MiniPrTest.MRN_SYS1_1)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.patient", hasSize(1)));
	
		verify(service, times(1)).getPatientDemographics(anyString(), anyString());
	
	}
	
	
	
	
	

}
