package com.ai.mini.pr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalIdentity implements Serializable {

	/**
	 * STS generated
	 */
	private static final long serialVersionUID = -3684484076330161248L;

	@Column(name = "MRN", nullable = false)
	private String mrn;
	
	@Column(name = "SOURCE_SYSTEM", nullable = false)
	private String sourceSystem;
	
	public LocalIdentity() {}
	
	public LocalIdentity(String mrn, String sourceSystem) {
		this.mrn = mrn;
		this.sourceSystem = sourceSystem;
	}

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mrn == null) ? 0 : mrn.hashCode());
		result = prime * result + ((sourceSystem == null) ? 0 : sourceSystem.hashCode());
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
		LocalIdentity other = (LocalIdentity) obj;
		if (mrn == null) {
			if (other.mrn != null)
				return false;
		} else if (!mrn.equals(other.mrn))
			return false;
		if (sourceSystem == null) {
			if (other.sourceSystem != null)
				return false;
		} else if (!sourceSystem.equals(other.sourceSystem))
			return false;
		return true;
	}
	
}
