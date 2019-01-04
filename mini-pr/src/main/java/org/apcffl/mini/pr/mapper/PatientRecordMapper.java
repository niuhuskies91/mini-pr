package org.apcffl.mini.pr.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apcffl.mini.pr.dto.Mrn;
import org.apcffl.mini.pr.dto.PatientAddress;
import org.apcffl.mini.pr.dto.PatientDemographics;
import org.apcffl.mini.pr.dto.PatientName;
import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.dto.PatientTelecom;
import org.apcffl.mini.pr.model.Address;
import org.apcffl.mini.pr.model.Demographics;
import org.apcffl.mini.pr.model.Name;
import org.apcffl.mini.pr.model.RelationshipByEid;
import org.apcffl.mini.pr.model.Telecom;
import org.apcffl.mini.pr.util.DateUtil;
import org.springframework.util.CollectionUtils;

public class PatientRecordMapper {
	
	private PatientRecordMapper() {}

	public static PatientRecord mapPatientRecord(List<Address> addresses, List<Demographics> demographics, 
			List<Name> names, List<Telecom> telecom, Long eid, List<RelationshipByEid> ids) {
		
		PatientRecord record = new PatientRecord();
		record.setEid(eid);
		record.setMrn(mapMrn(ids));
		record.setAddresses(mapAddress(addresses));
		record.setNames(mapName(names));
		record.setTelecom(mapTelecom(telecom));
		record.setPatientDemographics(mapDemographics(demographics));
		
		return record;
	}
	
	private static List<Mrn> mapMrn(List<RelationshipByEid> ids) {
		List<Mrn> localIds = new ArrayList<Mrn>();
		if (CollectionUtils.isEmpty(ids)) {
			return localIds;
		}
		for (RelationshipByEid id : ids) {
			Mrn localId = new Mrn();
			localId.setMrn(id.getMrn());
			localId.setSourceSystem(id.getSourceSystem());
			localIds.add(localId);
		}
		return localIds;
	}
	
	private static List<PatientAddress> mapAddress(List<Address> addresses) {
		List<PatientAddress> patAddresses = new ArrayList<PatientAddress>();
		if (CollectionUtils.isEmpty(addresses)) {
			return patAddresses;
		}
		for (Address address : addresses) {
			PatientAddress patAddr = new PatientAddress();
			patAddr.setAddressLine1(address.getAddressLine1());
			patAddr.setAddressLine2(address.getAddressLine2());
			patAddr.setCity(address.getCity());
			patAddr.setCountry(address.getCountry());
			patAddr.setCounty(address.getCounty());
			patAddr.setPostalCode(address.getPostalCode());
			patAddr.setState(address.getState());
			patAddr.setType(address.getType());
			patAddresses.add(patAddr);
		}
		return patAddresses;
	}
	
	private static List<PatientName> mapName(List<Name> names) {
		List<PatientName> patNames = new ArrayList<PatientName>();
		if (CollectionUtils.isEmpty(names)) {
			return patNames;
		}
		for (Name name : names) {
			PatientName patName = new PatientName();
			patName.setFirstName(name.getFirstName());
			patName.setLastName(name.getLastName());
			patName.setMiddleName(name.getMiddleName());
			patName.setSuffix(name.getSuffix());
			patName.setTitle(name.getTitle());
			patName.setTypeCode(name.getTypeCode());
			patNames.add(patName);
		}
		return patNames;
	}
	
	private static List<PatientTelecom> mapTelecom(List<Telecom> telecom) {
		List<PatientTelecom> patTelecom = new ArrayList<PatientTelecom>();
		if (CollectionUtils.isEmpty(telecom)) {
			return patTelecom;
		}
		for (Telecom nextTelecom : telecom) {
			PatientTelecom pat = new PatientTelecom();
			pat.setTypeCode(nextTelecom.getTypeCode());
			pat.setUseCode(nextTelecom.getUseCode());
			pat.setValue(nextTelecom.getValue());
			patTelecom.add(pat);
		}
		return patTelecom;
	}
	
	private static PatientDemographics mapDemographics(List<Demographics> demographicsList) {
		PatientDemographics patDemos = new PatientDemographics();
		if (CollectionUtils.isEmpty(demographicsList)) {
			return patDemos;
		}
		Demographics demographics = demographicsList.get(0);
		patDemos.setDateOfBirth( DateUtil.convertSqlDateToHL7(demographics.getDob()) );
		patDemos.setDateOfDeath( DateUtil.convertSqlDateToHL7(demographics.getDod()) );
		patDemos.setDeathFlag(demographics.getDeathInd());
		patDemos.setGender(demographics.getGender());
		patDemos.setMaritalStatus(demographics.getMaritalStatus());
		patDemos.setRace(demographics.getRace());
		patDemos.setReligion(demographics.getReligion());
		patDemos.setSsn(demographics.getSsn());
		
		return patDemos;
	}
}
