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
import com.ai.mini.pr.model.Name;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class NameRepositoryTest {

	@Autowired
	private NameRepository repo;
	
	@Test
	public void testFindByEid() {
		
		List<Name> result = repo.findByEid(MiniPrTest.EID_1);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(0).getLastName(), MiniPrTest.LAST_NAME_1);
		assertEquals(result.get(0).getFirstName(), MiniPrTest.FIRST_NAME_1);
		assertEquals(result.get(0).getMiddleName(), MiniPrTest.MIDDLE_NAME_1);
		assertEquals(result.get(0).getSuffix(), MiniPrTest.SUFFIX_1);
		assertEquals(result.get(0).getTitle(), MiniPrTest.TITLE_1);
		assertEquals(result.get(0).getTypeCode(), MiniPrTest.NAME_TYPE_1);
	}
}
