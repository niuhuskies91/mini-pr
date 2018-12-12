package com.ai.mini.pr.dto;

import java.util.List;

public class PatientRecord {
	private Long eid; 
	private List<Mrn> mrn;
	private List<PatientName> names;
	private PatientDemographics patientDemographics;
	private List<PatientAddress> addresses;
	private List<PatientTelecom> telecom;
	
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public List<Mrn> getMrn() {
		return mrn;
	}
	public void setMrn(List<Mrn> mrn) {
		this.mrn = mrn;
	}
	public List<PatientName> getNames() {
		return names;
	}
	public void setNames(List<PatientName> names) {
		this.names = names;
	}
	public List<PatientAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<PatientAddress> addresses) {
		this.addresses = addresses;
	}
	public List<PatientTelecom> getTelecom() {
		return telecom;
	}
	public void setTelecom(List<PatientTelecom> telecom) {
		this.telecom = telecom;
	}
	public PatientDemographics getPatientDemographics() {
		return patientDemographics;
	}
	public void setPatientDemographics(PatientDemographics patientDemographics) {
		this.patientDemographics = patientDemographics;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
		result = prime * result + ((mrn == null) ? 0 : mrn.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((patientDemographics == null) ? 0 : patientDemographics.hashCode());
		result = prime * result + ((telecom == null) ? 0 : telecom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientRecord other = (PatientRecord) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		if (mrn == null) {
			if (other.mrn != null)
				return false;
		} else if (!mrn.equals(other.mrn))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (patientDemographics == null) {
			if (other.patientDemographics != null)
				return false;
		} else if (!patientDemographics.equals(other.patientDemographics))
			return false;
		if (telecom == null) {
			if (other.telecom != null)
				return false;
		} else if (!telecom.equals(other.telecom))
			return false;
		return true;
	}
	
}
