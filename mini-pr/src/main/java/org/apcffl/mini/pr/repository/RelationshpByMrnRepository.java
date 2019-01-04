package org.apcffl.mini.pr.repository;

import org.apcffl.mini.pr.model.RelationshipByMrn;
import org.apcffl.mini.pr.model.RelationshipByMrnIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshpByMrnRepository extends JpaRepository<RelationshipByMrn, RelationshipByMrnIdentity>{
	
}
