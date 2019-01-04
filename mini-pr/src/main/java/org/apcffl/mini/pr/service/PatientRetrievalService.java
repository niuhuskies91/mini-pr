package org.apcffl.mini.pr.service;

import org.apcffl.mini.pr.dto.PdqResponse;

public interface PatientRetrievalService {
	
	public PdqResponse getPatientDemographics(String sourceSystem, String mrn);
}
