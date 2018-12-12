package com.ai.mini.pr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MINI_PR_ID_RELATIONSHIP")
@EntityListeners(AuditingEntityListener.class)
public class RelationshipByMrn implements Serializable {

	/**
	 * STS generated
	 */
	private static final long serialVersionUID = 1096343704799593110L;

	@EmbeddedId
	private RelationshipByMrnIdentity identity;
	
	@Column(name = "EID", nullable = false)
	private Long eid;

	public RelationshipByMrnIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(RelationshipByMrnIdentity identity) {
		this.identity = identity;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
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
		RelationshipByMrn other = (RelationshipByMrn) obj;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

}
