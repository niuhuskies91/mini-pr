package org.apcffl.mini.pr.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.controller.PatientRetrievalController;
import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.dto.PdqResponse;
import org.apcffl.mini.pr.exception.DataNotFoundException;
import org.apcffl.mini.pr.exception.ServiceException;
import org.apcffl.mini.pr.service.PatientRetrievalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PatientRetrievalController.class)
public class PatientRetrievalControllerTest {
	
	private static final String REST_URL = "/retrieval/sourceSystem/{sourceSystem}/mrn/{mrn}";
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientRetrievalService service;
 
    @Before
    public void setUp() {
    }
	
	@Test
	public void testDataNotFound() throws Exception {
		
		// build the mock service response

		when(service.getPatientDemographics(
				anyString(), 
				anyString()))
		.thenThrow(new DataNotFoundException("error1"));

		// perform the mock REST call
		
		mockMvc.perform(
				get(REST_URL, MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isIAmATeapot());
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
				get(REST_URL, MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testOtherException() throws Exception {
		
		// build the mock service response

		when(service.getPatientDemographics(
				anyString(), 
				anyString()))
		.thenThrow(new NullPointerException("error1"));

		// perform the mock REST call
		
		mockMvc.perform(
				get(REST_URL, MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1)
				.accept(MediaType.APPLICATION_JSON))
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
		
		
		MvcResult result = 
			mockMvc.perform(
				get(REST_URL, MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();

		// verify results
		
		verify(service, times(1)).getPatientDemographics(anyString(), anyString());

		String pdqResponse = result.getResponse().getContentAsString();
		assertTrue(pdqResponse.contains("\"eid\":" + MiniPrTest.EID_1));
		assertTrue(pdqResponse.contains("\"mrn\":\"" + MiniPrTest.MRN_SYS1_1 + "\""));
		assertTrue(pdqResponse.contains("\"sourceSystem\":\"" + MiniPrTest.SOURCE_SYSTEM_1 + "\""));
		assertTrue(pdqResponse.contains("\"mrn\":\"" + MiniPrTest.MRN_SYS2_1 + "\""));
		assertTrue(pdqResponse.contains("\"sourceSystem\":\"" + MiniPrTest.SOURCE_SYSTEM_1 + "\""));
		assertTrue(pdqResponse.contains("\"lastName\":\"" + MiniPrTest.LAST_NAME_1 + "\""));
		assertTrue(pdqResponse.contains("\"firstName\":\"" + MiniPrTest.FIRST_NAME_1 + "\""));
	}
}
