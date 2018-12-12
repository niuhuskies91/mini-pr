package com.ai.mini.pr;

import java.util.ArrayList;
import java.util.List;

import com.ai.mini.pr.dto.Mrn;
import com.ai.mini.pr.dto.PatientAddress;
import com.ai.mini.pr.dto.PatientDemographics;
import com.ai.mini.pr.dto.PatientName;
import com.ai.mini.pr.dto.PatientRecord;
import com.ai.mini.pr.dto.PatientTelecom;
import com.ai.mini.pr.model.Address;
import com.ai.mini.pr.model.Demographics;
import com.ai.mini.pr.model.Name;
import com.ai.mini.pr.model.RelationshipByEid;
import com.ai.mini.pr.model.Telecom;
import com.ai.mini.pr.util.DateUtil;

public class MiniPrTest {
	
	// standard constants
	
	public static final Long ID    = new Long(1);
	
	// Enterprise Ids
	
	public static final Long EID_1 = new Long(10000000001L);
	public static final Long EID_2 = new Long(10000000002L);
	
	// Local Ids
	
	public static final String SOURCE_SYSTEM_1 = "ABC";
	public static final String SOURCE_SYSTEM_2 = "XYZ";
	
	public static final String MRN_SYS1_1 = "ABC1000001";
	public static final String MRN_SYS2_1 = "XYZ1000001";
	
	public static final String MRN_SYS1_2 = "ABC1000002";
	public static final String MRN_SYS2_2 = "XYZ1000002";
	
	// Name constants
	
	public static final String LAST_NAME_1   = "Doe";
	public static final String FIRST_NAME_1  = "John";
	public static final String MIDDLE_NAME_1 = "C";
	public static final String SUFFIX_1      = "Jr";
	public static final String TITLE_1       = "Mr";
	public static final String NAME_TYPE_1   = "L";
	
	public static final String LAST_NAME_2   = "Doe";
	public static final String FIRST_NAME_2  = "Jane";
	public static final String NAME_TYPE_2   = "L";
	
	// Demographics constants
	
	public static final String DOB_1            = "19690604";
	public static final String DOD_1            = "20090604";
	public static final String GENDER_1         = "M";
	public static final String RACE_1           = "2106-3";
	public static final String MARITAL_STATUS_1 = "M";
	public static final String RELIGION_1       = "ATH";
	public static final String SSN_1            = "999-99-9999";
	public static final String DEATH_FLAG_1     = "Y";
	
	public static final String DOB_2            = "19990709";
	public static final String GENDER_2         = "F";
	public static final String RACE_2           = "2106-3";
	public static final String MARITAL_STATUS_2 = "S";
	public static final String RELIGION_2       = "ATH";
	public static final String SSN_2            = "999-99-9999";
	public static final String DEATH_FLAG_2     = "N";
	
	// Telecom constants
	
	public static final String TELECOM_USE_PRN    = "PRN";
	public static final String TELECOM_TYPE_PH    = "PH";
	public static final String TELECOM_TYPE_EMAIL = "Internet";
	
	public static final String TELECOM_VALUE_PH_1 = "5555551001";
	public static final String TELECOM_EMAIL_1    = "john.doe@whoami.net";
	
	public static final String TELECOM_VALUE_PH_2 = "5555555555";
	public static final String TELECOM_EMAIL_2    = "jane.doe@whitehouse.gov";
	
	// Address constants
	
	public static final String ADDR_ADDRESS_LINE_1_1 = "1060 W Addison St";
	public static final String ADDR_ADDRESS_LINE_2_1 = "Suite 100";
	public static final String ADDR_CITY_1           = "Chicago";
	public static final String ADDR_STATE_1          = "IL";
	public static final String ADDR_POSTAL_CODE_1    = "60613";
	public static final String ADDR_COUNTRY_1        = "USA";
	public static final String ADDR_TYPE_1           = "H";
	public static final String ADDR_COUNTY_1         = "Cook";
	
	public static final String ADDR_ADDRESS_LINE_1_2 = "1600 Pennsylvania Ave";
	public static final String ADDR_ADDRESS_LINE_2_2 = "Oval Office";
	public static final String ADDR_CITY_2           = "Washington";
	public static final String ADDR_STATE_2          = "DC";
	public static final String ADDR_POSTAL_CODE_2    = "20500";
	public static final String ADDR_COUNTRY_2        = "USA";
	public static final String ADDR_TYPE_2           = "H";
	
	/**
	 * *************************
	 *     Model (DB) data
	 * *************************
	 */
	
	public static List<Address> buildModelAddress() {
		List<Address> addresses = new ArrayList<Address>();
		
		Address address = new Address();
		address.setId(ID);
		address.setEid(EID_1);
		address.setAddressLine1(ADDR_ADDRESS_LINE_1_1);
		address.setAddressLine2(ADDR_ADDRESS_LINE_2_1);
		address.setCity(ADDR_CITY_1);
		address.setCountry(ADDR_COUNTRY_1);
		address.setCounty(ADDR_COUNTY_1);
		address.setEid(EID_1);
		address.setPostalCode(ADDR_POSTAL_CODE_1);
		address.setState(ADDR_STATE_1);
		address.setType(ADDR_TYPE_1);
		addresses.add(address);
		
		return addresses;
	}
	
	public static List<Name> buildModelName() {
		List<Name> names = new ArrayList<Name>();
		
		Name name = new Name();
		name.setId(ID);
		name.setEid(EID_1);
		name.setFirstName(FIRST_NAME_1);
		name.setLastName(LAST_NAME_1);
		name.setMiddleName(MIDDLE_NAME_1);
		name.setSuffix(SUFFIX_1);
		name.setTitle(TITLE_1);
		name.setTypeCode(NAME_TYPE_1);
		names.add(name);
		
		return names;
	}
	
	public static List<Telecom> buildModelTelecom() {
		List<Telecom> telecoms = new ArrayList<Telecom>();
		
		Telecom telecom = new Telecom();
		telecom.setId(ID);
		telecom.setEid(EID_1);
		telecom.setTypeCode(TELECOM_TYPE_PH);
		telecom.setUseCode(TELECOM_USE_PRN);
		telecom.setValue(TELECOM_VALUE_PH_1);
		telecoms.add(telecom);
		
		telecom = new Telecom();
		telecom.setId(ID);
		telecom.setEid(EID_1);
		telecom.setTypeCode(TELECOM_TYPE_EMAIL);
		telecom.setUseCode(TELECOM_USE_PRN);
		telecom.setValue(TELECOM_EMAIL_1);
		telecoms.add(telecom);
		
		return telecoms;
	}
	
	public static List<RelationshipByEid> buildModelIds() {
		List<RelationshipByEid> ids = new ArrayList<RelationshipByEid>();
		
		RelationshipByEid id = new RelationshipByEid();
		id.setEid(EID_1);
		id.setMrn(MRN_SYS1_1);
		id.setSourceSystem(SOURCE_SYSTEM_1);
		ids.add(id);
		
		id = new RelationshipByEid();
		id.setEid(EID_1);
		id.setMrn(MRN_SYS2_1);
		id.setSourceSystem(SOURCE_SYSTEM_2);
		ids.add(id);
		
		return ids;
	}
	
	public static List<Demographics> buildModelDemographics() {
		List<Demographics> demographicsList = new ArrayList<Demographics>();
		Demographics demos = new Demographics();
		demos.setId(ID);
		demos.setEid(EID_1);
		demos.setDeathInd(DEATH_FLAG_1);
		demos.setDob(DateUtil.convertHL7ToDate(DOB_1));
		demos.setDod(DateUtil.convertHL7ToDate(DOD_1));
		demos.setGender(GENDER_1);
		demos.setMaritalStatus(MARITAL_STATUS_1);
		demos.setRace(RACE_1);
		demos.setReligion(RELIGION_1);
		demos.setSsn(SSN_1);
		demographicsList.add(demos);
		
		return demographicsList;
	}

	/**
	 * *************************
	 *     Model DTO data
	 * *************************
	 */
	
	public static PatientRecord buildPatientRecord() {
		
		PatientRecord record = new PatientRecord();
		
		record.setEid(EID_1);
		
		record.setAddresses(buildPatientAddress());
		record.setMrn(buildMrn());
		record.setPatientDemographics(buildPatientDemographics());
		record.setNames(buildPatientName());
		record.setTelecom(buildPatientTelecom());

		return record;
	}
	
	public static List<PatientAddress> buildPatientAddress() {
		List<PatientAddress> addresses = new ArrayList<>();
		
		PatientAddress address = new PatientAddress();
		address.setAddressLine1(ADDR_ADDRESS_LINE_1_1);
		address.setAddressLine2(ADDR_ADDRESS_LINE_2_1);
		address.setCity(ADDR_CITY_1);
		address.setCountry(ADDR_COUNTRY_1);
		address.setCounty(ADDR_COUNTY_1);
		address.setPostalCode(ADDR_POSTAL_CODE_1);
		address.setState(ADDR_STATE_1);
		address.setType(ADDR_TYPE_1);
		addresses.add(address);
		
		return addresses;
	}
	
	public static List<PatientName> buildPatientName() {
		List<PatientName> names = new ArrayList<PatientName>();
		
		PatientName name = new PatientName();
		name.setFirstName(FIRST_NAME_1);
		name.setLastName(LAST_NAME_1);
		name.setMiddleName(MIDDLE_NAME_1);
		name.setSuffix(SUFFIX_1);
		name.setTitle(TITLE_1);
		name.setTypeCode(NAME_TYPE_1);
		names.add(name);
		
		return names;
	}
	
	public static List<PatientTelecom> buildPatientTelecom() {
		List<PatientTelecom> telecoms = new ArrayList<PatientTelecom>();
		
		PatientTelecom telecom = new PatientTelecom();
		telecom.setTypeCode(TELECOM_TYPE_PH);
		telecom.setUseCode(TELECOM_USE_PRN);
		telecom.setValue(TELECOM_VALUE_PH_1);
		telecoms.add(telecom);
		
		telecom = new PatientTelecom();
		telecom.setTypeCode(TELECOM_TYPE_EMAIL);
		telecom.setUseCode(TELECOM_USE_PRN);
		telecom.setValue(TELECOM_EMAIL_1);
		telecoms.add(telecom);
		
		return telecoms;
	}
	
	public static List<Mrn> buildMrn() {
		List<Mrn> ids = new ArrayList<Mrn>();
		
		Mrn id = new Mrn();
		id.setMrn(MRN_SYS1_1);
		id.setSourceSystem(SOURCE_SYSTEM_1);
		ids.add(id);
		
		id = new Mrn();
		id.setMrn(MRN_SYS2_1);
		id.setSourceSystem(SOURCE_SYSTEM_2);
		ids.add(id);
		
		return ids;
	}
	
	public static PatientDemographics buildPatientDemographics() {
		PatientDemographics demos = new PatientDemographics();
		demos.setDeathFlag(DEATH_FLAG_1);
		demos.setDateOfBirth(DOB_1);
		demos.setDateOfDeath(DOD_1);
		demos.setGender(GENDER_1);
		demos.setMaritalStatus(MARITAL_STATUS_1);
		demos.setRace(RACE_1);
		demos.setReligion(RELIGION_1);
		demos.setSsn(SSN_1);
		
		return demos;
	}
}
