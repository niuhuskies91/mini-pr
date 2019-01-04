package org.apcffl.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.config.RepositoryConfig;
import org.apcffl.mini.pr.model.Name;
import org.apcffl.mini.pr.repository.NameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
