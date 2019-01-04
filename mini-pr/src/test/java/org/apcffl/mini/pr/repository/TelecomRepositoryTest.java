package org.apcffl.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.config.RepositoryConfig;
import org.apcffl.mini.pr.model.Telecom;
import org.apcffl.mini.pr.repository.TelecomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class TelecomRepositoryTest {
    
	@Autowired
	TelecomRepository repo;
	
	@Test
	public void testFindByEid() {
		
		List<Telecom> result = repo.findByEid(MiniPrTest.EID_1);
		
		assertEquals(result.size(), 2);
		assertEquals(result.get(0).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(0).getTypeCode(), MiniPrTest.TELECOM_TYPE_PH);
		assertEquals(result.get(0).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.get(0).getValue(), MiniPrTest.TELECOM_VALUE_PH_1);
		assertEquals(result.get(1).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(1).getTypeCode(), MiniPrTest.TELECOM_TYPE_EMAIL);
		assertEquals(result.get(1).getUseCode(), MiniPrTest.TELECOM_USE_PRN);
		assertEquals(result.get(1).getValue(), MiniPrTest.TELECOM_EMAIL_1);
	}

}
