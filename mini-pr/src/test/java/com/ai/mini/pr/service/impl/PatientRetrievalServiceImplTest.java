package com.ai.mini.pr.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.dto.PatientRecord;
import com.ai.mini.pr.dto.PdqResponse;
import com.ai.mini.pr.exception.DataNotFoundException;
import com.ai.mini.pr.model.Address;
import com.ai.mini.pr.model.Demographics;
import com.ai.mini.pr.model.Name;
import com.ai.mini.pr.model.RelationshipByEid;
import com.ai.mini.pr.model.RelationshipByMrn;
import com.ai.mini.pr.model.Telecom;
import com.ai.mini.pr.repository.AddressRepository;
import com.ai.mini.pr.repository.DemographicsRepository;
import com.ai.mini.pr.repository.NameRepository;
import com.ai.mini.pr.repository.RelationshpByEidRepository;
import com.ai.mini.pr.repository.RelationshpByMrnRepository;
import com.ai.mini.pr.repository.TelecomRepository;

public class PatientRetrievalServiceImplTest {

	@InjectMocks
	private PatientRetrievalServiceImpl service;
	
	@Mock
	private RelationshpByMrnRepository mrnRelationshipRepository;
	
	@Mock
	private RelationshpByEidRepository eidRelationshipRepository;
	
	@Mock
	private NameRepository nameRepository;
	
	@Mock
	private AddressRepository addressRepository;
	
	@Mock
	private TelecomRepository telecomRepository;
	
	@Mock
	private DemographicsRepository demographicsRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = com.ai.mini.pr.exception.DataNotFoundException.class)
	public void testGetPatientDemographicsEidNotFound() {
		
		// prepare test data
		
		RelationshipByMrn mockEidRelation = new RelationshipByMrn();
		mockEidRelation.setEid(MiniPrTest.EID_1);
		Optional<RelationshipByMrn> mockEid = Optional.empty();
		
		when(mrnRelationshipRepository.findById(any()))
		.thenReturn(mockEid);
		
		// invoke service
		
		service.getPatientDemographics(MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1);
	}
	
	@Test(expected = com.ai.mini.pr.exception.DataNotFoundException.class)
	public void testGetPatientDemographicsMrnNull() {
		
		// prepare test data
		
		RelationshipByMrn mockEidRelation = new RelationshipByMrn();
		mockEidRelation.setEid(MiniPrTest.EID_1);
		Optional<RelationshipByMrn> mockEid = Optional.of(mockEidRelation);
		
		when(mrnRelationshipRepository.findById(any()))
		.thenReturn(mockEid);
		
		when(eidRelationshipRepository.findAllByIdentityEid(any()))
		.thenReturn(null);
		
		// invoke service
		
		service.getPatientDemographics(MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1);
	}
	
	@Test(expected = com.ai.mini.pr.exception.DataNotFoundException.class)
	public void testGetPatientDemographicsMrnEmpty() {
		
		// prepare test data
		
		RelationshipByMrn mockEidRelation = new RelationshipByMrn();
		mockEidRelation.setEid(MiniPrTest.EID_1);
		Optional<RelationshipByMrn> mockEid = Optional.of(mockEidRelation);
		
		when(mrnRelationshipRepository.findById(any()))
		.thenReturn(mockEid);
		
		when(eidRelationshipRepository.findAllByIdentityEid(any()))
		.thenReturn(new ArrayList<>());
		
		// invoke service
		
		service.getPatientDemographics(MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1);
	}
	
	@Test
	public void testGetPatientDemographics() {
		
		// prepare test data
		
		RelationshipByMrn mockEidRelation = new RelationshipByMrn();
		mockEidRelation.setEid(MiniPrTest.EID_1);
		Optional<RelationshipByMrn> mockEid = Optional.ofNullable(mockEidRelation);
		
		List<RelationshipByEid> mockMrnList = MiniPrTest.buildModelIds();
		List<Name> mockNameList = MiniPrTest.buildModelName();
		List<Address> mockAddressList = MiniPrTest.buildModelAddress();
		List<Telecom> mockTelecomList = MiniPrTest.buildModelTelecom();
		List<Demographics> mockDemographicsList = MiniPrTest.buildModelDemographics();
		
		when(mrnRelationshipRepository.findById(any()))
		.thenReturn(mockEid);
		
		when(eidRelationshipRepository.findAllByIdentityEid(any()))
		.thenReturn(mockMrnList);
		
		when(nameRepository.findByEid(anyLong()))
		.thenReturn(mockNameList);
		
		when(addressRepository.findByEid(anyLong()))
		.thenReturn(mockAddressList);
		
		when(telecomRepository.findByEid(anyLong()))
		.thenReturn(mockTelecomList);
		
		when(demographicsRepository.findByEid(anyLong()))
		.thenReturn(mockDemographicsList);
		
		// invoke service
		
		PdqResponse results = service.getPatientDemographics(MiniPrTest.SOURCE_SYSTEM_1, MiniPrTest.MRN_SYS1_1);
		
		// verify results
		
		assertEquals(results.getErrors(), null);
		
		PatientRecord record = results.getPatient();
		assertEquals(record.getEid(), MiniPrTest.EID_1);
		assertEquals(record.getAddresses().size(), 1);
		assertEquals(record.getAddresses().get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(record.getAddresses().get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(record.getAddresses().get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(record.getAddresses().get(0).getCountry(), MiniPrTest.ADDR_COUNTRY_1);
		assertEquals(record.getAddresses().get(0).getCounty(), MiniPrTest.ADDR_COUNTY_1);
		assertEquals(record.getAddresses().get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
		assertEquals(record.getAddresses().get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(record.getAddresses().get(0).getType(), MiniPrTest.ADDR_TYPE_1);
		assertEquals(record.getMrn().size(), 2);
		assertEquals(record.getMrn().get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(record.getMrn().get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(record.getMrn().get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(record.getMrn().get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
		assertEquals(record.getNames().size(), 1);
		assertEquals(record.getNames().get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(record.getNames().get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(record.getNames().get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(record.getNames().get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(record.getNames().get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(record.getNames().get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
		assertEquals(record.getTelecom().size(), 2);
		assertEquals(record.getTelecom().get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(record.getTelecom().get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(record.getTelecom().get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(record.getTelecom().get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(record.getTelecom().get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(record.getTelecom().get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
		assertEquals(record.getPatientDemographics().getDateOfBirth(), MiniPrTest.DOB_1);
		assertEquals(record.getPatientDemographics().getDateOfDeath(), MiniPrTest.DOD_1);
		assertEquals(record.getPatientDemographics().getDeathFlag(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(record.getPatientDemographics().getGender(), MiniPrTest.GENDER_1);
		assertEquals(record.getPatientDemographics().getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(record.getPatientDemographics().getRace(), MiniPrTest.RACE_1);
		assertEquals(record.getPatientDemographics().getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(record.getPatientDemographics().getSsn(), MiniPrTest.SSN_1);
	}
}
