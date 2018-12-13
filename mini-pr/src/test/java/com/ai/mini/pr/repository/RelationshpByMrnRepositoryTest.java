package com.ai.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.config.RepositoryConfig;
import com.ai.mini.pr.model.RelationshipByMrn;
import com.ai.mini.pr.model.RelationshipByMrnIdentity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class RelationshpByMrnRepositoryTest {

	@Autowired
	private RelationshpByMrnRepository repo;
	
	@Test
	public void testFindById() {
		
		Optional<RelationshipByMrn> result = 
				repo.findById(new RelationshipByMrnIdentity(MiniPrTest.MRN_SYS1_1, MiniPrTest.SOURCE_SYSTEM_1));
		
		assertEquals(result.isPresent(), true);
		assertEquals(result.get().getEid(), MiniPrTest.EID_1);
		assertEquals(result.get().getIdentity().getMrn(), MiniPrTest.MRN_SYS1_1);
		assertEquals(result.get().getIdentity().getSourceSystem(), MiniPrTest.SOURCE_SYSTEM_1);
	}
}
