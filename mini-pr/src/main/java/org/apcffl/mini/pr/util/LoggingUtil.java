package org.apcffl.mini.pr.util;

import java.util.Date;

import org.apcffl.mini.pr.dto.PatientRecord;
import org.apcffl.mini.pr.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingUtil {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingUtil.class);
	
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	
	private LoggingUtil() {}

	public static void logPatientRecord(PatientRecord record, String searchMrn, String searchSourceSystem) {
		
		if (LOG.isDebugEnabled()) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("\n\nInput search criteria:")
			  .append("\n\tsourceSystem: ").append(searchSourceSystem)
			  .append("\n\tmrn: ").append(searchMrn)
			  .append("\n\teid: ").append(record.getEid())
			  .append("\n\nPatient record: \n\n");
			
			try {
				sb.append( jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(record) ).append("\n\n");
			} catch (JsonProcessingException e) {
				String error = "Unable to log the resuting response message with error: " + e.getMessage();
				LOG.error(error, e);
				throw new ServiceException(error);
			}

			LOG.debug(sb.toString());
		}
	}
	
	public static void logTimeDuration(Date startTime, Date endTime) {
		if (LOG.isDebugEnabled()) {

			StringBuilder sb = new StringBuilder();
			sb.append("\n\n").append("Processing start time: ").append(DateUtil.convertDateToDisplayFormat(startTime)).append("\n\n");
			sb.append("Processing end time: ").append(DateUtil.convertDateToDisplayFormat(endTime)).append("\n\n");
			sb.append("Total time processing (in milliseconds): ").append(endTime.getTime() - startTime.getTime()).append("\n\n");
			LOG.debug(sb.toString());
		}
	}
}
