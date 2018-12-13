package com.ai.mini.pr.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.config.RepositoryConfig;
import com.ai.mini.pr.model.Address;
import com.ai.mini.pr.repository.AddressRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfig.class)
public class AddressRepositoryTest {
    
	@Autowired
	private AddressRepository repo;
	
	@Test
	public void testFindByEid() {
		
		List<Address> result = repo.findByEid(MiniPrTest.EID_1);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getEid(), MiniPrTest.EID_1);
		assertEquals(result.get(0).getAddressLine1(), MiniPrTest.ADDR_ADDRESS_LINE_1_1);
		assertEquals(result.get(0).getAddressLine2(), MiniPrTest.ADDR_ADDRESS_LINE_2_1);
		assertEquals(result.get(0).getCity(), MiniPrTest.ADDR_CITY_1);
		assertEquals(result.get(0).getState(), MiniPrTest.ADDR_STATE_1);
		assertEquals(result.get(0).getPostalCode(), MiniPrTest.ADDR_POSTAL_CODE_1);
	}
}

