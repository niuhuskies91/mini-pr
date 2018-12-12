package com.ai.mini.pr.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MINI_PR_LOCAL")
@EntityListeners(AuditingEntityListener.class)
public class Local implements Serializable {

	/**
	 * STS generated
	 */
	private static final long serialVersionUID = 4688026939442013133L;
	
	@EmbeddedId
	private LocalIdentity identity;

	public LocalIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(LocalIdentity identity) {
		this.identity = identity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Local other = (Local) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}
	
}
