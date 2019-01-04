package org.apcffl.mini.pr.util;

import static org.junit.Assert.assertTrue;

import org.apcffl.mini.pr.MiniPrTest;
import org.apcffl.mini.pr.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
	private java.util.Date currDate;
	
	@Before
	public void setUp() {
		currDate = new java.util.Date();
	}

	@Test
	public void testConvertSqlDateToHL7NullDate() {
		String result = DateUtil.convertSqlDateToHL7(null);
		assertTrue(result == null);
	}

	@Test
	public void testConvertSqlDateToHL7() {
		String result = DateUtil.convertSqlDateToHL7(new java.sql.Date(currDate.getTime()));
		assertTrue(result != null);
	}

	@Test
	public void testConvertUtilDateToHL7NullDate() {
		String result = DateUtil.convertUtilDateToHL7(null);
		assertTrue(result == null);
	}

	@Test
	public void testConvertUtilDateToHL7() {
		String result = DateUtil.convertUtilDateToHL7(currDate);
		assertTrue(result != null);
	}
	
	@Test
	public void testConvertHL7ToDateNullDate() {
		java.sql.Date result = DateUtil.convertHL7ToDate(null);
		assertTrue(result == null);
	}
	
	@Test
	public void testConvertHL7ToDateEmptyString() {
		java.sql.Date result = DateUtil.convertHL7ToDate("");
		assertTrue(result == null);
	}
	
	@Test(expected = org.apcffl.mini.pr.exception.ServiceException.class)
	public void testConvertHL7ToDateParseException() {
		java.sql.Date result = DateUtil.convertHL7ToDate("abc");
		assertTrue(result == null);
	}
	
	@Test(expected = org.apcffl.mini.pr.exception.ServiceException.class)
	public void testConvertHL7ToDateIncompleteDate() {
		java.sql.Date result = DateUtil.convertHL7ToDate("2018");
		assertTrue(result == null);
	}
	
	@Test
	public void testConvertHL7ToDate() {
		java.sql.Date result = DateUtil.convertHL7ToDate(MiniPrTest.DOB_1);
		assertTrue(result != null);
	}
	
	@Test
	public void testConvertDateToDisplayFormatNullDate() {
		String result = DateUtil.convertDateToDisplayFormat(null);
		assertTrue(result == null);
	}
	
	@Test
	public void testConvertDateToDisplayFormat() {
		String result = DateUtil.convertDateToDisplayFormat(new java.util.Date());
		assertTrue(result != null);
	}
}
