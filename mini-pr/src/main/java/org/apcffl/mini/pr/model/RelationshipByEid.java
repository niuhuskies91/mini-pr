package org.apcffl.mini.pr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MINI_PR_ID_RELATIONSHIP")
@EntityListeners(AuditingEntityListener.class)
public class RelationshipByEid implements Serializable {

	/**
	 * STS generated
	 */
	private static final long serialVersionUID = -7206114319843917929L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "EID", unique=true, nullable = false)
	private Long eid;
	
	@Column(name = "MRN", nullable = false)
	private String mrn;
	
	@Column(name = "SOURCE_SYSTEM", nullable = false)
	private String sourceSystem;

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
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
		RelationshipByEid other = (RelationshipByEid) obj;
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
		if (sourceSystem == null) {
			if (other.sourceSystem != null)
				return false;
		} else if (!sourceSystem.equals(other.sourceSystem))
			return false;
		return true;
	}

}
