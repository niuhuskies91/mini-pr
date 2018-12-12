package com.ai.mini.pr.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.junit.Test;

import com.ai.mini.pr.MiniPrTest;
import com.ai.mini.pr.repository.AddressRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


// https://g00glen00b.be/testing-spring-data-repository/
// http://springtestdbunit.github.io/spring-test-dbunit/

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages={"com.ai.mini.pr.repository"})
@EntityScan(basePackages={"com.ai.mini.pr.model"})
@TestPropertySource("classpath:application.properties")
public class AddressTest {
	@Autowired
	AddressRepository repo;
	
	@Test
	public void testFindByEid() {
		List<Address> result= repo.findByEid(MiniPrTest.EID_1);
	}
}

/*

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("mockDB.xml")
public class AddressTest {
	
	@Autowired
	private AddressRepository repository;

	@Test
	public void testFindByEuid() {
		List<Address> results = repository.findByEid(MiniPrTest.EID_1);
		
		assertEquals(results.size(), 1);
	}
	
}
*/
