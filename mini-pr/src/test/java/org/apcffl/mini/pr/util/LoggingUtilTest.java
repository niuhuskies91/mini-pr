package org.apcffl.mini.pr.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.util.LoggingUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.LoggerFactory;
import org.powermock.modules.junit4.PowerMockRunner;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class})
public class LoggingUtilTest {
	
	private Logger logger;
	ListAppender<ILoggingEvent> listAppender;
	
	private PatientRecord record;
	
	@Before
	public void setUp() {
		
		logger = (Logger) LoggerFactory.getLogger(LoggingUtil.class);

		// create and start the log appender
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
        
        // test debug logging
        logger.setLevel(Level.DEBUG);
		
        // build the test patient record
		record = MiniPrTest.buildPatientRecord();
	}

	@Test
	public void testLogPatientRecord() {
		
		// prepare test data
		
		String searchMrn = MiniPrTest.MRN_SYS1_1;
		String searchSourceSystem = MiniPrTest.SOURCE_SYSTEM_1;
		
		// invoke logger
		
		LoggingUtil.logPatientRecord(record, searchMrn, searchSourceSystem);
		
		// verify results
		
		List<ILoggingEvent> logsList = listAppender.list;
		
		assertEquals(logsList.size(), 1);
		assertEquals(logsList.get(0).getLevel(), Level.DEBUG);
		assertTrue(logsList.get(0).getMessage().contains("Input search criteria:"));
		assertTrue(logsList.get(0).getMessage().contains("Patient record:"));
	}

	@Test
	public void testLogTimeDuration() {
		
		// prepare test data
		
		// invoke logger
		
		LoggingUtil.logTimeDuration(new java.util.Date(), new java.util.Date());
		
		// verify results
		
		List<ILoggingEvent> logsList = listAppender.list;
		
		assertEquals(logsList.size(), 1);
		assertEquals(logsList.get(0).getLevel(), Level.DEBUG);
		assertTrue(logsList.get(0).getMessage().contains("Processing start time:"));
		assertTrue(logsList.get(0).getMessage().contains("Processing end time:"));
		assertTrue(logsList.get(0).getMessage().contains("Total time processing (in milliseconds):"));
	}
}
