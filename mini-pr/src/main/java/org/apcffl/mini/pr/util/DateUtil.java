package org.apcffl.mini.pr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apcffl.mini.pr.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

	private static final String HL7_DATE_FORMAT     = "yyyyMMdd";
	private static final String DISPLAY_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final DateFormat hl7 = new SimpleDateFormat(HL7_DATE_FORMAT);
	private static final DateFormat ui = new SimpleDateFormat(DISPLAY_DATE_FORMAT);
	
	private DateUtil() {}
	
	public static String convertSqlDateToHL7(java.sql.Date date) {
		if (date == null) {
			return null;
		}
		return hl7.format(date);
	}
	
	public static String convertUtilDateToHL7(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return hl7.format(date);
	}
	
	public static java.sql.Date convertHL7ToDate(String date) throws ServiceException {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			return new java.sql.Date(hl7.parse(date).getTime());
		} catch (ParseException e) {
			String error = "Date conversion issue occurred for date: " + date + 
					", with error: " + e.getMessage();
			LOG.error(error, e);
			throw new ServiceException(error);
		}
	}
	
	public static String convertDateToDisplayFormat(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return ui.format(date);
	}
}
