package org.apcffl.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.config.RepositoryConfig;
import org.apcffl.mini.pr.model.RelationshipByEid;
import org.apcffl.mini.pr.repository.RelationshpByEidRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class RelationshipByEidRepositoryTest {
	
	@Autowired
	private RelationshpByEidRepository repo;

	@Test
	public void testFindAllByIdentityEid() {
		
		List<RelationshipByEid> result = repo.findAllByIdentityEid(MiniPrTest.EID_1);
		
		assertEquals(result.size(), 2);
		assertEquals(result.get(0).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(0).getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.get(0).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
		assertEquals(result.get(1).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(1).getMrn(), MiniPrTest.MRN_SYS2_1);
		assertEquals(result.get(1).getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_2);
	}
}
