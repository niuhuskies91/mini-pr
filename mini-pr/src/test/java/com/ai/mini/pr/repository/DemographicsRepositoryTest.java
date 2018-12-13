package com.ai.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.config.RepositoryConfig;
import com.ai.mini.pr.model.Demographics;
import com.ai.mini.pr.util.DateUtil;

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
