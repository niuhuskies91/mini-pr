package org.apcffl.mini.pr.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.mapper.PatientRecordMapper;
import org.apcffl.mini.pr.model.Address;
import org.apcffl.mini.pr.model.Demographics;
import org.apcffl.mini.pr.model.Name;
import org.apcffl.mini.pr.model.RelationshipByEid;
import org.apcffl.mini.pr.model.Telecom;
import org.junit.Before;
import org.junit.Test;

public class PatientRecordMapperTest {
	
	private List<Address> addresses;
	private List<Name> names;
	private List<Telecom> telecoms;
	private List<RelationshipByEid> ids;
	private List<Demographics> demographics;
	private Long eid = MiniPrTest.EID_1;
	
	@Before
	public void setUp() {
		addresses = MiniPrTest.buildModelAddress();
		names = MiniPrTest.buildModelName();
		telecoms = MiniPrTest.buildModelTelecom();
		ids = MiniPrTest.buildModelIds();
		demographics = MiniPrTest.buildModelDemographics();
	}

	@Test
	public void testMapMrnNullIds() {
		
		// prepare test data
		
		ids = null;
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		
		assertEquals(result.getMrn().size(), 0);
		
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapMrnEmptyIds() {
		
		// prepare test data
		
		ids = new ArrayList<>();
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		
		assertEquals(result.getMrn().size(), 0);
		
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperNullAddresses() {
		
		// prepare test data
		
		addresses = null;
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		
		assertEquals(result.getAddresses().size(), 0);
		
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperEmptyAddresses() {
		
		// prepare test data
		
		addresses = new ArrayList<>();
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		
		assertEquals(result.getAddresses().size(), 0);
		
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}
	
	@Test
	public void testMapperNullDemographics() {
		
		// prepare test data
		
		demographics = null;
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		
		assertEquals(result.getPatientDemographics().getDateOfBirth(), null);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), null);
		assertEquals(result.getPatientDemographics().getDeathFlag(), null);
		assertEquals(result.getPatientDemographics().getGender(), null);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), null);
		assertEquals(result.getPatientDemographics().getRace(), null);
		assertEquals(result.getPatientDemographics().getReligion(), null);
		assertEquals(result.getPatientDemographics().getSsn(), null);
		
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperNullDOB() {
		
		// prepare test data
		
		demographics.get(0).setDob(null);
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		
		assertEquals(result.getPatientDemographics().getDateOfBirth(), null);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperNullDOD() {
		
		// prepare test data
		
		demographics.get(0).setDod(null);
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), null);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperNullNames() {
		
		// prepare test data
		
		names = null;
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		
		assertEquals(result.getNames().size(), 0);
		
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperEmptyNames() {
		
		// prepare test data
		
		names = new ArrayList<>();
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		
		assertEquals(result.getNames().size(), 0);
		
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

	@Test
	public void testMapperNullTelecom() {
		
		// prepare test data
		
		telecoms = null;
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		
		assertEquals(result.getTelecom().size(), 0);
	}

	@Test
	public void testMapperEmptyTelecom() {
		
		// prepare test data
		
		telecoms = new ArrayList<>();
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		
		assertEquals(result.getTelecom().size(), 0);
	}
	
	@Test
	public void testMapper() {
		
		// invoke mapper
		
		PatientRecord result = 
				PatientRecordMapper.mapPatientRecord(addresses, demographics, names, telecoms, eid, ids);
		
		// verify results
		
		assertEquals(result.getEid(), MiniPrTest.EID_1);
		assertEquals(result.getMrn().size(), 2);
		assertEquals(result.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(result.getAddresses().size(), 1);
		assertEquals(result.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(result.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(result.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(result.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(result.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(result.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(result.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(result.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(result.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
		assertEquals(result.getNames().size(), 1);
		assertEquals(result.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(result.getTelecom().size(), 2);
		assertEquals(result.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}
}
