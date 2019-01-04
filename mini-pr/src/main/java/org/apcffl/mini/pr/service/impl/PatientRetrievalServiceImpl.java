package org.apcffl.mini.pr.service.impl;

import java.util.List;
import java.util.Optional;

import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.dto.PdqResponse;
import org.apcffl.mini.pr.exception.DataNotFoundException;
import org.apcffl.mini.pr.mapper.PatientRecordMapper;
import org.apcffl.mini.pr.model.Address;
import org.apcffl.mini.pr.model.Demographics;
import org.apcffl.mini.pr.model.Name;
import org.apcffl.mini.pr.model.RelationshipByEid;
import org.apcffl.mini.pr.model.RelationshipByMrn;
import org.apcffl.mini.pr.model.RelationshipByMrnIdentity;
import org.apcffl.mini.pr.model.Telecom;
import org.apcffl.mini.pr.repository.AddressRepository;
import org.apcffl.mini.pr.repository.DemographicsRepository;
import org.apcffl.mini.pr.repository.NameRepository;
import org.apcffl.mini.pr.repository.RelationshpByEidRepository;
import org.apcffl.mini.pr.repository.RelationshpByMrnRepository;
import org.apcffl.mini.pr.repository.TelecomRepository;
import org.apcffl.mini.pr.service.PatientRetrievalService;
import org.apcffl.mini.pr.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
