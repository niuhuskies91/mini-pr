package com.ai.mini.pr.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ai.mini.pr.dto.PatientRecord;
import com.ai.mini.pr.dto.PdqResponse;
import com.ai.mini.pr.exception.DataNotFoundException;
import com.ai.mini.pr.mapper.PatientRecordMapper;
import com.ai.mini.pr.model.Address;
import com.ai.mini.pr.model.Demographics;
import com.ai.mini.pr.model.Name;
import com.ai.mini.pr.model.RelationshipByEid;
import com.ai.mini.pr.model.RelationshipByMrn;
import com.ai.mini.pr.model.RelationshipByMrnIdentity;
import com.ai.mini.pr.model.Telecom;
import com.ai.mini.pr.repository.AddressRepository;
import com.ai.mini.pr.repository.DemographicsRepository;
import com.ai.mini.pr.repository.NameRepository;
import com.ai.mini.pr.repository.RelationshpByEidRepository;
import com.ai.mini.pr.repository.RelationshpByMrnRepository;
import com.ai.mini.pr.repository.TelecomRepository;
import com.ai.mini.pr.service.PatientRetrievalService;
import com.ai.mini.pr.util.LoggingUtil;

@Service
public class PatientRetrievalServiceImpl implements PatientRetrievalService {

	private static final Logger LOG = LoggerFactory.getLogger(PatientRetrievalServiceImpl.class);
	
	@Autowired
	RelationshpByMrnRepository mrnRelationshipRepository;
	
	@Autowired
	RelationshpByEidRepository eidRelationshipRepository;
	
	@Autowired
	NameRepository nameRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	TelecomRepository telecomRepository;
	
	@Autowired
	DemographicsRepository demographicsRepository;
	
	@Override
	public PdqResponse getPatientDemographics(String sourceSystem, String mrn) {

		// retrieve the EID and associated MRN
		Long eid = retrieveEid(mrn, sourceSystem);
		List<RelationshipByEid> mrnList = retrieveMrn(eid);
		
		// retrieve patient names associated with the EID
		List<Name> names = nameRepository.findByEid(eid);
		
		// retrieve patient addresses associated with the EID
		List<Address> addresses = addressRepository.findByEid(eid);
		
		// retrieve all telecom (phone and/or email) associated with the EID
		List<Telecom> telecom = telecomRepository.findByEid(eid);
		
		// retrieve basic patient demographics associated with the EID
		List<Demographics> demographics = demographicsRepository.findByEid(eid);
		
		// map all row DB data into the patient record
		PatientRecord record = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecom, eid, mrnList);
		
		LoggingUtil.logPatientRecord(record, mrn, sourceSystem);
		
		PdqResponse response = new PdqResponse();
		response.setPatient(record);
		return response;
	}

	private Long retrieveEid(String mrn, String sourceSystem) {
		
		// retrieve the EID associated with the MRN / source system
		Optional<RelationshipByMrn> relationship = 
				mrnRelationshipRepository.findById(new RelationshipByMrnIdentity(mrn, sourceSystem));
		
		// if the relationship is not found throw an exception. Otherwise return the EID
		if (!relationship.isPresent()) {
			String error = "There is no MRN/EID relationship found for mrn: " + mrn +
					", sourceSystem: " + sourceSystem;
			LOG.error(error);
			throw new DataNotFoundException(error);
		} else {
			return relationship.get().getEid();
		}
	}
	
	private List<RelationshipByEid> retrieveMrn(Long eid) {
		
		// retrieve all MRN associated to the EID
		List<RelationshipByEid> mrn =
				eidRelationshipRepository.findAllByIdentityEid(eid);
		
		// if the relationship is not found throw an exception. Otherwise return the MRN
		if (CollectionUtils.isEmpty(mrn)) {
			String error = "There is no MRN/EID relationship found for eid: " + eid;
			LOG.error(error);
			throw new DataNotFoundException(error);
		} else {
			return mrn;
		}
	}
	
}
