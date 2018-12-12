package com.ai.mini.pr.service;

import com.ai.mini.pr.dto.PdqResponse;

public interface PatientRetrievalService {
	
	public PdqResponse getPatientDemographics(String sourceSystem, String mrn);
}
