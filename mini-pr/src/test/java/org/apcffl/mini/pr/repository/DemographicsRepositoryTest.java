package org.apcffl.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.config.RepositoryConfig;
import org.apcffl.mini.pr.model.Demographics;
import org.apcffl.mini.pr.repository.DemographicsRepository;
import org.apcffl.mini.pr.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class DemographicsRepositoryTest {
    
	@Autowired
	private DemographicsRepository repo;
	
	@Test
	public void testFindByEid() {
		
		List<Demographics> result = repo.findByEid(MiniPrTest.EID_1);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getDeathInd(), MiniPrTest.DEATH_FLAG_1);
		assertEquals(DateUtil.convertSqlDateToHL7(result.get(0).getDob()), MiniPrTest.DOB_1);
		assertEquals(DateUtil.convertSqlDateToHL7(result.get(0).getDod()), MiniPrTest.DOD_1);
		assertEquals(result.get(0).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(0).getGender(), MiniPrTest.GENDER_1);
		assertEquals(result.get(0).getMaritalStatus(), MiniPrTest.MARITAL_STATUS_1);
		assertEquals(result.get(0).getRace(), MiniPrTest.RACE_1);
		assertEquals(result.get(0).getReligion(), MiniPrTest.RELIGION_1);
		assertEquals(result.get(0).getSsn(), MiniPrTest.SSN_1);
	}

}
